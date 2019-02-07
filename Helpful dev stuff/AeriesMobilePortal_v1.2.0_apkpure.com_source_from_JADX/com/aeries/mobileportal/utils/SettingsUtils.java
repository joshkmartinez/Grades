package com.aeries.mobileportal.utils;

import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/SettingsUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsUtils.kt */
public final class SettingsUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/utils/SettingsUtils$Companion;", "", "()V", "getSettings", "Ljava/util/ArrayList;", "", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "schoolRealmRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SettingsUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ArrayList<String> getSettings(@NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo) {
            Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
            Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRealmRepo");
            ArrayList<String> arrayListOf = CollectionsKt.arrayListOf(new String[]{""});
            arrayListOf.addAll(CollectionsKt.sortedWith(configurationRepository.getAccountSettings(), new SettingsUtils$Companion$getSettings$$inlined$sortedBy$1()));
            arrayListOf.add("");
            if (schoolRepo.getSchools().size() > 1) {
                arrayListOf.addAll(AppConstants.Companion.getDISTRICT_SETTINGS());
            } else {
                arrayListOf.addAll(AppConstants.Companion.getDISTRICT_SETTINGS_ONE_DISTRICT());
            }
            arrayListOf.add("");
            arrayListOf.addAll(AppConstants.Companion.getABOUT_SETTINGS());
            return arrayListOf;
        }
    }
}
