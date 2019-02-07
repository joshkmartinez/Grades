package com.aeries.mobileportal.presenters.change_district;

import com.aeries.mobileportal.interactors.change_district.ChangeDistrictCallback;
import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0016J\b\u0010#\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/presenters/change_district/ChangeDistrictPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictCallback;", "changeDistrictViewModel", "changeDistrictInteractor", "Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;)V", "getChangeDistrictInteractor", "()Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;", "getChangeDistrictViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "checkSchoolAvailability", "", "school", "Lcom/aeries/mobileportal/models/School;", "deleteDistrict", "getCurrentDistrict", "", "getSchools", "onAppAvailable", "onAppAvailableError", "e", "", "onAppNotAvailable", "status", "onCreate", "onDistrictDeleted", "onDistrictDeletedError", "onPermissionsError", "onPermissionsFail", "onPermissionsRetrieved", "onSchoolsRetrieved", "schools", "", "onURLChanged", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictPresenter.kt */
public final class ChangeDistrictPresenter extends BasePresenter<ChangeDistrictViewModel> implements ChangeDistrictCallback {
    @NotNull
    private final ChangeDistrictInteractor changeDistrictInteractor;
    @NotNull
    private final ChangeDistrictViewModel changeDistrictViewModel;

    public ChangeDistrictPresenter(@NotNull ChangeDistrictViewModel changeDistrictViewModel, @NotNull ChangeDistrictInteractor changeDistrictInteractor) {
        Intrinsics.checkParameterIsNotNull(changeDistrictViewModel, "changeDistrictViewModel");
        Intrinsics.checkParameterIsNotNull(changeDistrictInteractor, "changeDistrictInteractor");
        super(changeDistrictViewModel, changeDistrictInteractor);
        this.changeDistrictViewModel = changeDistrictViewModel;
        this.changeDistrictInteractor = changeDistrictInteractor;
    }

    @NotNull
    public final ChangeDistrictInteractor getChangeDistrictInteractor() {
        return this.changeDistrictInteractor;
    }

    @NotNull
    public final ChangeDistrictViewModel getChangeDistrictViewModel() {
        return this.changeDistrictViewModel;
    }

    public final void getSchools() {
        this.changeDistrictInteractor.getSchools(this);
    }

    public final void checkSchoolAvailability(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.changeDistrictInteractor.checkSchoolAvailability(school, this);
    }

    public final void deleteDistrict(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.changeDistrictInteractor.deleteDistrict(school, this);
    }

    public void onSchoolsRetrieved(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        this.changeDistrictViewModel.updateDistricts(list);
    }

    public void onAppAvailable(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.changeDistrictInteractor.checkAccountSettings(school, this);
    }

    public void onAppNotAvailable(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.changeDistrictViewModel.showError(str);
    }

    public void onAppAvailableError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        ChangeDistrictViewModel changeDistrictViewModel = this.changeDistrictViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        changeDistrictViewModel.showError(th);
    }

    public void onPermissionsRetrieved(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.changeDistrictInteractor.setNewBaseURL(school, this);
    }

    public void onPermissionsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        ChangeDistrictViewModel changeDistrictViewModel = this.changeDistrictViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        changeDistrictViewModel.showError(th);
    }

    public void onPermissionsFail() {
        this.changeDistrictViewModel.showError("Something went wrong, please try again later");
    }

    public void onURLChanged() {
        this.changeDistrictViewModel.goToLogin();
    }

    public void onDistrictDeleted(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.changeDistrictViewModel.notifyDistrictDeleted(school);
    }

    public void onDistrictDeletedError() {
        this.changeDistrictViewModel.notifyDistrictDeletedError();
    }

    public void onCreate() {
        attachView(this.changeDistrictViewModel);
    }

    @NotNull
    public final String getCurrentDistrict() {
        return this.changeDistrictInteractor.getCurrentDistrict();
    }
}
