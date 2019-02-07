package com.aeries.mobileportal.repos.adapters;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "", "getCurrentBaseURL", "", "setCurrentBaseURL", "", "baseURL", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NetworkRepo.kt */
public interface NetworkRepo {
    @NotNull
    String getCurrentBaseURL();

    void setCurrentBaseURL(@Nullable String str);
}
