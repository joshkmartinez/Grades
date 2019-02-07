package com.aeries.mobileportal.interactors.attendance;

import com.aeries.mobileportal.models.Attendance;
import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AttendanceInteractor.kt */
final class AttendanceInteractor$getCurrentStudentYearlyAttendance$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AttendanceCallback $callback;
    final /* synthetic */ Student $student;
    final /* synthetic */ int $studentId;
    final /* synthetic */ AttendanceInteractor this$0;

    AttendanceInteractor$getCurrentStudentYearlyAttendance$1(AttendanceInteractor attendanceInteractor, Student student, int i, AttendanceCallback attendanceCallback) {
        this.this$0 = attendanceInteractor;
        this.$student = student;
        this.$studentId = i;
        this.$callback = attendanceCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Integer valueOf;
        Intrinsics.checkParameterIsNotNull(str, "it");
        AttendanceInteractor attendanceInteractor = this.this$0;
        AttendanceService attendanceService = this.this$0.getAttendanceService();
        Student student = this.$student;
        if (student != null) {
            Demographics demographics = student.getDemographics();
            if (demographics != null) {
                valueOf = Integer.valueOf(demographics.getSchoolCode());
                str = attendanceService.getSchoolYearAttendance(valueOf, Integer.valueOf(this.$studentId), str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<List<? extends Attendance>>() {
                    public final void accept(List<Attendance> list) {
                        List arrayList = new ArrayList();
                        for (Attendance attendance : list) {
                            List list2 = null;
                            List list3 = null;
                            List attendanceDetails = attendance.getAttendanceDetails();
                            if (!(attendanceDetails == null || attendanceDetails.isEmpty())) {
                                list3 = attendance.getAttendanceDetails();
                                if (list3 != null) {
                                    list2 = CollectionsKt.sortedWith(list3, new C0358x4666eee8());
                                }
                                list3 = list2;
                                if (list3 != null) {
                                    AttendanceDetail attendanceDetail = (AttendanceDetail) list3.get(0);
                                    if (attendanceDetail != null) {
                                        attendanceDetail.setSchoolName(attendance.getSchoolName());
                                    }
                                }
                            }
                            arrayList.addAll(list3 != null ? list3 : CollectionsKt.emptyList());
                        }
                        this.$callback.onAttendanceReceived(arrayList);
                    }
                }, new Consumer<Throwable>() {
                    public final void accept(Throwable th) {
                        AttendanceCallback attendanceCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(th, "it");
                        attendanceCallback.onAttendanceError(th);
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(str, "attendanceService.getSch…) }\n                    )");
                attendanceInteractor.addToCompositeDisposable(str);
            }
        }
        valueOf = null;
        str = attendanceService.getSchoolYearAttendance(valueOf, Integer.valueOf(this.$studentId), str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(/* anonymous class already generated */, /* anonymous class already generated */);
        Intrinsics.checkExpressionValueIsNotNull(str, "attendanceService.getSch…) }\n                    )");
        attendanceInteractor.addToCompositeDisposable(str);
    }
}
