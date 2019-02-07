package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@Class(creator = "CredentialCreator")
@Reserved({1000})
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zzd();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @Nullable
    @Field(getter = "getName", id = 2)
    private final String mName;
    @Nullable
    @Field(getter = "getAccountType", id = 6)
    private final String zzbx;
    @Field(getter = "getId", id = 1)
    @Nonnull
    private final String zzci;
    @Nullable
    @Field(getter = "getProfilePictureUri", id = 3)
    private final Uri zzcj;
    @Field(getter = "getIdTokens", id = 4)
    @Nonnull
    private final List<IdToken> zzck;
    @Nullable
    @Field(getter = "getPassword", id = 5)
    private final String zzcl;
    @Nullable
    @Field(getter = "getGeneratedPassword", id = 7)
    private final String zzcm;
    @Nullable
    @Field(getter = "getGeneratedHintId", id = 8)
    private final String zzcn;
    @Nullable
    @Field(getter = "getGivenName", id = 9)
    private final String zzco;
    @Nullable
    @Field(getter = "getFamilyName", id = 10)
    private final String zzcp;

    public static class Builder {
        private String mName;
        private String zzbx;
        private final String zzci;
        private Uri zzcj;
        private List<IdToken> zzck;
        private String zzcl;
        private String zzcm;
        private String zzcn;
        private String zzco;
        private String zzcp;

        public Builder(Credential credential) {
            this.zzci = credential.zzci;
            this.mName = credential.mName;
            this.zzcj = credential.zzcj;
            this.zzck = credential.zzck;
            this.zzcl = credential.zzcl;
            this.zzbx = credential.zzbx;
            this.zzcm = credential.zzcm;
            this.zzcn = credential.zzcn;
            this.zzco = credential.zzco;
            this.zzcp = credential.zzcp;
        }

        public Builder(String str) {
            this.zzci = str;
        }

        public Credential build() {
            return new Credential(this.zzci, this.mName, this.zzcj, this.zzck, this.zzcl, this.zzbx, this.zzcm, this.zzcn, this.zzco, this.zzcp);
        }

        public Builder setAccountType(String str) {
            this.zzbx = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzcl = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzcj = uri;
            return this;
        }
    }

    @Constructor
    Credential(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) Uri uri, @Param(id = 4) List<IdToken> list, @Param(id = 5) String str3, @Param(id = 6) String str4, @Param(id = 7) String str5, @Param(id = 8) String str6, @Param(id = 9) String str7, @Param(id = 10) String str8) {
        str = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(str, "credential identifier cannot be empty");
        if (str3 != null) {
            if (TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("Password must not be empty if set");
            }
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme())) {
                    if (!TextUtils.isEmpty(parse.getAuthority())) {
                        if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                            z = true;
                        }
                    }
                }
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
            }
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.mName = str2;
        this.zzcj = uri;
        this.zzck = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzci = str;
        this.zzcl = str3;
        this.zzbx = str4;
        this.zzcm = str5;
        this.zzcn = str6;
        this.zzco = str7;
        this.zzcp = str8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzci, credential.zzci) && TextUtils.equals(this.mName, credential.mName) && Objects.equal(this.zzcj, credential.zzcj) && TextUtils.equals(this.zzcl, credential.zzcl) && TextUtils.equals(this.zzbx, credential.zzbx) && TextUtils.equals(this.zzcm, credential.zzcm);
    }

    @Nullable
    public String getAccountType() {
        return this.zzbx;
    }

    @Nullable
    public String getFamilyName() {
        return this.zzcp;
    }

    @Nullable
    public String getGeneratedPassword() {
        return this.zzcm;
    }

    @Nullable
    public String getGivenName() {
        return this.zzco;
    }

    @Nonnull
    public String getId() {
        return this.zzci;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zzck;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPassword() {
        return this.zzcl;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zzcj;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzci, this.mName, this.zzcj, this.zzcl, this.zzbx, this.zzcm);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 7, getGeneratedPassword(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcn, false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
