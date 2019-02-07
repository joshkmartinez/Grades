package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

@WorkerThread
final class zzfo implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzajl;
    private final zzfm zzajm;
    private final Map<String, String> zzajn;
    private final /* synthetic */ zzfk zzajo;

    public zzfo(zzfk com_google_android_gms_internal_measurement_zzfk, String str, URL url, byte[] bArr, Map<String, String> map, zzfm com_google_android_gms_internal_measurement_zzfm) {
        this.zzajo = com_google_android_gms_internal_measurement_zzfk;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzfm);
        this.url = url;
        this.zzajl = bArr;
        this.zzajm = com_google_android_gms_internal_measurement_zzfm;
        this.packageName = str;
        this.zzajn = map;
    }

    public final void run() {
        Map map;
        int i;
        Throwable th;
        Throwable e;
        zzgg zzgd;
        Runnable com_google_android_gms_internal_measurement_zzfn;
        this.zzajo.zzfs();
        OutputStream outputStream = null;
        HttpURLConnection zzb;
        try {
            zzb = this.zzajo.zzb(this.url);
            try {
                if (this.zzajn != null) {
                    for (Entry entry : this.zzajn.entrySet()) {
                        zzb.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.zzajl != null) {
                    byte[] zza = this.zzajo.zzgb().zza(this.zzajl);
                    this.zzajo.zzge().zzit().zzg("Uploading data. size", Integer.valueOf(zza.length));
                    zzb.setDoOutput(true);
                    zzb.addRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
                    zzb.setFixedLengthStreamingMode(zza.length);
                    zzb.connect();
                    OutputStream outputStream2 = zzb.getOutputStream();
                    try {
                        outputStream2.write(zza);
                        outputStream2.close();
                    } catch (Throwable e2) {
                        map = null;
                        i = 0;
                        th = e2;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.zzajo.zzge().zzim().zze("Error closing HTTP compressed POST connection output stream. appId", zzfg.zzbm(this.packageName), e3);
                            }
                        }
                        if (zzb != null) {
                            zzb.disconnect();
                        }
                        zzgd = this.zzajo.zzgd();
                        com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, th, null, map);
                        zzgd.zzc(r1);
                    } catch (Throwable th2) {
                        e2 = th2;
                        map = null;
                        i = 0;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e32) {
                                this.zzajo.zzge().zzim().zze("Error closing HTTP compressed POST connection output stream. appId", zzfg.zzbm(this.packageName), e32);
                            }
                        }
                        if (zzb != null) {
                            zzb.disconnect();
                        }
                        this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                        throw e2;
                    }
                }
                i = zzb.getResponseCode();
            } catch (IOException e4) {
                e2 = e4;
                map = null;
                i = 0;
                th = e2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                zzgd = this.zzajo.zzgd();
                com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, th, null, map);
                zzgd.zzc(r1);
            } catch (Throwable th3) {
                e2 = th3;
                map = null;
                i = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                throw e2;
            }
            try {
                map = zzb.getHeaderFields();
                try {
                    byte[] zza2 = zzfk.zzb(zzb);
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    zzgd = this.zzajo.zzgd();
                    com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, null, zza2, map);
                } catch (IOException e5) {
                    e2 = e5;
                    th = e2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    zzgd = this.zzajo.zzgd();
                    com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, th, null, map);
                    zzgd.zzc(r1);
                } catch (Throwable th4) {
                    e2 = th4;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                    throw e2;
                }
            } catch (IOException e6) {
                e2 = e6;
                map = null;
                th = e2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                zzgd = this.zzajo.zzgd();
                com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, th, null, map);
                zzgd.zzc(r1);
            } catch (Throwable th5) {
                e2 = th5;
                map = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
                throw e2;
            }
        } catch (IOException e7) {
            e2 = e7;
            zzb = null;
            map = zzb;
            i = 0;
            th = e2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            zzgd = this.zzajo.zzgd();
            com_google_android_gms_internal_measurement_zzfn = new zzfn(this.packageName, this.zzajm, i, th, null, map);
            zzgd.zzc(r1);
        } catch (Throwable th6) {
            e2 = th6;
            zzb = null;
            map = zzb;
            i = 0;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            this.zzajo.zzgd().zzc(new zzfn(this.packageName, this.zzajm, i, null, null, map));
            throw e2;
        }
        zzgd.zzc(r1);
    }
}
