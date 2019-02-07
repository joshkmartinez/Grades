package com.aeries.mobileportal.views.fragments;

import android.location.Location;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/location/Location;", "kotlin.jvm.PlatformType", "onSuccess"}, k = 3, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragment.kt */
final class SchoolSearchFragment$requestSchoolsByLocation$1<TResult> implements OnSuccessListener<Location> {
    final /* synthetic */ SchoolSearchFragment this$0;

    SchoolSearchFragment$requestSchoolsByLocation$1(SchoolSearchFragment schoolSearchFragment) {
        this.this$0 = schoolSearchFragment;
    }

    public final void onSuccess(Location location) {
        if (location != null) {
            this.this$0.getPresenter().searchSchoolByLocation(location);
        } else {
            SchoolSearchFragment.access$getFusedLocationClient$p(this.this$0).requestLocationUpdates(LocationRequest.create(), this.this$0.getLocationCallback(), null);
        }
    }
}
