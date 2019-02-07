package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportCardsModule_ReportCardsPresenterFactory implements Factory<ReportCardsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ReportCardsInteractor> interactorProvider;
    private final ReportCardsModule module;

    public ReportCardsModule_ReportCardsPresenterFactory(ReportCardsModule reportCardsModule, Provider<ReportCardsInteractor> provider) {
        this.module = reportCardsModule;
        this.interactorProvider = provider;
    }

    public ReportCardsPresenter get() {
        return (ReportCardsPresenter) Preconditions.checkNotNull(this.module.reportCardsPresenter((ReportCardsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardsPresenter> create(ReportCardsModule reportCardsModule, Provider<ReportCardsInteractor> provider) {
        return new ReportCardsModule_ReportCardsPresenterFactory(reportCardsModule, provider);
    }
}
