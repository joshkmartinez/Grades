package com.aeries.mobileportal;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/FontManager;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FontManager.kt */
public final class FontManager {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String FONTAWESOME;
    @NotNull
    private static final String ROOT = "fonts/";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/FontManager$Companion;", "", "()V", "FONTAWESOME", "", "getFONTAWESOME", "()Ljava/lang/String;", "ROOT", "getROOT", "getTypeface", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: FontManager.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getROOT() {
            return FontManager.ROOT;
        }

        @NotNull
        public final String getFONTAWESOME() {
            return FontManager.FONTAWESOME;
        }

        @NotNull
        public final Typeface getTypeface(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "font");
            context = Typeface.createFromAsset(context.getAssets(), str);
            Intrinsics.checkExpressionValueIsNotNull(context, "Typeface.createFromAsset(context.assets, font)");
            return context;
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ROOT);
        stringBuilder.append("fontawesome-webfont.ttf");
        FONTAWESOME = stringBuilder.toString();
    }
}
