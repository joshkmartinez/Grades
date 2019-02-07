package com.aeries.mobileportal.interactors.change_district;

import com.aeries.mobileportal.models.School;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictCallback;", "", "onAppAvailable", "", "school", "Lcom/aeries/mobileportal/models/School;", "onAppAvailableError", "e", "", "onAppNotAvailable", "status", "", "onDistrictDeleted", "onDistrictDeletedError", "onPermissionsError", "onPermissionsFail", "onPermissionsRetrieved", "onSchoolsRetrieved", "schools", "", "onURLChanged", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictCallback.kt */
public interface ChangeDistrictCallback {
    void onAppAvailable(@NotNull School school);

    void onAppAvailableError(@NotNull Throwable th);

    void onAppNotAvailable(@NotNull String str);

    void onDistrictDeleted(@NotNull School school);

    void onDistrictDeletedError();

    void onPermissionsError(@NotNull Throwable th);

    void onPermissionsFail();

    void onPermissionsRetrieved(@NotNull School school);

    void onSchoolsRetrieved(@NotNull List<? extends School> list);

    void onURLChanged();
}
