package com.aeries.mobileportal.presenters.login;

import android.support.v4.view.PointerIconCompat;
import com.aeries.mobileportal.interactors.login.LoginCallback;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.User;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ \u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0012\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010/\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u00100\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020,H\u0016J\b\u00103\u001a\u00020\rH\u0016J \u00104\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0018H\u0016J \u00107\u001a\u00020\r2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u001609j\b\u0012\u0004\u0012\u00020\u0016`:H\u0016J\u000e\u0010;\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u001bJ\u000e\u0010<\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006="}, d2 = {"Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "Lcom/aeries/mobileportal/interactors/login/LoginCallback;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "loginViewModel", "loginInteractor", "Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;Lcom/aeries/mobileportal/interactors/login/LoginInteractor;)V", "getLoginInteractor", "()Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "getLoginViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "getAuthToken", "", "user", "Lcom/aeries/mobileportal/models/User;", "getLastUserName", "getSchoolsForSpinner", "googleSignIn", "googleAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "school", "Lcom/aeries/mobileportal/models/School;", "keepAccount", "", "login", "username", "", "password", "onAppDisabled", "message", "onAppEnabled", "onAuthTokenSuccess", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "onCreate", "onCreateAccountPermissionChecked", "createAccountDisabled", "passwordDisabled", "onGetServerInfoError", "onLastUserNameRetrieved", "lastUserName", "onLoginError", "throwable", "", "onLoginFail", "error", "onLoginSuccess", "onLoginSuccessNoStudents", "onPermissionsError", "e", "onPermissionsFail", "onPermissionsRetrieved", "parentPasswordDisabled", "studentPasswordDisabled", "onSchoolsRetrieved", "schools", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setLastUserName", "setNewSelectedSchool", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginPresenter.kt */
public final class LoginPresenter extends BasePresenter<LoginViewModel> implements LoginCallback {
    @NotNull
    private final LoginInteractor loginInteractor;
    @NotNull
    private final LoginViewModel loginViewModel;

    @NotNull
    public final LoginInteractor getLoginInteractor() {
        return this.loginInteractor;
    }

    @NotNull
    public final LoginViewModel getLoginViewModel() {
        return this.loginViewModel;
    }

    public LoginPresenter(@NotNull LoginViewModel loginViewModel, @NotNull LoginInteractor loginInteractor) {
        Intrinsics.checkParameterIsNotNull(loginViewModel, "loginViewModel");
        Intrinsics.checkParameterIsNotNull(loginInteractor, "loginInteractor");
        super(loginViewModel, loginInteractor);
        this.loginViewModel = loginViewModel;
        this.loginInteractor = loginInteractor;
    }

    public void onCreate() {
        this.loginInteractor.sendAnalytics();
        this.loginInteractor.checkCreateAccountPermission(this);
        this.loginInteractor.checkFeedbackFlag();
    }

    public final void getLastUserName() {
        this.loginInteractor.getLastUserName(this);
    }

    public final void setLastUserName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "lastUserName");
        this.loginInteractor.setLastUserName(str);
    }

    public final void getSchoolsForSpinner() {
        this.loginInteractor.getSchools(this);
    }

    public final void setNewSelectedSchool(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        this.loginInteractor.setNewSchool(school, this);
    }

    public final void login(@NotNull String str, @NotNull String str2, @NotNull School school, boolean z) {
        School school2 = school;
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, "username");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "password");
        Intrinsics.checkParameterIsNotNull(school2, "school");
        User user = new User(str3, str4, null, null, null, null, null, null, null, null, z, PointerIconCompat.TYPE_GRAB, null);
        user.setSchool(school2);
        this.loginInteractor.getServerInfo(user, this);
    }

    public final void googleSignIn(@Nullable GoogleSignInAccount googleSignInAccount, @NotNull School school, boolean z) {
        LoginPresenter loginPresenter = this;
        School school2 = school;
        Intrinsics.checkParameterIsNotNull(school2, "school");
        User user = new User(null, null, googleSignInAccount != null ? googleSignInAccount.getEmail() : null, googleSignInAccount != null ? googleSignInAccount.getIdToken() : null, "Google", null, null, null, null, null, z, 995, null);
        user.setSchool(school2);
        loginPresenter.loginInteractor.getServerInfo(user, loginPresenter);
    }

    public final void getAuthToken(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        this.loginInteractor.getAuthToken(user, this);
    }

    public void onCreateAccountPermissionChecked(boolean z, boolean z2) {
        this.loginViewModel.disableAccountViews(z, z2);
    }

    public void onLastUserNameRetrieved(@Nullable String str) {
        this.loginViewModel.populateUserNameField(str);
    }

    public void onLoginSuccess(@Nullable AuthenticationData authenticationData) {
        boolean booleanValue;
        this.loginInteractor.storeTokens(authenticationData);
        this.loginInteractor.storeDefaultStudent(authenticationData);
        LoginInteractor loginInteractor = this.loginInteractor;
        if (authenticationData != null) {
            Boolean signalKit = authenticationData.getSignalKit();
            if (signalKit != null) {
                booleanValue = signalKit.booleanValue();
                loginInteractor.storeSignalKitEnabled(booleanValue);
                this.loginInteractor.storeStudents(authenticationData);
                this.loginViewModel.finishLoginProcess(authenticationData);
            }
        }
        booleanValue = false;
        loginInteractor.storeSignalKitEnabled(booleanValue);
        this.loginInteractor.storeStudents(authenticationData);
        this.loginViewModel.finishLoginProcess(authenticationData);
    }

    public void onAuthTokenSuccess(@Nullable AuthenticationData authenticationData) {
        this.loginViewModel.finishLoginProcess(authenticationData);
    }

    public void onLoginSuccessNoStudents(@Nullable AuthenticationData authenticationData) {
        this.loginInteractor.storeTokens(authenticationData);
        LoginInteractor loginInteractor = this.loginInteractor;
        if (authenticationData != null) {
            authenticationData = authenticationData.getSignalKit();
            if (authenticationData != null) {
                authenticationData = authenticationData.booleanValue();
                loginInteractor.storeSignalKitEnabled(authenticationData);
                this.loginViewModel.showLinkStudent();
            }
        }
        authenticationData = null;
        loginInteractor.storeSignalKitEnabled(authenticationData);
        this.loginViewModel.showLinkStudent();
    }

    public void onLoginFail(@Nullable String str) {
        LoginViewModel loginViewModel = this.loginViewModel;
        if (str == null) {
            str = "";
        }
        loginViewModel.showError(str);
    }

    public void onLoginError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        LoginViewModel loginViewModel = this.loginViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        loginViewModel.showError(th);
    }

    public void onSchoolsRetrieved(@NotNull ArrayList<School> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "schools");
        this.loginViewModel.populateSchoolsSpinner(arrayList);
    }

    public void onPermissionsRetrieved(boolean z, boolean z2, boolean z3) {
        LoginViewModel loginViewModel = this.loginViewModel;
        z2 = z2 && z3;
        loginViewModel.disableAccountViews(z, z2);
    }

    public void onPermissionsFail() {
        this.loginViewModel.showError("Permissions could not be retrieved");
    }

    public void onPermissionsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        LoginViewModel loginViewModel = this.loginViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        loginViewModel.showError(th);
    }

    public void onAppEnabled(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        this.loginInteractor.login(user, this);
    }

    public void onAppDisabled(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.loginViewModel.showError(str);
    }

    public void onGetServerInfoError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.loginViewModel.showError(str);
    }
}
