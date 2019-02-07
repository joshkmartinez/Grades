package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class(creator = "AccountTransferProgressCreator")
public class zzr extends zzbs {
    public static final Creator<zzr> CREATOR = new zzs();
    private static final ArrayMap<String, Field<?, ?>> zzbp;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)
    private List<String> zzbq;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)
    private List<String> zzbr;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)
    private List<String> zzbs;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)
    private List<String> zzbt;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)
    private List<String> zzbu;
    @VersionField(id = 1)
    private final int zzy;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzbp = arrayMap;
        arrayMap.put("registered", Field.forStrings("registered", 2));
        zzbp.put("in_progress", Field.forStrings("in_progress", 3));
        zzbp.put(Param.SUCCESS, Field.forStrings(Param.SUCCESS, 4));
        zzbp.put("failed", Field.forStrings("failed", 5));
        zzbp.put("escrowed", Field.forStrings("escrowed", 6));
    }

    public zzr() {
        this.zzy = 1;
    }

    @Constructor
    zzr(@SafeParcelable.Param(id = 1) int i, @Nullable @SafeParcelable.Param(id = 2) List<String> list, @Nullable @SafeParcelable.Param(id = 3) List<String> list2, @Nullable @SafeParcelable.Param(id = 4) List<String> list3, @Nullable @SafeParcelable.Param(id = 5) List<String> list4, @Nullable @SafeParcelable.Param(id = 6) List<String> list5) {
        this.zzy = i;
        this.zzbq = list;
        this.zzbr = list2;
        this.zzbs = list3;
        this.zzbt = list4;
        this.zzbu = list5;
    }

    public Map<String, Field<?, ?>> getFieldMappings() {
        return zzbp;
    }

    protected Object getFieldValue(Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.zzy);
            case 2:
                return this.zzbq;
            case 3:
                return this.zzbr;
            case 4:
                return this.zzbs;
            case 5:
                return this.zzbt;
            case 6:
                return this.zzbu;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unknown SafeParcelable id=");
                stringBuilder.append(safeParcelableFieldId);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    protected boolean isFieldSet(Field field) {
        return true;
    }

    protected void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                this.zzbq = arrayList;
                return;
            case 3:
                this.zzbr = arrayList;
                return;
            case 4:
                this.zzbs = arrayList;
                return;
            case 5:
                this.zzbt = arrayList;
                return;
            case 6:
                this.zzbu = arrayList;
                return;
            default:
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(field.getSafeParcelableFieldId())}));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbq, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzbr, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzbs, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzbt, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzbu, false);
        SafeParcelWriter.finishObjectHeader(parcel, i);
    }
}
