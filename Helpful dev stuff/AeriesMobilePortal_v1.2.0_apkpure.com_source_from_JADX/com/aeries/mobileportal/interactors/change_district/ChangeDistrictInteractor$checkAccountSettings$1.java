package com.aeries.mobileportal.interactors.change_district;

import com.aeries.mobileportal.models.AccountSettings;
import com.aeries.mobileportal.models.School;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/AccountSettings;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ChangeDistrictInteractor.kt */
final class ChangeDistrictInteractor$checkAccountSettings$1<T> implements Consumer<AccountSettings> {
    final /* synthetic */ ChangeDistrictCallback $callback;
    final /* synthetic */ School $school;
    final /* synthetic */ ChangeDistrictInteractor this$0;

    ChangeDistrictInteractor$checkAccountSettings$1(ChangeDistrictInteractor changeDistrictInteractor, ChangeDistrictCallback changeDistrictCallback, School school) {
        this.this$0 = changeDistrictInteractor;
        this.$callback = changeDistrictCallback;
        this.$school = school;
    }

    public final void accept(AccountSettings accountSettings) {
        if (Intrinsics.areEqual(accountSettings.getStatus(), Param.SUCCESS)) {
            this.this$0.getConfigurationRepository().setCreateAccountDisabled(accountSettings.getDisableCreateAccount());
            this.this$0.getConfigurationRepository().setChangePasswordParentDisabled(accountSettings.getDisableParentChangePassword());
            this.this$0.getConfigurationRepository().setChangePasswordStudentDisabled(accountSettings.getDisableStudentChangePassword());
            this.$callback.onPermissionsRetrieved(this.$school);
            return;
        }
        this.$callback.onPermissionsFail();
    }
}
