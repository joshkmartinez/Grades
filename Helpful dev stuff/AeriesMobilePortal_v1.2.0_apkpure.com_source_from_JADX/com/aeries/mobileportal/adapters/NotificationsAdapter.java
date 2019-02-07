package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.utils.DateUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u001e\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0014\u0010\u0019\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/adapters/NotificationsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationHolder;", "listener", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "(Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "notifications", "", "Lcom/aeries/mobileportal/models/Notification;", "getNotifications", "()Ljava/util/List;", "getItemCount", "", "markNotificationAsSeen", "", "notification", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "NotificationHolder", "NotificationListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsAdapter.kt */
public final class NotificationsAdapter extends Adapter<NotificationHolder> {
    @NotNull
    private final NotificationListener listener;
    @NotNull
    private final List<Notification> notifications = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "", "onNotificationClick", "", "notification", "Lcom/aeries/mobileportal/models/Notification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: NotificationsAdapter.kt */
    public interface NotificationListener {
        void onNotificationClick(@NotNull Notification notification);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/NotificationsAdapter;Landroid/view/View;)V", "messageTV", "Landroid/widget/TextView;", "getMessageTV", "()Landroid/widget/TextView;", "setMessageTV", "(Landroid/widget/TextView;)V", "nameTV", "getNameTV", "setNameTV", "newBadge", "Landroid/support/v7/widget/CardView;", "getNewBadge", "()Landroid/support/v7/widget/CardView;", "setNewBadge", "(Landroid/support/v7/widget/CardView;)V", "timeAgo", "getTimeAgo", "setTimeAgo", "bindData", "", "notification", "Lcom/aeries/mobileportal/models/Notification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: NotificationsAdapter.kt */
    public final class NotificationHolder extends ViewHolder {
        @NotNull
        @BindView(2131362037)
        public TextView messageTV;
        @NotNull
        @BindView(2131362050)
        public TextView nameTV;
        @NotNull
        @BindView(2131362055)
        public CardView newBadge;
        final /* synthetic */ NotificationsAdapter this$0;
        @NotNull
        @BindView(2131362256)
        public TextView timeAgo;

        public NotificationHolder(@NotNull NotificationsAdapter notificationsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = notificationsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getMessageTV() {
            TextView textView = this.messageTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageTV");
            }
            return textView;
        }

        public final void setMessageTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.messageTV = textView;
        }

        @NotNull
        public final TextView getNameTV() {
            TextView textView = this.nameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nameTV");
            }
            return textView;
        }

        public final void setNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.nameTV = textView;
        }

        @NotNull
        public final CardView getNewBadge() {
            CardView cardView = this.newBadge;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newBadge");
            }
            return cardView;
        }

        public final void setNewBadge(@NotNull CardView cardView) {
            Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
            this.newBadge = cardView;
        }

        @NotNull
        public final TextView getTimeAgo() {
            TextView textView = this.timeAgo;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeAgo");
            }
            return textView;
        }

        public final void setTimeAgo(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.timeAgo = textView;
        }

        public final void bindData(@NotNull Notification notification) {
            Intrinsics.checkParameterIsNotNull(notification, "notification");
            CardView cardView = this.newBadge;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newBadge");
            }
            cardView.setVisibility((Intrinsics.areEqual(notification.getStatus(), (Object) "Read") ^ 1) != 0 ? 0 : 8);
            TextView textView = this.timeAgo;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeAgo");
            }
            Long millis = DateUtils.Companion.getMillis(notification.getDateCreated());
            textView.setText(android.text.format.DateUtils.getRelativeTimeSpanString(millis != null ? millis.longValue() : 0));
            textView = this.nameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nameTV");
            }
            textView.setText(notification.getName());
            textView = this.messageTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageTV");
            }
            textView.setText(notification.getNotificationMessage());
            this.itemView.setOnClickListener(new NotificationsAdapter$NotificationHolder$bindData$1(this, notification));
        }
    }

    public final class NotificationHolder_ViewBinding implements Unbinder {
        private NotificationHolder target;

        @UiThread
        public NotificationHolder_ViewBinding(NotificationHolder notificationHolder, View view) {
            this.target = notificationHolder;
            notificationHolder.messageTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'messageTV'", TextView.class);
            notificationHolder.nameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.name, "field 'nameTV'", TextView.class);
            notificationHolder.newBadge = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.new_badge, "field 'newBadge'", CardView.class);
            notificationHolder.timeAgo = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.time_ago, "field 'timeAgo'", TextView.class);
        }

        public void unbind() {
            NotificationHolder notificationHolder = this.target;
            if (notificationHolder != null) {
                this.target = null;
                notificationHolder.messageTV = null;
                notificationHolder.nameTV = null;
                notificationHolder.newBadge = null;
                notificationHolder.timeAgo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @NotNull
    public final NotificationListener getListener() {
        return this.listener;
    }

    public NotificationsAdapter(@NotNull NotificationListener notificationListener) {
        Intrinsics.checkParameterIsNotNull(notificationListener, CastExtraArgs.LISTENER);
        this.listener = notificationListener;
    }

    @NotNull
    public final List<Notification> getNotifications() {
        return this.notifications;
    }

    @NotNull
    public NotificationHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_notification, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new NotificationHolder(this, viewGroup);
    }

    public int getItemCount() {
        return this.notifications.size();
    }

    public void onBindViewHolder(@Nullable NotificationHolder notificationHolder, int i) {
        if (notificationHolder != null) {
            notificationHolder.bindData((Notification) this.notifications.get(i));
        }
    }

    public final void update(@NotNull List<? extends Notification> list) {
        Intrinsics.checkParameterIsNotNull(list, "notifications");
        this.notifications.clear();
        this.notifications.addAll(list);
        notifyDataSetChanged();
    }

    public final void markNotificationAsSeen(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        for (Notification notification2 : this.notifications) {
            if (Intrinsics.areEqual(notification2.getNotificationID(), notification.getNotificationID())) {
                notification2.setStatus("Read");
                notifyDataSetChanged();
                return;
            }
        }
        throw ((Throwable) new NoSuchElementException("Collection contains no element matching the predicate."));
    }
}
