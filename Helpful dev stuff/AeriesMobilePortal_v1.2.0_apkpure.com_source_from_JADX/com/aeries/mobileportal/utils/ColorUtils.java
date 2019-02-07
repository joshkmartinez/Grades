package com.aeries.mobileportal.utils;

import com.aeries.mobileportal.C0316R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/ColorUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ColorUtils.kt */
public final class ColorUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/utils/ColorUtils$Companion;", "", "()V", "getGradeHolderColor", "", "grade", "", "currentMark", "", "(Ljava/lang/Double;Ljava/lang/String;)I", "getGradeTextColor", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ColorUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getGradeHolderColor(@Nullable Double d, @Nullable String str) {
            if (d == null || Intrinsics.areEqual((Object) str, (Object) "")) {
                return C0316R.color.grayBackground;
            }
            if (str == null) {
                return C0316R.color.grayBackground;
            }
            if (RangesKt.intRangeContains(new IntRange(98, 999), d.doubleValue()) != null) {
                return C0316R.color.a_plus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(95, 97), d.doubleValue()) != null) {
                return C0316R.color.a_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(90, 94), d.doubleValue()) != null) {
                return C0316R.color.a_minus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(88, 89), d.doubleValue()) != null) {
                return C0316R.color.b_plus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(85, 87), d.doubleValue()) != null) {
                return C0316R.color.b_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(80, 84), d.doubleValue()) != null) {
                return C0316R.color.b_minus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(78, 79), d.doubleValue()) != null) {
                return C0316R.color.c_plus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(75, 77), d.doubleValue()) != null) {
                return C0316R.color.c_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(70, 74), d.doubleValue()) != null) {
                return C0316R.color.c_minus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(68, 69), d.doubleValue()) != null) {
                return C0316R.color.d_plus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(65, 67), d.doubleValue()) != null) {
                return C0316R.color.d_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(60, 64), d.doubleValue()) != null) {
                return C0316R.color.d_minus_cell;
            }
            if (RangesKt.intRangeContains(new IntRange(null, 59), d.doubleValue()) != null) {
                return C0316R.color.f_cell;
            }
            return C0316R.color.grayBackground;
        }

        public final int getGradeTextColor(@Nullable Double d, @Nullable String str) {
            if (d == null || Intrinsics.areEqual((Object) str, (Object) "")) {
                return C0316R.color.black_font;
            }
            if (str == null) {
                return C0316R.color.black_font;
            }
            if (RangesKt.intRangeContains(new IntRange(98, 999), d.doubleValue()) != null) {
                return C0316R.color.a_plus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(95, 97), d.doubleValue()) != null) {
                return C0316R.color.a_text;
            }
            if (RangesKt.intRangeContains(new IntRange(90, 94), d.doubleValue()) != null) {
                return C0316R.color.a_minus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(88, 89), d.doubleValue()) != null) {
                return C0316R.color.b_plus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(85, 87), d.doubleValue()) != null) {
                return C0316R.color.b_text;
            }
            if (RangesKt.intRangeContains(new IntRange(80, 84), d.doubleValue()) != null) {
                return C0316R.color.b_minus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(78, 79), d.doubleValue()) != null) {
                return C0316R.color.c_plus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(75, 77), d.doubleValue()) != null) {
                return C0316R.color.c_text;
            }
            if (RangesKt.intRangeContains(new IntRange(70, 74), d.doubleValue()) != null) {
                return C0316R.color.c_minus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(68, 69), d.doubleValue()) != null) {
                return C0316R.color.d_plus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(65, 67), d.doubleValue()) != null) {
                return C0316R.color.d_text;
            }
            if (RangesKt.intRangeContains(new IntRange(60, 64), d.doubleValue()) != null) {
                return C0316R.color.d_minus_text;
            }
            if (RangesKt.intRangeContains(new IntRange(null, 59), d.doubleValue()) != null) {
                return C0316R.color.f_text;
            }
            return C0316R.color.black_font;
        }
    }
}
