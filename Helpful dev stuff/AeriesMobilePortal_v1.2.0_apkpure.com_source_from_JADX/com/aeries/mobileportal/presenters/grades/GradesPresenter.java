package com.aeries.mobileportal.presenters.grades;

import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.interactors.grades.GradesCallback;
import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.models.MockGrade;
import com.aeries.mobileportal.models.MockGradebook;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020\u001cR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r¨\u0006*"}, d2 = {"Lcom/aeries/mobileportal/presenters/grades/GradesPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "Lcom/aeries/mobileportal/interactors/grades/GradesCallback;", "gradesViewModel", "gradesInteractor", "Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;)V", "categories", "", "getCategories", "()Z", "setCategories", "(Z)V", "dropdownVisible", "getDropdownVisible", "setDropdownVisible", "getGradesInteractor", "()Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;", "getGradesViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "lastUpdatedVisible", "getLastUpdatedVisible", "setLastUpdatedVisible", "showHideWhatIf", "getShowHideWhatIf", "setShowHideWhatIf", "cancelRequests", "", "getMockedGrade", "mockGradebook", "Lcom/aeries/mobileportal/models/MockGradebook;", "onClassSummariesError", "e", "", "onCreate", "onMockGradeReceived", "mockGrade", "Lcom/aeries/mobileportal/models/MockGrade;", "gradebookNumber", "", "sendDetailsAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesPresenter.kt */
public final class GradesPresenter extends BasePresenter<GradesViewModel> implements GradesCallback {
    private boolean categories;
    private boolean dropdownVisible;
    @NotNull
    private final GradesInteractor gradesInteractor;
    @NotNull
    private final GradesViewModel gradesViewModel;
    private boolean lastUpdatedVisible;
    private boolean showHideWhatIf;

    @NotNull
    public final GradesInteractor getGradesInteractor() {
        return this.gradesInteractor;
    }

    @NotNull
    public final GradesViewModel getGradesViewModel() {
        return this.gradesViewModel;
    }

    public GradesPresenter(@NotNull GradesViewModel gradesViewModel, @NotNull GradesInteractor gradesInteractor) {
        Intrinsics.checkParameterIsNotNull(gradesViewModel, "gradesViewModel");
        Intrinsics.checkParameterIsNotNull(gradesInteractor, "gradesInteractor");
        super(gradesViewModel, gradesInteractor);
        this.gradesViewModel = gradesViewModel;
        this.gradesInteractor = gradesInteractor;
    }

    public final boolean getDropdownVisible() {
        return this.dropdownVisible;
    }

    public final void setDropdownVisible(boolean z) {
        this.dropdownVisible = z;
    }

    public final boolean getLastUpdatedVisible() {
        return this.lastUpdatedVisible;
    }

    public final void setLastUpdatedVisible(boolean z) {
        this.lastUpdatedVisible = z;
    }

    public final boolean getCategories() {
        return this.categories;
    }

    public final void setCategories(boolean z) {
        this.categories = z;
    }

    public final boolean getShowHideWhatIf() {
        return this.showHideWhatIf;
    }

    public final void setShowHideWhatIf(boolean z) {
        this.showHideWhatIf = z;
    }

    public final void getMockedGrade(@NotNull MockGradebook mockGradebook) {
        Intrinsics.checkParameterIsNotNull(mockGradebook, "mockGradebook");
        this.gradesInteractor.getMockedGrade(mockGradebook, this);
    }

    public final void sendDetailsAnalytics() {
        this.gradesInteractor.sendAssignmentDetailsAnalytics();
    }

    public final void cancelRequests() {
        this.gradesInteractor.cancelRequests();
    }

    public void onClassSummariesError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        th.printStackTrace();
        this.gradesViewModel.showError(th);
    }

    public void onMockGradeReceived(@NotNull MockGrade mockGrade, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(mockGrade, "mockGrade");
        Intrinsics.checkParameterIsNotNull(str, "gradebookNumber");
        this.gradesViewModel.storeAndShowMockGrade(mockGrade, str);
    }

    public void onCreate() {
        String serverInfo = this.gradesInteractor.getServerInfo();
        boolean z = false;
        this.dropdownVisible = serverInfo.compareTo(BuildConfig.DROPDOWN_VERSION) >= 0;
        this.lastUpdatedVisible = serverInfo.compareTo(BuildConfig.LAST_UPDATED_VERSION) >= 0;
        this.categories = serverInfo.compareTo(BuildConfig.WHAT_IF_CATEGORIES_VERSION) >= 0;
        if (serverInfo.compareTo(BuildConfig.SHOW_WHAT_IF_AVAILABLE_VERSION) >= 0) {
            z = true;
        }
        this.showHideWhatIf = z;
    }
}
