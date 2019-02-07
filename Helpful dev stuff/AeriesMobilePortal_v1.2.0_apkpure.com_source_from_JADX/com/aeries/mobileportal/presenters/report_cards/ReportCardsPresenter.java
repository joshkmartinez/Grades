package com.aeries.mobileportal.presenters.report_cards;

import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;", "reportCardsViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsInteractor;)V", "onCreate", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsPresenter.kt */
public final class ReportCardsPresenter extends BasePresenter<ReportCardsViewModel> {
    public void onCreate() {
    }

    public ReportCardsPresenter(@NotNull ReportCardsViewModel reportCardsViewModel, @NotNull ReportCardsInteractor reportCardsInteractor) {
        Intrinsics.checkParameterIsNotNull(reportCardsViewModel, "reportCardsViewModel");
        Intrinsics.checkParameterIsNotNull(reportCardsInteractor, "interactor");
        super(reportCardsViewModel, reportCardsInteractor);
    }
}
