package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/aeries/mobileportal/models/StudentContacts;", "", "()V", "contactDetails", "", "Lcom/aeries/mobileportal/models/Contact;", "getContactDetails", "()Ljava/util/List;", "setContactDetails", "(Ljava/util/List;)V", "schoolCode", "", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "studentID", "getStudentID", "setStudentID", "studentRedFlag", "Lcom/aeries/mobileportal/models/StudentRedFlag;", "getStudentRedFlag", "()Lcom/aeries/mobileportal/models/StudentRedFlag;", "setStudentRedFlag", "(Lcom/aeries/mobileportal/models/StudentRedFlag;)V", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentContacts.kt */
public final class StudentContacts {
    @Nullable
    @SerializedName("ContactDetails")
    @Expose
    private List<Contact> contactDetails = new ArrayList();
    @SerializedName("SchoolCode")
    @Nullable
    @Expose
    private Integer schoolCode = Integer.valueOf(0);
    @SerializedName("StudentID")
    @Nullable
    @Expose
    private Integer studentID = Integer.valueOf(0);
    @SerializedName("StudentRedFlag")
    @Nullable
    @Expose
    private StudentRedFlag studentRedFlag = new StudentRedFlag();

    @Nullable
    public final Integer getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(@Nullable Integer num) {
        this.schoolCode = num;
    }

    @Nullable
    public final Integer getStudentID() {
        return this.studentID;
    }

    public final void setStudentID(@Nullable Integer num) {
        this.studentID = num;
    }

    @Nullable
    public final StudentRedFlag getStudentRedFlag() {
        return this.studentRedFlag;
    }

    public final void setStudentRedFlag(@Nullable StudentRedFlag studentRedFlag) {
        this.studentRedFlag = studentRedFlag;
    }

    @Nullable
    public final List<Contact> getContactDetails() {
        return this.contactDetails;
    }

    public final void setContactDetails(@Nullable List<Contact> list) {
        this.contactDetails = list;
    }
}
