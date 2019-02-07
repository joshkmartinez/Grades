package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
    static final Handler HANDLER = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                List list;
                if (i == 8) {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        BitmapHunter bitmapHunter = (BitmapHunter) list.get(i2);
                        bitmapHunter.picasso.complete(bitmapHunter);
                        i2++;
                    }
                    return;
                } else if (i == 13) {
                    list = (List) message.obj;
                    i = list.size();
                    while (i2 < i) {
                        Action action = (Action) list.get(i2);
                        action.picasso.resumeAction(action);
                        i2++;
                    }
                    return;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown handler message received: ");
                    stringBuilder.append(message.what);
                    throw new AssertionError(stringBuilder.toString());
                }
            }
            Action action2 = (Action) message.obj;
            if (action2.getPicasso().loggingEnabled) {
                Utils.log("Main", "canceled", action2.request.logId(), "target got garbage collected");
            }
            action2.picasso.cancelExistingRequest(action2.getTarget());
        }
    };
    static final String TAG = "Picasso";
    @SuppressLint({"StaticFieldLeak"})
    static volatile Picasso singleton;
    final Cache cache;
    private final CleanupThread cleanupThread;
    final Context context;
    final Config defaultBitmapConfig;
    final Dispatcher dispatcher;
    boolean indicatorsEnabled;
    private final Listener listener;
    volatile boolean loggingEnabled;
    final ReferenceQueue<Object> referenceQueue;
    private final List<RequestHandler> requestHandlers;
    private final RequestTransformer requestTransformer;
    boolean shutdown;
    final Stats stats;
    final Map<Object, Action> targetToAction;
    final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;

    public static class Builder {
        private Cache cache;
        private final Context context;
        private Config defaultBitmapConfig;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List<RequestHandler> requestHandlers;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder(@NonNull Context context) {
            if (context != null) {
                this.context = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Builder defaultBitmapConfig(@NonNull Config config) {
            if (config != null) {
                this.defaultBitmapConfig = config;
                return this;
            }
            throw new IllegalArgumentException("Bitmap config must not be null.");
        }

        public Builder downloader(@NonNull Downloader downloader) {
            if (downloader == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else if (this.downloader == null) {
                this.downloader = downloader;
                return this;
            } else {
                throw new IllegalStateException("Downloader already set.");
            }
        }

        public Builder executor(@NonNull ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.service == null) {
                this.service = executorService;
                return this;
            } else {
                throw new IllegalStateException("Executor service already set.");
            }
        }

        public Builder memoryCache(@NonNull Cache cache) {
            if (cache == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.cache == null) {
                this.cache = cache;
                return this;
            } else {
                throw new IllegalStateException("Memory cache already set.");
            }
        }

        public Builder listener(@NonNull Listener listener) {
            if (listener == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            } else if (this.listener == null) {
                this.listener = listener;
                return this;
            } else {
                throw new IllegalStateException("Listener already set.");
            }
        }

        public Builder requestTransformer(@NonNull RequestTransformer requestTransformer) {
            if (requestTransformer == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            } else if (this.transformer == null) {
                this.transformer = requestTransformer;
                return this;
            } else {
                throw new IllegalStateException("Transformer already set.");
            }
        }

        public Builder addRequestHandler(@NonNull RequestHandler requestHandler) {
            if (requestHandler != null) {
                if (this.requestHandlers == null) {
                    this.requestHandlers = new ArrayList();
                }
                if (this.requestHandlers.contains(requestHandler)) {
                    throw new IllegalStateException("RequestHandler already registered.");
                }
                this.requestHandlers.add(requestHandler);
                return this;
            }
            throw new IllegalArgumentException("RequestHandler must not be null.");
        }

        public Builder indicatorsEnabled(boolean z) {
            this.indicatorsEnabled = z;
            return this;
        }

        public Builder loggingEnabled(boolean z) {
            this.loggingEnabled = z;
            return this;
        }

        public Picasso build() {
            Context context = this.context;
            if (this.downloader == null) {
                this.downloader = new OkHttp3Downloader(context);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context);
            }
            if (this.service == null) {
                this.service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            Context context2 = context;
            return new Picasso(context2, new Dispatcher(context2, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
        }
    }

    private static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<Object> referenceQueue;

        CleanupThread(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.referenceQueue = referenceQueue;
            this.handler = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 10;
            android.os.Process.setThreadPriority(r0);
        L_0x0005:
            r0 = r3.referenceQueue;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r0.remove(r1);	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = (com.squareup.picasso.Action.RequestWeakReference) r0;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = r3.handler;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1 = r1.obtainMessage();	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            if (r0 == 0) goto L_0x0024;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
        L_0x0017:
            r2 = 3;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1.what = r2;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r0.action;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r1.obj = r0;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0 = r3.handler;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            r0.sendMessage(r1);	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            goto L_0x0005;	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
        L_0x0024:
            r1.recycle();	 Catch:{ InterruptedException -> 0x0033, Exception -> 0x0028 }
            goto L_0x0005;
        L_0x0028:
            r0 = move-exception;
            r1 = r3.handler;
            r2 = new com.squareup.picasso.Picasso$CleanupThread$1;
            r2.<init>(r0);
            r1.post(r2);
        L_0x0033:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Picasso.CleanupThread.run():void");
        }

        void shutdown() {
            interrupt();
        }
    }

    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception);
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        
        final int debugColor;

        private LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new C09221();

        static class C09221 implements RequestTransformer {
            public Request transformRequest(Request request) {
                return request;
            }

            C09221() {
            }
        }

        Request transformRequest(Request request);
    }

    Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requestTransformer, List<RequestHandler> list, Stats stats, Config config, boolean z, boolean z2) {
        this.context = context;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.listener = listener;
        this.requestTransformer = requestTransformer;
        this.defaultBitmapConfig = config;
        listener = new ArrayList(7 + (list != null ? list.size() : null));
        listener.add(new ResourceRequestHandler(context));
        if (list != null) {
            listener.addAll(list);
        }
        listener.add(new ContactsPhotoRequestHandler(context));
        listener.add(new MediaStoreRequestHandler(context));
        listener.add(new ContentStreamRequestHandler(context));
        listener.add(new AssetRequestHandler(context));
        listener.add(new FileRequestHandler(context));
        listener.add(new NetworkRequestHandler(dispatcher.downloader, stats));
        this.requestHandlers = Collections.unmodifiableList(listener);
        this.stats = stats;
        this.targetToAction = new WeakHashMap();
        this.targetToDeferredRequestCreator = new WeakHashMap();
        this.indicatorsEnabled = z;
        this.loggingEnabled = z2;
        this.referenceQueue = new ReferenceQueue();
        this.cleanupThread = new CleanupThread(this.referenceQueue, HANDLER);
        this.cleanupThread.start();
    }

    public void cancelRequest(@NonNull ImageView imageView) {
        if (imageView != null) {
            cancelExistingRequest(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void cancelRequest(@NonNull Target target) {
        if (target != null) {
            cancelExistingRequest(target);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void cancelRequest(@NonNull RemoteViews remoteViews, @IdRes int i) {
        if (remoteViews != null) {
            cancelExistingRequest(new RemoteViewsTarget(remoteViews, i));
            return;
        }
        throw new IllegalArgumentException("remoteViews cannot be null.");
    }

    public void cancelTag(@NonNull Object obj) {
        Utils.checkMain();
        if (obj != null) {
            List arrayList = new ArrayList(this.targetToAction.values());
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Action action = (Action) arrayList.get(i2);
                if (obj.equals(action.getTag())) {
                    cancelExistingRequest(action.getTarget());
                }
            }
            arrayList = new ArrayList(this.targetToDeferredRequestCreator.values());
            size = arrayList.size();
            while (i < size) {
                DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) arrayList.get(i);
                if (obj.equals(deferredRequestCreator.getTag())) {
                    deferredRequestCreator.cancel();
                }
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot cancel requests with null tag.");
    }

    public void pauseTag(@NonNull Object obj) {
        if (obj != null) {
            this.dispatcher.dispatchPauseTag(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public void resumeTag(@NonNull Object obj) {
        if (obj != null) {
            this.dispatcher.dispatchResumeTag(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public RequestCreator load(@Nullable Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public RequestCreator load(@Nullable String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public RequestCreator load(@NonNull File file) {
        if (file == null) {
            return new RequestCreator(this, null, 0);
        }
        return load(Uri.fromFile(file));
    }

    public RequestCreator load(@DrawableRes int i) {
        if (i != 0) {
            return new RequestCreator(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public void invalidate(@Nullable Uri uri) {
        if (uri != null) {
            this.cache.clearKeyUri(uri.toString());
        }
    }

    public void invalidate(@Nullable String str) {
        if (str != null) {
            invalidate(Uri.parse(str));
        }
    }

    public void invalidate(@NonNull File file) {
        if (file != null) {
            invalidate(Uri.fromFile(file));
            return;
        }
        throw new IllegalArgumentException("file == null");
    }

    public void setIndicatorsEnabled(boolean z) {
        this.indicatorsEnabled = z;
    }

    public boolean areIndicatorsEnabled() {
        return this.indicatorsEnabled;
    }

    public void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public StatsSnapshot getSnapshot() {
        return this.stats.createSnapshot();
    }

    public void shutdown() {
        if (this == singleton) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        } else if (!this.shutdown) {
            this.cache.clear();
            this.cleanupThread.shutdown();
            this.stats.shutdown();
            this.dispatcher.shutdown();
            for (DeferredRequestCreator cancel : this.targetToDeferredRequestCreator.values()) {
                cancel.cancel();
            }
            this.targetToDeferredRequestCreator.clear();
            this.shutdown = true;
        }
    }

    List<RequestHandler> getRequestHandlers() {
        return this.requestHandlers;
    }

    Request transformRequest(Request request) {
        Request transformRequest = this.requestTransformer.transformRequest(request);
        if (transformRequest != null) {
            return transformRequest;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request transformer ");
        stringBuilder.append(this.requestTransformer.getClass().getCanonicalName());
        stringBuilder.append(" returned null for ");
        stringBuilder.append(request);
        throw new IllegalStateException(stringBuilder.toString());
    }

    void defer(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.targetToDeferredRequestCreator.containsKey(imageView)) {
            cancelExistingRequest(imageView);
        }
        this.targetToDeferredRequestCreator.put(imageView, deferredRequestCreator);
    }

    void enqueueAndSubmit(Action action) {
        Object target = action.getTarget();
        if (!(target == null || this.targetToAction.get(target) == action)) {
            cancelExistingRequest(target);
            this.targetToAction.put(target, action);
        }
        submit(action);
    }

    void submit(Action action) {
        this.dispatcher.dispatchSubmit(action);
    }

    Bitmap quickMemoryCacheCheck(String str) {
        str = this.cache.get(str);
        if (str != null) {
            this.stats.dispatchCacheHit();
        } else {
            this.stats.dispatchCacheMiss();
        }
        return str;
    }

    void complete(BitmapHunter bitmapHunter) {
        Action action = bitmapHunter.getAction();
        List actions = bitmapHunter.getActions();
        int i = 1;
        int i2 = 0;
        int i3 = (actions == null || actions.isEmpty()) ? 0 : 1;
        if (action == null) {
            if (i3 == 0) {
                i = 0;
            }
        }
        if (i != 0) {
            Uri uri = bitmapHunter.getData().uri;
            Exception exception = bitmapHunter.getException();
            Bitmap result = bitmapHunter.getResult();
            bitmapHunter = bitmapHunter.getLoadedFrom();
            if (action != null) {
                deliverAction(result, bitmapHunter, action, exception);
            }
            if (i3 != 0) {
                int size = actions.size();
                while (i2 < size) {
                    deliverAction(result, bitmapHunter, (Action) actions.get(i2), exception);
                    i2++;
                }
            }
            if (!(this.listener == null || exception == null)) {
                this.listener.onImageLoadFailed(this, uri, exception);
            }
        }
    }

    void resumeAction(Action action) {
        Bitmap quickMemoryCacheCheck = MemoryPolicy.shouldReadFromMemoryCache(action.memoryPolicy) ? quickMemoryCacheCheck(action.getKey()) : null;
        if (quickMemoryCacheCheck != null) {
            deliverAction(quickMemoryCacheCheck, LoadedFrom.MEMORY, action, null);
            if (this.loggingEnabled) {
                action = action.request.logId();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("from ");
                stringBuilder.append(LoadedFrom.MEMORY);
                Utils.log("Main", "completed", action, stringBuilder.toString());
                return;
            }
            return;
        }
        enqueueAndSubmit(action);
        if (this.loggingEnabled) {
            Utils.log("Main", "resumed", action.request.logId());
        }
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedFrom, Action action, Exception exception) {
        if (!action.isCancelled()) {
            if (!action.willReplay()) {
                this.targetToAction.remove(action.getTarget());
            }
            if (bitmap == null) {
                action.error(exception);
                if (this.loggingEnabled != null) {
                    Utils.log("Main", "errored", action.request.logId(), exception.getMessage());
                }
            } else if (loadedFrom != null) {
                action.complete(bitmap, loadedFrom);
                if (this.loggingEnabled != null) {
                    action = action.request.logId();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("from ");
                    stringBuilder.append(loadedFrom);
                    Utils.log("Main", "completed", action, stringBuilder.toString());
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    void cancelExistingRequest(Object obj) {
        Utils.checkMain();
        Action action = (Action) this.targetToAction.remove(obj);
        if (action != null) {
            action.cancel();
            this.dispatcher.dispatchCancel(action);
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) this.targetToDeferredRequestCreator.remove((ImageView) obj);
            if (deferredRequestCreator != null) {
                deferredRequestCreator.cancel();
            }
        }
    }

    public static Picasso get() {
        if (singleton == null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    if (PicassoProvider.context != null) {
                        singleton = new Builder(PicassoProvider.context).build();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return singleton;
    }

    public static void setSingletonInstance(@NonNull Picasso picasso) {
        if (picasso != null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    singleton = picasso;
                } else {
                    throw new IllegalStateException("Singleton instance already exists.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Picasso must not be null.");
    }
}
