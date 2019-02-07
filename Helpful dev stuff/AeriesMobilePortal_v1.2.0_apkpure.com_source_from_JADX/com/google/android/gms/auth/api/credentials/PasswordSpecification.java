package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

@Class(creator = "PasswordSpecificationCreator")
@Reserved({1000})
public final class PasswordSpecification extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<PasswordSpecification> CREATOR = new zzm();
    public static final PasswordSpecification zzdg = new zzd().zzd(12, 16).zze("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzd("abcdefghijkmnopqrstxyz", 1).zzd("ABCDEFGHJKLMNPQRSTXY", 1).zzd("3456789", 1).zzj();
    private static final PasswordSpecification zzdh = new zzd().zzd(12, 16).zze("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzd("abcdefghijklmnopqrstuvwxyz", 1).zzd("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzd("1234567890", 1).zzj();
    @VisibleForTesting
    @Field(id = 1)
    private final String zzdi;
    @VisibleForTesting
    @Field(id = 2)
    private final List<String> zzdj;
    @VisibleForTesting
    @Field(id = 3)
    private final List<Integer> zzdk;
    @VisibleForTesting
    @Field(id = 4)
    private final int zzdl;
    @VisibleForTesting
    @Field(id = 5)
    private final int zzdm;
    private final int[] zzdn;
    private final Random zzdo;

    public static class zzd {
        private final List<String> zzdj = new ArrayList();
        private final List<Integer> zzdk = new ArrayList();
        private int zzdl = 12;
        private int zzdm = 16;
        private final TreeSet<Character> zzdp = new TreeSet();

        private static TreeSet<Character> zzd(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zze(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzd(c, 32, 126)) {
                    throw new zze(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final zzd zzd(int i, int i2) {
            this.zzdl = 12;
            this.zzdm = 16;
            return this;
        }

        public final zzd zzd(@NonNull String str, int i) {
            this.zzdj.add(PasswordSpecification.zzd(zzd(str, "requiredChars")));
            this.zzdk.add(Integer.valueOf(1));
            return this;
        }

        public final zzd zze(@NonNull String str) {
            this.zzdp.addAll(zzd(str, "allowedChars"));
            return this;
        }

        public final PasswordSpecification zzj() {
            if (this.zzdp.isEmpty()) {
                throw new zze("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.zzdk) {
                i += intValue.intValue();
            }
            if (i <= this.zzdm) {
                boolean[] zArr = new boolean[95];
                for (String toCharArray : this.zzdj) {
                    for (char c : toCharArray.toCharArray()) {
                        int i2 = c - 32;
                        if (zArr[i2]) {
                            StringBuilder stringBuilder = new StringBuilder(58);
                            stringBuilder.append("character ");
                            stringBuilder.append(c);
                            stringBuilder.append(" occurs in more than one required character set");
                            throw new zze(stringBuilder.toString());
                        }
                        zArr[i2] = true;
                    }
                }
                return new PasswordSpecification(PasswordSpecification.zzd(this.zzdp), this.zzdj, this.zzdk, this.zzdl, this.zzdm);
            }
            throw new zze("required character count cannot be greater than the max password size");
        }
    }

    public static class zze extends Error {
        public zze(String str) {
            super(str);
        }
    }

    @Constructor
    PasswordSpecification(@Param(id = 1) String str, @Param(id = 2) List<String> list, @Param(id = 3) List<Integer> list2, @Param(id = 4) int i, @Param(id = 5) int i2) {
        this.zzdi = str;
        this.zzdj = Collections.unmodifiableList(list);
        this.zzdk = Collections.unmodifiableList(list2);
        this.zzdl = i;
        this.zzdm = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        i = 0;
        for (String toCharArray : this.zzdj) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        this.zzdn = iArr;
        this.zzdo = new SecureRandom();
    }

    private static String zzd(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    private static boolean zzd(int i, int i2, int i3) {
        if (i >= 32) {
            if (i <= 126) {
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdi, false);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzdj, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.zzdk, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdl);
        SafeParcelWriter.writeInt(parcel, 5, this.zzdm);
        SafeParcelWriter.finishObjectHeader(parcel, i);
    }
}
