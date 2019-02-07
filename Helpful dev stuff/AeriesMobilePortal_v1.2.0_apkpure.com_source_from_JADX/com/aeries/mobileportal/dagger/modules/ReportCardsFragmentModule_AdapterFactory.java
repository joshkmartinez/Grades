package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.ReportCardsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ReportCardsFragmentModule_AdapterFactory implements Factory<ReportCardsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ReportCardsFragmentModule module;

    public ReportCardsFragmentModule_AdapterFactory(ReportCardsFragmentModule reportCardsFragmentModule) {
        this.module = reportCardsFragmentModule;
    }

    public ReportCardsAdapter get() {
        return (ReportCardsAdapter) Preconditions.checkNotNull(this.module.adapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardsAdapter> create(ReportCardsFragmentModule reportCardsFragmentModule) {
        return new ReportCardsFragmentModule_AdapterFactory(reportCardsFragmentModule);
    }
}
