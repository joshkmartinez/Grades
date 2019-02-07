package com.aeries.mobileportal.views.viewmodels.login;

import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J \u0010\n\u001a\u00020\u00032\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "disableAccountViews", "", "createAccountDisabled", "", "changePasswordDisabled", "finishLoginProcess", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "populateSchoolsSpinner", "schools", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/School;", "Lkotlin/collections/ArrayList;", "populateUserNameField", "lastUserName", "", "showError", "message", "showLinkStudent", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginViewModel.kt */
public interface LoginViewModel extends BaseViewModel {
    void disableAccountViews(boolean z, boolean z2);

    void finishLoginProcess(@Nullable AuthenticationData authenticationData);

    void populateSchoolsSpinner(@NotNull ArrayList<School> arrayList);

    void populateUserNameField(@Nullable String str);

    void showError(@NotNull String str);

    void showLinkStudent();
}
