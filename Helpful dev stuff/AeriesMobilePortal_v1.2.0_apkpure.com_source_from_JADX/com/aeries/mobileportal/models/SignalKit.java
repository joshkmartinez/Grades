package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/models/SignalKit;", "", "()V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "signalKitUrl", "getSignalKitUrl", "status", "getStatus", "setStatus", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SignalKit.kt */
public final class SignalKit {
    @SerializedName("ErrorMessage")
    @Nullable
    @Expose
    private final String errorMessage = "";
    @SerializedName("SignalKitUrl")
    @Nullable
    @Expose
    private final String signalKitUrl = "";
    @SerializedName("Status")
    @Nullable
    @Expose
    private String status = "";

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(@Nullable String str) {
        this.status = str;
    }

    @Nullable
    public final String getSignalKitUrl() {
        return this.signalKitUrl;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
