package com.squareup.picasso;

import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements OnPreDrawListener, OnAttachStateChangeListener {
    @VisibleForTesting
    Callback callback;
    private final RequestCreator creator;
    @VisibleForTesting
    final WeakReference<ImageView> target;

    DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback) {
        this.creator = requestCreator;
        this.target = new WeakReference(imageView);
        this.callback = callback;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.target.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0) {
            if (height > 0) {
                imageView.removeOnAttachStateChangeListener(this);
                viewTreeObserver.removeOnPreDrawListener(this);
                this.target.clear();
                this.creator.unfit().resize(width, height).into(imageView, this.callback);
                return true;
            }
        }
        return true;
    }

    void cancel() {
        this.creator.clearTag();
        this.callback = null;
        ImageView imageView = (ImageView) this.target.get();
        if (imageView != null) {
            this.target.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    Object getTag() {
        return this.creator.getTag();
    }
}
