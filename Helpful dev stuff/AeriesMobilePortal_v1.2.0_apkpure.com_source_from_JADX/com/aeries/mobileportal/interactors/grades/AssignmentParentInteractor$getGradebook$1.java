package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.web_services.services.GradesService;
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
/* compiled from: AssignmentParentInteractor.kt */
final class AssignmentParentInteractor$getGradebook$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AssignmentParentCallback $callback;
    final /* synthetic */ ClassSummary $classSummary;
    final /* synthetic */ Student $student;
    final /* synthetic */ AssignmentParentInteractor this$0;

    AssignmentParentInteractor$getGradebook$1(AssignmentParentInteractor assignmentParentInteractor, Student student, ClassSummary classSummary, AssignmentParentCallback assignmentParentCallback) {
        this.this$0 = assignmentParentInteractor;
        this.$student = student;
        this.$classSummary = classSummary;
        this.$callback = assignmentParentCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Integer valueOf;
        Student student;
        Integer valueOf2;
        ClassSummary classSummary;
        Integer gradeBookNumber;
        ClassSummary classSummary2;
        Intrinsics.checkParameterIsNotNull(str, "it");
        AssignmentParentInteractor assignmentParentInteractor = this.this$0;
        GradesService gradesService = this.this$0.getGradesService();
        Student student2 = this.$student;
        String str2 = null;
        if (student2 != null) {
            Demographics demographics = student2.getDemographics();
            if (demographics != null) {
                valueOf = Integer.valueOf(demographics.getSchoolCode());
                student = this.$student;
                valueOf2 = student == null ? Integer.valueOf(student.getStudentID()) : null;
                classSummary = this.$classSummary;
                gradeBookNumber = classSummary == null ? classSummary.getGradeBookNumber() : null;
                classSummary2 = this.$classSummary;
                if (classSummary2 != null) {
                    str2 = classSummary2.getTermCode();
                }
                str = gradesService.getGradebook(valueOf, valueOf2, gradeBookNumber, str2, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Gradebook>() {
                    public final void accept(Gradebook gradebook) {
                        AssignmentParentCallback assignmentParentCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(gradebook, "it");
                        assignmentParentCallback.onGradebookReceived(gradebook);
                    }
                }, new Consumer<Throwable>() {
                    public final void accept(Throwable th) {
                        AssignmentParentCallback assignmentParentCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(th, "it");
                        assignmentParentCallback.onGradebookError(th);
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(str, "gradesService.getGradebo…) }\n                    )");
                assignmentParentInteractor.addToCompositeDisposable(str);
            }
        }
        valueOf = null;
        student = this.$student;
        if (student == null) {
        }
        classSummary = this.$classSummary;
        if (classSummary == null) {
        }
        classSummary2 = this.$classSummary;
        if (classSummary2 != null) {
            str2 = classSummary2.getTermCode();
        }
        str = gradesService.getGradebook(valueOf, valueOf2, gradeBookNumber, str2, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(/* anonymous class already generated */, /* anonymous class already generated */);
        Intrinsics.checkExpressionValueIsNotNull(str, "gradesService.getGradebo…) }\n                    )");
        assignmentParentInteractor.addToCompositeDisposable(str);
    }
}
