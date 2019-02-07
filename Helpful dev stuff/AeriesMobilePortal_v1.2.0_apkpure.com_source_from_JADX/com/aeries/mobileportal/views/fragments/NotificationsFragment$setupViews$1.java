package com.aeries.mobileportal.views.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/aeries/mobileportal/views/fragments/NotificationsFragment$setupViews$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/aeries/mobileportal/views/fragments/NotificationsFragment;Landroid/support/v7/widget/LinearLayoutManager;)V", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsFragment.kt */
public final class NotificationsFragment$setupViews$1 extends OnScrollListener {
    final /* synthetic */ LinearLayoutManager $manager;
    final /* synthetic */ NotificationsFragment this$0;

    NotificationsFragment$setupViews$1(NotificationsFragment notificationsFragment, LinearLayoutManager linearLayoutManager) {
        this.this$0 = notificationsFragment;
        this.$manager = linearLayoutManager;
    }

    public void onScrolled(@Nullable RecyclerView recyclerView, int i, int i2) {
        this.this$0.getSwipeRefresh().setEnabled(this.$manager.findFirstCompletelyVisibleItemPosition() == 0 ? 1 : 0);
    }
}
