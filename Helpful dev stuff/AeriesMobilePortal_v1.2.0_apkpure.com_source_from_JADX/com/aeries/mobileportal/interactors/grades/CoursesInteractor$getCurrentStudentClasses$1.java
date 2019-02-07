package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.SchoolClassSummary;
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
/* compiled from: CoursesInteractor.kt */
final class CoursesInteractor$getCurrentStudentClasses$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ CoursesCallback $callback;
    final /* synthetic */ int $studentId;
    final /* synthetic */ CoursesInteractor this$0;

    CoursesInteractor$getCurrentStudentClasses$1(CoursesInteractor coursesInteractor, int i, CoursesCallback coursesCallback) {
        this.this$0 = coursesInteractor;
        this.$studentId = i;
        this.$callback = coursesCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        CoursesInteractor coursesInteractor = this.this$0;
        str = this.this$0.getGradesService().getClassSummary(Integer.valueOf(this.$studentId), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<SchoolClassSummary>>() {
            public final void accept(List<SchoolClassSummary> list) {
                CoursesCallback coursesCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(list, "it");
                coursesCallback.onClassSummariesReceived(list);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                CoursesCallback coursesCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                coursesCallback.onClassSummariesError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "gradesService.getClassSu…) }\n                    )");
        coursesInteractor.addToCompositeDisposable(str);
    }
}
