package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso.LoadedFrom;

abstract class RemoteViewsAction extends Action<RemoteViewsTarget> {
    Callback callback;
    final RemoteViews remoteViews;
    private RemoteViewsTarget target;
    final int viewId;

    static class RemoteViewsTarget {
        final RemoteViews remoteViews;
        final int viewId;

        RemoteViewsTarget(RemoteViews remoteViews, int i) {
            this.remoteViews = remoteViews;
            this.viewId = i;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    RemoteViewsTarget remoteViewsTarget = (RemoteViewsTarget) obj;
                    if (this.viewId != remoteViewsTarget.viewId || this.remoteViews.equals(remoteViewsTarget.remoteViews) == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * this.remoteViews.hashCode()) + this.viewId;
        }
    }

    static class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;

        /* bridge */ /* synthetic */ Object getTarget() {
            return super.getTarget();
        }

        AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int[] iArr, int i2, int i3, String str, Object obj, int i4, Callback callback) {
            super(picasso, request, remoteViews, i, i4, i2, i3, obj, str, callback);
            this.appWidgetIds = iArr;
        }

        void update() {
            AppWidgetManager.getInstance(this.picasso.context).updateAppWidget(this.appWidgetIds, this.remoteViews);
        }
    }

    static class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;
        private final String notificationTag;

        /* bridge */ /* synthetic */ Object getTarget() {
            return super.getTarget();
        }

        NotificationAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, Notification notification, String str, int i3, int i4, String str2, Object obj, int i5, Callback callback) {
            super(picasso, request, remoteViews, i, i5, i3, i4, obj, str2, callback);
            this.notificationId = i2;
            this.notificationTag = str;
            this.notification = notification;
        }

        void update() {
            ((NotificationManager) Utils.getService(this.picasso.context, "notification")).notify(this.notificationTag, this.notificationId, this.notification);
        }
    }

    abstract void update();

    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, int i3, int i4, Object obj, String str, Callback callback) {
        super(picasso, null, request, i3, i4, i2, null, str, obj, false);
        this.remoteViews = remoteViews;
        this.viewId = i;
        this.callback = callback;
    }

    void complete(Bitmap bitmap, LoadedFrom loadedFrom) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
        if (this.callback != null) {
            this.callback.onSuccess();
        }
    }

    void cancel() {
        super.cancel();
        if (this.callback != null) {
            this.callback = null;
        }
    }

    public void error(Exception exception) {
        if (this.errorResId != 0) {
            setImageResource(this.errorResId);
        }
        if (this.callback != null) {
            this.callback.onError(exception);
        }
    }

    RemoteViewsTarget getTarget() {
        if (this.target == null) {
            this.target = new RemoteViewsTarget(this.remoteViews, this.viewId);
        }
        return this.target;
    }

    void setImageResource(int i) {
        this.remoteViews.setImageViewResource(this.viewId, i);
        update();
    }
}
