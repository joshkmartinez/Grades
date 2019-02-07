package com.squareup.picasso;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.Request.Builder;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private int memoryPolicy;
    private int networkPolicy;
    private boolean noFade;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean setPlaceholder;
    private Object tag;

    RequestCreator(Picasso picasso, Uri uri, int i) {
        this.setPlaceholder = true;
        if (picasso.shutdown) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.picasso = picasso;
        this.data = new Builder(uri, i, picasso.defaultBitmapConfig);
    }

    @VisibleForTesting
    RequestCreator() {
        this.setPlaceholder = true;
        this.picasso = null;
        this.data = new Builder(null, 0, null);
    }

    public RequestCreator noPlaceholder() {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.placeholderDrawable == null) {
            this.setPlaceholder = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator placeholder(@DrawableRes int i) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.placeholderDrawable == null) {
            this.placeholderResId = i;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator placeholder(@NonNull Drawable drawable) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.placeholderResId == 0) {
            this.placeholderDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator error(@DrawableRes int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.errorDrawable == null) {
            this.errorResId = i;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public RequestCreator error(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.errorResId == 0) {
            this.errorDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public RequestCreator tag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        } else if (this.tag == null) {
            this.tag = obj;
            return this;
        } else {
            throw new IllegalStateException("Tag already set.");
        }
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    RequestCreator unfit() {
        this.deferred = false;
        return this;
    }

    RequestCreator clearTag() {
        this.tag = null;
        return this;
    }

    Object getTag() {
        return this.tag;
    }

    public RequestCreator resizeDimen(int i, int i2) {
        Resources resources = this.picasso.context.getResources();
        return resize(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i2));
    }

    public RequestCreator resize(int i, int i2) {
        this.data.resize(i, i2);
        return this;
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop(17);
        return this;
    }

    public RequestCreator centerCrop(int i) {
        this.data.centerCrop(i);
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    public RequestCreator onlyScaleDown() {
        this.data.onlyScaleDown();
        return this;
    }

    public RequestCreator rotate(float f) {
        this.data.rotate(f);
        return this;
    }

    public RequestCreator rotate(float f, float f2, float f3) {
        this.data.rotate(f, f2, f3);
        return this;
    }

    public RequestCreator config(@NonNull Config config) {
        this.data.config(config);
        return this;
    }

    public RequestCreator stableKey(@NonNull String str) {
        this.data.stableKey(str);
        return this;
    }

    public RequestCreator priority(@NonNull Priority priority) {
        this.data.priority(priority);
        return this;
    }

    public RequestCreator transform(@NonNull Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    public RequestCreator transform(@NonNull List<? extends Transformation> list) {
        this.data.transform((List) list);
        return this;
    }

    public RequestCreator memoryPolicy(@NonNull MemoryPolicy memoryPolicy, @NonNull MemoryPolicy... memoryPolicyArr) {
        if (memoryPolicy != null) {
            this.memoryPolicy = memoryPolicy.index | this.memoryPolicy;
            if (memoryPolicyArr != null) {
                if (memoryPolicyArr.length > null) {
                    memoryPolicy = memoryPolicyArr.length;
                    int i = 0;
                    while (i < memoryPolicy) {
                        MemoryPolicy memoryPolicy2 = memoryPolicyArr[i];
                        if (memoryPolicy2 != null) {
                            this.memoryPolicy = memoryPolicy2.index | this.memoryPolicy;
                            i++;
                        } else {
                            throw new IllegalArgumentException("Memory policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public RequestCreator networkPolicy(@NonNull NetworkPolicy networkPolicy, @NonNull NetworkPolicy... networkPolicyArr) {
        if (networkPolicy != null) {
            this.networkPolicy = networkPolicy.index | this.networkPolicy;
            if (networkPolicyArr != null) {
                if (networkPolicyArr.length > null) {
                    networkPolicy = networkPolicyArr.length;
                    int i = 0;
                    while (i < networkPolicy) {
                        NetworkPolicy networkPolicy2 = networkPolicyArr[i];
                        if (networkPolicy2 != null) {
                            this.networkPolicy = networkPolicy2.index | this.networkPolicy;
                            i++;
                        } else {
                            throw new IllegalArgumentException("Network policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    public RequestCreator purgeable() {
        this.data.purgeable();
        return this;
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public Bitmap get() throws IOException {
        long nanoTime = System.nanoTime();
        Utils.checkNotMain();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.data.hasImage()) {
            return null;
        } else {
            Request createRequest = createRequest(nanoTime);
            return BitmapHunter.forRequest(this.picasso, this.picasso.dispatcher, this.picasso.cache, this.picasso.stats, new GetAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, Utils.createKey(createRequest, new StringBuilder()))).hunt();
        }
    }

    public void fetch() {
        fetch(null);
    }

    public void fetch(@Nullable Callback callback) {
        long nanoTime = System.nanoTime();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        }
        if (this.data.hasImage()) {
            if (!this.data.hasPriority()) {
                this.data.priority(Priority.LOW);
            }
            Request createRequest = createRequest(nanoTime);
            String createKey = Utils.createKey(createRequest, new StringBuilder());
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy) || this.picasso.quickMemoryCacheCheck(createKey) == null) {
                this.picasso.submit(new FetchAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, createKey, callback));
            } else {
                if (this.picasso.loggingEnabled) {
                    String plainId = createRequest.plainId();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("from ");
                    stringBuilder.append(LoadedFrom.MEMORY);
                    Utils.log("Main", "completed", plainId, stringBuilder.toString());
                }
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        }
    }

    public void into(@NonNull Target target) {
        long nanoTime = System.nanoTime();
        Utils.checkMain();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else {
            Drawable drawable = null;
            if (this.data.hasImage()) {
                Request createRequest = createRequest(nanoTime);
                String createKey = Utils.createKey(createRequest);
                if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
                    Bitmap quickMemoryCacheCheck = this.picasso.quickMemoryCacheCheck(createKey);
                    if (quickMemoryCacheCheck != null) {
                        this.picasso.cancelRequest(target);
                        target.onBitmapLoaded(quickMemoryCacheCheck, LoadedFrom.MEMORY);
                        return;
                    }
                }
                if (this.setPlaceholder) {
                    drawable = getPlaceholderDrawable();
                }
                target.onPrepareLoad(drawable);
                this.picasso.enqueueAndSubmit(new TargetAction(this.picasso, target, createRequest, this.memoryPolicy, this.networkPolicy, this.errorDrawable, createKey, this.tag, this.errorResId));
                return;
            }
            this.picasso.cancelRequest(target);
            if (this.setPlaceholder) {
                drawable = getPlaceholderDrawable();
            }
            target.onPrepareLoad(drawable);
        }
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification) {
        into(remoteViews, i, i2, notification, null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification, @Nullable String str) {
        into(remoteViews, i, i2, notification, str, null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification, @Nullable String str, Callback callback) {
        RequestCreator requestCreator = this;
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        } else if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null.");
        } else if (requestCreator.deferred) {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        } else if (requestCreator.placeholderDrawable == null && requestCreator.placeholderResId == 0 && requestCreator.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i3 = i;
            int i4 = i2;
            Notification notification2 = notification;
            String str2 = str;
            performRemoteViewInto(new NotificationAction(requestCreator.picasso, createRequest, remoteViews2, i3, i4, notification2, str2, requestCreator.memoryPolicy, requestCreator.networkPolicy, Utils.createKey(createRequest, new StringBuilder()), requestCreator.tag, requestCreator.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, @NonNull int[] iArr) {
        into(remoteViews, i, iArr, null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, @NonNull int[] iArr, Callback callback) {
        RequestCreator requestCreator = this;
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews must not be null.");
        } else if (iArr == null) {
            throw new IllegalArgumentException("appWidgetIds must not be null.");
        } else if (requestCreator.deferred) {
            throw new IllegalStateException("Fit cannot be used with remote views.");
        } else if (requestCreator.placeholderDrawable == null && requestCreator.placeholderResId == 0 && requestCreator.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i2 = i;
            int[] iArr2 = iArr;
            performRemoteViewInto(new AppWidgetAction(requestCreator.picasso, createRequest, remoteViews2, i2, iArr2, requestCreator.memoryPolicy, requestCreator.networkPolicy, Utils.createKey(createRequest, new StringBuilder()), requestCreator.tag, requestCreator.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(ImageView imageView) {
        into(imageView, null);
    }

    public void into(ImageView imageView, Callback callback) {
        RequestCreator requestCreator = this;
        ImageView imageView2 = imageView;
        Callback callback2 = callback;
        long nanoTime = System.nanoTime();
        Utils.checkMain();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (requestCreator.data.hasImage()) {
            if (requestCreator.deferred) {
                if (requestCreator.data.hasSize()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width != 0) {
                    if (height != 0) {
                        requestCreator.data.resize(width, height);
                    }
                }
                if (requestCreator.setPlaceholder) {
                    PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
                }
                requestCreator.picasso.defer(imageView2, new DeferredRequestCreator(requestCreator, imageView2, callback2));
                return;
            }
            Request createRequest = createRequest(nanoTime);
            String createKey = Utils.createKey(createRequest);
            if (MemoryPolicy.shouldReadFromMemoryCache(requestCreator.memoryPolicy)) {
                Bitmap quickMemoryCacheCheck = requestCreator.picasso.quickMemoryCacheCheck(createKey);
                if (quickMemoryCacheCheck != null) {
                    requestCreator.picasso.cancelRequest(imageView2);
                    PicassoDrawable.setBitmap(imageView, requestCreator.picasso.context, quickMemoryCacheCheck, LoadedFrom.MEMORY, requestCreator.noFade, requestCreator.picasso.indicatorsEnabled);
                    if (requestCreator.picasso.loggingEnabled) {
                        String plainId = createRequest.plainId();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("from ");
                        stringBuilder.append(LoadedFrom.MEMORY);
                        Utils.log("Main", "completed", plainId, stringBuilder.toString());
                    }
                    if (callback2 != null) {
                        callback.onSuccess();
                    }
                    return;
                }
            }
            if (requestCreator.setPlaceholder) {
                PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
            }
            requestCreator.picasso.enqueueAndSubmit(new ImageViewAction(requestCreator.picasso, imageView, createRequest, requestCreator.memoryPolicy, requestCreator.networkPolicy, requestCreator.errorResId, requestCreator.errorDrawable, createKey, requestCreator.tag, callback, requestCreator.noFade));
        } else {
            requestCreator.picasso.cancelRequest(imageView2);
            if (requestCreator.setPlaceholder) {
                PicassoDrawable.setPlaceholder(imageView2, getPlaceholderDrawable());
            }
        }
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderResId == 0) {
            return this.placeholderDrawable;
        }
        if (VERSION.SDK_INT >= 21) {
            return this.picasso.context.getDrawable(this.placeholderResId);
        }
        if (VERSION.SDK_INT >= 16) {
            return this.picasso.context.getResources().getDrawable(this.placeholderResId);
        }
        TypedValue typedValue = new TypedValue();
        this.picasso.context.getResources().getValue(this.placeholderResId, typedValue, true);
        return this.picasso.context.getResources().getDrawable(typedValue.resourceId);
    }

    private Request createRequest(long j) {
        int andIncrement = nextId.getAndIncrement();
        Request build = this.data.build();
        build.id = andIncrement;
        build.started = j;
        boolean z = this.picasso.loggingEnabled;
        if (z) {
            Utils.log("Main", "created", build.plainId(), build.toString());
        }
        Request transformRequest = this.picasso.transformRequest(build);
        if (transformRequest != build) {
            transformRequest.id = andIncrement;
            transformRequest.started = j;
            if (z) {
                String logId = transformRequest.logId();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("into ");
                stringBuilder.append(transformRequest);
                Utils.log("Main", "changed", logId, stringBuilder.toString());
            }
        }
        return transformRequest;
    }

    private void performRemoteViewInto(RemoteViewsAction remoteViewsAction) {
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            Bitmap quickMemoryCacheCheck = this.picasso.quickMemoryCacheCheck(remoteViewsAction.getKey());
            if (quickMemoryCacheCheck != null) {
                remoteViewsAction.complete(quickMemoryCacheCheck, LoadedFrom.MEMORY);
                return;
            }
        }
        if (this.placeholderResId != 0) {
            remoteViewsAction.setImageResource(this.placeholderResId);
        }
        this.picasso.enqueueAndSubmit(remoteViewsAction);
    }
}
