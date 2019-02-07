package com.aeries.mobileportal.views.viewmodels.link_student;

import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showCompleteMessage", "", "message", "", "showError", "error", "showUpdateContactScreen", "addStudentResponse", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentViewModel.kt */
public interface LinkStudentViewModel extends BaseViewModel {
    void showCompleteMessage();

    void showCompleteMessage(@NotNull String str);

    void showError(@NotNull String str);

    void showUpdateContactScreen(@NotNull AddStudentResponse addStudentResponse);
}
