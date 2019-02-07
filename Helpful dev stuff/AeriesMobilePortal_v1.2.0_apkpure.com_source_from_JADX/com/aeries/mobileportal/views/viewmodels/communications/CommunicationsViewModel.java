package com.aeries.mobileportal.views.viewmodels.communications;

import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showErrorMessage", "", "message", "", "showFailureMessage", "showWebView", "url", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CommunicationsViewModel.kt */
public interface CommunicationsViewModel extends BaseViewModel {
    void showErrorMessage(@NotNull String str);

    void showFailureMessage(@Nullable String str);

    void showWebView(@NotNull String str);
}
