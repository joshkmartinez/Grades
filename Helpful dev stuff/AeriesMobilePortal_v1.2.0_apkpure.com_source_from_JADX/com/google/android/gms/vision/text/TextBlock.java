package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzt[] zzcw;
    private List<Line> zzcx;
    private String zzcy;
    private Rect zzcz;

    TextBlock(SparseArray<zzt> sparseArray) {
        this.zzcw = new zzt[sparseArray.size()];
        for (int i = 0; i < this.zzcw.length; i++) {
            this.zzcw[i] = (zzt) sparseArray.valueAt(i);
        }
    }

    public Rect getBoundingBox() {
        if (this.zzcz == null) {
            this.zzcz = zzc.zza((Text) this);
        }
        return this.zzcz;
    }

    public List<? extends Text> getComponents() {
        int i = 0;
        if (this.zzcw.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzcx == null) {
            this.zzcx = new ArrayList(this.zzcw.length);
            zzt[] com_google_android_gms_internal_vision_zztArr = this.zzcw;
            int length = com_google_android_gms_internal_vision_zztArr.length;
            while (i < length) {
                this.zzcx.add(new Line(com_google_android_gms_internal_vision_zztArr[i]));
                i++;
            }
        }
        return this.zzcx;
    }

    public Point[] getCornerPoints() {
        if (this.cornerPoints == null) {
            int i = 0;
            if (r0.zzcw.length == 0) {
                r0.cornerPoints = new Point[0];
            } else {
                double sin;
                int i2;
                int i3;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MIN_VALUE;
                int i6 = i5;
                int i7 = 0;
                int i8 = Integer.MAX_VALUE;
                while (i7 < r0.zzcw.length) {
                    zzn com_google_android_gms_internal_vision_zzn = r0.zzcw[i7].zzde;
                    zzn com_google_android_gms_internal_vision_zzn2 = r0.zzcw[i].zzde;
                    int i9 = -com_google_android_gms_internal_vision_zzn2.left;
                    int i10 = -com_google_android_gms_internal_vision_zzn2.top;
                    sin = Math.sin(Math.toRadians((double) com_google_android_gms_internal_vision_zzn2.zzdc));
                    double cos = Math.cos(Math.toRadians((double) com_google_android_gms_internal_vision_zzn2.zzdc));
                    Point[] pointArr = new Point[4];
                    i2 = i6;
                    pointArr[0] = new Point(com_google_android_gms_internal_vision_zzn.left, com_google_android_gms_internal_vision_zzn.top);
                    pointArr[0].offset(i9, i10);
                    i3 = i4;
                    i = (int) ((((double) pointArr[0].x) * cos) + (((double) pointArr[0].y) * sin));
                    i6 = (int) ((((double) (-pointArr[0].x)) * sin) + (((double) pointArr[0].y) * cos));
                    pointArr[0].x = i;
                    pointArr[0].y = i6;
                    pointArr[1] = new Point(com_google_android_gms_internal_vision_zzn.width + i, i6);
                    pointArr[2] = new Point(com_google_android_gms_internal_vision_zzn.width + i, com_google_android_gms_internal_vision_zzn.height + i6);
                    pointArr[3] = new Point(i, i6 + com_google_android_gms_internal_vision_zzn.height);
                    i6 = i2;
                    i4 = i3;
                    for (i = 0; i < 4; i++) {
                        Point point = pointArr[i];
                        i4 = Math.min(i4, point.x);
                        i5 = Math.max(i5, point.x);
                        i8 = Math.min(i8, point.y);
                        i6 = Math.max(i6, point.y);
                    }
                    i7++;
                    i = 0;
                }
                i3 = i4;
                i2 = i6;
                zzn com_google_android_gms_internal_vision_zzn3 = r0.zzcw[0].zzde;
                i = com_google_android_gms_internal_vision_zzn3.left;
                i4 = com_google_android_gms_internal_vision_zzn3.top;
                double sin2 = Math.sin(Math.toRadians((double) com_google_android_gms_internal_vision_zzn3.zzdc));
                sin = Math.cos(Math.toRadians((double) com_google_android_gms_internal_vision_zzn3.zzdc));
                r10 = new Point[4];
                int i11 = i3;
                int i12 = 0;
                r10[0] = new Point(i11, i8);
                r10[1] = new Point(i5, i8);
                i8 = i2;
                r10[2] = new Point(i5, i8);
                r10[3] = new Point(i11, i8);
                while (i12 < 4) {
                    int i13 = i;
                    i7 = (int) ((((double) r10[i12].x) * sin2) + (((double) r10[i12].y) * sin));
                    r10[i12].x = (int) ((((double) r10[i12].x) * sin) - (((double) r10[i12].y) * sin2));
                    r10[i12].y = i7;
                    i = i13;
                    r10[i12].offset(i, i4);
                    i12++;
                }
                r0.cornerPoints = r10;
            }
        }
        return r0.cornerPoints;
    }

    public String getLanguage() {
        if (this.zzcy != null) {
            return this.zzcy;
        }
        HashMap hashMap = new HashMap();
        for (zzt com_google_android_gms_internal_vision_zzt : this.zzcw) {
            hashMap.put(com_google_android_gms_internal_vision_zzt.zzcy, Integer.valueOf((hashMap.containsKey(com_google_android_gms_internal_vision_zzt.zzcy) ? ((Integer) hashMap.get(com_google_android_gms_internal_vision_zzt.zzcy)).intValue() : 0) + 1));
        }
        this.zzcy = (String) ((Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        if (this.zzcy == null || this.zzcy.isEmpty()) {
            this.zzcy = "und";
        }
        return this.zzcy;
    }

    public String getValue() {
        if (this.zzcw.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(this.zzcw[0].zzdh);
        for (int i = 1; i < this.zzcw.length; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(this.zzcw[i].zzdh);
        }
        return stringBuilder.toString();
    }
}
