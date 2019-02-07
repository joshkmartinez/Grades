package com.aeries.mobileportal.views.custom;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.models.Notification;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: AeriesDialog.kt */
final class AeriesDialog$setupViews$1 implements OnClickListener {
    final /* synthetic */ AeriesDialog this$0;

    AeriesDialog$setupViews$1(AeriesDialog aeriesDialog) {
        this.this$0 = aeriesDialog;
    }

    public final void onClick(View view) {
        view = this.this$0.getMListener();
        if (view != null) {
            Notification access$getNotification$p = this.this$0.notification;
            if (access$getNotification$p == null) {
                Intrinsics.throwNpe();
            }
            view.onActionButtonClick(access$getNotification$p);
        }
        this.this$0.dismiss();
    }
}
