package com.aeries.mobileportal.presenters.add_district;

import com.aeries.mobileportal.interactors.add_district.AddDistrictCallback;
import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/aeries/mobileportal/presenters/add_district/AddDistrictPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;", "Lcom/aeries/mobileportal/interactors/add_district/AddDistrictCallback;", "addDistrictViewModel", "addDistrictInteractor", "Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;)V", "getAddDistrictInteractor", "()Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;", "getAddDistrictViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;", "checkAppStatus", "", "school", "Lcom/aeries/mobileportal/models/School;", "checkSchoolPermissions", "onAppAvailable", "onAppCheckError", "e", "", "onAppNotAvailable", "error", "", "onCreate", "onPermissionsError", "onPermissionsFail", "onPermissionsRetrieved", "onSchoolRepeated", "message", "onSearchDistrictError", "onURLUpdated", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddDistrictPresenter.kt */
public final class AddDistrictPresenter extends BasePresenter<AddDistrictViewModel> implements AddDistrictCallback {
    @NotNull
    private final AddDistrictInteractor addDistrictInteractor;
    @NotNull
    private final AddDistrictViewModel addDistrictViewModel;

    public AddDistrictPresenter(@NotNull AddDistrictViewModel addDistrictViewModel, @NotNull AddDistrictInteractor addDistrictInteractor) {
        Intrinsics.checkParameterIsNotNull(addDistrictViewModel, "addDistrictViewModel");
        Intrinsics.checkParameterIsNotNull(addDistrictInteractor, "addDistrictInteractor");
        super(addDistrictViewModel, addDistrictInteractor);
        this.addDistrictViewModel = addDistrictViewModel;
        this.addDistrictInteractor = addDistrictInteractor;
    }

    @NotNull
    public final AddDistrictInteractor getAddDistrictInteractor() {
        return this.addDistrictInteractor;
    }

    @NotNull
    public final AddDistrictViewModel getAddDistrictViewModel() {
        return this.addDistrictViewModel;
    }

    public final void checkAppStatus(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.addDistrictInteractor.checkAppStatus(school, this);
    }

    public final void checkSchoolPermissions(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.addDistrictInteractor.checkAccountSettings(school, this);
    }

    public void onSearchDistrictError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        AddDistrictViewModel addDistrictViewModel = this.addDistrictViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "error";
        }
        addDistrictViewModel.showError(th);
    }

    public void onAppAvailable(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.addDistrictViewModel.showLoginDialog();
        this.addDistrictInteractor.sendSuccessAnalytics();
    }

    public void onSchoolRepeated(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.addDistrictViewModel.showError(str);
    }

    public void onAppNotAvailable(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.addDistrictViewModel.showError(str);
    }

    public void onAppCheckError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        AddDistrictViewModel addDistrictViewModel = this.addDistrictViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        addDistrictViewModel.showError(th);
    }

    public void onPermissionsRetrieved(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.addDistrictInteractor.updateSelectedURL(school, this);
    }

    public void onPermissionsFail() {
        this.addDistrictViewModel.showError("Something went wrong, please try again later");
    }

    public void onPermissionsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        AddDistrictViewModel addDistrictViewModel = this.addDistrictViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        addDistrictViewModel.showError(th);
    }

    public void onURLUpdated() {
        this.addDistrictViewModel.goToLogin();
    }

    public void onCreate() {
        this.addDistrictInteractor.sendAnalytics();
    }
}
