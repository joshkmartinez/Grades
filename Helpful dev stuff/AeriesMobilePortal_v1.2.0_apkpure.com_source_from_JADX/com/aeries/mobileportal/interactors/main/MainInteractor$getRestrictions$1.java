package com.aeries.mobileportal.interactors.main;

import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.Restricted;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.web_services.services.RestrictionService;
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
/* compiled from: MainInteractor.kt */
final class MainInteractor$getRestrictions$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MainCallback $callback;
    final /* synthetic */ Student $student;
    final /* synthetic */ int $studentID;
    final /* synthetic */ MainInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
    /* compiled from: MainInteractor.kt */
    static final class C07582<T> implements Consumer<Throwable> {
        public static final C07582 INSTANCE = new C07582();

        C07582() {
        }

        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    MainInteractor$getRestrictions$1(MainInteractor mainInteractor, Student student, int i, MainCallback mainCallback) {
        this.this$0 = mainInteractor;
        this.$student = student;
        this.$studentID = i;
        this.$callback = mainCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        int schoolCode;
        Intrinsics.checkParameterIsNotNull(str, "it");
        MainInteractor mainInteractor = this.this$0;
        RestrictionService restrictionService = this.this$0.getRestrictionService();
        Student student = this.$student;
        if (student != null) {
            Demographics demographics = student.getDemographics();
            if (demographics != null) {
                schoolCode = demographics.getSchoolCode();
                str = restrictionService.getRestricted(schoolCode, this.$studentID, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Restricted>() {
                    public final void accept(Restricted restricted) {
                        boolean studentRestriction = this.this$0.getRestrictionRepository().getStudentRestriction(this.$studentID);
                        MainCallback mainCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(restricted, "it");
                        mainCallback.onRestrictionsReceived(restricted, studentRestriction);
                    }
                }, C07582.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(str, "restrictionService.getRe…  }\n                    )");
                mainInteractor.addToCompositeDisposable(str);
            }
        }
        schoolCode = 0;
        str = restrictionService.getRestricted(schoolCode, this.$studentID, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(/* anonymous class already generated */, C07582.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(str, "restrictionService.getRe…  }\n                    )");
        mainInteractor.addToCompositeDisposable(str);
    }
}
