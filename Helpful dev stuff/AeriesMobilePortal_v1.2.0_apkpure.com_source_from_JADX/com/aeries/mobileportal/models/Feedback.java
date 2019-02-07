package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/models/Feedback;", "", "email", "", "comment", "(Ljava/lang/String;Ljava/lang/String;)V", "getComment", "()Ljava/lang/String;", "getEmail", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Feedback.kt */
public final class Feedback {
    @SerializedName("comment")
    @NotNull
    @Expose
    private final String comment;
    @SerializedName("email")
    @NotNull
    @Expose
    private final String email;

    @NotNull
    public static /* bridge */ /* synthetic */ Feedback copy$default(Feedback feedback, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedback.email;
        }
        if ((i & 2) != 0) {
            str2 = feedback.comment;
        }
        return feedback.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.email;
    }

    @NotNull
    public final String component2() {
        return this.comment;
    }

    @NotNull
    public final Feedback copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "comment");
        return new Feedback(str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Feedback) {
                Feedback feedback = (Feedback) obj;
                if (Intrinsics.areEqual(this.email, feedback.email) && Intrinsics.areEqual(this.comment, feedback.comment)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.comment;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Feedback(email=");
        stringBuilder.append(this.email);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Feedback(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "comment");
        this.email = str;
        this.comment = str2;
    }

    @NotNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }
}
