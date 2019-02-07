package com.aeries.mobileportal.presenters.demographics;

import com.aeries.mobileportal.interactors.demographics.DemographicsCallback;
import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/presenters/demographics/DemographicsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;", "Lcom/aeries/mobileportal/interactors/demographics/DemographicsCallback;", "demographicsViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/demographics/DemographicsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;Lcom/aeries/mobileportal/interactors/demographics/DemographicsInteractor;)V", "getDemographicsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/demographics/DemographicsInteractor;", "getDemographics", "", "onCreate", "onDemographicsReceived", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DemographicsPresenter.kt */
public final class DemographicsPresenter extends BasePresenter<DemographicsViewModel> implements DemographicsCallback {
    @NotNull
    private final DemographicsViewModel demographicsViewModel;
    @NotNull
    private final DemographicsInteractor interactor;

    public DemographicsPresenter(@NotNull DemographicsViewModel demographicsViewModel, @NotNull DemographicsInteractor demographicsInteractor) {
        Intrinsics.checkParameterIsNotNull(demographicsViewModel, "demographicsViewModel");
        Intrinsics.checkParameterIsNotNull(demographicsInteractor, "interactor");
        super(demographicsViewModel, demographicsInteractor);
        this.demographicsViewModel = demographicsViewModel;
        this.interactor = demographicsInteractor;
    }

    @NotNull
    public final DemographicsViewModel getDemographicsViewModel() {
        return this.demographicsViewModel;
    }

    @NotNull
    public final DemographicsInteractor getInteractor() {
        return this.interactor;
    }

    public final void getDemographics() {
        this.interactor.getCurrentStudentDemographics(this);
    }

    public void onDemographicsReceived(@NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        this.demographicsViewModel.showDemographics(demographics);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
