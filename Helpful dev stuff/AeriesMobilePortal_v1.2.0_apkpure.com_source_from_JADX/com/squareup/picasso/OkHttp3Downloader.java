package com.squareup.picasso;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

public final class OkHttp3Downloader implements Downloader {
    private final Cache cache;
    @VisibleForTesting
    final Factory client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttp3Downloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    public OkHttp3Downloader(File file, long j) {
        this(new Builder().cache(new Cache(file, j)).build());
        this.sharedClient = null;
    }

    public OkHttp3Downloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.client = okHttpClient;
        this.cache = okHttpClient.cache();
    }

    public OkHttp3Downloader(Factory factory) {
        this.sharedClient = true;
        this.client = factory;
        this.cache = null;
    }

    @NonNull
    public Response load(@NonNull Request request) throws IOException {
        return this.client.newCall(request).execute();
    }

    public void shutdown() {
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
        r1 = this;
        r0 = r1.sharedClient;
        if (r0 != 0) goto L_0x000d;
    L_0x0004:
        r0 = r1.cache;
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r0 = r1.cache;	 Catch:{ IOException -> 0x000d }
        r0.close();	 Catch:{ IOException -> 0x000d }
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.OkHttp3Downloader.shutdown():void");
    }
}
