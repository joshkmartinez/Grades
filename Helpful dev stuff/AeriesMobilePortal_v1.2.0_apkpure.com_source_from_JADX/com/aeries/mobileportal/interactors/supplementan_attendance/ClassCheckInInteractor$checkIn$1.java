package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.models.CheckInOutRequest;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ClassCheckInInteractor.kt */
final class ClassCheckInInteractor$checkIn$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ClassCheckInCallback $callback;
    final /* synthetic */ CheckInOutRequest $checkInRequest;
    final /* synthetic */ Session $session;
    final /* synthetic */ ClassCheckInInteractor this$0;

    ClassCheckInInteractor$checkIn$1(ClassCheckInInteractor classCheckInInteractor, CheckInOutRequest checkInOutRequest, Session session, ClassCheckInCallback classCheckInCallback) {
        this.this$0 = classCheckInInteractor;
        this.$checkInRequest = checkInOutRequest;
        this.$session = session;
        this.$callback = classCheckInCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        ClassCheckInInteractor classCheckInInteractor = this.this$0;
        str = this.this$0.getSupplementalAttendanceService().checkIn(this.$checkInRequest, str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<SupplementalAttendanceStatus>() {
            public final void accept(SupplementalAttendanceStatus supplementalAttendanceStatus) {
                ClassCheckInCallback classCheckInCallback;
                if (!Intrinsics.areEqual(supplementalAttendanceStatus.getStatus(), Param.SUCCESS)) {
                    classCheckInCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                    classCheckInCallback.onCheckInFailure(supplementalAttendanceStatus);
                } else if (supplementalAttendanceStatus.getSessions() == null || (supplementalAttendanceStatus.getSessions().isEmpty() ^ 1) == 0) {
                    classCheckInCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                    classCheckInCallback.onCheckInSuccessNoSessions(supplementalAttendanceStatus);
                } else if (supplementalAttendanceStatus.getSessions().size() == 1 && Intrinsics.areEqual(((Session) CollectionsKt.first(supplementalAttendanceStatus.getSessions())).getSessionId(), this.$session.getSessionId())) {
                    classCheckInCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                    classCheckInCallback.onCheckInSuccessNoSessions(supplementalAttendanceStatus);
                } else {
                    classCheckInCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                    classCheckInCallback.onCheckInSuccessWithSessions(supplementalAttendanceStatus);
                }
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                th.printStackTrace();
                ClassCheckInCallback classCheckInCallback = this.$callback;
                th = th.getMessage();
                if (th == null) {
                    th = "";
                }
                classCheckInCallback.onCheckInError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "supplementalAttendanceSe…  }\n                    )");
        classCheckInInteractor.addToCompositeDisposable(str);
    }
}
