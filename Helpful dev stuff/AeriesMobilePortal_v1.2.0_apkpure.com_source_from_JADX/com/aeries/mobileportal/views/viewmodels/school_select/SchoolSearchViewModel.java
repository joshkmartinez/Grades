package com.aeries.mobileportal.views.viewmodels.school_select;

import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goToLogin", "", "requestPermissions", "selectSchool", "showError", "message", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchViewModel.kt */
public interface SchoolSearchViewModel extends BaseViewModel {
    void goToLogin();

    void requestPermissions();

    void selectSchool();

    void showError(@NotNull String str);
}
