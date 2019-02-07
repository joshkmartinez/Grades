package com.aeries.mobileportal.views.custom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 10})
/* compiled from: AeriesDialogI.kt */
final class AeriesDialogI$create$3 implements OnCancelListener {
    final /* synthetic */ AeriesDialogI this$0;

    AeriesDialogI$create$3(AeriesDialogI aeriesDialogI) {
        this.this$0 = aeriesDialogI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface = this.this$0.getBuilder().getOnCancel();
        if (dialogInterface != null) {
            Unit unit = (Unit) dialogInterface.invoke();
        }
    }
}
