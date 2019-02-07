package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.ReportCardsAdapter;
import com.aeries.mobileportal.adapters.ReportCardsAdapter.ReportCardsListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsFragmentPresenter;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsFragmentViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ReportCardsFragmentModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "listener", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "(Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "adapter", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;", "reportCardsPresenter", "Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsFragmentPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ReportCardsFragmentModule.kt */
public final class ReportCardsFragmentModule {
    @NotNull
    private final ReportCardsListener listener;
    @NotNull
    private final ReportCardsFragmentViewModel viewModel;

    public ReportCardsFragmentModule(@NotNull ReportCardsFragmentViewModel reportCardsFragmentViewModel, @NotNull ReportCardsListener reportCardsListener) {
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(reportCardsListener, CastExtraArgs.LISTENER);
        this.viewModel = reportCardsFragmentViewModel;
        this.listener = reportCardsListener;
    }

    @NotNull
    public final ReportCardsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ReportCardsFragmentViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final ReportCardsFragmentPresenter reportCardsPresenter(@NotNull ReportCardsFragmentInteractor reportCardsFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentInteractor, "interactor");
        return new ReportCardsFragmentPresenter(this.viewModel, reportCardsFragmentInteractor);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final ReportCardsAdapter adapter() {
        return new ReportCardsAdapter(this.listener);
    }
}
