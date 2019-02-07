package com.aeries.mobileportal.repos.adapters;

import com.aeries.mobileportal.models.School;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH&¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "", "addSchool", "", "school", "Lcom/aeries/mobileportal/models/School;", "deleteSchool", "cds", "", "getSchool", "getSchools", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolRepo.kt */
public interface SchoolRepo {
    boolean addSchool(@NotNull School school);

    boolean deleteSchool(@Nullable String str);

    @Nullable
    School getSchool(@Nullable String str);

    @NotNull
    List<School> getSchools();
}
