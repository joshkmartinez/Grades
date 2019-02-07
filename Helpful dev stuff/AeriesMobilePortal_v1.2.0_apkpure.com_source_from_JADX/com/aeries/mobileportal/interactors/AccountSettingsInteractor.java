package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.utils.SettingsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "configRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;)V", "getConfigRepo", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getSettings", "", "callback", "Lcom/aeries/mobileportal/interactors/AccountSettingsCallback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountSettingsInteractor.kt */
public final class AccountSettingsInteractor extends BaseInteractor {
    @NotNull
    private final ConfigurationRepository configRepo;
    @NotNull
    private final SchoolRepo schoolRepo;

    public AccountSettingsInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        this.configRepo = configurationRepository;
        this.schoolRepo = schoolRepo;
    }

    @NotNull
    public final ConfigurationRepository getConfigRepo() {
        return this.configRepo;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    public final void getSettings(@NotNull AccountSettingsCallback accountSettingsCallback) {
        Intrinsics.checkParameterIsNotNull(accountSettingsCallback, "callback");
        accountSettingsCallback.onSettingsRetreived(SettingsUtils.Companion.getSettings(this.configRepo, this.schoolRepo));
    }
}
