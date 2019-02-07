package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.Student;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ClassCheckInInteractor.kt */
final class ClassCheckInInteractor$getSessions$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ClassCheckInCallback $callback;
    final /* synthetic */ Student $student;
    final /* synthetic */ ClassCheckInInteractor this$0;

    ClassCheckInInteractor$getSessions$1(ClassCheckInInteractor classCheckInInteractor, Student student, ClassCheckInCallback classCheckInCallback) {
        this.this$0 = classCheckInInteractor;
        this.$student = student;
        this.$callback = classCheckInCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        ClassCheckInInteractor classCheckInInteractor = this.this$0;
        str = this.this$0.getSupplementalAttendanceService().sessions(this.$student.getDemographics().getSchoolCode(), this.$student.getStudentID(), str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<List<? extends Session>>() {
            public final void accept(List<Session> list) {
                ClassCheckInCallback classCheckInCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(list, "it");
                classCheckInCallback.onSessionsRetrieved(list);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                th.printStackTrace();
                ClassCheckInCallback classCheckInCallback = this.$callback;
                th = th.getMessage();
                if (th == null) {
                    th = "";
                }
                classCheckInCallback.onSessionsError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "supplementalAttendanceSe…  }\n                    )");
        classCheckInInteractor.addToCompositeDisposable(str);
    }
}
