package com.aeries.mobileportal.presenters.tablet;

import com.aeries.mobileportal.interactors.tablet.MainTabletCallback;
import com.aeries.mobileportal.interactors.tablet.MainTabletInteractor;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.main_tablet.MainTabletViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ.\u0010\u000f\u001a\u00020\r2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J \u0010\u0017\u001a\u00020\r2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0015H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006&"}, d2 = {"Lcom/aeries/mobileportal/presenters/tablet/MainTabletPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/main_tablet/MainTabletViewModel;", "Lcom/aeries/mobileportal/interactors/tablet/MainTabletCallback;", "mainTabletViewModel", "mainTabletInteractor", "Lcom/aeries/mobileportal/interactors/tablet/MainTabletInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/main_tablet/MainTabletViewModel;Lcom/aeries/mobileportal/interactors/tablet/MainTabletInteractor;)V", "getMainTabletInteractor", "()Lcom/aeries/mobileportal/interactors/tablet/MainTabletInteractor;", "getMainTabletViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/main_tablet/MainTabletViewModel;", "cancelRequests", "", "checkGradesViewPermissions", "displaySettingsParent", "settings", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "students", "", "Lcom/aeries/mobileportal/models/Student;", "displaySettingsStudent", "getSelectedStudent", "getSettingsType", "getStudentGrades", "onCoursesError", "e", "", "onCoursesRetrieved", "courses", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "onCreate", "setGradesViewsVisibility", "dropdown", "", "lastUpdated", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainTabletPresenter.kt */
public final class MainTabletPresenter extends BasePresenter<MainTabletViewModel> implements MainTabletCallback {
    @NotNull
    private final MainTabletInteractor mainTabletInteractor;
    @NotNull
    private final MainTabletViewModel mainTabletViewModel;

    public void onCreate() {
    }

    @NotNull
    public final MainTabletInteractor getMainTabletInteractor() {
        return this.mainTabletInteractor;
    }

    @NotNull
    public final MainTabletViewModel getMainTabletViewModel() {
        return this.mainTabletViewModel;
    }

    public MainTabletPresenter(@NotNull MainTabletViewModel mainTabletViewModel, @NotNull MainTabletInteractor mainTabletInteractor) {
        Intrinsics.checkParameterIsNotNull(mainTabletViewModel, "mainTabletViewModel");
        Intrinsics.checkParameterIsNotNull(mainTabletInteractor, "mainTabletInteractor");
        super(mainTabletViewModel, mainTabletInteractor);
        this.mainTabletViewModel = mainTabletViewModel;
        this.mainTabletInteractor = mainTabletInteractor;
    }

    @Nullable
    public final Student getSelectedStudent() {
        return this.mainTabletInteractor.getSelectedStudent();
    }

    public final void getSettingsType() {
        this.mainTabletInteractor.getSettingsType(this);
    }

    public final void checkGradesViewPermissions() {
        this.mainTabletInteractor.getAeriesVersion(this);
    }

    public final void cancelRequests() {
        this.mainTabletInteractor.cancelRequests();
    }

    public final void getStudentGrades() {
        this.mainTabletInteractor.getStudentCourses(this);
    }

    public void displaySettingsParent(@NotNull ArrayList<String> arrayList, @NotNull List<Student> list) {
        Intrinsics.checkParameterIsNotNull(arrayList, "settings");
        Intrinsics.checkParameterIsNotNull(list, "students");
        this.mainTabletViewModel.displaySettingsParent(arrayList, list);
    }

    public void displaySettingsStudent(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "settings");
        this.mainTabletViewModel.displaySettingsStudent(arrayList);
    }

    public void setGradesViewsVisibility(boolean z, boolean z2) {
        this.mainTabletViewModel.showGradesFragment(z, z2);
    }

    public void onCoursesRetrieved(@NotNull List<SchoolClassSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "courses");
        this.mainTabletViewModel.showCourses(list);
    }

    public void onCoursesError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.mainTabletViewModel.showError(th);
    }
}
