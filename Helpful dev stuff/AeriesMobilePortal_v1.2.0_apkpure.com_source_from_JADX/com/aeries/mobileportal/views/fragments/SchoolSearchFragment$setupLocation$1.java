package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/aeries/mobileportal/views/fragments/SchoolSearchFragment$setupLocation$1", "Lcom/google/android/gms/location/LocationCallback;", "(Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;)V", "onLocationResult", "", "p0", "Lcom/google/android/gms/location/LocationResult;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragment.kt */
public final class SchoolSearchFragment$setupLocation$1 extends LocationCallback {
    final /* synthetic */ SchoolSearchFragment this$0;

    SchoolSearchFragment$setupLocation$1(SchoolSearchFragment schoolSearchFragment) {
        this.this$0 = schoolSearchFragment;
    }

    public void onLocationResult(@Nullable LocationResult locationResult) {
        if (locationResult != null) {
            SchoolSearchFragmentPresenter presenter = this.this$0.getPresenter();
            locationResult = locationResult.getLastLocation();
            Intrinsics.checkExpressionValueIsNotNull(locationResult, "p0.lastLocation");
            presenter.searchSchoolByLocation(locationResult);
            SchoolSearchFragment.access$getFusedLocationClient$p(this.this$0).removeLocationUpdates((LocationCallback) this);
        }
    }
}
