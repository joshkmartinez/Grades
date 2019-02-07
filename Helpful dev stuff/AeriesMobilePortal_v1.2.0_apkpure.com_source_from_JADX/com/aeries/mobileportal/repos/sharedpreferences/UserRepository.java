package com.aeries.mobileportal.repos.sharedpreferences;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0006J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0006J\u0010\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u0006J\u0010\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0006J\u0010\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010\u0006J\u0010\u0010*\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0006J\u0010\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "", "userPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "CLIENT_ID", "", "GOOGLE_ACCOUNT", "GOOGLE_TOKEN", "LAST_USER_NAME", "PASSWORD", "SCHOOL_NAME", "SECRET_KEY", "USER_NAME", "USER_TYPE", "getUserPreferences", "()Landroid/content/SharedPreferences;", "deleteAll", "", "getClientID", "getGoogleAccount", "getGoogleToken", "getLastUserName", "getPassword", "getSchoolName", "getSecretKey", "getUserName", "getUserType", "setClientID", "clientID", "setGoogleAccount", "googleAccount", "setGoogleToken", "googleToken", "setLastUserName", "userName", "setPassword", "password", "setSchoolName", "schoolName", "setSecretKey", "secretKey", "setUserName", "setUserType", "userType", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: UserRepository.kt */
public class UserRepository {
    private final String CLIENT_ID = "CLIENT_ID";
    private final String GOOGLE_ACCOUNT = "G_ACC";
    private final String GOOGLE_TOKEN = "G_TOK";
    private final String LAST_USER_NAME = "LAST_USER_NAME";
    private final String PASSWORD = "PASSWORD";
    private final String SCHOOL_NAME = "SCHOOL_NAME";
    private final String SECRET_KEY = "SECRET_KEY";
    private final String USER_NAME = "USER_NAME";
    private final String USER_TYPE = "USER_TYPE";
    @NotNull
    private final SharedPreferences userPreferences;

    public UserRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        this.userPreferences = sharedPreferences;
    }

    @NotNull
    public final SharedPreferences getUserPreferences() {
        return this.userPreferences;
    }

    @NotNull
    public final String getUserName() {
        String string = this.userPreferences.getString(this.USER_NAME, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(USER_NAME, \"\")");
        return string;
    }

    @Nullable
    public final String getLastUserName() {
        return this.userPreferences.getString(this.LAST_USER_NAME, null);
    }

    @NotNull
    public final String getPassword() {
        String string = this.userPreferences.getString(this.PASSWORD, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(PASSWORD, \"\")");
        return string;
    }

    @NotNull
    public final String getSecretKey() {
        String string = this.userPreferences.getString(this.SECRET_KEY, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(SECRET_KEY, \"\")");
        return string;
    }

    @NotNull
    public final String getClientID() {
        String string = this.userPreferences.getString(this.CLIENT_ID, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(CLIENT_ID, \"\")");
        return string;
    }

    @NotNull
    public final String getUserType() {
        String string = this.userPreferences.getString(this.USER_TYPE, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(USER_TYPE, \"\")");
        return string;
    }

    @NotNull
    public final String getSchoolName() {
        String string = this.userPreferences.getString(this.SCHOOL_NAME, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "userPreferences.getString(SCHOOL_NAME, \"\")");
        return string;
    }

    @Nullable
    public final String getGoogleAccount() {
        return this.userPreferences.getString(this.GOOGLE_ACCOUNT, "");
    }

    @Nullable
    public final String getGoogleToken() {
        return this.userPreferences.getString(this.GOOGLE_TOKEN, "");
    }

    public final void setUserName(@Nullable String str) {
        this.userPreferences.edit().putString(this.USER_NAME, str).apply();
    }

    public final void setLastUserName(@Nullable String str) {
        this.userPreferences.edit().putString(this.LAST_USER_NAME, str).apply();
    }

    public final void setPassword(@Nullable String str) {
        this.userPreferences.edit().putString(this.PASSWORD, str).apply();
    }

    public final void setSecretKey(@Nullable String str) {
        this.userPreferences.edit().putString(this.SECRET_KEY, str).apply();
    }

    public final void setClientID(@Nullable String str) {
        this.userPreferences.edit().putString(this.CLIENT_ID, str).apply();
    }

    public final void setUserType(@Nullable String str) {
        this.userPreferences.edit().putString(this.USER_TYPE, str).apply();
    }

    public final void setSchoolName(@Nullable String str) {
        this.userPreferences.edit().putString(this.SCHOOL_NAME, str).apply();
    }

    public final void setGoogleAccount(@Nullable String str) {
        this.userPreferences.edit().putString(this.GOOGLE_ACCOUNT, str).apply();
    }

    public final void setGoogleToken(@Nullable String str) {
        this.userPreferences.edit().putString(this.GOOGLE_TOKEN, str).apply();
    }

    public final void deleteAll() {
        setUserType(null);
        setUserName(null);
        setPassword(null);
        setSecretKey(null);
        setClientID(null);
        setGoogleAccount(null);
        setGoogleToken(null);
    }
}
