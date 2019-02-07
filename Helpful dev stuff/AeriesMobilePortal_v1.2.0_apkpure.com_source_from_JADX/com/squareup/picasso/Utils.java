package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;

final class Utils {
    private static final int KEY_PADDING = 50;
    static final char KEY_SEPARATOR = '\n';
    static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    static final String OWNER_DISPATCHER = "Dispatcher";
    static final String OWNER_HUNTER = "Hunter";
    static final String OWNER_MAIN = "Main";
    private static final String PICASSO_CACHE = "picasso-cache";
    static final String THREAD_IDLE_NAME = "Picasso-Idle";
    static final int THREAD_LEAK_CLEANING_MS = 1000;
    static final String THREAD_PREFIX = "Picasso-";
    static final String VERB_BATCHED = "batched";
    static final String VERB_CANCELED = "canceled";
    static final String VERB_CHANGED = "changed";
    static final String VERB_COMPLETED = "completed";
    static final String VERB_CREATED = "created";
    static final String VERB_DECODED = "decoded";
    static final String VERB_DELIVERED = "delivered";
    static final String VERB_ENQUEUED = "enqueued";
    static final String VERB_ERRORED = "errored";
    static final String VERB_EXECUTING = "executing";
    static final String VERB_IGNORED = "ignored";
    static final String VERB_JOINED = "joined";
    static final String VERB_PAUSED = "paused";
    static final String VERB_REMOVED = "removed";
    static final String VERB_REPLAYING = "replaying";
    static final String VERB_RESUMED = "resumed";
    static final String VERB_RETRYING = "retrying";
    static final String VERB_TRANSFORMED = "transformed";
    private static final ByteString WEBP_FILE_HEADER_RIFF = ByteString.encodeUtf8("RIFF");
    private static final ByteString WEBP_FILE_HEADER_WEBP = ByteString.encodeUtf8("WEBP");

    private static class PicassoThread extends Thread {
        PicassoThread(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class PicassoThreadFactory implements ThreadFactory {
        PicassoThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    private Utils() {
    }

    static int getBitmapBytes(Bitmap bitmap) {
        int allocationByteCount = VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(bitmap);
        throw new IllegalStateException(stringBuilder.toString());
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void checkNotMain() {
        if (isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void checkMain() {
        if (!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String getLogIdsForHunter(BitmapHunter bitmapHunter) {
        return getLogIdsForHunter(bitmapHunter, "");
    }

    static String getLogIdsForHunter(BitmapHunter bitmapHunter, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        str = bitmapHunter.getAction();
        if (str != null) {
            stringBuilder.append(str.request.logId());
        }
        bitmapHunter = bitmapHunter.getActions();
        if (bitmapHunter != null) {
            int size = bitmapHunter.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || str != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((Action) bitmapHunter.get(i)).request.logId());
            }
        }
        return stringBuilder.toString();
    }

    static void log(String str, String str2, String str3) {
        log(str, str2, str3, "");
    }

    static void log(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static String createKey(Request request) {
        request = createKey(request, MAIN_THREAD_KEY_BUILDER);
        MAIN_THREAD_KEY_BUILDER.setLength(0);
        return request;
    }

    static String createKey(Request request, StringBuilder stringBuilder) {
        if (request.stableKey != null) {
            stringBuilder.ensureCapacity(request.stableKey.length() + 50);
            stringBuilder.append(request.stableKey);
        } else if (request.uri != null) {
            String uri = request.uri.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(request.resourceId);
        }
        stringBuilder.append(KEY_SEPARATOR);
        if (request.rotationDegrees != 0.0f) {
            stringBuilder.append("rotation:");
            stringBuilder.append(request.rotationDegrees);
            if (request.hasRotationPivot) {
                stringBuilder.append('@');
                stringBuilder.append(request.rotationPivotX);
                stringBuilder.append('x');
                stringBuilder.append(request.rotationPivotY);
            }
            stringBuilder.append(KEY_SEPARATOR);
        }
        if (request.hasSize()) {
            stringBuilder.append("resize:");
            stringBuilder.append(request.targetWidth);
            stringBuilder.append('x');
            stringBuilder.append(request.targetHeight);
            stringBuilder.append(KEY_SEPARATOR);
        }
        if (request.centerCrop) {
            stringBuilder.append("centerCrop:");
            stringBuilder.append(request.centerCropGravity);
            stringBuilder.append(KEY_SEPARATOR);
        } else if (request.centerInside) {
            stringBuilder.append("centerInside");
            stringBuilder.append(KEY_SEPARATOR);
        }
        if (request.transformations != null) {
            int size = request.transformations.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((Transformation) request.transformations.get(i)).key());
                stringBuilder.append(KEY_SEPARATOR);
            }
        }
        return stringBuilder.toString();
    }

    static File createDefaultCacheDir(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    @android.annotation.TargetApi(18)
    static long calculateDiskCacheSize(java.io.File r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r2 = new android.os.StatFs;	 Catch:{ IllegalArgumentException -> 0x0030 }
        r6 = r6.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x0030 }
        r2.<init>(r6);	 Catch:{ IllegalArgumentException -> 0x0030 }
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalArgumentException -> 0x0030 }
        r3 = 18;	 Catch:{ IllegalArgumentException -> 0x0030 }
        if (r6 >= r3) goto L_0x0018;	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x0012:
        r6 = r2.getBlockCount();	 Catch:{ IllegalArgumentException -> 0x0030 }
        r4 = (long) r6;	 Catch:{ IllegalArgumentException -> 0x0030 }
        goto L_0x001c;	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x0018:
        r4 = r2.getBlockCountLong();	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x001c:
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalArgumentException -> 0x0030 }
        if (r6 >= r3) goto L_0x0026;	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x0020:
        r6 = r2.getBlockSize();	 Catch:{ IllegalArgumentException -> 0x0030 }
        r2 = (long) r6;	 Catch:{ IllegalArgumentException -> 0x0030 }
        goto L_0x002a;	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x0026:
        r2 = r2.getBlockSizeLong();	 Catch:{ IllegalArgumentException -> 0x0030 }
    L_0x002a:
        r4 = r4 * r2;	 Catch:{ IllegalArgumentException -> 0x0030 }
        r2 = 50;	 Catch:{ IllegalArgumentException -> 0x0030 }
        r2 = r4 / r2;	 Catch:{ IllegalArgumentException -> 0x0030 }
        goto L_0x0031;
    L_0x0030:
        r2 = r0;
    L_0x0031:
        r4 = 52428800; // 0x3200000 float:4.7019774E-37 double:2.5903269E-316;
        r2 = java.lang.Math.min(r2, r4);
        r0 = java.lang.Math.max(r2, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.calculateDiskCacheSize(java.io.File):long");
    }

    static int calculateMemoryCacheSize(Context context) {
        ActivityManager activityManager = (ActivityManager) getService(context, "activity");
        return (int) ((PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED * ((long) (((context.getApplicationInfo().flags & 1048576) != null ? true : null) != null ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()))) / 7);
    }

    static boolean isAirplaneModeOn(android.content.Context r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = r4.getContentResolver();
        r0 = 0;
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        r2 = 17;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        r3 = 1;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        if (r1 >= r2) goto L_0x0016;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
    L_0x000c:
        r1 = "airplane_mode_on";	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        r4 = android.provider.Settings.System.getInt(r4, r1, r0);	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        if (r4 == 0) goto L_0x0015;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
    L_0x0014:
        r0 = r3;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
    L_0x0015:
        return r0;	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
    L_0x0016:
        r1 = "airplane_mode_on";	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        r4 = android.provider.Settings.Global.getInt(r4, r1, r0);	 Catch:{ NullPointerException -> 0x0021, SecurityException -> 0x0020 }
        if (r4 == 0) goto L_0x001f;
    L_0x001e:
        r0 = r3;
    L_0x001f:
        return r0;
    L_0x0020:
        return r0;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.isAirplaneModeOn(android.content.Context):boolean");
    }

    static <T> T getService(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == null ? true : null;
    }

    static boolean isWebPFile(BufferedSource bufferedSource) throws IOException {
        return (!bufferedSource.rangeEquals(0, WEBP_FILE_HEADER_RIFF) || bufferedSource.rangeEquals(8, WEBP_FILE_HEADER_WEBP) == null) ? null : true;
    }

    static int getResourceId(android.content.res.Resources r6, com.squareup.picasso.Request r7) throws java.io.FileNotFoundException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r7.resourceId;
        if (r0 != 0) goto L_0x00af;
    L_0x0004:
        r0 = r7.uri;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00af;
    L_0x000a:
        r0 = r7.uri;
        r0 = r0.getAuthority();
        if (r0 == 0) goto L_0x0096;
    L_0x0012:
        r1 = r7.uri;
        r1 = r1.getPathSegments();
        if (r1 == 0) goto L_0x007d;
    L_0x001a:
        r2 = r1.isEmpty();
        if (r2 != 0) goto L_0x007d;
    L_0x0020:
        r2 = r1.size();
        r3 = 0;
        r4 = 1;
        if (r2 != r4) goto L_0x004c;
    L_0x0028:
        r6 = r1.get(r3);	 Catch:{ NumberFormatException -> 0x0033 }
        r6 = (java.lang.String) r6;	 Catch:{ NumberFormatException -> 0x0033 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x0033 }
        goto L_0x0063;
    L_0x0033:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Last path segment is not a resource ID: ";
        r0.append(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x004c:
        r2 = r1.size();
        r5 = 2;
        if (r2 != r5) goto L_0x0064;
    L_0x0053:
        r7 = r1.get(r3);
        r7 = (java.lang.String) r7;
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
        r6 = r6.getIdentifier(r1, r7, r0);
    L_0x0063:
        return r6;
    L_0x0064:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "More than two path segments: ";
        r0.append(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x007d:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No path segments: ";
        r0.append(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0096:
        r6 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No package provided: ";
        r0.append(r1);
        r7 = r7.uri;
        r0.append(r7);
        r7 = r0.toString();
        r6.<init>(r7);
        throw r6;
    L_0x00af:
        r6 = r7.resourceId;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.getResourceId(android.content.res.Resources, com.squareup.picasso.Request):int");
    }

    static android.content.res.Resources getResources(android.content.Context r2, com.squareup.picasso.Request r3) throws java.io.FileNotFoundException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r3.resourceId;
        if (r0 != 0) goto L_0x004c;
    L_0x0004:
        r0 = r3.uri;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x004c;
    L_0x0009:
        r0 = r3.uri;
        r0 = r0.getAuthority();
        if (r0 == 0) goto L_0x0033;
    L_0x0011:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001a }
        r2 = r2.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x001a }
        return r2;
    L_0x001a:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Unable to obtain resources for package: ";
        r0.append(r1);
        r3 = r3.uri;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0033:
        r2 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "No package provided: ";
        r0.append(r1);
        r3 = r3.uri;
        r0.append(r3);
        r3 = r0.toString();
        r2.<init>(r3);
        throw r2;
    L_0x004c:
        r2 = r2.getResources();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.getResources(android.content.Context, com.squareup.picasso.Request):android.content.res.Resources");
    }

    static void flushStackLocalLeaks(Looper looper) {
        Handler c04901 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        c04901.sendMessageDelayed(c04901.obtainMessage(), 1000);
    }
}
