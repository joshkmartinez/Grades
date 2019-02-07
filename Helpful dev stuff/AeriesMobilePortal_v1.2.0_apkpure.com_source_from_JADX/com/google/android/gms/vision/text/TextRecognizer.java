package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzaa;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.internal.vision.zzt;
import com.google.android.gms.internal.vision.zzv;
import com.google.android.gms.internal.vision.zzz;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class TextRecognizer extends Detector<TextBlock> {
    private final zzz zzda;

    public static class Builder {
        private Context mContext;
        private zzaa zzdb = new zzaa();

        public Builder(Context context) {
            this.mContext = context;
        }

        public TextRecognizer build() {
            return new TextRecognizer(new zzz(this.mContext, this.zzdb));
        }
    }

    private TextRecognizer() {
        throw new IllegalStateException("Default constructor called");
    }

    private TextRecognizer(zzz com_google_android_gms_internal_vision_zzz) {
        this.zzda = com_google_android_gms_internal_vision_zzz;
    }

    public final SparseArray<TextBlock> detect(Frame frame) {
        zzv com_google_android_gms_internal_vision_zzv = new zzv(new Rect());
        if (frame != null) {
            Bitmap bitmap;
            int i;
            zzk zzc = zzk.zzc(frame);
            int i2 = 0;
            if (frame.getBitmap() != null) {
                bitmap = frame.getBitmap();
            } else {
                byte[] array;
                Metadata metadata = frame.getMetadata();
                ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
                int format = metadata.getFormat();
                i = zzc.width;
                int i3 = zzc.height;
                if (grayscaleImageData.hasArray() && grayscaleImageData.arrayOffset() == 0) {
                    array = grayscaleImageData.array();
                } else {
                    byte[] bArr = new byte[grayscaleImageData.capacity()];
                    grayscaleImageData.get(bArr);
                    array = bArr;
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(array, format, i, i3, null).compressToJpeg(new Rect(0, 0, i, i3), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
            }
            bitmap = zzm.zzb(bitmap, zzc);
            if (!com_google_android_gms_internal_vision_zzv.zzdm.isEmpty()) {
                Rect rect;
                Rect rect2 = com_google_android_gms_internal_vision_zzv.zzdm;
                int width = frame.getMetadata().getWidth();
                int height = frame.getMetadata().getHeight();
                switch (zzc.rotation) {
                    case 1:
                        rect = new Rect(height - rect2.bottom, rect2.left, height - rect2.top, rect2.right);
                        break;
                    case 2:
                        rect = new Rect(width - rect2.right, height - rect2.bottom, width - rect2.left, height - rect2.top);
                        break;
                    case 3:
                        rect = new Rect(rect2.top, width - rect2.right, rect2.bottom, width - rect2.left);
                        break;
                    default:
                        rect = rect2;
                        break;
                }
                com_google_android_gms_internal_vision_zzv.zzdm.set(rect);
            }
            zzc.rotation = 0;
            zzt[] zza = this.zzda.zza(bitmap, zzc, com_google_android_gms_internal_vision_zzv);
            SparseArray sparseArray = new SparseArray();
            for (zzt com_google_android_gms_internal_vision_zzt : zza) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(com_google_android_gms_internal_vision_zzt.zzdk);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(com_google_android_gms_internal_vision_zzt.zzdk, sparseArray2);
                }
                sparseArray2.append(com_google_android_gms_internal_vision_zzt.zzdl, com_google_android_gms_internal_vision_zzt);
            }
            SparseArray<TextBlock> sparseArray3 = new SparseArray(sparseArray.size());
            while (i2 < sparseArray.size()) {
                sparseArray3.append(sparseArray.keyAt(i2), new TextBlock((SparseArray) sparseArray.valueAt(i2)));
                i2++;
            }
            return sparseArray3;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzda.isOperational();
    }

    public final void release() {
        super.release();
        this.zzda.zzg();
    }
}
