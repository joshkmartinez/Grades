package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/models/LinkContact;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "studentID", "", "sequenceNumber", "name", "", "emailAddress", "relationship", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmailAddress", "()Ljava/lang/String;", "getName", "getRelationship", "getSequenceNumber", "()I", "getStudentID", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkContact.kt */
public final class LinkContact implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("EmailAddress")
    @NotNull
    @Expose
    private final String emailAddress;
    @SerializedName("Name")
    @NotNull
    @Expose
    private final String name;
    @SerializedName("RelationShip")
    @NotNull
    @Expose
    private final String relationship;
    @SerializedName("SequenceNumber")
    @Expose
    private final int sequenceNumber;
    @SerializedName("StudentID")
    @Expose
    private final int studentID;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/LinkContact$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/LinkContact;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/LinkContact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LinkContact.kt */
    public static final class CREATOR implements Creator<LinkContact> {
        private CREATOR() {
        }

        @NotNull
        public LinkContact createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new LinkContact(parcel);
        }

        @NotNull
        public LinkContact[] newArray(int i) {
            return new LinkContact[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ LinkContact copy$default(LinkContact linkContact, int i, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = linkContact.studentID;
        }
        if ((i3 & 2) != 0) {
            i2 = linkContact.sequenceNumber;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = linkContact.name;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = linkContact.emailAddress;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = linkContact.relationship;
        }
        return linkContact.copy(i, i4, str4, str5, str3);
    }

    public final int component1() {
        return this.studentID;
    }

    public final int component2() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.emailAddress;
    }

    @NotNull
    public final String component5() {
        return this.relationship;
    }

    @NotNull
    public final LinkContact copy(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str3, "relationship");
        return new LinkContact(i, i2, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkContact) {
                LinkContact linkContact = (LinkContact) obj;
                if (this.studentID == linkContact.studentID) {
                    if ((this.sequenceNumber == linkContact.sequenceNumber) && Intrinsics.areEqual(this.name, linkContact.name) && Intrinsics.areEqual(this.emailAddress, linkContact.emailAddress) && Intrinsics.areEqual(this.relationship, linkContact.relationship)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.studentID * 31) + this.sequenceNumber) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.emailAddress;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.relationship;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkContact(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", sequenceNumber=");
        stringBuilder.append(this.sequenceNumber);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", emailAddress=");
        stringBuilder.append(this.emailAddress);
        stringBuilder.append(", relationship=");
        stringBuilder.append(this.relationship);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkContact(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str3, "relationship");
        this.studentID = i;
        this.sequenceNumber = i2;
        this.name = str;
        this.emailAddress = str2;
        this.relationship = str3;
    }

    public final int getStudentID() {
        return this.studentID;
    }

    public final int getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    @NotNull
    public final String getRelationship() {
        return this.relationship;
    }

    public LinkContact(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        this(readInt, readInt2, readString, readString2, readString3);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.studentID);
        parcel.writeInt(this.sequenceNumber);
        parcel.writeString(this.name);
        parcel.writeString(this.emailAddress);
        parcel.writeString(this.relationship);
    }
}
