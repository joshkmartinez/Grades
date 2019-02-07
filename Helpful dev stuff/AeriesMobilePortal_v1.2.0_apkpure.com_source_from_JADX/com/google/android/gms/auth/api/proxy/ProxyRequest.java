package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zzd();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @Field(id = 4)
    public final byte[] body;
    @Field(id = 2)
    public final int httpMethod;
    @Field(id = 3)
    public final long timeoutMillis;
    @Field(id = 1)
    public final String url;
    @VersionField(id = 1000)
    private final int versionCode;
    @Field(id = 5)
    private Bundle zzdw;

    @KeepForSdkWithMembers
    public static class Builder {
        private String zzdx;
        private int zzdy = ProxyRequest.HTTP_METHOD_GET;
        private long zzdz = 3000;
        private byte[] zzea = null;
        private Bundle zzeb = new Bundle();

        public Builder(String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzdx = str;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(51 + String.valueOf(str).length());
            stringBuilder.append("The supplied url [ ");
            stringBuilder.append(str);
            stringBuilder.append("] is not match Patterns.WEB_URL!");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public ProxyRequest build() {
            if (this.zzea == null) {
                this.zzea = new byte[0];
            }
            return new ProxyRequest(2, this.zzdx, this.zzdy, this.zzdz, this.zzea, this.zzeb);
        }

        public Builder putHeader(String str, String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzeb;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzea = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            boolean z = i >= 0 && i <= ProxyRequest.LAST_CODE;
            Preconditions.checkArgument(z, "Unrecognized http method code.");
            this.zzdy = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            Preconditions.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.zzdz = j;
            return this;
        }
    }

    @Constructor
    ProxyRequest(@Param(id = 1000) int i, @Param(id = 1) String str, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) byte[] bArr, @Param(id = 5) Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzdw = bundle;
    }

    public Map<String, String> getHeaderMap() {
        Map linkedHashMap = new LinkedHashMap(this.zzdw.size());
        for (String str : this.zzdw.keySet()) {
            linkedHashMap.put(str, this.zzdw.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i = this.httpMethod;
        StringBuilder stringBuilder = new StringBuilder(42 + String.valueOf(str).length());
        stringBuilder.append("ProxyRequest[ url: ");
        stringBuilder.append(str);
        stringBuilder.append(", method: ");
        stringBuilder.append(i);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzdw, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, i);
    }
}
