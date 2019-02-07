package com.aeries.mobileportal.repos.sharedpreferences;

import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b3\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\b\u0010 \u001a\u0004\u0018\u00010\u0006J\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u001eJ\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u001eJ\u0006\u0010'\u001a\u00020\u001eJ\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0018J\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u0018J\u0006\u00101\u001a\u00020\u0018J\u0006\u00102\u001a\u00020\u0018J\u0006\u00103\u001a\u00020\u0018J\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020\u0018J\u0006\u00106\u001a\u00020\u0018J\u0006\u00107\u001a\u00020\u0018J\u0006\u00108\u001a\u00020\u0018J\u0014\u00109\u001a\u00020\u00182\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aJ\u000e\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u001eJ\u000e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001eJ\u000e\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u001cJ\u000e\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u001eJ\u000e\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u001eJ\u000e\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u001eJ\u000e\u0010H\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u001eJ\u000e\u0010I\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u001eJ\u0010\u0010J\u001a\u00020\u00182\b\u0010K\u001a\u0004\u0018\u00010\u0006J\u000e\u0010L\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u001eJ\u0010\u0010M\u001a\u00020\u00182\b\u0010N\u001a\u0004\u0018\u00010\u0006J\u000e\u0010O\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u001cJ\u000e\u0010P\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006Q"}, d2 = {"Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "", "userPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "ACCOUNT_SETTINGS_SET", "", "CREATE_ACCOUNT_DISABLED", "DEFAULT_STUDENT", "FEEDBACK", "JUST_LOGGED_IN", "LINKING_STUDENT", "MESSAGE_SHOWN", "PARENT_CHANGE_PASSWORD_DISABLED", "PORTAL_VERSION", "PORTAL_VERSION_FORCE_LOGOUT", "RESTRICTED_SECURITY_LOAD", "SCHOOL_CDS", "SELECTED_STUDENT", "SIGNAL_KIT", "STUDENT_CHANGE_PASSWORD_DISABLED", "getUserPreferences", "()Landroid/content/SharedPreferences;", "deleteAll", "", "getAccountSettings", "", "getDefaultStudent", "", "getForceLogoutForPortalVersion", "", "getNonFormattedPortalVersion", "getPortalVersion", "getSelectedSchoolCDS", "getSelectedStudent", "isChangePasswordParentDisabled", "isChangePasswordStudentDisabled", "isCreateAccountDisabled", "isFeedbackEnabled", "isJustLoggedIn", "isLinkingStudent", "isMessageShown", "isRestrictedSecurityLoaded", "isSignalKitEnabled", "removeAccountSettings", "removeCreateAccountDisabled", "removeDefaultStudent", "removeFeedbackEnabled", "removeJustLoggedIn", "removeLinkingStudent", "removeMessageShown", "removeParentChangePasswordDisabled", "removePortalVersion", "removeRestrictedSecurityLoaded", "removeSelectedSchoolCDS", "removeSelectedStudent", "removeSignalKitEnabled", "setAccountSettings", "settings", "setChangePasswordParentDisabled", "parentChangePasswordDisabled", "setChangePasswordStudentDisabled", "setCreateAccountDisabled", "createAccountDisabled", "setDefaultStudent", "defaultStudentCode", "setFeedbackEnabled", "signalKit", "setForceLogoutForPortalVersion", "forcedLogout", "setJustLoggedIn", "b", "setLinkingStudent", "setMessageShown", "setPortalVersion", "portalVersion", "setRestrictedSecurityLoaded", "setSelectedSchoolCDS", "cds", "setSelectedStudent", "setSignalKitEnabled", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ConfigurationRepository.kt */
public class ConfigurationRepository {
    private final String ACCOUNT_SETTINGS_SET = "ACCOUNT_SETTINGS_SET";
    private final String CREATE_ACCOUNT_DISABLED = "CREATE_ACCOUNT_DISABLED";
    private final String DEFAULT_STUDENT = "DEFAULT_STUDENT";
    private final String FEEDBACK = "FEEDBACK";
    private final String JUST_LOGGED_IN = "JUST_LOGGED_IN";
    private final String LINKING_STUDENT = "LINKING_STUDENT";
    private final String MESSAGE_SHOWN = "MESSAGE_SHOWN";
    private final String PARENT_CHANGE_PASSWORD_DISABLED = "PARENT_CHANGE_PASSWORD_DISABLED";
    private final String PORTAL_VERSION = "PORTAL_VERSION";
    private final String PORTAL_VERSION_FORCE_LOGOUT = "PORTAL_VERSION_FORCE_LOGOUT";
    private final String RESTRICTED_SECURITY_LOAD = "RESTRICTED_SECURITY_LOAD";
    private final String SCHOOL_CDS = "SCHOOL_CDS";
    private final String SELECTED_STUDENT = "SELECTED_STUDENT";
    private final String SIGNAL_KIT = "SIGNAL_KIT";
    private final String STUDENT_CHANGE_PASSWORD_DISABLED = "STUDENT_CHANGE_PASSWORD_DISABLED";
    @NotNull
    private final SharedPreferences userPreferences;

    public ConfigurationRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        this.userPreferences = sharedPreferences;
    }

    @NotNull
    public final SharedPreferences getUserPreferences() {
        return this.userPreferences;
    }

    public final int getDefaultStudent() {
        return this.userPreferences.getInt(this.DEFAULT_STUDENT, 0);
    }

    public final void setDefaultStudent(int i) {
        this.userPreferences.edit().putInt(this.DEFAULT_STUDENT, i).apply();
    }

    public final void removeDefaultStudent() {
        this.userPreferences.edit().remove(this.DEFAULT_STUDENT).apply();
    }

    public final int getSelectedStudent() {
        return this.userPreferences.getInt(this.SELECTED_STUDENT, getDefaultStudent());
    }

    public final void setSelectedStudent(int i) {
        this.userPreferences.edit().putInt(this.SELECTED_STUDENT, i).apply();
    }

    public final void removeSelectedStudent() {
        this.userPreferences.edit().remove(this.SELECTED_STUDENT).apply();
    }

    @Nullable
    public final String getSelectedSchoolCDS() {
        return this.userPreferences.getString(this.SCHOOL_CDS, null);
    }

    public final void setSelectedSchoolCDS(@Nullable String str) {
        this.userPreferences.edit().putString(this.SCHOOL_CDS, str).apply();
    }

    public final void removeSelectedSchoolCDS() {
        this.userPreferences.edit().remove(this.SCHOOL_CDS).apply();
    }

    public final boolean isSignalKitEnabled() {
        return this.userPreferences.getBoolean(this.SIGNAL_KIT, false);
    }

    public final void setSignalKitEnabled(boolean z) {
        this.userPreferences.edit().putBoolean(this.SIGNAL_KIT, z).apply();
    }

    public final void removeSignalKitEnabled() {
        this.userPreferences.edit().remove(this.SIGNAL_KIT).apply();
    }

    public final boolean isFeedbackEnabled() {
        return this.userPreferences.getBoolean(this.FEEDBACK, false);
    }

    public final void setFeedbackEnabled(boolean z) {
        this.userPreferences.edit().putBoolean(this.FEEDBACK, z).apply();
    }

    public final void removeFeedbackEnabled() {
        this.userPreferences.edit().remove(this.FEEDBACK).apply();
    }

    public final boolean isCreateAccountDisabled() {
        return this.userPreferences.getBoolean(this.CREATE_ACCOUNT_DISABLED, false);
    }

    public final void setCreateAccountDisabled(boolean z) {
        this.userPreferences.edit().putBoolean(this.CREATE_ACCOUNT_DISABLED, z).apply();
    }

    public final void removeCreateAccountDisabled() {
        this.userPreferences.edit().remove(this.CREATE_ACCOUNT_DISABLED).apply();
    }

    public final boolean isChangePasswordParentDisabled() {
        return this.userPreferences.getBoolean(this.PARENT_CHANGE_PASSWORD_DISABLED, false);
    }

    public final void setChangePasswordParentDisabled(boolean z) {
        this.userPreferences.edit().putBoolean(this.PARENT_CHANGE_PASSWORD_DISABLED, z).apply();
    }

    public final boolean isChangePasswordStudentDisabled() {
        return this.userPreferences.getBoolean(this.STUDENT_CHANGE_PASSWORD_DISABLED, false);
    }

    public final void setChangePasswordStudentDisabled(boolean z) {
        this.userPreferences.edit().putBoolean(this.STUDENT_CHANGE_PASSWORD_DISABLED, z).apply();
    }

    public final void removeParentChangePasswordDisabled() {
        this.userPreferences.edit().remove(this.PARENT_CHANGE_PASSWORD_DISABLED).apply();
    }

    @NotNull
    public final Set<String> getAccountSettings() {
        Set<String> stringSet = this.userPreferences.getStringSet(this.ACCOUNT_SETTINGS_SET, new LinkedHashSet());
        Intrinsics.checkExpressionValueIsNotNull(stringSet, "userPreferences.getStrin…INGS_SET, mutableSetOf())");
        return stringSet;
    }

    public final void setAccountSettings(@NotNull Set<String> set) {
        Intrinsics.checkParameterIsNotNull(set, "settings");
        this.userPreferences.edit().putStringSet(this.ACCOUNT_SETTINGS_SET, set).apply();
    }

    public final void removeAccountSettings() {
        this.userPreferences.edit().remove(this.ACCOUNT_SETTINGS_SET).apply();
    }

    @Nullable
    public final String getPortalVersion() {
        return this.userPreferences.getString(this.PORTAL_VERSION, null);
    }

    @Nullable
    public final String getNonFormattedPortalVersion() {
        String portalVersion = getPortalVersion();
        return portalVersion != null ? StringsKt.replace$default(portalVersion, ".", "", false, 4, null) : null;
    }

    public final void setPortalVersion(@Nullable String str) {
        this.userPreferences.edit().putString(this.PORTAL_VERSION, str).apply();
    }

    public final boolean getForceLogoutForPortalVersion() {
        return this.userPreferences.getBoolean(this.PORTAL_VERSION_FORCE_LOGOUT, true);
    }

    public final void setForceLogoutForPortalVersion(boolean z) {
        this.userPreferences.edit().putBoolean(this.PORTAL_VERSION_FORCE_LOGOUT, z).apply();
    }

    public final void removePortalVersion() {
        this.userPreferences.edit().remove(this.PORTAL_VERSION).apply();
    }

    public final boolean isRestrictedSecurityLoaded() {
        return this.userPreferences.getBoolean(this.RESTRICTED_SECURITY_LOAD, false);
    }

    public final void setRestrictedSecurityLoaded(boolean z) {
        this.userPreferences.edit().putBoolean(this.ACCOUNT_SETTINGS_SET, z).apply();
    }

    public final void removeRestrictedSecurityLoaded() {
        this.userPreferences.edit().remove(this.ACCOUNT_SETTINGS_SET).apply();
    }

    public final boolean isLinkingStudent() {
        return this.userPreferences.getBoolean(this.LINKING_STUDENT, false);
    }

    public final void setLinkingStudent(boolean z) {
        this.userPreferences.edit().putBoolean(this.LINKING_STUDENT, z).apply();
    }

    public final void removeLinkingStudent() {
        this.userPreferences.edit().remove(this.LINKING_STUDENT).apply();
    }

    public final boolean isMessageShown() {
        return this.userPreferences.getBoolean(this.MESSAGE_SHOWN, false);
    }

    public final void setMessageShown(boolean z) {
        this.userPreferences.edit().putBoolean(this.MESSAGE_SHOWN, z).apply();
    }

    public final void removeMessageShown() {
        this.userPreferences.edit().remove(this.MESSAGE_SHOWN).apply();
    }

    public final boolean isJustLoggedIn() {
        return this.userPreferences.getBoolean(this.JUST_LOGGED_IN, false);
    }

    public final void setJustLoggedIn(boolean z) {
        this.userPreferences.edit().putBoolean(this.JUST_LOGGED_IN, z).apply();
    }

    public final void removeJustLoggedIn() {
        this.userPreferences.edit().remove(this.JUST_LOGGED_IN).apply();
    }

    public final void deleteAll() {
        removeDefaultStudent();
        removeSelectedStudent();
        removeSignalKitEnabled();
        removeAccountSettings();
        removeLinkingStudent();
        removeMessageShown();
        removeJustLoggedIn();
        removePortalVersion();
    }
}
