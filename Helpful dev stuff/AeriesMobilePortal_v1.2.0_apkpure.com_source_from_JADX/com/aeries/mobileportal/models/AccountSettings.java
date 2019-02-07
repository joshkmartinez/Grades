package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/models/AccountSettings;", "", "status", "", "disableCreateAccount", "", "disableStudentChangePassword", "disableParentChangePassword", "(Ljava/lang/String;ZZZ)V", "getDisableCreateAccount", "()Z", "getDisableParentChangePassword", "getDisableStudentChangePassword", "getStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountSettings.kt */
public final class AccountSettings {
    @SerializedName("disable_createaccount")
    @Expose
    private final boolean disableCreateAccount;
    @SerializedName("disable_parentchangepassword")
    @Expose
    private final boolean disableParentChangePassword;
    @SerializedName("disable_studentchangepassword")
    @Expose
    private final boolean disableStudentChangePassword;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @NotNull
    public static /* bridge */ /* synthetic */ AccountSettings copy$default(AccountSettings accountSettings, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountSettings.status;
        }
        if ((i & 2) != 0) {
            z = accountSettings.disableCreateAccount;
        }
        if ((i & 4) != 0) {
            z2 = accountSettings.disableStudentChangePassword;
        }
        if ((i & 8) != 0) {
            z3 = accountSettings.disableParentChangePassword;
        }
        return accountSettings.copy(str, z, z2, z3);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.disableCreateAccount;
    }

    public final boolean component3() {
        return this.disableStudentChangePassword;
    }

    public final boolean component4() {
        return this.disableParentChangePassword;
    }

    @NotNull
    public final AccountSettings copy(@NotNull String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        return new AccountSettings(str, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AccountSettings) {
                AccountSettings accountSettings = (AccountSettings) obj;
                if (Intrinsics.areEqual(this.status, accountSettings.status)) {
                    if (this.disableCreateAccount == accountSettings.disableCreateAccount) {
                        if (this.disableStudentChangePassword == accountSettings.disableStudentChangePassword) {
                            if (this.disableParentChangePassword == accountSettings.disableParentChangePassword) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.status;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        int i = this.disableCreateAccount;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.disableStudentChangePassword;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.disableParentChangePassword;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccountSettings(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", disableCreateAccount=");
        stringBuilder.append(this.disableCreateAccount);
        stringBuilder.append(", disableStudentChangePassword=");
        stringBuilder.append(this.disableStudentChangePassword);
        stringBuilder.append(", disableParentChangePassword=");
        stringBuilder.append(this.disableParentChangePassword);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountSettings(@NotNull String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.status = str;
        this.disableCreateAccount = z;
        this.disableStudentChangePassword = z2;
        this.disableParentChangePassword = z3;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final boolean getDisableCreateAccount() {
        return this.disableCreateAccount;
    }

    public final boolean getDisableStudentChangePassword() {
        return this.disableStudentChangePassword;
    }

    public final boolean getDisableParentChangePassword() {
        return this.disableParentChangePassword;
    }
}
