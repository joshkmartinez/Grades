package com.aeries.mobileportal.views.viewmodels;

import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showError", "", "message", "", "showNearbySchoolProgress", "show", "", "showNearbySchools", "schools", "", "Lcom/aeries/mobileportal/models/School;", "showSchools", "showSearchSchoolProgress", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragmentViewModel.kt */
public interface SchoolSearchFragmentViewModel extends BaseViewModel {
    void showError(@NotNull String str);

    void showNearbySchoolProgress(boolean z);

    void showNearbySchools(@NotNull List<? extends School> list);

    void showSchools(@NotNull List<? extends School> list);

    void showSearchSchoolProgress(boolean z);
}
