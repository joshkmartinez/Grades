package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private Bitmap mBitmap;
    private Metadata zzam;
    private ByteBuffer zzan;

    public static class Builder {
        private Frame zzao = new Frame();

        public Frame build() {
            if (this.zzao.zzan == null) {
                if (this.zzao.mBitmap == null) {
                    throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
                }
            }
            return this.zzao;
        }

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.zzao.mBitmap = bitmap;
            Metadata metadata = this.zzao.getMetadata();
            metadata.zzap = width;
            metadata.zzaq = height;
            return this;
        }

        public Builder setId(int i) {
            this.zzao.getMetadata().mId = i;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() >= i * i2) {
                if (i3 != 842094169) {
                    switch (i3) {
                        case 16:
                        case 17:
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(37);
                            stringBuilder.append("Unsupported image format: ");
                            stringBuilder.append(i3);
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                this.zzao.zzan = byteBuffer;
                Metadata metadata = this.zzao.getMetadata();
                metadata.zzap = i;
                metadata.zzaq = i2;
                metadata.format = i3;
                return this;
            } else {
                throw new IllegalArgumentException("Invalid image data size.");
            }
        }

        public Builder setRotation(int i) {
            this.zzao.getMetadata().zzg = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            this.zzao.getMetadata().zzar = j;
            return this;
        }
    }

    public static class Metadata {
        private int format = -1;
        private int mId;
        private int zzap;
        private int zzaq;
        private long zzar;
        private int zzg;

        public Metadata(Metadata metadata) {
            this.zzap = metadata.getWidth();
            this.zzaq = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzar = metadata.getTimestampMillis();
            this.zzg = metadata.getRotation();
        }

        public int getFormat() {
            return this.format;
        }

        public int getHeight() {
            return this.zzaq;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzg;
        }

        public long getTimestampMillis() {
            return this.zzar;
        }

        public int getWidth() {
            return this.zzap;
        }

        public final void zzd() {
            if (this.zzg % 2 != 0) {
                int i = this.zzap;
                this.zzap = this.zzaq;
                this.zzaq = i;
            }
            this.zzg = 0;
        }
    }

    private Frame() {
        this.zzam = new Metadata();
        this.zzan = null;
        this.mBitmap = null;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        if (this.mBitmap == null) {
            return this.zzan;
        }
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArr[i2] = (byte) ((int) (((((float) Color.red(iArr[i2])) * 0.299f) + (((float) Color.green(iArr[i2])) * 0.587f)) + (((float) Color.blue(iArr[i2])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Metadata getMetadata() {
        return this.zzam;
    }
}
