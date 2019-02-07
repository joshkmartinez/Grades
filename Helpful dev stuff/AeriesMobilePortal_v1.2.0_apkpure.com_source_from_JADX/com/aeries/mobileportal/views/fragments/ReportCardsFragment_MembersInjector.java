package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.ReportCardsAdapter;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsFragmentPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReportCardsFragment_MembersInjector implements MembersInjector<ReportCardsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ReportCardsAdapter> adapterProvider;
    private final Provider<ReportCardsFragmentPresenter> presenterProvider;

    public ReportCardsFragment_MembersInjector(Provider<ReportCardsFragmentPresenter> provider, Provider<ReportCardsAdapter> provider2) {
        this.presenterProvider = provider;
        this.adapterProvider = provider2;
    }

    public static MembersInjector<ReportCardsFragment> create(Provider<ReportCardsFragmentPresenter> provider, Provider<ReportCardsAdapter> provider2) {
        return new ReportCardsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ReportCardsFragment reportCardsFragment) {
        if (reportCardsFragment != null) {
            reportCardsFragment.presenter = (ReportCardsFragmentPresenter) this.presenterProvider.get();
            reportCardsFragment.adapter = (ReportCardsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
