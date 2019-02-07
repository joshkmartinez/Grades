package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Okio;
import okio.Source;

class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new C09202();
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new C04771();
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List<Action> actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifOrientation;
    Future<?> future;
    final String key;
    LoadedFrom loadedFrom;
    final int memoryPolicy;
    int networkPolicy;
    final Picasso picasso;
    Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    final Stats stats;

    static class C04771 extends ThreadLocal<StringBuilder> {
        C04771() {
        }

        protected StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    static class C09202 extends RequestHandler {
        public boolean canHandleRequest(Request request) {
            return true;
        }

        C09202() {
        }

        public Result load(Request request, int i) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized type of request: ");
            stringBuilder.append(request);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    static int getExifRotation(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    static int getExifTranslation(int i) {
        if (!(i == 2 || i == 7)) {
            switch (i) {
                case 4:
                case 5:
                    break;
                default:
                    return 1;
            }
        }
        return -1;
    }

    private static boolean shouldResize(boolean z, int i, int i2, int i3, int i4) {
        if (z && (i3 == 0 || i <= i3)) {
            if (i4 == 0 || i2 <= i4) {
                return false;
            }
        }
        return true;
    }

    BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.picasso = picasso;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.stats = stats;
        this.action = action;
        this.key = action.getKey();
        this.data = action.getRequest();
        this.priority = action.getPriority();
        this.memoryPolicy = action.getMemoryPolicy();
        this.networkPolicy = action.getNetworkPolicy();
        this.requestHandler = requestHandler;
        this.retryCount = requestHandler.getRetryCount();
    }

    static Bitmap decodeStream(Source source, Request request) throws IOException {
        source = Okio.buffer(source);
        boolean isWebPFile = Utils.isWebPFile(source);
        boolean z = request.purgeable && VERSION.SDK_INT < 21;
        Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        boolean requiresInSampleSize = RequestHandler.requiresInSampleSize(createBitmapOptions);
        if (!isWebPFile) {
            if (!z) {
                source = source.inputStream();
                if (requiresInSampleSize) {
                    InputStream markableInputStream = new MarkableInputStream(source);
                    markableInputStream.allowMarksToExpire(false);
                    long savePosition = markableInputStream.savePosition(1024);
                    BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
                    RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
                    markableInputStream.reset(savePosition);
                    markableInputStream.allowMarksToExpire(true);
                    source = markableInputStream;
                }
                source = BitmapFactory.decodeStream(source, null, createBitmapOptions);
                if (source != null) {
                    return source;
                }
                throw new IOException("Failed to decode stream.");
            }
        }
        source = source.readByteArray();
        if (requiresInSampleSize) {
            BitmapFactory.decodeByteArray(source, 0, source.length, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
        }
        return BitmapFactory.decodeByteArray(source, 0, source.length, createBitmapOptions);
    }

    public void run() {
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
            }
            this.result = hunt();
            if (this.result == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (Exception e) {
            if (!(NetworkPolicy.isOfflineOnly(e.networkPolicy) && e.code == 504)) {
                this.exception = e;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e2) {
            this.exception = e2;
            this.dispatcher.dispatchRetry(this);
        } catch (Throwable e3) {
            Writer stringWriter = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(stringWriter));
            this.exception = new RuntimeException(stringWriter.toString(), e3);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e22) {
            this.exception = e22;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    android.graphics.Bitmap hunt() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = r6.memoryPolicy;
        r0 = com.squareup.picasso.MemoryPolicy.shouldReadFromMemoryCache(r0);
        if (r0 == 0) goto L_0x0031;
    L_0x0008:
        r0 = r6.cache;
        r1 = r6.key;
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x0032;
    L_0x0012:
        r1 = r6.stats;
        r1.dispatchCacheHit();
        r1 = com.squareup.picasso.Picasso.LoadedFrom.MEMORY;
        r6.loadedFrom = r1;
        r1 = r6.picasso;
        r1 = r1.loggingEnabled;
        if (r1 == 0) goto L_0x0030;
    L_0x0021:
        r1 = "Hunter";
        r2 = "decoded";
        r3 = r6.data;
        r3 = r3.logId();
        r4 = "from cache";
        com.squareup.picasso.Utils.log(r1, r2, r3, r4);
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = 0;
    L_0x0032:
        r1 = r6.retryCount;
        if (r1 != 0) goto L_0x003b;
    L_0x0036:
        r1 = com.squareup.picasso.NetworkPolicy.OFFLINE;
        r1 = r1.index;
        goto L_0x003d;
    L_0x003b:
        r1 = r6.networkPolicy;
    L_0x003d:
        r6.networkPolicy = r1;
        r1 = r6.requestHandler;
        r2 = r6.data;
        r3 = r6.networkPolicy;
        r1 = r1.load(r2, r3);
        if (r1 == 0) goto L_0x0071;
    L_0x004b:
        r0 = r1.getLoadedFrom();
        r6.loadedFrom = r0;
        r0 = r1.getExifOrientation();
        r6.exifOrientation = r0;
        r0 = r1.getBitmap();
        if (r0 != 0) goto L_0x0071;
    L_0x005d:
        r0 = r1.getSource();
        r1 = r6.data;	 Catch:{ all -> 0x006c }
        r1 = decodeStream(r0, r1);	 Catch:{ all -> 0x006c }
        r0.close();	 Catch:{ IOException -> 0x006a }
    L_0x006a:
        r0 = r1;
        goto L_0x0071;
    L_0x006c:
        r1 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0070:
        throw r1;
    L_0x0071:
        if (r0 == 0) goto L_0x00f2;
    L_0x0073:
        r1 = r6.picasso;
        r1 = r1.loggingEnabled;
        if (r1 == 0) goto L_0x0086;
    L_0x0079:
        r1 = "Hunter";
        r2 = "decoded";
        r3 = r6.data;
        r3 = r3.logId();
        com.squareup.picasso.Utils.log(r1, r2, r3);
    L_0x0086:
        r1 = r6.stats;
        r1.dispatchBitmapDecoded(r0);
        r1 = r6.data;
        r1 = r1.needsTransformation();
        if (r1 != 0) goto L_0x0097;
    L_0x0093:
        r1 = r6.exifOrientation;
        if (r1 == 0) goto L_0x00f2;
    L_0x0097:
        r1 = DECODE_LOCK;
        monitor-enter(r1);
        r2 = r6.data;	 Catch:{ all -> 0x00ef }
        r2 = r2.needsMatrixTransform();	 Catch:{ all -> 0x00ef }
        if (r2 != 0) goto L_0x00a6;	 Catch:{ all -> 0x00ef }
    L_0x00a2:
        r2 = r6.exifOrientation;	 Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00c1;	 Catch:{ all -> 0x00ef }
    L_0x00a6:
        r2 = r6.data;	 Catch:{ all -> 0x00ef }
        r3 = r6.exifOrientation;	 Catch:{ all -> 0x00ef }
        r0 = transformResult(r2, r0, r3);	 Catch:{ all -> 0x00ef }
        r2 = r6.picasso;	 Catch:{ all -> 0x00ef }
        r2 = r2.loggingEnabled;	 Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00c1;	 Catch:{ all -> 0x00ef }
    L_0x00b4:
        r2 = "Hunter";	 Catch:{ all -> 0x00ef }
        r3 = "transformed";	 Catch:{ all -> 0x00ef }
        r4 = r6.data;	 Catch:{ all -> 0x00ef }
        r4 = r4.logId();	 Catch:{ all -> 0x00ef }
        com.squareup.picasso.Utils.log(r2, r3, r4);	 Catch:{ all -> 0x00ef }
    L_0x00c1:
        r2 = r6.data;	 Catch:{ all -> 0x00ef }
        r2 = r2.hasCustomTransformations();	 Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00e6;	 Catch:{ all -> 0x00ef }
    L_0x00c9:
        r2 = r6.data;	 Catch:{ all -> 0x00ef }
        r2 = r2.transformations;	 Catch:{ all -> 0x00ef }
        r0 = applyCustomTransformations(r2, r0);	 Catch:{ all -> 0x00ef }
        r2 = r6.picasso;	 Catch:{ all -> 0x00ef }
        r2 = r2.loggingEnabled;	 Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00e6;	 Catch:{ all -> 0x00ef }
    L_0x00d7:
        r2 = "Hunter";	 Catch:{ all -> 0x00ef }
        r3 = "transformed";	 Catch:{ all -> 0x00ef }
        r4 = r6.data;	 Catch:{ all -> 0x00ef }
        r4 = r4.logId();	 Catch:{ all -> 0x00ef }
        r5 = "from custom transformations";	 Catch:{ all -> 0x00ef }
        com.squareup.picasso.Utils.log(r2, r3, r4, r5);	 Catch:{ all -> 0x00ef }
    L_0x00e6:
        monitor-exit(r1);	 Catch:{ all -> 0x00ef }
        if (r0 == 0) goto L_0x00f2;
    L_0x00e9:
        r1 = r6.stats;
        r1.dispatchBitmapTransformed(r0);
        goto L_0x00f2;
    L_0x00ef:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00ef }
        throw r0;
    L_0x00f2:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.hunt():android.graphics.Bitmap");
    }

    void attach(Action action) {
        boolean z = this.picasso.loggingEnabled;
        Request request = action.request;
        if (this.action == null) {
            this.action = action;
            if (z) {
                if (this.actions != null) {
                    if (this.actions.isEmpty() == null) {
                        Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
                    }
                }
                Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
            }
            return;
        }
        if (this.actions == null) {
            this.actions = new ArrayList(3);
        }
        this.actions.add(action);
        if (z) {
            Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
        }
        action = action.getPriority();
        if (action.ordinal() > this.priority.ordinal()) {
            this.priority = action;
        }
    }

    void detach(Action action) {
        boolean z;
        if (this.action == action) {
            this.action = null;
            z = true;
        } else {
            z = this.actions != null ? this.actions.remove(action) : false;
        }
        if (z && action.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "removed", action.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    private Priority computeNewPriority() {
        Priority priority = Priority.LOW;
        int i = 1;
        int i2 = 0;
        int i3 = (this.actions == null || this.actions.isEmpty()) ? 0 : 1;
        if (this.action == null) {
            if (i3 == 0) {
                i = 0;
            }
        }
        if (i == 0) {
            return priority;
        }
        if (this.action != null) {
            priority = this.action.getPriority();
        }
        if (i3 != 0) {
            i3 = this.actions.size();
            while (i2 < i3) {
                Priority priority2 = ((Action) this.actions.get(i2)).getPriority();
                if (priority2.ordinal() > priority.ordinal()) {
                    priority = priority2;
                }
                i2++;
            }
        }
        return priority;
    }

    boolean cancel() {
        if (this.action != null) {
            return false;
        }
        if ((this.actions == null || this.actions.isEmpty()) && this.future != null && this.future.cancel(false)) {
            return true;
        }
        return false;
    }

    boolean isCancelled() {
        return this.future != null && this.future.isCancelled();
    }

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        if ((this.retryCount > 0 ? 1 : false) == 0) {
            return false;
        }
        this.retryCount--;
        return this.requestHandler.shouldRetry(z, networkInfo);
    }

    boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }

    Bitmap getResult() {
        return this.result;
    }

    String getKey() {
        return this.key;
    }

    int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    Request getData() {
        return this.data;
    }

    Action getAction() {
        return this.action;
    }

    Picasso getPicasso() {
        return this.picasso;
    }

    List<Action> getActions() {
        return this.actions;
    }

    Exception getException() {
        return this.exception;
    }

    LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    Priority getPriority() {
        return this.priority;
    }

    static void updateThreadName(Request request) {
        request = request.getName();
        StringBuilder stringBuilder = (StringBuilder) NAME_BUILDER.get();
        stringBuilder.ensureCapacity("Picasso-".length() + request.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), request);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    static BitmapHunter forRequest(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        Request request = action.getRequest();
        List requestHandlers = picasso.getRequestHandlers();
        int size = requestHandlers.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler = (RequestHandler) requestHandlers.get(i);
            if (requestHandler.canHandleRequest(request)) {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
            }
        }
        return new BitmapHunter(picasso, dispatcher, cache, stats, action, ERRORING_HANDLER);
    }

    static Bitmap applyCustomTransformations(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final Transformation transformation = (Transformation) list.get(i);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    bitmap = new StringBuilder();
                    bitmap.append("Transformation ");
                    bitmap.append(transformation.key());
                    bitmap.append(" returned null after ");
                    bitmap.append(i);
                    bitmap.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation key : list) {
                        bitmap.append(key.key());
                        bitmap.append('\n');
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(bitmap.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(transformation.key());
                            stringBuilder.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled() != null) {
                    i++;
                    bitmap = transform;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(transformation.key());
                            stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                }
            } catch (final List<Transformation> list2) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Transformation ");
                        stringBuilder.append(transformation.key());
                        stringBuilder.append(" crashed with exception.");
                        throw new RuntimeException(stringBuilder.toString(), list2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    static Bitmap transformResult(Request request, Bitmap bitmap, int i) {
        int i2;
        Bitmap createBitmap;
        Bitmap bitmap2;
        int i3;
        boolean z;
        int i4;
        Request request2 = request;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z2 = request2.onlyScaleDown;
        Matrix matrix = new Matrix();
        if (!request.needsMatrixTransform()) {
            if (i == 0) {
                int i5 = height;
                Matrix matrix2 = matrix;
                height = width;
                int i6 = height;
                int i7 = i5;
                int i8 = 0;
                i2 = 0;
                createBitmap = Bitmap.createBitmap(bitmap, i8, i2, i6, i7, matrix2, true);
                bitmap2 = bitmap;
                if (createBitmap != bitmap2) {
                    return bitmap2;
                }
                bitmap.recycle();
                return createBitmap;
            }
        }
        int i9 = request2.targetWidth;
        i2 = request2.targetHeight;
        float f = request2.rotationDegrees;
        if (f != 0.0f) {
            double d = (double) f;
            double cos = Math.cos(Math.toRadians(d));
            d = Math.sin(Math.toRadians(d));
            if (request2.hasRotationPivot) {
                matrix.setRotate(f, request2.rotationPivotX, request2.rotationPivotY);
                double d2 = 1.0d - cos;
                double d3 = (((double) request2.rotationPivotX) * d2) + (((double) request2.rotationPivotY) * d);
                i3 = height;
                z = z2;
                double d4 = (((double) request2.rotationPivotY) * d2) - (((double) request2.rotationPivotX) * d);
                double d5 = (((double) request2.targetWidth) * cos) + d3;
                i4 = width;
                Matrix matrix3 = matrix;
                double d6 = (((double) request2.targetWidth) * d) + d4;
                double d7 = ((((double) request2.targetWidth) * cos) + d3) - (((double) request2.targetHeight) * d);
                double d8 = ((((double) request2.targetWidth) * d) + d4) + (((double) request2.targetHeight) * cos);
                double d9 = d3 - (((double) request2.targetHeight) * d);
                double d10 = (((double) request2.targetHeight) * cos) + d4;
                d = d7;
                cos = Math.max(d9, Math.max(d, Math.max(d3, d5)));
                d5 = Math.min(d9, Math.min(d, Math.min(d3, d5)));
                d3 = d6;
                d = d10;
                d9 = Math.max(d, Math.max(d8, Math.max(d4, d3)));
                d8 = Math.min(d, Math.min(d8, Math.min(d4, d3)));
                i9 = (int) Math.floor(cos - d5);
                i2 = (int) Math.floor(d9 - d8);
                matrix2 = matrix3;
            } else {
                i4 = width;
                i3 = height;
                z = z2;
                matrix2 = matrix;
                matrix2.setRotate(f);
                double d11 = ((double) request2.targetWidth) * cos;
                double d12 = (((double) request2.targetWidth) * cos) - (((double) request2.targetHeight) * d);
                double d13 = ((double) request2.targetWidth) * d;
                double d14 = (((double) request2.targetWidth) * d) + (((double) request2.targetHeight) * cos);
                double d15 = -(((double) request2.targetHeight) * d);
                double d16 = ((double) request2.targetHeight) * cos;
                double max = Math.max(d15, Math.max(d12, Math.max(0.0d, d11)));
                d11 = Math.min(d15, Math.min(d12, Math.min(0.0d, d11)));
                d15 = d13;
                i2 = (int) Math.floor(Math.max(d16, Math.max(d14, Math.max(0.0d, d15))) - Math.min(d16, Math.min(d14, Math.min(0.0d, d15))));
                i9 = (int) Math.floor(max - d11);
            }
        } else {
            i4 = width;
            i3 = height;
            z = z2;
            matrix2 = matrix;
        }
        if (i != 0) {
            height = getExifRotation(i);
            width = getExifTranslation(i);
            if (height != 0) {
                matrix2.preRotate((float) height);
                if (height == 90 || height == 270) {
                    int i10 = i2;
                    i2 = i9;
                    i9 = i10;
                }
            }
            if (width != 1) {
                matrix2.postScale((float) width, 1.0f);
            }
        }
        float f2;
        boolean z3;
        if (request2.centerCrop) {
            float f3;
            int i11;
            int i12;
            int i13;
            if (i9 != 0) {
                height = i4;
                f3 = ((float) i9) / ((float) height);
                i5 = i3;
            } else {
                height = i4;
                i5 = i3;
                f3 = ((float) i2) / ((float) i5);
            }
            if (i2 != 0) {
                f2 = (float) i2;
                f = (float) i5;
            } else {
                f2 = (float) i9;
                f = (float) height;
            }
            f2 /= f;
            if (f3 > f2) {
                i8 = (int) Math.ceil((double) (((float) i5) * (f2 / f3)));
                if ((request2.centerCropGravity & 48) == 48) {
                    i11 = 0;
                } else if ((request2.centerCropGravity & 80) == 80) {
                    i11 = i5 - i8;
                } else {
                    i11 = (i5 - i8) / 2;
                }
                f = ((float) i2) / ((float) i8);
                i7 = height;
                i12 = i8;
                i13 = 0;
                f2 = f3;
                z3 = z;
            } else if (f3 < f2) {
                width = (int) Math.ceil((double) (((float) height) * (f3 / f2)));
                if ((request2.centerCropGravity & 3) == 3) {
                    i11 = 0;
                } else if ((request2.centerCropGravity & 5) == 5) {
                    i11 = height - width;
                } else {
                    i11 = (height - width) / 2;
                }
                f = ((float) i9) / ((float) width);
                i13 = i11;
                i7 = width;
                i12 = i5;
                z3 = z;
                i11 = 0;
                float f4 = f;
                f = f2;
                f2 = f4;
            } else {
                i7 = height;
                i12 = i5;
                f = f2;
                z3 = z;
                i11 = 0;
                i13 = 0;
            }
            if (shouldResize(z3, height, i5, i9, i2)) {
                matrix2.preScale(f2, f);
            }
            i2 = i11;
            i6 = i7;
            i7 = i12;
            i8 = i13;
            createBitmap = Bitmap.createBitmap(bitmap, i8, i2, i6, i7, matrix2, true);
            bitmap2 = bitmap;
            if (createBitmap != bitmap2) {
                return bitmap2;
            }
            bitmap.recycle();
            return createBitmap;
        }
        i5 = i3;
        z3 = z;
        height = i4;
        float f5;
        if (request2.centerInside) {
            if (i9 != 0) {
                f5 = (float) i9;
                f2 = (float) height;
            } else {
                f5 = (float) i2;
                f2 = (float) i5;
            }
            f5 /= f2;
            if (i2 != 0) {
                f2 = (float) i2;
                f = (float) i5;
            } else {
                f2 = (float) i9;
                f = (float) height;
            }
            f2 /= f;
            if (f5 >= f2) {
                f5 = f2;
            }
            if (shouldResize(z3, height, i5, i9, i2)) {
                matrix2.preScale(f5, f5);
            }
        } else if (!((i9 == 0 && i2 == 0) || (i9 == height && i2 == i5))) {
            if (i9 != 0) {
                f5 = (float) i9;
                f2 = (float) height;
            } else {
                f5 = (float) i2;
                f2 = (float) i5;
            }
            f5 /= f2;
            if (i2 != 0) {
                f2 = (float) i2;
                f = (float) i5;
            } else {
                f2 = (float) i9;
                f = (float) height;
            }
            f2 /= f;
            if (shouldResize(z3, height, i5, i9, i2)) {
                matrix2.preScale(f5, f2);
            }
        }
        int i62 = height;
        int i72 = i5;
        int i82 = 0;
        i2 = 0;
        createBitmap = Bitmap.createBitmap(bitmap, i82, i2, i62, i72, matrix2, true);
        bitmap2 = bitmap;
        if (createBitmap != bitmap2) {
            return bitmap2;
        }
        bitmap.recycle();
        return createBitmap;
    }
}
