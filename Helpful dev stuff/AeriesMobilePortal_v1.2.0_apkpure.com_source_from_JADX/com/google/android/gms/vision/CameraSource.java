package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private final Object zzd;
    @GuardedBy("mCameraLock")
    private Camera zze;
    private int zzf;
    private int zzg;
    private Size zzh;
    private float zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private SurfaceTexture zzm;
    private boolean zzn;
    private Thread zzo;
    private zzb zzp;
    private Map<byte[], ByteBuffer> zzq;

    public static class Builder {
        private final Detector<?> zzr;
        private CameraSource zzs = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector != null) {
                this.zzr = detector;
                this.zzs.mContext = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzs;
            CameraSource cameraSource2 = this.zzs;
            cameraSource2.getClass();
            cameraSource.zzp = new zzb(cameraSource2, this.zzr);
            return this.zzs;
        }

        public Builder setAutoFocusEnabled(boolean z) {
            this.zzs.zzl = z;
            return this;
        }

        public Builder setFacing(int i) {
            if (i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder(27);
                    stringBuilder.append("Invalid camera: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.zzs.zzf = i;
            return this;
        }

        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                this.zzs.zzi = f;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Invalid fps: ");
            stringBuilder.append(f);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Invalid preview size: ");
                stringBuilder.append(i);
                stringBuilder.append("x");
                stringBuilder.append(i2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.zzs.zzj = i;
            this.zzs.zzk = i2;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements PreviewCallback {
        private final /* synthetic */ CameraSource zzt;

        private zza(CameraSource cameraSource) {
            this.zzt = cameraSource;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            this.zzt.zzp.zza(bArr, camera);
        }
    }

    private class zzb implements Runnable {
        private boolean mActive = true;
        private final Object mLock = new Object();
        private Detector<?> zzr;
        private final /* synthetic */ CameraSource zzt;
        private long zzu = SystemClock.elapsedRealtime();
        private long zzv;
        private int zzw = 0;
        private ByteBuffer zzx;

        zzb(CameraSource cameraSource, Detector<?> detector) {
            this.zzt = cameraSource;
            this.zzr = detector;
        }

        @SuppressLint({"Assert"})
        final void release() {
            this.zzr.release();
            this.zzr = null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.annotation.SuppressLint({"InlinedApi"})
        public final void run() {
            /*
            r6 = this;
        L_0x0000:
            r0 = r6.mLock;
            monitor-enter(r0);
        L_0x0003:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x001b;
        L_0x0007:
            r1 = r6.zzx;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x001b;
        L_0x000b:
            r1 = r6.mLock;	 Catch:{ InterruptedException -> 0x0011 }
            r1.wait();	 Catch:{ InterruptedException -> 0x0011 }
            goto L_0x0003;
        L_0x0011:
            r1 = move-exception;
            r2 = "CameraSource";
            r3 = "Frame processing loop terminated.";
            android.util.Log.d(r2, r3, r1);	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x001b:
            r1 = r6.mActive;	 Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            return;
        L_0x0021:
            r1 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x008e }
            r1.<init>();	 Catch:{ all -> 0x008e }
            r2 = r6.zzx;	 Catch:{ all -> 0x008e }
            r3 = r6.zzt;	 Catch:{ all -> 0x008e }
            r3 = r3.zzh;	 Catch:{ all -> 0x008e }
            r3 = r3.getWidth();	 Catch:{ all -> 0x008e }
            r4 = r6.zzt;	 Catch:{ all -> 0x008e }
            r4 = r4.zzh;	 Catch:{ all -> 0x008e }
            r4 = r4.getHeight();	 Catch:{ all -> 0x008e }
            r5 = 17;
            r1 = r1.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x008e }
            r2 = r6.zzw;	 Catch:{ all -> 0x008e }
            r1 = r1.setId(r2);	 Catch:{ all -> 0x008e }
            r2 = r6.zzv;	 Catch:{ all -> 0x008e }
            r1 = r1.setTimestampMillis(r2);	 Catch:{ all -> 0x008e }
            r2 = r6.zzt;	 Catch:{ all -> 0x008e }
            r2 = r2.zzg;	 Catch:{ all -> 0x008e }
            r1 = r1.setRotation(r2);	 Catch:{ all -> 0x008e }
            r1 = r1.build();	 Catch:{ all -> 0x008e }
            r2 = r6.zzx;	 Catch:{ all -> 0x008e }
            r3 = 0;
            r6.zzx = r3;	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            r0 = r6.zzr;	 Catch:{ Throwable -> 0x0077 }
            r0.receiveFrame(r1);	 Catch:{ Throwable -> 0x0077 }
        L_0x0067:
            r0 = r6.zzt;
            r0 = r0.zze;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0075:
            r0 = move-exception;
            goto L_0x0080;
        L_0x0077:
            r0 = move-exception;
            r1 = "CameraSource";
            r3 = "Exception thrown from receiver.";
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x0075 }
            goto L_0x0067;
        L_0x0080:
            r1 = r6.zzt;
            r1 = r1.zze;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
        L_0x008e:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        final void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        final void zza(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                if (this.zzx != null) {
                    camera.addCallbackBuffer(this.zzx.array());
                    this.zzx = null;
                }
                if (this.zzt.zzq.containsKey(bArr)) {
                    this.zzv = SystemClock.elapsedRealtime() - this.zzu;
                    this.zzw++;
                    this.zzx = (ByteBuffer) this.zzt.zzq.get(bArr);
                    this.mLock.notifyAll();
                    return;
                }
                Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
            }
        }
    }

    private class zzc implements android.hardware.Camera.PictureCallback {
        private final /* synthetic */ CameraSource zzt;
        private PictureCallback zzy;

        private zzc(CameraSource cameraSource) {
            this.zzt = cameraSource;
        }

        public final void onPictureTaken(byte[] bArr, Camera camera) {
            if (this.zzy != null) {
                this.zzy.onPictureTaken(bArr);
            }
            synchronized (this.zzt.zzd) {
                if (this.zzt.zze != null) {
                    this.zzt.zze.startPreview();
                }
            }
        }
    }

    private static class zzd implements android.hardware.Camera.ShutterCallback {
        private ShutterCallback zzz;

        private zzd() {
        }

        public final void onShutter() {
            if (this.zzz != null) {
                this.zzz.onShutter();
            }
        }
    }

    @VisibleForTesting
    static class zze {
        private Size zzaa;
        private Size zzab;

        public zze(Camera.Size size, @Nullable Camera.Size size2) {
            this.zzaa = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzab = new Size(size2.width, size2.height);
            }
        }

        public final Size zzb() {
            return this.zzaa;
        }

        @Nullable
        public final Size zzc() {
            return this.zzab;
        }
    }

    private CameraSource() {
        this.zzd = new Object();
        this.zzf = 0;
        this.zzi = 30.0f;
        this.zzj = 1024;
        this.zzk = 768;
        this.zzl = false;
        this.zzq = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private final Camera zza() throws IOException {
        int i = this.zzf;
        CameraInfo cameraInfo = new CameraInfo();
        int i2 = 0;
        int i3 = 0;
        while (i3 < Camera.getNumberOfCameras()) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i) {
                break;
            }
            i3++;
        }
        i3 = -1;
        if (i3 != -1) {
            Camera open = Camera.open(i3);
            int i4 = this.zzj;
            int i5 = this.zzk;
            Parameters parameters = open.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            List arrayList = new ArrayList();
            for (Camera.Size size : supportedPreviewSizes) {
                float f = ((float) size.width) / ((float) size.height);
                for (Camera.Size size2 : supportedPictureSizes) {
                    if (Math.abs(f - (((float) size2.width) / ((float) size2.height))) < 0.01f) {
                        arrayList.add(new zze(size, size2));
                        break;
                    }
                }
            }
            if (arrayList.size() == 0) {
                Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
                for (Camera.Size com_google_android_gms_vision_CameraSource_zze : supportedPreviewSizes) {
                    arrayList.add(new zze(com_google_android_gms_vision_CameraSource_zze, null));
                }
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size3 = arrayList2.size();
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            int i8 = Integer.MAX_VALUE;
            zze com_google_android_gms_vision_CameraSource_zze2 = null;
            while (i7 < size3) {
                Object obj = arrayList2.get(i7);
                i7++;
                zze com_google_android_gms_vision_CameraSource_zze3 = (zze) obj;
                Size zzb = com_google_android_gms_vision_CameraSource_zze3.zzb();
                int abs = Math.abs(zzb.getWidth() - i4) + Math.abs(zzb.getHeight() - i5);
                if (abs < i8) {
                    com_google_android_gms_vision_CameraSource_zze2 = com_google_android_gms_vision_CameraSource_zze3;
                    i8 = abs;
                }
            }
            if (com_google_android_gms_vision_CameraSource_zze2 != null) {
                Size zzc = com_google_android_gms_vision_CameraSource_zze2.zzc();
                this.zzh = com_google_android_gms_vision_CameraSource_zze2.zzb();
                i5 = (int) (this.zzi * 1000.0f);
                int[] iArr = null;
                for (int[] iArr2 : open.getParameters().getSupportedPreviewFpsRange()) {
                    int abs2 = Math.abs(i5 - iArr2[0]) + Math.abs(i5 - iArr2[1]);
                    if (abs2 < i6) {
                        iArr = iArr2;
                        i6 = abs2;
                    }
                }
                if (iArr != null) {
                    Parameters parameters2 = open.getParameters();
                    if (zzc != null) {
                        parameters2.setPictureSize(zzc.getWidth(), zzc.getHeight());
                    }
                    parameters2.setPreviewSize(this.zzh.getWidth(), this.zzh.getHeight());
                    parameters2.setPreviewFpsRange(iArr[0], iArr[1]);
                    parameters2.setPreviewFormat(17);
                    i4 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
                    switch (i4) {
                        case 0:
                            break;
                        case 1:
                            i2 = 90;
                            break;
                        case 2:
                            i2 = 180;
                            break;
                        case 3:
                            i2 = 270;
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(31);
                            stringBuilder.append("Bad rotation value: ");
                            stringBuilder.append(i4);
                            Log.e("CameraSource", stringBuilder.toString());
                            break;
                    }
                    cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        i4 = (cameraInfo.orientation + i2) % 360;
                        i2 = (360 - i4) % 360;
                    } else {
                        i4 = ((cameraInfo.orientation - i2) + 360) % 360;
                        i2 = i4;
                    }
                    this.zzg = i4 / 90;
                    open.setDisplayOrientation(i2);
                    parameters2.setRotation(i4);
                    if (this.zzl) {
                        if (parameters2.getSupportedFocusModes().contains("continuous-video")) {
                            parameters2.setFocusMode("continuous-video");
                        } else {
                            Log.i("CameraSource", "Camera auto focus is not supported on this device.");
                        }
                    }
                    open.setParameters(parameters2);
                    open.setPreviewCallbackWithBuffer(new zza());
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    return open;
                }
                throw new IOException("Could not find suitable preview frames per second range.");
            }
            throw new IOException("Could not find suitable preview size.");
        }
        throw new IOException("Could not find requested camera.");
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        Object obj = new byte[(((int) Math.ceil(((double) ((long) ((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(obj);
        if (wrap.hasArray() && wrap.array() == obj) {
            this.zzq.put(obj, wrap);
            return obj;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }

    public int getCameraFacing() {
        return this.zzf;
    }

    public Size getPreviewSize() {
        return this.zzh;
    }

    public void release() {
        synchronized (this.zzd) {
            stop();
            this.zzp.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzd) {
            if (this.zze != null) {
                return this;
            }
            this.zze = zza();
            this.zzm = new SurfaceTexture(100);
            this.zze.setPreviewTexture(this.zzm);
            this.zzn = true;
            this.zze.startPreview();
            this.zzo = new Thread(this.zzp);
            this.zzp.setActive(true);
            this.zzo.start();
            return this;
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzd) {
            if (this.zze != null) {
                return this;
            }
            this.zze = zza();
            this.zze.setPreviewDisplay(surfaceHolder);
            this.zze.startPreview();
            this.zzo = new Thread(this.zzp);
            this.zzp.setActive(true);
            this.zzo.start();
            this.zzn = false;
            return this;
        }
    }

    public void stop() {
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
        r6 = this;
        r0 = r6.zzd;
        monitor-enter(r0);
        r1 = r6.zzp;	 Catch:{ all -> 0x006f }
        r2 = 0;	 Catch:{ all -> 0x006f }
        r1.setActive(r2);	 Catch:{ all -> 0x006f }
        r1 = r6.zzo;	 Catch:{ all -> 0x006f }
        r2 = 0;
        if (r1 == 0) goto L_0x001d;
    L_0x000e:
        r1 = r6.zzo;	 Catch:{ InterruptedException -> 0x0014 }
        r1.join();	 Catch:{ InterruptedException -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r1 = "CameraSource";	 Catch:{ all -> 0x006f }
        r3 = "Frame processing thread interrupted on release.";	 Catch:{ all -> 0x006f }
        android.util.Log.d(r1, r3);	 Catch:{ all -> 0x006f }
    L_0x001b:
        r6.zzo = r2;	 Catch:{ all -> 0x006f }
    L_0x001d:
        r1 = r6.zze;	 Catch:{ all -> 0x006f }
        if (r1 == 0) goto L_0x0068;	 Catch:{ all -> 0x006f }
    L_0x0021:
        r1 = r6.zze;	 Catch:{ all -> 0x006f }
        r1.stopPreview();	 Catch:{ all -> 0x006f }
        r1 = r6.zze;	 Catch:{ all -> 0x006f }
        r1.setPreviewCallbackWithBuffer(r2);	 Catch:{ all -> 0x006f }
        r1 = r6.zzn;	 Catch:{ Exception -> 0x003b }
        if (r1 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x003b }
    L_0x002f:
        r1 = r6.zze;	 Catch:{ Exception -> 0x003b }
        r1.setPreviewTexture(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0061;	 Catch:{ Exception -> 0x003b }
    L_0x0035:
        r1 = r6.zze;	 Catch:{ Exception -> 0x003b }
        r1.setPreviewDisplay(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0061;
    L_0x003b:
        r1 = move-exception;
        r3 = "CameraSource";	 Catch:{ all -> 0x006f }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x006f }
        r4 = 32;	 Catch:{ all -> 0x006f }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x006f }
        r5 = r5.length();	 Catch:{ all -> 0x006f }
        r4 = r4 + r5;	 Catch:{ all -> 0x006f }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r5.<init>(r4);	 Catch:{ all -> 0x006f }
        r4 = "Failed to clear camera preview: ";	 Catch:{ all -> 0x006f }
        r5.append(r4);	 Catch:{ all -> 0x006f }
        r5.append(r1);	 Catch:{ all -> 0x006f }
        r1 = r5.toString();	 Catch:{ all -> 0x006f }
        android.util.Log.e(r3, r1);	 Catch:{ all -> 0x006f }
    L_0x0061:
        r1 = r6.zze;	 Catch:{ all -> 0x006f }
        r1.release();	 Catch:{ all -> 0x006f }
        r6.zze = r2;	 Catch:{ all -> 0x006f }
    L_0x0068:
        r1 = r6.zzq;	 Catch:{ all -> 0x006f }
        r1.clear();	 Catch:{ all -> 0x006f }
        monitor-exit(r0);	 Catch:{ all -> 0x006f }
        return;	 Catch:{ all -> 0x006f }
    L_0x006f:
        r1 = move-exception;	 Catch:{ all -> 0x006f }
        monitor-exit(r0);	 Catch:{ all -> 0x006f }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.stop():void");
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzd) {
            if (this.zze != null) {
                android.hardware.Camera.ShutterCallback com_google_android_gms_vision_CameraSource_zzd = new zzd();
                com_google_android_gms_vision_CameraSource_zzd.zzz = shutterCallback;
                android.hardware.Camera.PictureCallback com_google_android_gms_vision_CameraSource_zzc = new zzc();
                com_google_android_gms_vision_CameraSource_zzc.zzy = pictureCallback;
                this.zze.takePicture(com_google_android_gms_vision_CameraSource_zzd, null, null, com_google_android_gms_vision_CameraSource_zzc);
            }
        }
    }
}
