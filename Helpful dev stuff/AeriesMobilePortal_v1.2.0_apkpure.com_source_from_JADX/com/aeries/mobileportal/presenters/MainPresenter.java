package com.aeries.mobileportal.presenters;

import android.util.Log;
import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.interactors.main.MainCallback;
import com.aeries.mobileportal.interactors.main.MainInteractor;
import com.aeries.mobileportal.models.Restricted;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.views.viewmodels.main.MainViewModel;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0016J\u0012\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&J\u0006\u0010-\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006."}, d2 = {"Lcom/aeries/mobileportal/presenters/MainPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/main/MainViewModel;", "Lcom/aeries/mobileportal/interactors/main/MainCallback;", "mainViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/main/MainInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/main/MainViewModel;Lcom/aeries/mobileportal/interactors/main/MainInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/main/MainInteractor;", "getMainViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/main/MainViewModel;", "areNotificationsEnabled", "", "getLogoutForPortalVersion", "getPortalVersion", "", "getRestrictions", "", "getSelectedStudent", "getUserType", "goToParentPortal", "invalidateAccessToken", "invalidateRefreshToken", "logout", "onAllDeleted", "onCreate", "onRestrictedError", "message", "onRestrictedFail", "onRestrictedLogout", "onRestrictedNotLogout", "onRestrictionsReceived", "restricted", "Lcom/aeries/mobileportal/models/Restricted;", "localForceLogout", "onSelectedStudentRetrieved", "student", "Lcom/aeries/mobileportal/models/Student;", "onTokenInvalidated", "sendAccountSettingsAnalytics", "sendStudentSelectAnalytics", "setMessageShown", "b", "setSelectedStudent", "updatePortalVersion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainPresenter.kt */
public final class MainPresenter extends BasePresenter<MainViewModel> implements MainCallback {
    @NotNull
    private final MainInteractor interactor;
    @NotNull
    private final MainViewModel mainViewModel;

    public MainPresenter(@NotNull MainViewModel mainViewModel, @NotNull MainInteractor mainInteractor) {
        Intrinsics.checkParameterIsNotNull(mainViewModel, "mainViewModel");
        Intrinsics.checkParameterIsNotNull(mainInteractor, "interactor");
        super(mainViewModel, mainInteractor);
        this.mainViewModel = mainViewModel;
        this.interactor = mainInteractor;
    }

    @NotNull
    public final MainInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final MainViewModel getMainViewModel() {
        return this.mainViewModel;
    }

    public final void getRestrictions() {
        this.interactor.getRestrictions(this);
    }

    public final void updatePortalVersion() {
        this.interactor.getPortalVersion();
    }

    public final void sendStudentSelectAnalytics() {
        this.interactor.sendStudentSelectAnalytics();
    }

    public final void sendAccountSettingsAnalytics() {
        this.interactor.sendAccountSettingsAnalytics();
    }

    public final void setSelectedStudent(@NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(student, "student");
        this.interactor.setSelectedStudent(student);
    }

    public final void getSelectedStudent() {
        this.interactor.getSelectedStudent(this);
    }

    @NotNull
    public final String getUserType() {
        return this.interactor.getUserType();
    }

    public final void invalidateAccessToken() {
        this.interactor.invalidateAccessToken(this);
    }

    public final void invalidateRefreshToken() {
        this.interactor.invalidateRefreshToken(this);
    }

    public final void logout() {
        this.interactor.deleteTokens(this);
        this.interactor.deleteNotifications();
        this.interactor.deletePortalVersion();
        this.interactor.signOutFromGoogle();
        this.mainViewModel.startLoginActivity();
    }

    public final void setMessageShown(boolean z) {
        this.interactor.setMessageShown(z);
    }

    @Nullable
    public final String getPortalVersion() {
        return this.interactor.getSavedPortalVersion();
    }

    public final boolean areNotificationsEnabled() {
        String replace$default;
        String savedPortalVersion = this.interactor.getSavedPortalVersion();
        if (savedPortalVersion != null) {
            replace$default = StringsKt.replace$default(savedPortalVersion, ".", "", false, 4, null);
            if (replace$default != null) {
                return replace$default.compareTo(BuildConfig.NOTIFICATIONS) < 0;
            }
        }
        replace$default = "0";
        if (replace$default.compareTo(BuildConfig.NOTIFICATIONS) < 0) {
        }
    }

    public final void goToParentPortal() {
        this.interactor.goToParentPortal();
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }

    public void onSelectedStudentRetrieved(@Nullable Student student) {
        this.mainViewModel.showSelectedStudent(student);
    }

    public void onTokenInvalidated() {
        this.mainViewModel.showInvalidatedAccessTokenToast();
    }

    public void onAllDeleted() {
        this.mainViewModel.startLoginActivity();
    }

    public void onRestrictionsReceived(@NotNull Restricted restricted, boolean z) {
        Intrinsics.checkParameterIsNotNull(restricted, "restricted");
        if (Intrinsics.areEqual(restricted.getStatus(), Param.SUCCESS)) {
            Object obj;
            CharSequence message = restricted.getMessage();
            if (message != null) {
                if (message.length() != 0) {
                    obj = null;
                    if (obj != null) {
                        if (z) {
                            if (restricted.getForceLogout()) {
                                z = this.mainViewModel;
                                restricted = restricted.getMessage();
                                if (restricted == null) {
                                    Intrinsics.throwNpe();
                                }
                                z.showRestrictionMessage(restricted);
                                return;
                            }
                            this.interactor.setRestriction(restricted.getForceLogout());
                            z = this.mainViewModel;
                            restricted = restricted.getMessage();
                            if (restricted == null) {
                                Intrinsics.throwNpe();
                            }
                            z.showRestrictionMessageLogout(restricted);
                            return;
                        } else if (restricted.getForceLogout()) {
                            this.interactor.setRestriction(restricted.getForceLogout());
                            this.mainViewModel.showRestrictionMessageLogout("Your restrictions have been cleared, please log in again.");
                            return;
                        } else {
                            z = this.mainViewModel;
                            restricted = restricted.getMessage();
                            if (restricted == null) {
                                Intrinsics.throwNpe();
                            }
                            z.showRestrictionMessage(restricted);
                            return;
                        }
                    } else if (!restricted.getForceLogout() && z) {
                        this.interactor.setRestriction(restricted.getForceLogout());
                        z = this.mainViewModel;
                        restricted = restricted.getMessage();
                        if (restricted == null) {
                            restricted = "Your restrictions have been cleared, please log in again.";
                        }
                        z.showRestrictionMessageLogout(restricted);
                        return;
                    } else {
                        return;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                if (!restricted.getForceLogout()) {
                    return;
                }
                return;
            } else if (z) {
                if (restricted.getForceLogout()) {
                    z = this.mainViewModel;
                    restricted = restricted.getMessage();
                    if (restricted == null) {
                        Intrinsics.throwNpe();
                    }
                    z.showRestrictionMessage(restricted);
                    return;
                }
                this.interactor.setRestriction(restricted.getForceLogout());
                this.mainViewModel.showRestrictionMessageLogout("Your restrictions have been cleared, please log in again.");
                return;
            } else if (restricted.getForceLogout()) {
                this.interactor.setRestriction(restricted.getForceLogout());
                z = this.mainViewModel;
                restricted = restricted.getMessage();
                if (restricted == null) {
                    Intrinsics.throwNpe();
                }
                z.showRestrictionMessageLogout(restricted);
                return;
            } else {
                z = this.mainViewModel;
                restricted = restricted.getMessage();
                if (restricted == null) {
                    Intrinsics.throwNpe();
                }
                z.showRestrictionMessage(restricted);
                return;
            }
        }
        z = "RESTRICTED_ERROR";
        restricted = restricted.getMessage();
        if (restricted == null) {
            restricted = "";
        }
        Log.w(z, restricted);
    }

    public void onRestrictedLogout(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.mainViewModel.showRestrictionMessageLogout(str);
    }

    public void onRestrictedNotLogout(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            this.mainViewModel.showRestrictionMessage(str);
        }
    }

    public void onRestrictedFail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.mainViewModel.showError(str);
    }

    public void onRestrictedError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.mainViewModel.showError(str);
    }

    public final boolean getLogoutForPortalVersion() {
        return this.interactor.getLogoutForPortalVersion();
    }
}
