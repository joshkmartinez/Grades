package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.report_cards.ReportCardsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReportCardsActivity_MembersInjector implements MembersInjector<ReportCardsActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ReportCardsPresenter> presenterProvider;

    public ReportCardsActivity_MembersInjector(Provider<ReportCardsPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<ReportCardsActivity> create(Provider<ReportCardsPresenter> provider) {
        return new ReportCardsActivity_MembersInjector(provider);
    }

    public void injectMembers(ReportCardsActivity reportCardsActivity) {
        if (reportCardsActivity != null) {
            reportCardsActivity.presenter = (ReportCardsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
