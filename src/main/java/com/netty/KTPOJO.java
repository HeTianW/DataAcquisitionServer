package com.netty;

public final class KTPOJO {
  private KTPOJO() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KongTiaoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:KongTiao)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *1表示属性序号，不是值
     * </pre>
     *
     * <code>float PM = 1;</code>
     */
    float getPM();

    /**
     * <code>float RH = 2;</code>
     */
    float getRH();
  }
  /**
   * <pre>
   *protobuf 使用message管理数据
   *会在StudentPOJO外部生成一个内部类Student，他是真正发送的Proto对象
   * </pre>
   *
   * Protobuf type {@code KongTiao}
   */
  public  static final class KongTiao extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:KongTiao)
      KongTiaoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use KongTiao.newBuilder() to construct.
    private KongTiao(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KongTiao() {
      pM_ = 0F;
      rH_ = 0F;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private KongTiao(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 13: {

              pM_ = input.readFloat();
              break;
            }
            case 21: {

              rH_ = input.readFloat();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return KTPOJO.internal_static_KongTiao_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return KTPOJO.internal_static_KongTiao_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              KTPOJO.KongTiao.class, KTPOJO.KongTiao.Builder.class);
    }

    public static final int PM_FIELD_NUMBER = 1;
    private float pM_;
    /**
     * <pre>
     *1表示属性序号，不是值
     * </pre>
     *
     * <code>float PM = 1;</code>
     */
    public float getPM() {
      return pM_;
    }

    public static final int RH_FIELD_NUMBER = 2;
    private float rH_;
    /**
     * <code>float RH = 2;</code>
     */
    public float getRH() {
      return rH_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (pM_ != 0F) {
        output.writeFloat(1, pM_);
      }
      if (rH_ != 0F) {
        output.writeFloat(2, rH_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (pM_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(1, pM_);
      }
      if (rH_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(2, rH_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof KTPOJO.KongTiao)) {
        return super.equals(obj);
      }
      KTPOJO.KongTiao other = (KTPOJO.KongTiao) obj;

      boolean result = true;
      result = result && (
          java.lang.Float.floatToIntBits(getPM())
          == java.lang.Float.floatToIntBits(
              other.getPM()));
      result = result && (
          java.lang.Float.floatToIntBits(getRH())
          == java.lang.Float.floatToIntBits(
              other.getRH()));
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + PM_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getPM());
      hash = (37 * hash) + RH_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getRH());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static KTPOJO.KongTiao parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static KTPOJO.KongTiao parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static KTPOJO.KongTiao parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static KTPOJO.KongTiao parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static KTPOJO.KongTiao parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static KTPOJO.KongTiao parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static KTPOJO.KongTiao parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static KTPOJO.KongTiao parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static KTPOJO.KongTiao parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static KTPOJO.KongTiao parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static KTPOJO.KongTiao parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static KTPOJO.KongTiao parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(KTPOJO.KongTiao prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     *protobuf 使用message管理数据
     *会在StudentPOJO外部生成一个内部类Student，他是真正发送的Proto对象
     * </pre>
     *
     * Protobuf type {@code KongTiao}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:KongTiao)
        KTPOJO.KongTiaoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return KTPOJO.internal_static_KongTiao_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return KTPOJO.internal_static_KongTiao_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                KTPOJO.KongTiao.class, KTPOJO.KongTiao.Builder.class);
      }

      // Construct using KTPOJO.KongTiao.newBuilder()
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
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        pM_ = 0F;

        rH_ = 0F;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return KTPOJO.internal_static_KongTiao_descriptor;
      }

      @java.lang.Override
      public KTPOJO.KongTiao getDefaultInstanceForType() {
        return KTPOJO.KongTiao.getDefaultInstance();
      }

      @java.lang.Override
      public KTPOJO.KongTiao build() {
        KTPOJO.KongTiao result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public KTPOJO.KongTiao buildPartial() {
        KTPOJO.KongTiao result = new KTPOJO.KongTiao(this);
        result.pM_ = pM_;
        result.rH_ = rH_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof KTPOJO.KongTiao) {
          return mergeFrom((KTPOJO.KongTiao)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(KTPOJO.KongTiao other) {
        if (other == KTPOJO.KongTiao.getDefaultInstance()) return this;
        if (other.getPM() != 0F) {
          setPM(other.getPM());
        }
        if (other.getRH() != 0F) {
          setRH(other.getRH());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        KTPOJO.KongTiao parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (KTPOJO.KongTiao) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private float pM_ ;
      /**
       * <pre>
       *1表示属性序号，不是值
       * </pre>
       *
       * <code>float PM = 1;</code>
       */
      public float getPM() {
        return pM_;
      }
      /**
       * <pre>
       *1表示属性序号，不是值
       * </pre>
       *
       * <code>float PM = 1;</code>
       */
      public Builder setPM(float value) {
        
        pM_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *1表示属性序号，不是值
       * </pre>
       *
       * <code>float PM = 1;</code>
       */
      public Builder clearPM() {
        
        pM_ = 0F;
        onChanged();
        return this;
      }

      private float rH_ ;
      /**
       * <code>float RH = 2;</code>
       */
      public float getRH() {
        return rH_;
      }
      /**
       * <code>float RH = 2;</code>
       */
      public Builder setRH(float value) {
        
        rH_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>float RH = 2;</code>
       */
      public Builder clearRH() {
        
        rH_ = 0F;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:KongTiao)
    }

    // @@protoc_insertion_point(class_scope:KongTiao)
    private static final KTPOJO.KongTiao DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new KTPOJO.KongTiao();
    }

    public static KTPOJO.KongTiao getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<KongTiao>
        PARSER = new com.google.protobuf.AbstractParser<KongTiao>() {
      @java.lang.Override
      public KongTiao parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KongTiao(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KongTiao> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<KongTiao> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public KTPOJO.KongTiao getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_KongTiao_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_KongTiao_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017KonngTiao.proto\"\"\n\010KongTiao\022\n\n\002PM\030\001 \001(" +
      "\002\022\n\n\002RH\030\002 \001(\002B\010B\006KTPOJOb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_KongTiao_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_KongTiao_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_KongTiao_descriptor,
        new java.lang.String[] { "PM", "RH", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
