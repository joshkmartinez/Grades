package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.NotificationsAdapter.NotificationHolder;
import com.aeries.mobileportal.models.Notification;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: NotificationsAdapter.kt */
final class NotificationsAdapter$NotificationHolder$bindData$1 implements OnClickListener {
    final /* synthetic */ Notification $notification;
    final /* synthetic */ NotificationHolder this$0;

    NotificationsAdapter$NotificationHolder$bindData$1(NotificationHolder notificationHolder, Notification notification) {
        this.this$0 = notificationHolder;
        this.$notification = notification;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getListener().onNotificationClick(this.$notification);
    }
}
