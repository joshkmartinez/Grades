package com.aeries.mobileportal.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/KeyboardUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: KeyboardUtils.kt */
public final class KeyboardUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/utils/KeyboardUtils$Companion;", "", "()V", "hideKeyboard", "", "view", "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: KeyboardUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void hideKeyboard(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            view.clearFocus();
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
