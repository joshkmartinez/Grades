package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.models.CheckInOutRequest;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ClassCheckInInteractor.kt */
final class ClassCheckInInteractor$checkOut$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ClassCheckInCallback $callback;
    final /* synthetic */ CheckInOutRequest $checkOutRequest;
    final /* synthetic */ ClassCheckInInteractor this$0;

    ClassCheckInInteractor$checkOut$1(ClassCheckInInteractor classCheckInInteractor, CheckInOutRequest checkInOutRequest, ClassCheckInCallback classCheckInCallback) {
        this.this$0 = classCheckInInteractor;
        this.$checkOutRequest = checkInOutRequest;
        this.$callback = classCheckInCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        ClassCheckInInteractor classCheckInInteractor = this.this$0;
        str = this.this$0.getSupplementalAttendanceService().checkOut(this.$checkOutRequest, str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<SupplementalAttendanceStatus>() {
            public final void accept(SupplementalAttendanceStatus supplementalAttendanceStatus) {
                if (Intrinsics.areEqual(supplementalAttendanceStatus.getStatus(), Param.SUCCESS)) {
                    ClassCheckInCallback classCheckInCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                    classCheckInCallback.onCheckOutSuccess(supplementalAttendanceStatus);
                    return;
                }
                classCheckInCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(supplementalAttendanceStatus, "it");
                classCheckInCallback.onCheckOutFailure(supplementalAttendanceStatus);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                th.printStackTrace();
                ClassCheckInCallback classCheckInCallback = this.$callback;
                th = th.getMessage();
                if (th == null) {
                    th = "";
                }
                classCheckInCallback.onCheckOutError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "supplementalAttendanceSe…  }\n                    )");
        classCheckInInteractor.addToCompositeDisposable(str);
    }
}
