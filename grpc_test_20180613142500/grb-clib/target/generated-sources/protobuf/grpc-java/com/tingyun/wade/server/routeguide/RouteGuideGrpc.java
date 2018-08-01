package com.tingyun.wade.server.routeguide;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: route_guide.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tingyun.wade.server.routeguide.Point,
      com.tingyun.wade.server.routeguide.Feature> METHOD_GET_FEATURE =
      io.grpc.MethodDescriptor.<com.tingyun.wade.server.routeguide.Point, com.tingyun.wade.server.routeguide.Feature>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "GetFeature"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.Point.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.Feature.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tingyun.wade.server.routeguide.Rectangle,
      com.tingyun.wade.server.routeguide.Feature> METHOD_LIST_FEATURES =
      io.grpc.MethodDescriptor.<com.tingyun.wade.server.routeguide.Rectangle, com.tingyun.wade.server.routeguide.Feature>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "ListFeatures"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.Rectangle.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.Feature.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tingyun.wade.server.routeguide.Point,
      com.tingyun.wade.server.routeguide.RouteSummary> METHOD_RECORD_ROUTE =
      io.grpc.MethodDescriptor.<com.tingyun.wade.server.routeguide.Point, com.tingyun.wade.server.routeguide.RouteSummary>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "RecordRoute"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.Point.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.RouteSummary.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tingyun.wade.server.routeguide.RouteNote,
      com.tingyun.wade.server.routeguide.RouteNote> METHOD_ROUTE_CHAT =
      io.grpc.MethodDescriptor.<com.tingyun.wade.server.routeguide.RouteNote, com.tingyun.wade.server.routeguide.RouteNote>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "routeguide.RouteGuide", "RouteChat"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.RouteNote.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.tingyun.wade.server.routeguide.RouteNote.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getFeature(com.tingyun.wade.server.routeguide.Point request,
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FEATURE, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void listFeatures(com.tingyun.wade.server.routeguide.Rectangle request,
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_FEATURES, responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_RECORD_ROUTE, responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_ROUTE_CHAT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FEATURE,
            asyncUnaryCall(
              new MethodHandlers<
                com.tingyun.wade.server.routeguide.Point,
                com.tingyun.wade.server.routeguide.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            METHOD_LIST_FEATURES,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.tingyun.wade.server.routeguide.Rectangle,
                com.tingyun.wade.server.routeguide.Feature>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            METHOD_RECORD_ROUTE,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.tingyun.wade.server.routeguide.Point,
                com.tingyun.wade.server.routeguide.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            METHOD_ROUTE_CHAT,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.tingyun.wade.server.routeguide.RouteNote,
                com.tingyun.wade.server.routeguide.RouteNote>(
                  this, METHODID_ROUTE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getFeature(com.tingyun.wade.server.routeguide.Point request,
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FEATURE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void listFeatures(com.tingyun.wade.server.routeguide.Rectangle request,
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_FEATURES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_RECORD_ROUTE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_ROUTE_CHAT, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public com.tingyun.wade.server.routeguide.Feature getFeature(com.tingyun.wade.server.routeguide.Point request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FEATURE, getCallOptions(), request);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public java.util.Iterator<com.tingyun.wade.server.routeguide.Feature> listFeatures(
        com.tingyun.wade.server.routeguide.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_FEATURES, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.tingyun.wade.server.routeguide.Feature> getFeature(
        com.tingyun.wade.server.routeguide.Point request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FEATURE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEATURE = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_ROUTE_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((com.tingyun.wade.server.routeguide.Point) request,
              (io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((com.tingyun.wade.server.routeguide.Rectangle) request,
              (io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.Feature>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteSummary>) responseObserver);
        case METHODID_ROUTE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeChat(
              (io.grpc.stub.StreamObserver<com.tingyun.wade.server.routeguide.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class RouteGuideDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.tingyun.wade.server.routeguide.RouteGuideProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideDescriptorSupplier())
              .addMethod(METHOD_GET_FEATURE)
              .addMethod(METHOD_LIST_FEATURES)
              .addMethod(METHOD_RECORD_ROUTE)
              .addMethod(METHOD_ROUTE_CHAT)
              .build();
        }
      }
    }
    return result;
  }
}
