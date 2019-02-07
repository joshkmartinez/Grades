package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/models/StudentRedFlag;", "", "()V", "comment", "", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "redFlag", "", "getRedFlag", "()Ljava/lang/Boolean;", "setRedFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentRedFlag.kt */
public final class StudentRedFlag {
    @SerializedName("Comment")
    @Nullable
    @Expose
    private String comment = "";
    @SerializedName("RedFlag")
    @Nullable
    @Expose
    private Boolean redFlag = Boolean.valueOf(false);

    @Nullable
    public final Boolean getRedFlag() {
        return this.redFlag;
    }

    public final void setRedFlag(@Nullable Boolean bool) {
        this.redFlag = bool;
    }

    @Nullable
    public final String getComment() {
        return this.comment;
    }

    public final void setComment(@Nullable String str) {
        this.comment = str;
    }
}
