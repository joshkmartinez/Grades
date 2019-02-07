package com.getkeepsafe.relinker;

import com.getkeepsafe.relinker.ReLinker.LibraryInstaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ApkLibraryInstaller implements LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    public void installLibrary(android.content.Context r19, java.lang.String[] r20, java.lang.String r21, java.io.File r22, com.getkeepsafe.relinker.ReLinkerInstance r23) {
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
        r18 = this;
        r1 = r18;
        r0 = r20;
        r2 = r21;
        r3 = r22;
        r4 = r23;
        r5 = 0;
        r6 = r19.getApplicationInfo();	 Catch:{ all -> 0x0102 }
        r7 = 0;
        r8 = r7;
    L_0x0011:
        r9 = r8 + 1;
        r10 = 5;
        r11 = 1;
        if (r8 >= r10) goto L_0x0026;
    L_0x0017:
        r8 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0024 }
        r12 = new java.io.File;	 Catch:{ IOException -> 0x0024 }
        r13 = r6.sourceDir;	 Catch:{ IOException -> 0x0024 }
        r12.<init>(r13);	 Catch:{ IOException -> 0x0024 }
        r8.<init>(r12, r11);	 Catch:{ IOException -> 0x0024 }
        goto L_0x0027;
    L_0x0024:
        r8 = r9;
        goto L_0x0011;
    L_0x0026:
        r8 = r5;
    L_0x0027:
        if (r8 != 0) goto L_0x0037;
    L_0x0029:
        r0 = "FATAL! Couldn't find application APK!";	 Catch:{ all -> 0x0034 }
        r4.log(r0);	 Catch:{ all -> 0x0034 }
        if (r8 == 0) goto L_0x0033;
    L_0x0030:
        r8.close();	 Catch:{ IOException -> 0x0033 }
    L_0x0033:
        return;
    L_0x0034:
        r0 = move-exception;
        goto L_0x0104;
    L_0x0037:
        r6 = r7;
    L_0x0038:
        r9 = r6 + 1;
        if (r6 >= r10) goto L_0x00f7;
    L_0x003c:
        r6 = r0.length;	 Catch:{ all -> 0x0034 }
        r13 = r5;	 Catch:{ all -> 0x0034 }
        r14 = r13;	 Catch:{ all -> 0x0034 }
        r12 = r7;	 Catch:{ all -> 0x0034 }
    L_0x0040:
        if (r12 >= r6) goto L_0x006c;	 Catch:{ all -> 0x0034 }
    L_0x0042:
        r13 = r0[r12];	 Catch:{ all -> 0x0034 }
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r14.<init>();	 Catch:{ all -> 0x0034 }
        r15 = "lib";	 Catch:{ all -> 0x0034 }
        r14.append(r15);	 Catch:{ all -> 0x0034 }
        r15 = java.io.File.separatorChar;	 Catch:{ all -> 0x0034 }
        r14.append(r15);	 Catch:{ all -> 0x0034 }
        r14.append(r13);	 Catch:{ all -> 0x0034 }
        r13 = java.io.File.separatorChar;	 Catch:{ all -> 0x0034 }
        r14.append(r13);	 Catch:{ all -> 0x0034 }
        r14.append(r2);	 Catch:{ all -> 0x0034 }
        r13 = r14.toString();	 Catch:{ all -> 0x0034 }
        r14 = r8.getEntry(r13);	 Catch:{ all -> 0x0034 }
        if (r14 == 0) goto L_0x0069;	 Catch:{ all -> 0x0034 }
    L_0x0068:
        goto L_0x006c;	 Catch:{ all -> 0x0034 }
    L_0x0069:
        r12 = r12 + 1;	 Catch:{ all -> 0x0034 }
        goto L_0x0040;	 Catch:{ all -> 0x0034 }
    L_0x006c:
        if (r13 == 0) goto L_0x0077;	 Catch:{ all -> 0x0034 }
    L_0x006e:
        r6 = "Looking for %s in APK...";	 Catch:{ all -> 0x0034 }
        r12 = new java.lang.Object[r11];	 Catch:{ all -> 0x0034 }
        r12[r7] = r13;	 Catch:{ all -> 0x0034 }
        r4.log(r6, r12);	 Catch:{ all -> 0x0034 }
    L_0x0077:
        if (r14 != 0) goto L_0x0087;	 Catch:{ all -> 0x0034 }
    L_0x0079:
        if (r13 == 0) goto L_0x0081;	 Catch:{ all -> 0x0034 }
    L_0x007b:
        r0 = new com.getkeepsafe.relinker.MissingLibraryException;	 Catch:{ all -> 0x0034 }
        r0.<init>(r13);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0081:
        r0 = new com.getkeepsafe.relinker.MissingLibraryException;	 Catch:{ all -> 0x0034 }
        r0.<init>(r2);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0087:
        r6 = "Found %s! Extracting...";	 Catch:{ all -> 0x0034 }
        r12 = new java.lang.Object[r11];	 Catch:{ all -> 0x0034 }
        r12[r7] = r13;	 Catch:{ all -> 0x0034 }
        r4.log(r6, r12);	 Catch:{ all -> 0x0034 }
        r6 = r22.exists();	 Catch:{ IOException -> 0x00f4 }
        if (r6 != 0) goto L_0x009d;	 Catch:{ IOException -> 0x00f4 }
    L_0x0096:
        r6 = r22.createNewFile();	 Catch:{ IOException -> 0x00f4 }
        if (r6 != 0) goto L_0x009d;
    L_0x009c:
        goto L_0x00f4;
    L_0x009d:
        r6 = r8.getInputStream(r14);	 Catch:{ FileNotFoundException -> 0x00ee, IOException -> 0x00e8, all -> 0x00de }
        r12 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00dc, IOException -> 0x00da, all -> 0x00d7 }
        r12.<init>(r3);	 Catch:{ FileNotFoundException -> 0x00dc, IOException -> 0x00da, all -> 0x00d7 }
        r13 = r1.copy(r6, r12);	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00ea, all -> 0x00d5 }
        r15 = r12.getFD();	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00ea, all -> 0x00d5 }
        r15.sync();	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00ea, all -> 0x00d5 }
        r15 = r22.length();	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00ea, all -> 0x00d5 }
        r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));
        if (r17 == 0) goto L_0x00c0;
    L_0x00b9:
        r1.closeSilently(r6);	 Catch:{ all -> 0x0034 }
    L_0x00bc:
        r1.closeSilently(r12);	 Catch:{ all -> 0x0034 }
        goto L_0x00f4;	 Catch:{ all -> 0x0034 }
    L_0x00c0:
        r1.closeSilently(r6);	 Catch:{ all -> 0x0034 }
        r1.closeSilently(r12);	 Catch:{ all -> 0x0034 }
        r3.setReadable(r11, r7);	 Catch:{ all -> 0x0034 }
        r3.setExecutable(r11, r7);	 Catch:{ all -> 0x0034 }
        r3.setWritable(r11);	 Catch:{ all -> 0x0034 }
        if (r8 == 0) goto L_0x00d4;
    L_0x00d1:
        r8.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x00d4:
        return;
    L_0x00d5:
        r0 = move-exception;
        goto L_0x00e1;
    L_0x00d7:
        r0 = move-exception;
        r12 = r5;
        goto L_0x00e1;
    L_0x00da:
        r12 = r5;
        goto L_0x00ea;
    L_0x00dc:
        r12 = r5;
        goto L_0x00f0;
    L_0x00de:
        r0 = move-exception;
        r6 = r5;
        r12 = r6;
    L_0x00e1:
        r1.closeSilently(r6);	 Catch:{ all -> 0x0034 }
        r1.closeSilently(r12);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x00e8:
        r6 = r5;	 Catch:{ all -> 0x0034 }
        r12 = r6;	 Catch:{ all -> 0x0034 }
    L_0x00ea:
        r1.closeSilently(r6);	 Catch:{ all -> 0x0034 }
        goto L_0x00bc;	 Catch:{ all -> 0x0034 }
    L_0x00ee:
        r6 = r5;	 Catch:{ all -> 0x0034 }
        r12 = r6;	 Catch:{ all -> 0x0034 }
    L_0x00f0:
        r1.closeSilently(r6);	 Catch:{ all -> 0x0034 }
        goto L_0x00bc;	 Catch:{ all -> 0x0034 }
    L_0x00f4:
        r6 = r9;	 Catch:{ all -> 0x0034 }
        goto L_0x0038;	 Catch:{ all -> 0x0034 }
    L_0x00f7:
        r0 = "FATAL! Couldn't extract the library from the APK!";	 Catch:{ all -> 0x0034 }
        r4.log(r0);	 Catch:{ all -> 0x0034 }
        if (r8 == 0) goto L_0x0101;
    L_0x00fe:
        r8.close();	 Catch:{ IOException -> 0x0101 }
    L_0x0101:
        return;
    L_0x0102:
        r0 = move-exception;
        r8 = r5;
    L_0x0104:
        if (r8 == 0) goto L_0x0109;
    L_0x0106:
        r8.close();	 Catch:{ IOException -> 0x0109 }
    L_0x0109:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.ApkLibraryInstaller.installLibrary(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.getkeepsafe.relinker.ReLinkerInstance):void");
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    private void closeSilently(java.io.Closeable r1) {
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
        r0 = this;
        if (r1 == 0) goto L_0x0005;
    L_0x0002:
        r1.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.ApkLibraryInstaller.closeSilently(java.io.Closeable):void");
    }
}
