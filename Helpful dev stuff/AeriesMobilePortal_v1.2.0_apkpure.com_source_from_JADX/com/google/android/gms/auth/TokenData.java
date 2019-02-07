package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@Class(creator = "TokenDataCreator")
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR = new zzn();
    @Field(getter = "getExpirationTimeSecs", id = 3)
    private final Long zzaa;
    @Field(getter = "isCached", id = 4)
    private final boolean zzab;
    @Field(getter = "isSnowballed", id = 5)
    private final boolean zzac;
    @Field(getter = "getGrantedScopes", id = 6)
    private final List<String> zzad;
    @VersionField(id = 1)
    private final int zzy;
    @Field(getter = "getToken", id = 2)
    private final String zzz;

    @Constructor
    TokenData(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) Long l, @Param(id = 4) boolean z, @Param(id = 5) boolean z2, @Param(id = 6) List<String> list) {
        this.zzy = i;
        this.zzz = Preconditions.checkNotEmpty(str);
        this.zzaa = l;
        this.zzab = z;
        this.zzac = z2;
        this.zzad = list;
    }

    @Nullable
    public static TokenData zzd(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        bundle = bundle.getBundle(str);
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzz, tokenData.zzz) && Objects.equal(this.zzaa, tokenData.zzaa) && this.zzab == tokenData.zzab && this.zzac == tokenData.zzac && Objects.equal(this.zzad, tokenData.zzad);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzz, this.zzaa, Boolean.valueOf(this.zzab), Boolean.valueOf(this.zzac), this.zzad);
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.zzz, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.zzaa, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzac);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzad, false);
        SafeParcelWriter.finishObjectHeader(parcel, i);
    }

    public final String zze() {
        return this.zzz;
    }
}
