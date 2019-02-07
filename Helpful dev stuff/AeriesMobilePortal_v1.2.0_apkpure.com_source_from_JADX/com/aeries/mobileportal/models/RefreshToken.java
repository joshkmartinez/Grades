package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/models/RefreshToken;", "", "accessToken", "", "expiresIn", "tokenType", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "getRefreshToken", "getTokenType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: RefreshToken.kt */
public final class RefreshToken {
    @SerializedName("access_token")
    @Nullable
    @Expose
    private final String accessToken;
    @SerializedName("expires_in")
    @Nullable
    @Expose
    private final String expiresIn;
    @SerializedName("refresh_token")
    @Nullable
    @Expose
    private final String refreshToken;
    @SerializedName("token_type")
    @Nullable
    @Expose
    private final String tokenType;

    @NotNull
    public static /* bridge */ /* synthetic */ RefreshToken copy$default(RefreshToken refreshToken, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = refreshToken.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = refreshToken.expiresIn;
        }
        if ((i & 4) != 0) {
            str3 = refreshToken.tokenType;
        }
        if ((i & 8) != 0) {
            str4 = refreshToken.refreshToken;
        }
        return refreshToken.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.accessToken;
    }

    @Nullable
    public final String component2() {
        return this.expiresIn;
    }

    @Nullable
    public final String component3() {
        return this.tokenType;
    }

    @Nullable
    public final String component4() {
        return this.refreshToken;
    }

    @NotNull
    public final RefreshToken copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new RefreshToken(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RefreshToken) {
                RefreshToken refreshToken = (RefreshToken) obj;
                if (Intrinsics.areEqual(this.accessToken, refreshToken.accessToken) && Intrinsics.areEqual(this.expiresIn, refreshToken.expiresIn) && Intrinsics.areEqual(this.tokenType, refreshToken.tokenType) && Intrinsics.areEqual(this.refreshToken, refreshToken.refreshToken)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.accessToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expiresIn;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.tokenType;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.refreshToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RefreshToken(accessToken=");
        stringBuilder.append(this.accessToken);
        stringBuilder.append(", expiresIn=");
        stringBuilder.append(this.expiresIn);
        stringBuilder.append(", tokenType=");
        stringBuilder.append(this.tokenType);
        stringBuilder.append(", refreshToken=");
        stringBuilder.append(this.refreshToken);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RefreshToken(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.accessToken = str;
        this.expiresIn = str2;
        this.tokenType = str3;
        this.refreshToken = str4;
    }

    @Nullable
    public final String getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    @Nullable
    public final String getTokenType() {
        return this.tokenType;
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }
}
