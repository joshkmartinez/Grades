package com.aeries.mobileportal.views.viewmodels.main;

import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/main/MainViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showError", "", "message", "", "showInvalidatedAccessTokenToast", "showRestrictionMessage", "showRestrictionMessageLogout", "showSelectedStudent", "student", "Lcom/aeries/mobileportal/models/Student;", "startLoginActivity", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainViewModel.kt */
public interface MainViewModel extends BaseViewModel {
    void showError(@NotNull String str);

    void showInvalidatedAccessTokenToast();

    void showRestrictionMessage(@NotNull String str);

    void showRestrictionMessageLogout(@NotNull String str);

    void showSelectedStudent(@Nullable Student student);

    void startLoginActivity();
}
