package com.aeries.mobileportal.views.viewmodels.change_password;

import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showDoneScreen", "", "showError", "error", "", "showPasswordFragment", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordViewModel.kt */
public interface ChangePasswordViewModel extends BaseViewModel {
    void showDoneScreen();

    void showError(@NotNull String str);

    void showPasswordFragment(@NotNull AccountTakenRequest accountTakenRequest);
}
