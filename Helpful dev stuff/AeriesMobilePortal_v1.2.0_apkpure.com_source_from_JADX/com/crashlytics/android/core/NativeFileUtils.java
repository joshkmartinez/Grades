package com.crashlytics.android.core;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class NativeFileUtils {
    private NativeFileUtils() {
    }

    static byte[] readFile(java.io.File r2) {
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
        r0 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0016, all -> 0x0011 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0016, all -> 0x0011 }
        r2 = readBytes(r1);	 Catch:{ FileNotFoundException -> 0x001c, IOException -> 0x0017, all -> 0x000e }
        io.fabric.sdk.android.services.common.CommonUtils.closeQuietly(r1);
        return r2;
    L_0x000e:
        r2 = move-exception;
        r0 = r1;
        goto L_0x0012;
    L_0x0011:
        r2 = move-exception;
    L_0x0012:
        io.fabric.sdk.android.services.common.CommonUtils.closeQuietly(r0);
        throw r2;
    L_0x0016:
        r1 = r0;
    L_0x0017:
        io.fabric.sdk.android.services.common.CommonUtils.closeQuietly(r1);
        return r0;
    L_0x001b:
        r1 = r0;
    L_0x001c:
        io.fabric.sdk.android.services.common.CommonUtils.closeQuietly(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.NativeFileUtils.readFile(java.io.File):byte[]");
    }

    private static byte[] readBytes(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static File filter(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    static byte[] minidumpFromDirectory(File file) {
        file = filter(file, ".dmp");
        return file == null ? new byte[null] : minidumpFromFile(file);
    }

    private static byte[] minidumpFromFile(File file) {
        return readFile(file);
    }

    static byte[] binaryImagesJsonFromDirectory(File file, Context context) throws IOException {
        file = filter(file, ".binary_libs");
        if (file == null) {
            return null;
        }
        return binaryImagesJsonFromFile(file, context);
    }

    private static byte[] binaryImagesJsonFromFile(File file, Context context) throws IOException {
        file = readFile(file);
        if (file != null) {
            if (file.length != 0) {
                return processBinaryImages(context, new String(file));
            }
        }
        return null;
    }

    static byte[] metadataJsonFromDirectory(File file) {
        file = filter(file, ".device_info");
        if (file == null) {
            return null;
        }
        return readFile(file);
    }

    private static byte[] processBinaryImages(Context context, String str) throws IOException {
        return new BinaryImagesConverter(context, new Sha1FileIdStrategy()).convert(str);
    }
}
