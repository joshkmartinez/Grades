package com.aeries.mobileportal.views.viewmodels;

import android.content.Intent;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "attemptStartActivity", "", "intent", "Landroid/content/Intent;", "showError", "", "message", "", "showNotifications", "notifications", "", "Lcom/aeries/mobileportal/models/Notification;", "showProgressBar", "b", "showRedirectingDialog", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsViewModel.kt */
public interface NotificationsViewModel extends BaseViewModel {
    boolean attemptStartActivity(@NotNull Intent intent);

    void showError(@NotNull String str);

    void showNotifications(@NotNull List<? extends Notification> list);

    void showProgressBar(boolean z);

    void showRedirectingDialog(boolean z);
}
