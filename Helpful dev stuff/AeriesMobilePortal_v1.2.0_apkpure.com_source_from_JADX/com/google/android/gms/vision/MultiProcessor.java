package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import java.util.HashSet;
import java.util.Set;

public class MultiProcessor<T> implements Processor<T> {
    private int zzai;
    private Factory<T> zzax;
    private SparseArray<zza> zzay;

    public static class Builder<T> {
        private MultiProcessor<T> zzaz = new MultiProcessor();

        public Builder(Factory<T> factory) {
            if (factory != null) {
                this.zzaz.zzax = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public MultiProcessor<T> build() {
            return this.zzaz;
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                this.zzaz.zzai = i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Invalid max gap: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza {
        private Tracker<T> zzah;
        private int zzal;

        private zza(MultiProcessor multiProcessor) {
            this.zzal = 0;
        }
    }

    private MultiProcessor() {
        this.zzay = new SparseArray();
        this.zzai = 3;
    }

    public void receiveDetections(Detections<T> detections) {
        int i;
        SparseArray detectedItems = detections.getDetectedItems();
        for (i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            if (this.zzay.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = new zza();
                com_google_android_gms_vision_MultiProcessor_zza.zzah = this.zzax.create(valueAt);
                com_google_android_gms_vision_MultiProcessor_zza.zzah.onNewItem(keyAt, valueAt);
                this.zzay.append(keyAt, com_google_android_gms_vision_MultiProcessor_zza);
            }
        }
        detectedItems = detections.getDetectedItems();
        Set<Integer> hashSet = new HashSet();
        for (keyAt = 0; keyAt < this.zzay.size(); keyAt++) {
            int keyAt2 = this.zzay.keyAt(keyAt);
            if (detectedItems.get(keyAt2) == null) {
                com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzay.valueAt(keyAt);
                com_google_android_gms_vision_MultiProcessor_zza.zzal = com_google_android_gms_vision_MultiProcessor_zza.zzal + 1;
                if (com_google_android_gms_vision_MultiProcessor_zza.zzal >= this.zzai) {
                    com_google_android_gms_vision_MultiProcessor_zza.zzah.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    com_google_android_gms_vision_MultiProcessor_zza.zzah.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzay.delete(intValue.intValue());
        }
        detectedItems = detections.getDetectedItems();
        for (i = 0; i < detectedItems.size(); i++) {
            keyAt = detectedItems.keyAt(i);
            valueAt = detectedItems.valueAt(i);
            zza com_google_android_gms_vision_MultiProcessor_zza2 = (zza) this.zzay.get(keyAt);
            com_google_android_gms_vision_MultiProcessor_zza2.zzal = 0;
            com_google_android_gms_vision_MultiProcessor_zza2.zzah.onUpdate(detections, valueAt);
        }
    }

    public void release() {
        for (int i = 0; i < this.zzay.size(); i++) {
            ((zza) this.zzay.valueAt(i)).zzah.onDone();
        }
        this.zzay.clear();
    }
}
