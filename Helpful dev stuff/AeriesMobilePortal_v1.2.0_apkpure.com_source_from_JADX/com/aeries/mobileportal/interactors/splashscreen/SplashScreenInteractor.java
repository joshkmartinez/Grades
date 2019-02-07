package com.aeries.mobileportal.interactors.splashscreen;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "sendAnalytics", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SplashScreenInteractor.kt */
public final class SplashScreenInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;

    public SplashScreenInteractor(@NotNull AnalyticsService analyticsService) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        this.analyticsService = analyticsService;
    }

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    public final void sendAnalytics() {
        AnalyticsService analyticsService = this.analyticsService;
        String splash_id = AnalyticsScreenNames.Companion.getSPLASH_ID();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getSPLASH_ID());
        Disposable subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, null, null, null, splash_id, stringBuilder.toString(), 0, 0, 0, 0, 0, 0, 0, null, 261375, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(SplashScreenInteractor$sendAnalytics$1.INSTANCE, SplashScreenInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }
}
