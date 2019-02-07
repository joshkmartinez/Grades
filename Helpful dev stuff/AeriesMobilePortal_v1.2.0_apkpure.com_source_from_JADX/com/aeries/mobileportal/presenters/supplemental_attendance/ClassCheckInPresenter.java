package com.aeries.mobileportal.presenters.supplemental_attendance;

import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInCallback;
import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010#\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001f\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010,R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006-"}, d2 = {"Lcom/aeries/mobileportal/presenters/supplemental_attendance/ClassCheckInPresenter;", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInCallback;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "classCheckInViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;)V", "getClassCheckInViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;", "checkIn", "", "session", "Lcom/aeries/mobileportal/models/Session;", "checkOut", "getSessions", "getStatus", "onCheckInError", "message", "", "onCheckInFailure", "supplementalAttendanceStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "onCheckInSuccessNoSessions", "onCheckInSuccessWithSessions", "onCheckOutError", "onCheckOutFailure", "onCheckOutSuccess", "onCheckedIn", "onCreate", "onNotCheckedIn", "onScanCheckInSuccess", "onSessionsError", "onSessionsRetrieved", "sessions", "", "onStatusError", "onStatusFail", "scanCheckIn", "schoolCode", "", "room", "(Ljava/lang/Integer;Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassCheckInPresenter.kt */
public final class ClassCheckInPresenter extends BasePresenter<ClassCheckInViewModel> implements ClassCheckInCallback {
    @NotNull
    private final ClassCheckInViewModel classCheckInViewModel;
    @NotNull
    private final ClassCheckInInteractor interactor;

    @NotNull
    public final ClassCheckInViewModel getClassCheckInViewModel() {
        return this.classCheckInViewModel;
    }

    public ClassCheckInPresenter(@NotNull ClassCheckInViewModel classCheckInViewModel, @NotNull ClassCheckInInteractor classCheckInInteractor) {
        Intrinsics.checkParameterIsNotNull(classCheckInViewModel, "classCheckInViewModel");
        Intrinsics.checkParameterIsNotNull(classCheckInInteractor, "interactor");
        super(classCheckInViewModel, classCheckInInteractor);
        this.classCheckInViewModel = classCheckInViewModel;
        this.interactor = classCheckInInteractor;
    }

    @NotNull
    public final ClassCheckInInteractor getInteractor() {
        return this.interactor;
    }

    public final void getStatus() {
        this.interactor.getStatus(this);
    }

    public final void getSessions() {
        this.interactor.getSessions(this);
    }

    public final void checkIn(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        this.interactor.checkIn(session, this);
    }

    public final void scanCheckIn(@Nullable Integer num, @Nullable String str) {
        this.interactor.scanCheckIn(num, str, this);
    }

    public final void checkOut(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        this.interactor.checkOut(session, this);
    }

    public void onNotCheckedIn(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showCheckInFragment(supplementalAttendanceStatus);
    }

    public void onCheckedIn(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showCheckOutFragment(supplementalAttendanceStatus);
    }

    public void onStatusFail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.classCheckInViewModel.showError(str);
    }

    public void onStatusError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.classCheckInViewModel.showError(str);
    }

    public void onSessionsRetrieved(@NotNull List<Session> list) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        this.classCheckInViewModel.updateSessions(list);
    }

    public void onSessionsError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.classCheckInViewModel.showError(str);
    }

    public void onCheckInSuccessWithSessions(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showSessionsFragment(supplementalAttendanceStatus);
    }

    public void onCheckInSuccessNoSessions(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.interactor.sendSuccessAnalytics();
        this.classCheckInViewModel.showCheckOutFragment(supplementalAttendanceStatus);
    }

    public void onCheckInFailure(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showCheckInToAnotherRoomFragment(supplementalAttendanceStatus);
    }

    public void onCheckInError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.classCheckInViewModel.showError(str);
    }

    public void onCheckOutSuccess(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showCheckInToAnotherRoomFragment(supplementalAttendanceStatus);
    }

    public void onCheckOutFailure(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.classCheckInViewModel.showCheckInToAnotherRoomFragment(supplementalAttendanceStatus);
    }

    public void onCheckOutError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.classCheckInViewModel.showError(str);
    }

    public void onScanCheckInSuccess(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        this.interactor.sendSuccessAnalytics();
        this.classCheckInViewModel.showScanCheckOutFragment(supplementalAttendanceStatus);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
