package com.aeries.mobileportal.views.custom;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/aeries/mobileportal/views/custom/AeriesDialogI$create$2$1"}, k = 3, mv = {1, 1, 10})
/* compiled from: AeriesDialogI.kt */
final class AeriesDialogI$create$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ Dialog $dialog$inlined;
    final /* synthetic */ AeriesDialogI this$0;

    AeriesDialogI$create$$inlined$apply$lambda$1(AeriesDialogI aeriesDialogI, Dialog dialog) {
        this.this$0 = aeriesDialogI;
        this.$dialog$inlined = dialog;
    }

    public final void onClick(View view) {
        view = this.this$0.getBuilder().getOnClickListener();
        if (view != null) {
            Unit unit = (Unit) view.invoke();
        }
        this.$dialog$inlined.dismiss();
    }
}
