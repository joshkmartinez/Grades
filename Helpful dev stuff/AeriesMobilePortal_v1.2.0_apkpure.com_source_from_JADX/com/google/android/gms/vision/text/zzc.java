package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzn;

final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : text.getCornerPoints()) {
            i2 = Math.min(i2, point.x);
            i = Math.max(i, point.x);
            i4 = Math.min(i4, point.y);
            i3 = Math.max(i3, point.y);
        }
        return new Rect(i2, i4, i, i3);
    }

    static Point[] zza(zzn com_google_android_gms_internal_vision_zzn) {
        r0 = new Point[4];
        double sin = Math.sin(Math.toRadians((double) com_google_android_gms_internal_vision_zzn.zzdc));
        double cos = Math.cos(Math.toRadians((double) com_google_android_gms_internal_vision_zzn.zzdc));
        r0[0] = new Point(com_google_android_gms_internal_vision_zzn.left, com_google_android_gms_internal_vision_zzn.top);
        r0[1] = new Point((int) (((double) com_google_android_gms_internal_vision_zzn.left) + (((double) com_google_android_gms_internal_vision_zzn.width) * cos)), (int) (((double) com_google_android_gms_internal_vision_zzn.top) + (((double) com_google_android_gms_internal_vision_zzn.width) * sin)));
        r0[2] = new Point((int) (((double) r0[1].x) - (((double) com_google_android_gms_internal_vision_zzn.height) * sin)), (int) (((double) r0[1].y) + (((double) com_google_android_gms_internal_vision_zzn.height) * cos)));
        r0[3] = new Point(r0[0].x + (r0[2].x - r0[1].x), r0[0].y + (r0[2].y - r0[1].y));
        return r0;
    }
}
