package com.aeries.mobileportal.views.viewmodels.change_district;

import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goToLogin", "", "notifyDistrictDeleted", "school", "Lcom/aeries/mobileportal/models/School;", "notifyDistrictDeletedError", "showError", "message", "", "updateDistricts", "districts", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictViewModel.kt */
public interface ChangeDistrictViewModel extends BaseViewModel {
    void goToLogin();

    void notifyDistrictDeleted(@NotNull School school);

    void notifyDistrictDeletedError();

    void showError(@NotNull String str);

    void updateDistricts(@NotNull List<? extends School> list);
}
