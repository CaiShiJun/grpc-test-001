package com.tingyun.wade.server.helloworld;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by tingyun on 2018/1/24.
 */
public class HelloWorldServer implements Runnable{

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServer.class);

    private int port = 50052;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        LOGGER.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public void run() {
        final HelloWorldServer server = new HelloWorldServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            server.blockUntilShutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            //super.sayHello(request, responseObserver);
           /* String a = 5/0+"";*/
            System.err.println("server is sayHello.");
            HelloReply reply = HelloReply.newBuilder().setMessage("hello " + request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }

    /**
     * 启动方法
     */
    public void startServer() throws InterruptedException, IOException {
        final HelloWorldServer server=new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }


}
