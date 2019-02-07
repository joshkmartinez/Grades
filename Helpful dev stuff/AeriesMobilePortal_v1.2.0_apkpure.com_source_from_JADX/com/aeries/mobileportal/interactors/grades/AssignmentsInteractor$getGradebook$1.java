package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.web_services.services.GradesService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentsInteractor.kt */
final class AssignmentsInteractor$getGradebook$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AssignmentsCallback $callback;
    final /* synthetic */ ClassSummary $course;
    final /* synthetic */ AssignmentsInteractor this$0;

    AssignmentsInteractor$getGradebook$1(AssignmentsInteractor assignmentsInteractor, ClassSummary classSummary, AssignmentsCallback assignmentsCallback) {
        this.this$0 = assignmentsInteractor;
        this.$course = classSummary;
        this.$callback = assignmentsCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Integer gradeBookNumber;
        ClassSummary classSummary;
        Intrinsics.checkParameterIsNotNull(str, "it");
        AssignmentsInteractor assignmentsInteractor = this.this$0;
        GradesService gradesService = this.this$0.getGradesService();
        ClassSummary classSummary2 = this.$course;
        String str2 = null;
        Integer schoolCode = classSummary2 != null ? classSummary2.getSchoolCode() : null;
        ClassSummary classSummary3 = this.$course;
        Integer studentID = classSummary3 != null ? classSummary3.getStudentID() : null;
        ClassSummary classSummary4 = this.$course;
        if (classSummary4 != null) {
            gradeBookNumber = classSummary4.getGradeBookNumber();
            if (gradeBookNumber != null) {
                classSummary = this.$course;
                if (classSummary != null) {
                    str2 = classSummary.getTermCode();
                }
                str = gradesService.getGradebook(schoolCode, studentID, gradeBookNumber, str2, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Gradebook>() {
                    public final void accept(Gradebook gradebook) {
                        RealmList assignments = gradebook.getAssignments();
                        if (assignments == null) {
                            Intrinsics.throwNpe();
                        }
                        Iterator it = assignments.iterator();
                        while (it.hasNext()) {
                            ((Assignment) it.next()).setGradebookName(gradebook.getGradebookName());
                        }
                        AssignmentsCallback assignmentsCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(gradebook, "it");
                        assignmentsCallback.onGradebookReceived(gradebook);
                    }
                }, new Consumer<Throwable>() {
                    public final void accept(Throwable th) {
                        AssignmentsCallback assignmentsCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(th, "it");
                        assignmentsCallback.onGradebookError(th);
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(str, "gradesService.getGradebo…) }\n                    )");
                assignmentsInteractor.addToCompositeDisposable(str);
            }
        }
        gradeBookNumber = Integer.valueOf(1);
        classSummary = this.$course;
        if (classSummary != null) {
            str2 = classSummary.getTermCode();
        }
        str = gradesService.getGradebook(schoolCode, studentID, gradeBookNumber, str2, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(/* anonymous class already generated */, /* anonymous class already generated */);
        Intrinsics.checkExpressionValueIsNotNull(str, "gradesService.getGradebo…) }\n                    )");
        assignmentsInteractor.addToCompositeDisposable(str);
    }
}
