package com.aeries.mobileportal.interactors.communications;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/communications/CommunicationsCallback;", "", "onErrorReceived", "", "error", "", "onNetworkError", "e", "", "onURLReceived", "url", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CommunicationsCallback.kt */
public interface CommunicationsCallback {
    void onErrorReceived(@Nullable String str);

    void onNetworkError(@NotNull Throwable th);

    void onURLReceived(@Nullable String str);
}
