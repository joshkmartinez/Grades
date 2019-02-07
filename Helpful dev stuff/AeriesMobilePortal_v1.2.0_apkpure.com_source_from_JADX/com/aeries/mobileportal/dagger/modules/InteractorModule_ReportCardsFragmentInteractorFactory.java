package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_ReportCardsFragmentInteractorFactory implements Factory<ReportCardsFragmentInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final InteractorModule module;
    private final Provider<ReportCardService> reportCardServiceProvider;
    private final Provider<TokenProvider> tokenProvider;

    public InteractorModule_ReportCardsFragmentInteractorFactory(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<TokenProvider> provider2, Provider<ReportCardService> provider3, Provider<Context> provider4) {
        this.module = interactorModule;
        this.configurationRepositoryProvider = provider;
        this.tokenProvider = provider2;
        this.reportCardServiceProvider = provider3;
        this.contextProvider = provider4;
    }

    public ReportCardsFragmentInteractor get() {
        return (ReportCardsFragmentInteractor) Preconditions.checkNotNull(this.module.reportCardsFragmentInteractor((ConfigurationRepository) this.configurationRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get(), (ReportCardService) this.reportCardServiceProvider.get(), (Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardsFragmentInteractor> create(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<TokenProvider> provider2, Provider<ReportCardService> provider3, Provider<Context> provider4) {
        return new InteractorModule_ReportCardsFragmentInteractorFactory(interactorModule, provider, provider2, provider3, provider4);
    }
}
