package com.aeries.mobileportal.repos.sharedpreferences;

import android.content.SharedPreferences;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/repos/sharedpreferences/NetworkRepository;", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "networkPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "CURRENT_BASE_URL", "", "getNetworkPreferences", "()Landroid/content/SharedPreferences;", "getCurrentBaseURL", "setCurrentBaseURL", "", "baseURL", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NetworkRepository.kt */
public final class NetworkRepository implements NetworkRepo {
    private final String CURRENT_BASE_URL = "CURRENT_BASE_URL";
    @NotNull
    private final SharedPreferences networkPreferences;

    public NetworkRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "networkPreferences");
        this.networkPreferences = sharedPreferences;
    }

    @NotNull
    public final SharedPreferences getNetworkPreferences() {
        return this.networkPreferences;
    }

    @NotNull
    public String getCurrentBaseURL() {
        String string = this.networkPreferences.getString(this.CURRENT_BASE_URL, "");
        if (string == null) {
            Intrinsics.throwNpe();
        }
        return string;
    }

    public void setCurrentBaseURL(@Nullable String str) {
        this.networkPreferences.edit().putString(this.CURRENT_BASE_URL, Intrinsics.stringPlus(str, AppConstants.Companion.getURL_EXTENSION())).apply();
    }
}
