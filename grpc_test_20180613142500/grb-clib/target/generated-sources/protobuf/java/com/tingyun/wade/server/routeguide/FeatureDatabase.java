// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.tingyun.wade.server.routeguide;

/**
 * <pre>
 * Not used in the RPC.  Instead, this is here for the form serialized to disk.
 * </pre>
 *
 * Protobuf type {@code routeguide.FeatureDatabase}
 */
public  final class FeatureDatabase extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:routeguide.FeatureDatabase)
    FeatureDatabaseOrBuilder {
  // Use FeatureDatabase.newBuilder() to construct.
  private FeatureDatabase(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FeatureDatabase() {
    feature_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private FeatureDatabase(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              feature_ = new java.util.ArrayList<com.tingyun.wade.server.routeguide.Feature>();
              mutable_bitField0_ |= 0x00000001;
            }
            feature_.add(
                input.readMessage(com.tingyun.wade.server.routeguide.Feature.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        feature_ = java.util.Collections.unmodifiableList(feature_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tingyun.wade.server.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tingyun.wade.server.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tingyun.wade.server.routeguide.FeatureDatabase.class, com.tingyun.wade.server.routeguide.FeatureDatabase.Builder.class);
  }

  public static final int FEATURE_FIELD_NUMBER = 1;
  private java.util.List<com.tingyun.wade.server.routeguide.Feature> feature_;
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  public java.util.List<com.tingyun.wade.server.routeguide.Feature> getFeatureList() {
    return feature_;
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  public java.util.List<? extends com.tingyun.wade.server.routeguide.FeatureOrBuilder> 
      getFeatureOrBuilderList() {
    return feature_;
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  public int getFeatureCount() {
    return feature_.size();
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  public com.tingyun.wade.server.routeguide.Feature getFeature(int index) {
    return feature_.get(index);
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  public com.tingyun.wade.server.routeguide.FeatureOrBuilder getFeatureOrBuilder(
      int index) {
    return feature_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < feature_.size(); i++) {
      output.writeMessage(1, feature_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < feature_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, feature_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.tingyun.wade.server.routeguide.FeatureDatabase)) {
      return super.equals(obj);
    }
    com.tingyun.wade.server.routeguide.FeatureDatabase other = (com.tingyun.wade.server.routeguide.FeatureDatabase) obj;

    boolean result = true;
    result = result && getFeatureList()
        .equals(other.getFeatureList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getFeatureCount() > 0) {
      hash = (37 * hash) + FEATURE_FIELD_NUMBER;
      hash = (53 * hash) + getFeatureList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tingyun.wade.server.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.tingyun.wade.server.routeguide.FeatureDatabase prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Not used in the RPC.  Instead, this is here for the form serialized to disk.
   * </pre>
   *
   * Protobuf type {@code routeguide.FeatureDatabase}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:routeguide.FeatureDatabase)
      com.tingyun.wade.server.routeguide.FeatureDatabaseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tingyun.wade.server.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tingyun.wade.server.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tingyun.wade.server.routeguide.FeatureDatabase.class, com.tingyun.wade.server.routeguide.FeatureDatabase.Builder.class);
    }

    // Construct using com.tingyun.wade.server.routeguide.FeatureDatabase.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getFeatureFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (featureBuilder_ == null) {
        feature_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        featureBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tingyun.wade.server.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
    }

    public com.tingyun.wade.server.routeguide.FeatureDatabase getDefaultInstanceForType() {
      return com.tingyun.wade.server.routeguide.FeatureDatabase.getDefaultInstance();
    }

    public com.tingyun.wade.server.routeguide.FeatureDatabase build() {
      com.tingyun.wade.server.routeguide.FeatureDatabase result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.tingyun.wade.server.routeguide.FeatureDatabase buildPartial() {
      com.tingyun.wade.server.routeguide.FeatureDatabase result = new com.tingyun.wade.server.routeguide.FeatureDatabase(this);
      int from_bitField0_ = bitField0_;
      if (featureBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          feature_ = java.util.Collections.unmodifiableList(feature_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.feature_ = feature_;
      } else {
        result.feature_ = featureBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.tingyun.wade.server.routeguide.FeatureDatabase) {
        return mergeFrom((com.tingyun.wade.server.routeguide.FeatureDatabase)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tingyun.wade.server.routeguide.FeatureDatabase other) {
      if (other == com.tingyun.wade.server.routeguide.FeatureDatabase.getDefaultInstance()) return this;
      if (featureBuilder_ == null) {
        if (!other.feature_.isEmpty()) {
          if (feature_.isEmpty()) {
            feature_ = other.feature_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureFeatureIsMutable();
            feature_.addAll(other.feature_);
          }
          onChanged();
        }
      } else {
        if (!other.feature_.isEmpty()) {
          if (featureBuilder_.isEmpty()) {
            featureBuilder_.dispose();
            featureBuilder_ = null;
            feature_ = other.feature_;
            bitField0_ = (bitField0_ & ~0x00000001);
            featureBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFeatureFieldBuilder() : null;
          } else {
            featureBuilder_.addAllMessages(other.feature_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.tingyun.wade.server.routeguide.FeatureDatabase parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tingyun.wade.server.routeguide.FeatureDatabase) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.tingyun.wade.server.routeguide.Feature> feature_ =
      java.util.Collections.emptyList();
    private void ensureFeatureIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        feature_ = new java.util.ArrayList<com.tingyun.wade.server.routeguide.Feature>(feature_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tingyun.wade.server.routeguide.Feature, com.tingyun.wade.server.routeguide.Feature.Builder, com.tingyun.wade.server.routeguide.FeatureOrBuilder> featureBuilder_;

    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<com.tingyun.wade.server.routeguide.Feature> getFeatureList() {
      if (featureBuilder_ == null) {
        return java.util.Collections.unmodifiableList(feature_);
      } else {
        return featureBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public int getFeatureCount() {
      if (featureBuilder_ == null) {
        return feature_.size();
      } else {
        return featureBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public com.tingyun.wade.server.routeguide.Feature getFeature(int index) {
      if (featureBuilder_ == null) {
        return feature_.get(index);
      } else {
        return featureBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder setFeature(
        int index, com.tingyun.wade.server.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.set(index, value);
        onChanged();
      } else {
        featureBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder setFeature(
        int index, com.tingyun.wade.server.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.set(index, builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(com.tingyun.wade.server.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.add(value);
        onChanged();
      } else {
        featureBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        int index, com.tingyun.wade.server.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.add(index, value);
        onChanged();
      } else {
        featureBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        com.tingyun.wade.server.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.add(builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        int index, com.tingyun.wade.server.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.add(index, builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addAllFeature(
        java.lang.Iterable<? extends com.tingyun.wade.server.routeguide.Feature> values) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, feature_);
        onChanged();
      } else {
        featureBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder clearFeature() {
      if (featureBuilder_ == null) {
        feature_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        featureBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder removeFeature(int index) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.remove(index);
        onChanged();
      } else {
        featureBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public com.tingyun.wade.server.routeguide.Feature.Builder getFeatureBuilder(
        int index) {
      return getFeatureFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public com.tingyun.wade.server.routeguide.FeatureOrBuilder getFeatureOrBuilder(
        int index) {
      if (featureBuilder_ == null) {
        return feature_.get(index);  } else {
        return featureBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<? extends com.tingyun.wade.server.routeguide.FeatureOrBuilder> 
         getFeatureOrBuilderList() {
      if (featureBuilder_ != null) {
        return featureBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(feature_);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public com.tingyun.wade.server.routeguide.Feature.Builder addFeatureBuilder() {
      return getFeatureFieldBuilder().addBuilder(
          com.tingyun.wade.server.routeguide.Feature.getDefaultInstance());
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public com.tingyun.wade.server.routeguide.Feature.Builder addFeatureBuilder(
        int index) {
      return getFeatureFieldBuilder().addBuilder(
          index, com.tingyun.wade.server.routeguide.Feature.getDefaultInstance());
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<com.tingyun.wade.server.routeguide.Feature.Builder> 
         getFeatureBuilderList() {
      return getFeatureFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tingyun.wade.server.routeguide.Feature, com.tingyun.wade.server.routeguide.Feature.Builder, com.tingyun.wade.server.routeguide.FeatureOrBuilder> 
        getFeatureFieldBuilder() {
      if (featureBuilder_ == null) {
        featureBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.tingyun.wade.server.routeguide.Feature, com.tingyun.wade.server.routeguide.Feature.Builder, com.tingyun.wade.server.routeguide.FeatureOrBuilder>(
                feature_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        feature_ = null;
      }
      return featureBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:routeguide.FeatureDatabase)
  }

  // @@protoc_insertion_point(class_scope:routeguide.FeatureDatabase)
  private static final com.tingyun.wade.server.routeguide.FeatureDatabase DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tingyun.wade.server.routeguide.FeatureDatabase();
  }

  public static com.tingyun.wade.server.routeguide.FeatureDatabase getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FeatureDatabase>
      PARSER = new com.google.protobuf.AbstractParser<FeatureDatabase>() {
    public FeatureDatabase parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FeatureDatabase(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FeatureDatabase> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FeatureDatabase> getParserForType() {
    return PARSER;
  }

  public com.tingyun.wade.server.routeguide.FeatureDatabase getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

