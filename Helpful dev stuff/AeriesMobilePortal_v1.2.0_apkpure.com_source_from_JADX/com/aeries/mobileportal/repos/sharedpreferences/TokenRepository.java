package com.aeries.mobileportal.repos.sharedpreferences;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "", "tokenPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "ACCESS_TOKEN", "", "REFRESH_TOKEN", "getTokenPreferences", "()Landroid/content/SharedPreferences;", "deleteAccessToken", "", "deleteRefreshToken", "deleteTokens", "getAccessToken", "getRefreshToken", "invalidateAccessToken", "setAccessToken", "accessToken", "setRefreshToken", "refreshToken", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: TokenRepository.kt */
public class TokenRepository {
    private final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private final String REFRESH_TOKEN = "REFRESH_TOKEN";
    @NotNull
    private final SharedPreferences tokenPreferences;

    public TokenRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "tokenPreferences");
        this.tokenPreferences = sharedPreferences;
    }

    @NotNull
    public final SharedPreferences getTokenPreferences() {
        return this.tokenPreferences;
    }

    @NotNull
    public final String getAccessToken() {
        String string = this.tokenPreferences.getString(this.ACCESS_TOKEN, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "tokenPreferences.getString(ACCESS_TOKEN, \"\")");
        return string;
    }

    @NotNull
    public final String getRefreshToken() {
        String string = this.tokenPreferences.getString(this.REFRESH_TOKEN, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "tokenPreferences.getString(REFRESH_TOKEN, \"\")");
        return string;
    }

    public final void setAccessToken(@Nullable String str) {
        Editor edit = this.tokenPreferences.edit();
        String str2 = this.ACCESS_TOKEN;
        if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bearer ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } else {
            str = "";
        }
        edit.putString(str2, str).apply();
        Log.w("AccessToken", "Token modified!!");
    }

    public final void deleteAccessToken() {
        this.tokenPreferences.edit().putString(this.ACCESS_TOKEN, null).apply();
        Log.w("AccessToken", "Token deleted!!");
    }

    public final void invalidateAccessToken() {
        this.tokenPreferences.edit().putString(this.ACCESS_TOKEN, "invalid").apply();
        Log.w("AccessToken", "Token deleted!!");
    }

    public final void setRefreshToken(@Nullable String str) {
        this.tokenPreferences.edit().putString(this.REFRESH_TOKEN, str).apply();
    }

    public final void deleteRefreshToken() {
        this.tokenPreferences.edit().putString(this.REFRESH_TOKEN, null).apply();
    }

    public final void deleteTokens() {
        deleteAccessToken();
        deleteRefreshToken();
    }
}
