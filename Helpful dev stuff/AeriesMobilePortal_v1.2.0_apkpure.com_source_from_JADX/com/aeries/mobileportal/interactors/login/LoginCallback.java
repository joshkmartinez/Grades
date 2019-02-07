package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.User;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0015H&J\b\u0010\u001c\u001a\u00020\u0003H&J \u0010\u001d\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH&J \u0010 \u001a\u00020\u00032\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H&¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/interactors/login/LoginCallback;", "", "onAppDisabled", "", "message", "", "onAppEnabled", "user", "Lcom/aeries/mobileportal/models/User;", "onAuthTokenSuccess", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "onCreateAccountPermissionChecked", "createAccountDisabled", "", "passwordDisabled", "onGetServerInfoError", "onLastUserNameRetrieved", "lastUserName", "onLoginError", "throwable", "", "onLoginFail", "error", "onLoginSuccess", "onLoginSuccessNoStudents", "onPermissionsError", "e", "onPermissionsFail", "onPermissionsRetrieved", "parentPasswordDisabled", "studentPasswordDisabled", "onSchoolsRetrieved", "schools", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/School;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginCallback.kt */
public interface LoginCallback {
    void onAppDisabled(@NotNull String str);

    void onAppEnabled(@NotNull User user);

    void onAuthTokenSuccess(@Nullable AuthenticationData authenticationData);

    void onCreateAccountPermissionChecked(boolean z, boolean z2);

    void onGetServerInfoError(@NotNull String str);

    void onLastUserNameRetrieved(@Nullable String str);

    void onLoginError(@NotNull Throwable th);

    void onLoginFail(@Nullable String str);

    void onLoginSuccess(@Nullable AuthenticationData authenticationData);

    void onLoginSuccessNoStudents(@Nullable AuthenticationData authenticationData);

    void onPermissionsError(@NotNull Throwable th);

    void onPermissionsFail();

    void onPermissionsRetrieved(boolean z, boolean z2, boolean z3);

    void onSchoolsRetrieved(@NotNull ArrayList<School> arrayList);
}
