package com.aeries.mobileportal.views.fragments;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onRefresh"}, k = 3, mv = {1, 1, 10})
/* compiled from: NotificationsFragment.kt */
final class NotificationsFragment$setupViews$2 implements OnRefreshListener {
    final /* synthetic */ NotificationsFragment this$0;

    NotificationsFragment$setupViews$2(NotificationsFragment notificationsFragment) {
        this.this$0 = notificationsFragment;
    }

    public final void onRefresh() {
        this.this$0.getNotificationsError().setVisibility(8);
        this.this$0.getNoNotifications().setVisibility(8);
        this.this$0.getPresenter().refreshNotifications();
    }
}
