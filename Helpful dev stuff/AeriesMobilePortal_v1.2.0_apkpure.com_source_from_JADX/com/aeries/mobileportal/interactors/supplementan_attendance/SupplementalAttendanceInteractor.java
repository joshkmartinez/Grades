package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;)V", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getSupplementalAttendanceService", "()Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceInteractor.kt */
public final class SupplementalAttendanceInteractor extends BaseInteractor {
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final SupplementalAttendanceService supplementalAttendanceService;
    @NotNull
    private final TokenRepository tokenRepository;

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final SupplementalAttendanceService getSupplementalAttendanceService() {
        return this.supplementalAttendanceService;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        return this.tokenRepository;
    }

    public SupplementalAttendanceInteractor(@NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull SupplementalAttendanceService supplementalAttendanceService) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceService, "supplementalAttendanceService");
        this.tokenRepository = tokenRepository;
        this.configurationRepository = configurationRepository;
        this.supplementalAttendanceService = supplementalAttendanceService;
    }
}
