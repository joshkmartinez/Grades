package com.aeries.mobileportal.views.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onGlobalLayout"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginActivity.kt */
final class LoginActivity$setupViews$2 implements OnGlobalLayoutListener {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$setupViews$2(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void onGlobalLayout() {
        boolean z;
        Rect rect = new Rect();
        this.this$0.getRootView().getWindowVisibleDisplayFrame(rect);
        View rootView = this.this$0.getRootView().getRootView();
        Intrinsics.checkExpressionValueIsNotNull(rootView, "rootView.rootView");
        int height = rootView.getHeight();
        int i = height - rect.bottom;
        LoginActivity loginActivity = this.this$0;
        if (((double) i) <= ((double) height) * 0.2d) {
            Resources resources = this.this$0.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
            if (resources.getConfiguration().fontScale < 1.3f) {
                z = false;
                loginActivity.setUpperViewsGone(z);
            }
        }
        z = true;
        loginActivity.setUpperViewsGone(z);
    }
}
