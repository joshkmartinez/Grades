package com.aeries.mobileportal.interactors.school.select;

import com.aeries.mobileportal.models.School;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchCallback;", "", "onAppAvailable", "", "onAppAvailableError", "e", "", "onAppNotAvailable", "message", "", "onError", "throwable", "onPermissionsError", "onPermissionsFail", "onPermissionsRetrieved", "onSchoolsFound", "schools", "", "Lcom/aeries/mobileportal/models/School;", "onURLStored", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchCallback.kt */
public interface SchoolSearchCallback {
    void onAppAvailable();

    void onAppAvailableError(@NotNull Throwable th);

    void onAppNotAvailable(@NotNull String str);

    void onError(@Nullable Throwable th);

    void onPermissionsError(@NotNull Throwable th);

    void onPermissionsFail();

    void onPermissionsRetrieved();

    void onSchoolsFound(@Nullable List<? extends School> list);

    void onURLStored();
}
