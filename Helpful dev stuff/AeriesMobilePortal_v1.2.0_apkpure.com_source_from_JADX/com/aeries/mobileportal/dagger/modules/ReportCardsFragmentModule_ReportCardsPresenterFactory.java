package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsFragmentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReportCardsFragmentModule_ReportCardsPresenterFactory implements Factory<ReportCardsFragmentPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ReportCardsFragmentInteractor> interactorProvider;
    private final ReportCardsFragmentModule module;

    public ReportCardsFragmentModule_ReportCardsPresenterFactory(ReportCardsFragmentModule reportCardsFragmentModule, Provider<ReportCardsFragmentInteractor> provider) {
        this.module = reportCardsFragmentModule;
        this.interactorProvider = provider;
    }

    public ReportCardsFragmentPresenter get() {
        return (ReportCardsFragmentPresenter) Preconditions.checkNotNull(this.module.reportCardsPresenter((ReportCardsFragmentInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardsFragmentPresenter> create(ReportCardsFragmentModule reportCardsFragmentModule, Provider<ReportCardsFragmentInteractor> provider) {
        return new ReportCardsFragmentModule_ReportCardsPresenterFactory(reportCardsFragmentModule, provider);
    }
}
