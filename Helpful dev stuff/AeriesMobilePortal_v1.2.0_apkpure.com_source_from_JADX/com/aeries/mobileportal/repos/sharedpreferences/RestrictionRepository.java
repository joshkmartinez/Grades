package com.aeries.mobileportal.repos.sharedpreferences;

import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "", "restrictionPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "STUDENT_IDS", "", "getRestrictionPreferences", "()Landroid/content/SharedPreferences;", "addStudentID", "", "studentID", "", "deleteStudentRestrictions", "getStudentRestriction", "", "storeStudentRestriction", "restrictedSecurityLoaded", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: RestrictionRepository.kt */
public final class RestrictionRepository {
    private final String STUDENT_IDS = "STUDENT_IDS";
    @NotNull
    private final SharedPreferences restrictionPreferences;

    public RestrictionRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "restrictionPreferences");
        this.restrictionPreferences = sharedPreferences;
    }

    @NotNull
    public final SharedPreferences getRestrictionPreferences() {
        return this.restrictionPreferences;
    }

    public final void deleteStudentRestrictions() {
        for (String remove : this.restrictionPreferences.getStringSet(this.STUDENT_IDS, new LinkedHashSet())) {
            this.restrictionPreferences.edit().remove(remove).apply();
        }
        this.restrictionPreferences.edit().remove(this.STUDENT_IDS).apply();
    }

    public final void storeStudentRestriction(int i, boolean z) {
        this.restrictionPreferences.edit().putBoolean(String.valueOf(i), z).apply();
        addStudentID(i);
    }

    private final void addStudentID(int i) {
        Set stringSet = this.restrictionPreferences.getStringSet(this.STUDENT_IDS, new LinkedHashSet());
        stringSet.add(String.valueOf(i));
        this.restrictionPreferences.edit().putStringSet(this.STUDENT_IDS, stringSet).apply();
    }

    public final boolean getStudentRestriction(int i) {
        return this.restrictionPreferences.getBoolean(String.valueOf(i), false);
    }
}
