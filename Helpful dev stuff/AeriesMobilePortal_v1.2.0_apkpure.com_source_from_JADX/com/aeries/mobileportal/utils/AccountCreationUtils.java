package com.aeries.mobileportal.utils;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/AccountCreationUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountCreationUtils.kt */
public final class AccountCreationUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/utils/AccountCreationUtils$Companion;", "", "()V", "checkValidConfirmation", "", "input", "Landroid/text/Editable;", "inputConfirm", "checkValidEmail", "email", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountCreationUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean checkValidConfirmation(@Nullable Editable editable, @Nullable Editable editable2) {
            Object valueOf = String.valueOf(editable);
            Object valueOf2 = String.valueOf(editable2);
            return ((Intrinsics.areEqual(valueOf, (Object) "") ^ 1) == 0 || (Intrinsics.areEqual(valueOf2, (Object) "") ^ 1) == 0 || Intrinsics.areEqual(valueOf, valueOf2) == null) ? false : true;
        }

        public final boolean checkValidEmail(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "email");
            return new Regex(".+@.+[.].+").containsMatchIn(str);
        }
    }
}
