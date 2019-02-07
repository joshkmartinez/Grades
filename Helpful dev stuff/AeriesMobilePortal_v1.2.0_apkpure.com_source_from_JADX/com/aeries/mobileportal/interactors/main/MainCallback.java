package com.aeries.mobileportal.interactors.main;

import com.aeries.mobileportal.models.Restricted;
import com.aeries.mobileportal.models.Student;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/interactors/main/MainCallback;", "", "onAllDeleted", "", "onRestrictedError", "message", "", "onRestrictedFail", "onRestrictedLogout", "onRestrictedNotLogout", "onRestrictionsReceived", "restricted", "Lcom/aeries/mobileportal/models/Restricted;", "localForceLogout", "", "onSelectedStudentRetrieved", "student", "Lcom/aeries/mobileportal/models/Student;", "onTokenInvalidated", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainCallback.kt */
public interface MainCallback {
    void onAllDeleted();

    void onRestrictedError(@NotNull String str);

    void onRestrictedFail(@NotNull String str);

    void onRestrictedLogout(@NotNull String str);

    void onRestrictedNotLogout(@NotNull String str);

    void onRestrictionsReceived(@NotNull Restricted restricted, boolean z);

    void onSelectedStudentRetrieved(@Nullable Student student);

    void onTokenInvalidated();
}
