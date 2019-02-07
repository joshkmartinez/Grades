package com.aeries.mobileportal.presenters.school.select;

import com.aeries.mobileportal.interactors.school.select.SchoolSearchCallback;
import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u000e\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010#\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/presenters/school/select/SchoolSearchPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchCallback;", "schoolSearchViewModel", "schoolSearchInteractor", "Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;)V", "getSchoolSearchInteractor", "()Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;", "getSchoolSearchViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "checkAvailability", "", "school", "Lcom/aeries/mobileportal/models/School;", "onAppAvailable", "onAppAvailableError", "e", "", "onAppNotAvailable", "message", "", "onCreate", "onError", "throwable", "onPermissionsError", "onPermissionsFail", "onPermissionsRetrieved", "onSchoolsFound", "schools", "", "onURLStored", "requestPermissions", "selectSchool", "sendAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchPresenter.kt */
public final class SchoolSearchPresenter extends BasePresenter<SchoolSearchViewModel> implements SchoolSearchCallback {
    @NotNull
    private final SchoolSearchInteractor schoolSearchInteractor;
    @NotNull
    private final SchoolSearchViewModel schoolSearchViewModel;

    public void onSchoolsFound(@Nullable List<? extends School> list) {
    }

    @NotNull
    public final SchoolSearchInteractor getSchoolSearchInteractor() {
        return this.schoolSearchInteractor;
    }

    @NotNull
    public final SchoolSearchViewModel getSchoolSearchViewModel() {
        return this.schoolSearchViewModel;
    }

    public SchoolSearchPresenter(@NotNull SchoolSearchViewModel schoolSearchViewModel, @NotNull SchoolSearchInteractor schoolSearchInteractor) {
        Intrinsics.checkParameterIsNotNull(schoolSearchViewModel, "schoolSearchViewModel");
        Intrinsics.checkParameterIsNotNull(schoolSearchInteractor, "schoolSearchInteractor");
        super(schoolSearchViewModel, schoolSearchInteractor);
        this.schoolSearchViewModel = schoolSearchViewModel;
        this.schoolSearchInteractor = schoolSearchInteractor;
    }

    public final void checkAvailability(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.schoolSearchInteractor.checkSchoolAvailability(school, this);
    }

    public final void selectSchool(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.schoolSearchInteractor.selectSchool(school, this);
    }

    public final void requestPermissions(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.schoolSearchInteractor.checkAccountSettings(school, this);
    }

    public final void sendAnalytics() {
        this.schoolSearchInteractor.postAnalytics();
    }

    public void onCreate() {
        sendAnalytics();
    }

    public void onError(@Nullable Throwable th) {
        SchoolSearchViewModel schoolSearchViewModel = this.schoolSearchViewModel;
        if (th != null) {
            th = th.getMessage();
            if (th != null) {
                schoolSearchViewModel.showError(th);
            }
        }
        th = "Error";
        schoolSearchViewModel.showError(th);
    }

    public void onAppAvailable() {
        this.schoolSearchViewModel.requestPermissions();
    }

    public void onAppNotAvailable(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.schoolSearchViewModel.showError(str);
    }

    public void onAppAvailableError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        SchoolSearchViewModel schoolSearchViewModel = this.schoolSearchViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        schoolSearchViewModel.showError(th);
    }

    public void onPermissionsRetrieved() {
        this.schoolSearchViewModel.selectSchool();
    }

    public void onPermissionsFail() {
        this.schoolSearchViewModel.showError("Couldn't get school configurations, try again later");
    }

    public void onPermissionsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        SchoolSearchViewModel schoolSearchViewModel = this.schoolSearchViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        schoolSearchViewModel.showError(th);
    }

    public void onURLStored() {
        this.schoolSearchViewModel.goToLogin();
    }
}
