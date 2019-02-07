package com.aeries.mobileportal.interactors.add_district;

import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.School;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: AddDistrictInteractor.kt */
final class AddDistrictInteractor$checkAppStatus$1<T> implements Consumer<GenericServiceResponse> {
    final /* synthetic */ AddDistrictCallback $callback;
    final /* synthetic */ School $school;
    final /* synthetic */ AddDistrictInteractor this$0;

    AddDistrictInteractor$checkAppStatus$1(AddDistrictInteractor addDistrictInteractor, School school, AddDistrictCallback addDistrictCallback) {
        this.this$0 = addDistrictInteractor;
        this.$school = school;
        this.$callback = addDistrictCallback;
    }

    public final void accept(GenericServiceResponse genericServiceResponse) {
        if (!Intrinsics.areEqual(genericServiceResponse.getStatus(), Param.SUCCESS)) {
            this.$callback.onAppNotAvailable(genericServiceResponse.getError());
        } else if (this.this$0.getSchoolRepo().addSchool(this.$school) != null) {
            this.$callback.onAppAvailable(this.$school);
        } else {
            this.$callback.onSchoolRepeated("This school is already linked.");
        }
    }
}
