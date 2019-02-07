package com.aeries.mobileportal.views.viewmodels.feedback;

import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "autoFillEmail", "", "email", "", "showError", "message", "showThankYouScreen", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackViewModel.kt */
public interface FeedbackViewModel extends BaseViewModel {
    void autoFillEmail(@NotNull String str);

    void showError(@NotNull String str);

    void showThankYouScreen();
}
