package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/models/Session;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sessionId", "", "sessionName", "", "room", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getRoom", "()Ljava/lang/String;", "getSessionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSessionName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/aeries/mobileportal/models/Session;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Session.kt */
public final class Session implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Room")
    @Nullable
    @Expose
    private final String room;
    @SerializedName("SessionID")
    @Nullable
    @Expose
    private final Integer sessionId;
    @SerializedName("SessionName")
    @Nullable
    @Expose
    private final String sessionName;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Session$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Session;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Session.kt */
    public static final class CREATOR implements Creator<Session> {
        private CREATOR() {
        }

        @NotNull
        public Session createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Session(parcel);
        }

        @NotNull
        public Session[] newArray(int i) {
            return new Session[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Session copy$default(Session session, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = session.sessionId;
        }
        if ((i & 2) != 0) {
            str = session.sessionName;
        }
        if ((i & 4) != 0) {
            str2 = session.room;
        }
        return session.copy(num, str, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.sessionId;
    }

    @Nullable
    public final String component2() {
        return this.sessionName;
    }

    @Nullable
    public final String component3() {
        return this.room;
    }

    @NotNull
    public final Session copy(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        return new Session(num, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Session) {
                Session session = (Session) obj;
                if (Intrinsics.areEqual(this.sessionId, session.sessionId) && Intrinsics.areEqual(this.sessionName, session.sessionName) && Intrinsics.areEqual(this.room, session.room)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.sessionId;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.sessionName;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.room;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Session(sessionId=");
        stringBuilder.append(this.sessionId);
        stringBuilder.append(", sessionName=");
        stringBuilder.append(this.sessionName);
        stringBuilder.append(", room=");
        stringBuilder.append(this.room);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Session(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.sessionId = num;
        this.sessionName = str;
        this.room = str2;
    }

    @Nullable
    public final Integer getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final String getSessionName() {
        return this.sessionName;
    }

    @Nullable
    public final String getRoom() {
        return this.room;
    }

    public Session(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        this((Integer) readValue, parcel.readString(), parcel.readString());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeValue(this.sessionId);
        parcel.writeString(this.sessionName);
        parcel.writeString(this.room);
    }
}