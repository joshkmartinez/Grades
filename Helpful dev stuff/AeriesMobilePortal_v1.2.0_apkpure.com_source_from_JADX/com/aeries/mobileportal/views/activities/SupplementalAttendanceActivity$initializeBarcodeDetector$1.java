package com.aeries.mobileportal.views.activities;

import android.content.Intent;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import com.google.android.gms.vision.barcode.Barcode;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/activities/SupplementalAttendanceActivity$initializeBarcodeDetector$1", "Lcom/google/android/gms/vision/Detector$Processor;", "Lcom/google/android/gms/vision/barcode/Barcode;", "(Lcom/aeries/mobileportal/views/activities/SupplementalAttendanceActivity;)V", "receiveDetections", "", "p0", "Lcom/google/android/gms/vision/Detector$Detections;", "release", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceActivity.kt */
public final class SupplementalAttendanceActivity$initializeBarcodeDetector$1 implements Processor<Barcode> {
    final /* synthetic */ SupplementalAttendanceActivity this$0;

    public void release() {
    }

    SupplementalAttendanceActivity$initializeBarcodeDetector$1(SupplementalAttendanceActivity supplementalAttendanceActivity) {
        this.this$0 = supplementalAttendanceActivity;
    }

    public void receiveDetections(@Nullable Detections<Barcode> detections) {
        if (detections != null && detections.getDetectedItems().size() != 0) {
            Intent intent;
            detections = detections.getDetectedItems();
            if (detections != null) {
                Barcode barcode = (Barcode) detections.valueAt(0);
                if (barcode != null) {
                    detections = barcode.displayValue;
                    this.this$0.runOnUiThread(new C0361x3ff55c15(this));
                    this.this$0.getBarcodeDetector().release();
                    intent = new Intent();
                    intent.putExtra(SupplementalAttendanceActivity.Companion.getURL(), detections);
                    this.this$0.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
            detections = null;
            this.this$0.runOnUiThread(new C0361x3ff55c15(this));
            this.this$0.getBarcodeDetector().release();
            intent = new Intent();
            intent.putExtra(SupplementalAttendanceActivity.Companion.getURL(), detections);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
        }
    }
}
