package com.aeries.mobileportal.models;

import com.google.android.gms.dynamite.ProviderConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/models/ServerInfo;", "", "status", "", "message", "appEnabled", "", "version", "Lcom/aeries/mobileportal/models/Version;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/aeries/mobileportal/models/Version;)V", "getAppEnabled", "()Z", "getMessage", "()Ljava/lang/String;", "getStatus", "getVersion", "()Lcom/aeries/mobileportal/models/Version;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ServerInfo.kt */
public final class ServerInfo {
    @SerializedName("AppEnabled")
    @Expose
    private final boolean appEnabled;
    @SerializedName("Message")
    @NotNull
    @Expose
    private final String message;
    @SerializedName("Status")
    @NotNull
    @Expose
    private final String status;
    @SerializedName("Version")
    @NotNull
    @Expose
    private final Version version;

    @NotNull
    public static /* bridge */ /* synthetic */ ServerInfo copy$default(ServerInfo serverInfo, String str, String str2, boolean z, Version version, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serverInfo.status;
        }
        if ((i & 2) != 0) {
            str2 = serverInfo.message;
        }
        if ((i & 4) != 0) {
            z = serverInfo.appEnabled;
        }
        if ((i & 8) != 0) {
            version = serverInfo.version;
        }
        return serverInfo.copy(str, str2, z, version);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.appEnabled;
    }

    @NotNull
    public final Version component4() {
        return this.version;
    }

    @NotNull
    public final ServerInfo copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull Version version) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(version, ProviderConstants.API_COLNAME_FEATURE_VERSION);
        return new ServerInfo(str, str2, z, version);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ServerInfo) {
                ServerInfo serverInfo = (ServerInfo) obj;
                if (Intrinsics.areEqual(this.status, serverInfo.status) && Intrinsics.areEqual(this.message, serverInfo.message)) {
                    if ((this.appEnabled == serverInfo.appEnabled) && Intrinsics.areEqual(this.version, serverInfo.version)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.appEnabled;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Version version = this.version;
        if (version != null) {
            i = version.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ServerInfo(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", appEnabled=");
        stringBuilder.append(this.appEnabled);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ServerInfo(@NotNull String str, @NotNull String str2, boolean z, @NotNull Version version) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(version, ProviderConstants.API_COLNAME_FEATURE_VERSION);
        this.status = str;
        this.message = str2;
        this.appEnabled = z;
        this.version = version;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean getAppEnabled() {
        return this.appEnabled;
    }

    @NotNull
    public final Version getVersion() {
        return this.version;
    }
}
