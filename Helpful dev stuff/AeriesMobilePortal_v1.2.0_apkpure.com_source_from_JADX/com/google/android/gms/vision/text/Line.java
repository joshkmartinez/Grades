package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzt;
import java.util.ArrayList;
import java.util.List;

public class Line implements Text {
    private zzt zzcu;
    private List<Element> zzcv;

    Line(zzt com_google_android_gms_internal_vision_zzt) {
        this.zzcu = com_google_android_gms_internal_vision_zzt;
    }

    public float getAngle() {
        return this.zzcu.zzde.zzdc;
    }

    public Rect getBoundingBox() {
        return zzc.zza((Text) this);
    }

    public List<? extends Text> getComponents() {
        int i = 0;
        if (this.zzcu.zzdd.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzcv == null) {
            this.zzcv = new ArrayList(this.zzcu.zzdd.length);
            zzac[] com_google_android_gms_internal_vision_zzacArr = this.zzcu.zzdd;
            int length = com_google_android_gms_internal_vision_zzacArr.length;
            while (i < length) {
                this.zzcv.add(new Element(com_google_android_gms_internal_vision_zzacArr[i]));
                i++;
            }
        }
        return this.zzcv;
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzcu.zzde);
    }

    public String getLanguage() {
        return this.zzcu.zzcy;
    }

    public String getValue() {
        return this.zzcu.zzdh;
    }

    public boolean isVertical() {
        return this.zzcu.zzdj;
    }
}
