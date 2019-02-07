package com.aeries.mobileportal.views.activities;

import android.app.ProgressDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/ProgressDialog;", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AddDistrictActivity.kt */
final class AddDistrictActivity$progressDialog$2 extends Lambda implements Function0<ProgressDialog> {
    final /* synthetic */ AddDistrictActivity this$0;

    AddDistrictActivity$progressDialog$2(AddDistrictActivity addDistrictActivity) {
        this.this$0 = addDistrictActivity;
        super(0);
    }

    @NotNull
    public final ProgressDialog invoke() {
        return new ProgressDialog(this.this$0);
    }
}
