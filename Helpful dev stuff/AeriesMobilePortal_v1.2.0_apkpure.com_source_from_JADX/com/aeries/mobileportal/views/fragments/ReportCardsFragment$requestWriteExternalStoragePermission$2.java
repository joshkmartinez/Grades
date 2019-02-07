package com.aeries.mobileportal.views.fragments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 10})
/* compiled from: ReportCardsFragment.kt */
final class ReportCardsFragment$requestWriteExternalStoragePermission$2 implements OnCancelListener {
    final /* synthetic */ ReportCardsFragment this$0;

    ReportCardsFragment$requestWriteExternalStoragePermission$2(ReportCardsFragment reportCardsFragment) {
        this.this$0 = reportCardsFragment;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.this$0.requestWritePermission();
    }
}
