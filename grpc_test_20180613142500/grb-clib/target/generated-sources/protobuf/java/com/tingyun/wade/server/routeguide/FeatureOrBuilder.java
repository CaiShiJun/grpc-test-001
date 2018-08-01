// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.tingyun.wade.server.routeguide;

public interface FeatureOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.Feature)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * The name of the feature.
   * </pre>
   *
   * <code>optional string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>optional .routeguide.Point location = 2;</code>
   */
  boolean hasLocation();
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>optional .routeguide.Point location = 2;</code>
   */
  com.tingyun.wade.server.routeguide.Point getLocation();
  /**
   * <pre>
   * The point where the feature is detected.
   * </pre>
   *
   * <code>optional .routeguide.Point location = 2;</code>
   */
  com.tingyun.wade.server.routeguide.PointOrBuilder getLocationOrBuilder();
}
