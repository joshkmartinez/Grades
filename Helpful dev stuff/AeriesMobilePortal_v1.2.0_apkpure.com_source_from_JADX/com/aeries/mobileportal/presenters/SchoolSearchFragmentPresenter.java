package com.aeries.mobileportal.presenters;

import android.location.Location;
import com.aeries.mobileportal.interactors.SchoolSearchFragmentCallback;
import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.views.viewmodels.SchoolSearchFragmentViewModel;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/presenters/SchoolSearchFragmentPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentCallback;", "vm", "interactor", "Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;", "getVm", "()Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "onCreate", "", "onSchoolsError", "e", "", "onSchoolsRetreived", "schools", "", "Lcom/aeries/mobileportal/models/School;", "onSchoolsRetreivedLocation", "searchSchool", "query", "", "searchSchoolByLocation", "location", "Landroid/location/Location;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragmentPresenter.kt */
public final class SchoolSearchFragmentPresenter extends BasePresenter<SchoolSearchFragmentViewModel> implements SchoolSearchFragmentCallback {
    @NotNull
    private final SchoolSearchFragmentInteractor interactor;
    @NotNull
    private final SchoolSearchFragmentViewModel vm;

    public void onCreate() {
    }

    @NotNull
    public final SchoolSearchFragmentInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final SchoolSearchFragmentViewModel getVm() {
        return this.vm;
    }

    public SchoolSearchFragmentPresenter(@NotNull SchoolSearchFragmentViewModel schoolSearchFragmentViewModel, @NotNull SchoolSearchFragmentInteractor schoolSearchFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentViewModel, "vm");
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentInteractor, "interactor");
        super(schoolSearchFragmentViewModel, schoolSearchFragmentInteractor);
        this.vm = schoolSearchFragmentViewModel;
        this.interactor = schoolSearchFragmentInteractor;
    }

    public final void searchSchool(@Nullable String str) {
        this.interactor.searchSchools(str, this);
        this.vm.showSearchSchoolProgress(true);
    }

    public final void searchSchoolByLocation(@NotNull Location location) {
        Intrinsics.checkParameterIsNotNull(location, Param.LOCATION);
        this.vm.showNearbySchoolProgress(true);
        this.interactor.searchSchoolsByLocation(location, this);
    }

    public void onSchoolsRetreived(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        this.vm.showNearbySchoolProgress(false);
        this.vm.showSearchSchoolProgress(false);
        this.vm.showSchools(list);
    }

    public void onSchoolsRetreivedLocation(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        this.vm.showNearbySchoolProgress(false);
        this.vm.showNearbySchools(list);
    }

    public void onSchoolsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.vm.showNearbySchoolProgress(false);
        this.vm.showSearchSchoolProgress(false);
        SchoolSearchFragmentViewModel schoolSearchFragmentViewModel = this.vm;
        th = th.getMessage();
        if (th == null) {
            th = "Oops, something went wrong! Please try again later";
        }
        schoolSearchFragmentViewModel.showError(th);
    }
}
