package com.aeries.mobileportal.interactors.report_cards;

import android.content.Context;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "reportCardService", "Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "context", "Landroid/content/Context;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/web_services/TokenProvider;Lcom/aeries/mobileportal/web_services/services/ReportCardService;Landroid/content/Context;)V", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getContext", "()Landroid/content/Context;", "getReportCardService", "()Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "downloadReport", "", "reportCard", "Lcom/aeries/mobileportal/models/ReportCard;", "isEnglish", "", "callback", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentCallback;", "getReports", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentInteractor.kt */
public final class ReportCardsFragmentInteractor extends BaseInteractor {
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final ReportCardService reportCardService;
    @NotNull
    private final TokenProvider tokenProvider;

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    @NotNull
    public final ReportCardService getReportCardService() {
        return this.reportCardService;
    }

    public ReportCardsFragmentInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull TokenProvider tokenProvider, @NotNull ReportCardService reportCardService, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(reportCardService, "reportCardService");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.configurationRepository = configurationRepository;
        this.tokenProvider = tokenProvider;
        this.reportCardService = reportCardService;
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void getReports(@NotNull ReportCardsFragmentCallback reportCardsFragmentCallback) {
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentCallback, "callback");
        this.tokenProvider.performAuthCall(new ReportCardsFragmentInteractor$getReports$1(this, reportCardsFragmentCallback));
    }

    public final void downloadReport(@NotNull ReportCard reportCard, boolean z, @NotNull ReportCardsFragmentCallback reportCardsFragmentCallback) {
        Intrinsics.checkParameterIsNotNull(reportCard, "reportCard");
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentCallback, "callback");
        this.tokenProvider.performAuthCall(new ReportCardsFragmentInteractor$downloadReport$1(this, reportCard, z));
    }
}
