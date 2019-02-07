package com.getkeepsafe.relinker;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker.LibraryInstaller;
import com.getkeepsafe.relinker.ReLinker.LibraryLoader;
import com.getkeepsafe.relinker.ReLinker.LoadListener;
import com.getkeepsafe.relinker.ReLinker.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance {
    private static final String LIB_DIR = "lib";
    protected boolean force;
    protected final LibraryInstaller libraryInstaller;
    protected final LibraryLoader libraryLoader;
    protected final Set<String> loadedLibraries;
    protected Logger logger;
    protected boolean recursive;

    protected ReLinkerInstance() {
        this(new SystemLibraryLoader(), new ApkLibraryInstaller());
    }

    protected ReLinkerInstance(LibraryLoader libraryLoader, LibraryInstaller libraryInstaller) {
        this.loadedLibraries = new HashSet();
        if (libraryLoader == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (libraryInstaller != null) {
            this.libraryLoader = libraryLoader;
            this.libraryInstaller = libraryInstaller;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }

    public ReLinkerInstance log(Logger logger) {
        this.logger = logger;
        return this;
    }

    public ReLinkerInstance force() {
        this.force = true;
        return this;
    }

    public ReLinkerInstance recursively() {
        this.recursive = true;
        return this;
    }

    public void loadLibrary(Context context, String str) {
        loadLibrary(context, str, null, null);
    }

    public void loadLibrary(Context context, String str, String str2) {
        loadLibrary(context, str, str2, null);
    }

    public void loadLibrary(Context context, String str, LoadListener loadListener) {
        loadLibrary(context, str, null, loadListener);
    }

    public void loadLibrary(Context context, String str, String str2, LoadListener loadListener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            log("Beginning load of %s...", str);
            if (loadListener == null) {
                loadLibraryInternal(context, str, str2);
                return;
            }
            final Context context2 = context;
            final String str3 = str;
            final String str4 = str2;
            final LoadListener loadListener2 = loadListener;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        ReLinkerInstance.this.loadLibraryInternal(context2, str3, str4);
                        loadListener2.success();
                    } catch (Throwable e) {
                        loadListener2.failure(e);
                    } catch (Throwable e2) {
                        loadListener2.failure(e2);
                    }
                }
            }).start();
        }
    }

    private void loadLibraryInternal(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
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
        r11 = this;
        r0 = r11.loadedLibraries;
        r0 = r0.contains(r13);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0018;
    L_0x000a:
        r0 = r11.force;
        if (r0 != 0) goto L_0x0018;
    L_0x000e:
        r12 = "%s already loaded previously!";
        r14 = new java.lang.Object[r2];
        r14[r1] = r13;
        r11.log(r12, r14);
        return;
    L_0x0018:
        r0 = 2;
        r3 = r11.libraryLoader;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3.loadLibrary(r13);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3 = r11.loadedLibraries;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3.add(r13);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3 = "%s (%s) was loaded normally!";	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4 = new java.lang.Object[r0];	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4[r1] = r13;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4[r2] = r14;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r11.log(r3, r4);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        return;
    L_0x002f:
        r3 = move-exception;
        r4 = "Loading the library normally failed: %s";
        r5 = new java.lang.Object[r2];
        r3 = android.util.Log.getStackTraceString(r3);
        r5[r1] = r3;
        r11.log(r4, r5);
        r3 = "%s (%s) was not loaded normally, re-linking...";
        r4 = new java.lang.Object[r0];
        r4[r1] = r13;
        r4[r2] = r14;
        r11.log(r3, r4);
        r3 = r11.getWorkaroundLibFile(r12, r13, r14);
        r4 = r3.exists();
        if (r4 == 0) goto L_0x0056;
    L_0x0052:
        r4 = r11.force;
        if (r4 == 0) goto L_0x007c;
    L_0x0056:
        r4 = r11.force;
        if (r4 == 0) goto L_0x0065;
    L_0x005a:
        r4 = "Forcing a re-link of %s (%s)...";
        r5 = new java.lang.Object[r0];
        r5[r1] = r13;
        r5[r2] = r14;
        r11.log(r4, r5);
    L_0x0065:
        r11.cleanupOldLibFiles(r12, r13, r14);
        r5 = r11.libraryInstaller;
        r4 = r11.libraryLoader;
        r7 = r4.supportedAbis();
        r4 = r11.libraryLoader;
        r8 = r4.mapLibraryName(r13);
        r6 = r12;
        r9 = r3;
        r10 = r11;
        r5.installLibrary(r6, r7, r8, r9, r10);
    L_0x007c:
        r4 = r11.recursive;	 Catch:{ IOException -> 0x00a3 }
        if (r4 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a3 }
    L_0x0080:
        r4 = new com.getkeepsafe.relinker.elf.ElfParser;	 Catch:{ IOException -> 0x00a3 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x00a3 }
        r4 = r4.parseNeededDependencies();	 Catch:{ IOException -> 0x00a3 }
        r4 = r4.iterator();	 Catch:{ IOException -> 0x00a3 }
    L_0x008d:
        r5 = r4.hasNext();	 Catch:{ IOException -> 0x00a3 }
        if (r5 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a3 }
    L_0x0093:
        r5 = r4.next();	 Catch:{ IOException -> 0x00a3 }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x00a3 }
        r6 = r11.libraryLoader;	 Catch:{ IOException -> 0x00a3 }
        r5 = r6.unmapLibraryName(r5);	 Catch:{ IOException -> 0x00a3 }
        r11.loadLibrary(r12, r5);	 Catch:{ IOException -> 0x00a3 }
        goto L_0x008d;
    L_0x00a3:
        r12 = r11.libraryLoader;
        r3 = r3.getAbsolutePath();
        r12.loadPath(r3);
        r12 = r11.loadedLibraries;
        r12.add(r13);
        r12 = "%s (%s) was re-linked!";
        r0 = new java.lang.Object[r0];
        r0[r1] = r13;
        r0[r2] = r14;
        r11.log(r12, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.ReLinkerInstance.loadLibraryInternal(android.content.Context, java.lang.String, java.lang.String):void");
    }

    protected File getWorkaroundLibDir(Context context) {
        return context.getDir(LIB_DIR, 0);
    }

    protected File getWorkaroundLibFile(Context context, String str, String str2) {
        str = this.libraryLoader.mapLibraryName(str);
        if (TextUtils.isEmpty(str2)) {
            return new File(getWorkaroundLibDir(context), str);
        }
        context = getWorkaroundLibDir(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        return new File(context, stringBuilder.toString());
    }

    protected void cleanupOldLibFiles(Context context, String str, String str2) {
        File workaroundLibDir = getWorkaroundLibDir(context);
        context = getWorkaroundLibFile(context, str, str2);
        str = this.libraryLoader.mapLibraryName(str);
        str = workaroundLibDir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith(str);
            }
        });
        if (str != null) {
            for (File file : str) {
                if (this.force || !file.getAbsolutePath().equals(context.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    public void log(String str, Object... objArr) {
        log(String.format(Locale.US, str, objArr));
    }

    public void log(String str) {
        if (this.logger != null) {
            this.logger.log(str);
        }
    }
}
