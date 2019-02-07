package com.aeries.mobileportal.utils;

import android.content.Context;
import android.util.Log;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.custom.AeriesDialogI.Builder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/DialogUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DialogUtils.kt */
public final class DialogUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001c\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/utils/DialogUtils$Companion;", "", "()V", "getDialogBuilder", "Lcom/aeries/mobileportal/views/custom/AeriesDialogI$Builder;", "context", "Landroid/content/Context;", "title", "", "message", "", "getErrorDialogBuilder", "getReadableMessage", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DialogUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Builder getErrorDialogBuilder(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Log.d("ERROR MESSAGE", str);
            return new Builder(context).setTitle((int) C0316R.string.error).setMessage(getReadableMessage(str, context));
        }

        @NotNull
        public final Builder getDialogBuilder(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return new Builder(context).setTitle(str).setMessage(getReadableMessage(str2, context));
        }

        @NotNull
        public final Builder getDialogBuilder(@NotNull Context context, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return new Builder(context).setTitle(i).setMessage(i2);
        }

        private final String getReadableMessage(String str, Context context) {
            if (Intrinsics.areEqual((Object) str, (Object) "timeout")) {
                return context.getString(C0316R.string.request_not_completed);
            }
            if (!(str != null ? StringsKt.contains(str, "503", false) : false)) {
                return str;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            context = context.getString(C0316R.string.server_error);
            Intrinsics.checkExpressionValueIsNotNull(context, "context.getString(R.string.server_error)");
            Object[] objArr = new Object[]{str};
            str = String.format(context, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
            return str;
        }
    }
}
