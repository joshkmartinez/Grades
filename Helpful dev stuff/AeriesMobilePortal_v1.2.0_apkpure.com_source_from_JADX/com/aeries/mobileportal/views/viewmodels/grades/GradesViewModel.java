package com.aeries.mobileportal.views.viewmodels.grades;

import com.aeries.mobileportal.models.MockGrade;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "getMockedGrade", "Lcom/aeries/mobileportal/models/MockGrade;", "gradebookNumber", "", "isEditModeEnabled", "", "showError", "", "e", "", "storeAndShowMockGrade", "mockGrade", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesViewModel.kt */
public interface GradesViewModel extends BaseViewModel {
    @Nullable
    MockGrade getMockedGrade(@NotNull String str);

    boolean isEditModeEnabled();

    void showError(@NotNull Throwable th);

    void storeAndShowMockGrade(@NotNull MockGrade mockGrade, @NotNull String str);
}
