package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsPresenter;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ReportCardsModule;", "", "viewMode", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;)V", "getViewMode", "()Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;", "reportCardsPresenter", "Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ReportCardsModule.kt */
public final class ReportCardsModule {
    @NotNull
    private final ReportCardsViewModel viewMode;

    public ReportCardsModule(@NotNull ReportCardsViewModel reportCardsViewModel) {
        Intrinsics.checkParameterIsNotNull(reportCardsViewModel, "viewMode");
        this.viewMode = reportCardsViewModel;
    }

    @NotNull
    public final ReportCardsViewModel getViewMode() {
        return this.viewMode;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ReportCardsPresenter reportCardsPresenter(@NotNull ReportCardsInteractor reportCardsInteractor) {
        Intrinsics.checkParameterIsNotNull(reportCardsInteractor, "interactor");
        return new ReportCardsPresenter(this.viewMode, reportCardsInteractor);
    }
}
