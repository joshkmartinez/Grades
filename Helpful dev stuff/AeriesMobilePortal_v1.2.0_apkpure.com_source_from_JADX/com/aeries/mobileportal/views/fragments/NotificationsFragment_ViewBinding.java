package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class NotificationsFragment_ViewBinding implements Unbinder {
    private NotificationsFragment target;
    private View view2131361882;

    @UiThread
    public NotificationsFragment_ViewBinding(final NotificationsFragment notificationsFragment, View view) {
        this.target = notificationsFragment;
        notificationsFragment.notificationsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.notifications, "field 'notificationsRV'", RecyclerView.class);
        notificationsFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        notificationsFragment.swipeRefresh = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, C0316R.id.swipe_refresh, "field 'swipeRefresh'", SwipeRefreshLayout.class);
        notificationsFragment.noNotifications = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.no_notifications, "field 'noNotifications'", TextView.class);
        notificationsFragment.notificationsError = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.notifications_error, "field 'notificationsError'", TextView.class);
        view = Utils.findRequiredView(view, C0316R.id.close_icon, "method 'onCloseIconClicked'");
        this.view2131361882 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                notificationsFragment.onCloseIconClicked();
            }
        });
    }

    public void unbind() {
        NotificationsFragment notificationsFragment = this.target;
        if (notificationsFragment != null) {
            this.target = null;
            notificationsFragment.notificationsRV = null;
            notificationsFragment.progressBar = null;
            notificationsFragment.swipeRefresh = null;
            notificationsFragment.noNotifications = null;
            notificationsFragment.notificationsError = null;
            this.view2131361882.setOnClickListener(null);
            this.view2131361882 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
