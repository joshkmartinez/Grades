package com.aeries.mobileportal.interactors;

import android.location.Location;
import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "schoolSearchService", "Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;", "(Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;)V", "getSchoolSearchService", "()Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;", "searchSchools", "", "query", "", "callback", "Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentCallback;", "searchSchoolsByLocation", "location", "Landroid/location/Location;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragmentInteractor.kt */
public final class SchoolSearchFragmentInteractor extends BaseInteractor {
    @NotNull
    private final SchoolSearchService schoolSearchService;

    @NotNull
    public final SchoolSearchService getSchoolSearchService() {
        return this.schoolSearchService;
    }

    public SchoolSearchFragmentInteractor(@NotNull SchoolSearchService schoolSearchService) {
        Intrinsics.checkParameterIsNotNull(schoolSearchService, "schoolSearchService");
        this.schoolSearchService = schoolSearchService;
    }

    public final void searchSchoolsByLocation(@NotNull Location location, @NotNull SchoolSearchFragmentCallback schoolSearchFragmentCallback) {
        Intrinsics.checkParameterIsNotNull(location, Param.LOCATION);
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentCallback, "callback");
        location = this.schoolSearchService.searchSchoolByLocation(location.getLatitude(), location.getLongitude()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SchoolSearchFragmentInteractor$searchSchoolsByLocation$1(schoolSearchFragmentCallback), (Consumer) SchoolSearchFragmentInteractor$searchSchoolsByLocation$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(location, "schoolSearchService.sear…      }\n                )");
        addToCompositeDisposable(location);
    }

    public final void searchSchools(@Nullable String str, @NotNull SchoolSearchFragmentCallback schoolSearchFragmentCallback) {
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentCallback, "callback");
        str = this.schoolSearchService.searchSchool(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SchoolSearchFragmentInteractor$searchSchools$1(schoolSearchFragmentCallback), new SchoolSearchFragmentInteractor$searchSchools$2(schoolSearchFragmentCallback));
        Intrinsics.checkExpressionValueIsNotNull(str, "schoolSearchService.sear…      }\n                )");
        addToCompositeDisposable(str);
    }
}
