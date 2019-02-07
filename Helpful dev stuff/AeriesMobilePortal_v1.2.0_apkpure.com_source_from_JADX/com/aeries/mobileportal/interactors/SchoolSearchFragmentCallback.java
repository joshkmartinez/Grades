package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.models.School;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentCallback;", "", "onSchoolsError", "", "e", "", "onSchoolsRetreived", "schools", "", "Lcom/aeries/mobileportal/models/School;", "onSchoolsRetreivedLocation", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragmentCallback.kt */
public interface SchoolSearchFragmentCallback {
    void onSchoolsError(@NotNull Throwable th);

    void onSchoolsRetreived(@NotNull List<? extends School> list);

    void onSchoolsRetreivedLocation(@NotNull List<? extends School> list);
}
