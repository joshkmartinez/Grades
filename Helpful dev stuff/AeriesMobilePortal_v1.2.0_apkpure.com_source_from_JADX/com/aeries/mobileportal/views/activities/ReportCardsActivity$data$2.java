package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.models.ViewPermission;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/models/ViewPermission;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ReportCardsActivity.kt */
final class ReportCardsActivity$data$2 extends Lambda implements Function0<ViewPermission> {
    final /* synthetic */ ReportCardsActivity this$0;

    ReportCardsActivity$data$2(ReportCardsActivity reportCardsActivity) {
        this.this$0 = reportCardsActivity;
        super(0);
    }

    public final ViewPermission invoke() {
        return (ViewPermission) this.this$0.getIntent().getParcelableExtra(DataBufferSafeParcelable.DATA_FIELD);
    }
}
