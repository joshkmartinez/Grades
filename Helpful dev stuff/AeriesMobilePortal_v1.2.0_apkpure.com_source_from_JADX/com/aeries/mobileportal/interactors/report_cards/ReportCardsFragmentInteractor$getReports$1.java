package com.aeries.mobileportal.interactors.report_cards;

import com.aeries.mobileportal.models.ReportCard;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentInteractor.kt */
final class ReportCardsFragmentInteractor$getReports$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ReportCardsFragmentCallback $callback;
    final /* synthetic */ ReportCardsFragmentInteractor this$0;

    ReportCardsFragmentInteractor$getReports$1(ReportCardsFragmentInteractor reportCardsFragmentInteractor, ReportCardsFragmentCallback reportCardsFragmentCallback) {
        this.this$0 = reportCardsFragmentInteractor;
        this.$callback = reportCardsFragmentCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getReportCardService().getReports(Integer.valueOf(this.this$0.getConfigurationRepository().getSelectedStudent()), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<? extends ReportCard>>() {
            public final void accept(List<ReportCard> list) {
                ReportCardsFragmentCallback reportCardsFragmentCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(list, "it");
                reportCardsFragmentCallback.onReportCardsRetrieved(list);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                this.$callback.onReportCardsError(th);
            }
        });
    }
}
