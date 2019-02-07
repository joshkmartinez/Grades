package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InteractorModule_ReportCardsInteractorFactory implements Factory<ReportCardsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InteractorModule module;

    public InteractorModule_ReportCardsInteractorFactory(InteractorModule interactorModule) {
        this.module = interactorModule;
    }

    public ReportCardsInteractor get() {
        return (ReportCardsInteractor) Preconditions.checkNotNull(this.module.reportCardsInteractor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardsInteractor> create(InteractorModule interactorModule) {
        return new InteractorModule_ReportCardsInteractorFactory(interactorModule);
    }
}
