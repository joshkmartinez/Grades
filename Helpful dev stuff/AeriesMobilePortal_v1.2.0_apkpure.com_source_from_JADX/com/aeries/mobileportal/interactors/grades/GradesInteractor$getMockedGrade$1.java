package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.models.CalculateScoreRequest;
import com.aeries.mobileportal.models.MockGrade;
import com.aeries.mobileportal.models.MockGradebook;
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
/* compiled from: GradesInteractor.kt */
final class GradesInteractor$getMockedGrade$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GradesCallback $callback;
    final /* synthetic */ MockGradebook $gradebook;
    final /* synthetic */ CalculateScoreRequest $r;
    final /* synthetic */ GradesInteractor this$0;

    GradesInteractor$getMockedGrade$1(GradesInteractor gradesInteractor, CalculateScoreRequest calculateScoreRequest, GradesCallback gradesCallback, MockGradebook mockGradebook) {
        this.this$0 = gradesInteractor;
        this.$r = calculateScoreRequest;
        this.$callback = gradesCallback;
        this.$gradebook = mockGradebook;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        GradesInteractor gradesInteractor = this.this$0;
        str = this.this$0.getWhatIfService().getGrade(this.$r, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MockGrade>() {
            public final void accept(MockGrade mockGrade) {
                GradesCallback gradesCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(mockGrade, "it");
                gradesCallback.onMockGradeReceived(mockGrade, this.$gradebook.getGradebookNumber());
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                GradesCallback gradesCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                gradesCallback.onClassSummariesError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "whatIfService.getGrade(r…  }\n                    )");
        gradesInteractor.addToCompositeDisposable(str);
    }
}
