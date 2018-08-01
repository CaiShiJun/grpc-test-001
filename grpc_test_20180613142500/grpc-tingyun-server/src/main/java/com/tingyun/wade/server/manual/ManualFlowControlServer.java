package com.tingyun.wade.server.manual;

import com.tingyun.wade.server.manualflowcontrol.HelloReply;
import com.tingyun.wade.server.manualflowcontrol.HelloRequest;
import com.tingyun.wade.server.manualflowcontrol.StreamingGreeterGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tingyun on 2018/1/26.
 */
@Service
public class ManualFlowControlServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManualFlowControlServer.class);


    public void execute() throws IOException, InterruptedException {
        StreamingGreeterGrpc.StreamingGreeterImplBase svc = new StreamingGreeterGrpc.StreamingGreeterImplBase() {
            @Override
            public StreamObserver<HelloRequest> sayHelloStreaming(final StreamObserver<HelloReply> responseObserver) {
                final ServerCallStreamObserver<HelloReply> serverCallStreamObserver =
                        (ServerCallStreamObserver<HelloReply>) responseObserver;
                serverCallStreamObserver.disableAutoInboundFlowControl();

                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                serverCallStreamObserver.setOnReadyHandler(new Runnable() {
                    @Override
                    public void run() {
                        if (serverCallStreamObserver.isReady() && atomicBoolean.compareAndSet(false, true)) {
                            LOGGER.info("is ready ");
                            serverCallStreamObserver.request(1);
                        }
                    }

                });

                return new StreamObserver<HelloRequest>() {
                    @Override
                    public void onNext(HelloRequest helloRequest) {
                        try {
                            String name = helloRequest.getName();
                            LOGGER.info("---> " + name);
                            // Simulate server "work"
                            Thread.sleep(100);
                            // Send a response.
                            String message = "Hello " + name;
                            LOGGER.info("<-- " + message);
                            HelloReply helloReply = HelloReply.newBuilder().setMessage(message).build();
                            responseObserver.onNext(helloReply);
                            if (serverCallStreamObserver.isReady()) {
                                serverCallStreamObserver.request(1);
                            } else {
                                atomicBoolean.set(false);
                            }
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                            responseObserver.onError(
                                    Status.UNKNOWN.withDescription("Error handling request").withCause(throwable).asException());
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                        responseObserver.onCompleted();
                    }

                    @Override
                    public void onCompleted() {
                        LOGGER.info("COMPLETED");
                        responseObserver.onCompleted();
                    }
                };
            }
        };
        final Server server = ServerBuilder
                .forPort(50051)
                .addService(svc)
                .build()
                .start();

        LOGGER.info("Listening on " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LOGGER.info("Shutting down");
                server.shutdown();
            }
        });
        server.awaitTermination();
    }
}
