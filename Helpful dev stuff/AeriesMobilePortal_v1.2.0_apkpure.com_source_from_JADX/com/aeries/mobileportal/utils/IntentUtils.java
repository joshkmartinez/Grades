package com.aeries.mobileportal.utils;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/IntentUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: IntentUtils.kt */
public final class IntentUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/utils/IntentUtils$Companion;", "", "()V", "getEmailIntent", "Landroid/content/Intent;", "email", "", "getLocationIntent", "mapsAddress", "getPhoneIntent", "phone", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: IntentUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Intent getLocationIntent(@Nullable String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("geo:0,0?q=");
            stringBuilder.append(str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
            intent.setPackage("com.google.android.apps.maps");
            return intent;
        }

        @NotNull
        public final Intent getPhoneIntent(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "phone");
            Intent intent = new Intent("android.intent.action.DIAL");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tel:");
            stringBuilder.append(str);
            intent.setData(Uri.parse(stringBuilder.toString()));
            return intent;
        }

        @NotNull
        public final Intent getEmailIntent(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "email");
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
            return intent;
        }
    }
}
