package com.aeries.mobileportal;

import android.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/ColorConstants;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ColorConstants.kt */
public final class ColorConstants {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final Integer[][] courseColors;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/ColorConstants$Companion;", "", "()V", "courseColors", "", "", "getCourseColors", "()[[Ljava/lang/Integer;", "[[Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ColorConstants.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Integer[][] getCourseColors() {
            return ColorConstants.courseColors;
        }
    }

    static {
        r0 = new Integer[7][];
        r0[0] = new Integer[]{Integer.valueOf(Color.parseColor("#C64646")), Integer.valueOf(Color.parseColor("#B13131"))};
        r0[1] = new Integer[]{Integer.valueOf(Color.parseColor("#C6A846")), Integer.valueOf(Color.parseColor("#97823E"))};
        r0[2] = new Integer[]{Integer.valueOf(Color.parseColor("#A4C646")), Integer.valueOf(Color.parseColor("#728736"))};
        r0[3] = new Integer[]{Integer.valueOf(Color.parseColor("#46C65F")), Integer.valueOf(Color.parseColor("#258538"))};
        r0[4] = new Integer[]{Integer.valueOf(Color.parseColor("#46B4C6")), Integer.valueOf(Color.parseColor("#3596A6"))};
        r0[5] = new Integer[]{Integer.valueOf(Color.parseColor("#7146C6")), Integer.valueOf(Color.parseColor("#522F98"))};
        r0[6] = new Integer[]{Integer.valueOf(Color.parseColor("#C64682")), Integer.valueOf(Color.parseColor("#982F80"))};
        courseColors = r0;
    }
}
