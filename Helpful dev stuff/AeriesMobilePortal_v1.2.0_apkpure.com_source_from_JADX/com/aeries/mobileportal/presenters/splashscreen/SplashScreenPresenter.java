package com.aeries.mobileportal.presenters.splashscreen;

import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.splash_screen.SplashScreenViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/presenters/splashscreen/SplashScreenPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;", "splashScreenViewModel", "splashScreenInteractor", "Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;)V", "getSplashScreenInteractor", "()Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;", "onCreate", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SplashScreenPresenter.kt */
public final class SplashScreenPresenter extends BasePresenter<SplashScreenViewModel> {
    @NotNull
    private final SplashScreenInteractor splashScreenInteractor;

    public SplashScreenPresenter(@NotNull SplashScreenViewModel splashScreenViewModel, @NotNull SplashScreenInteractor splashScreenInteractor) {
        Intrinsics.checkParameterIsNotNull(splashScreenViewModel, "splashScreenViewModel");
        Intrinsics.checkParameterIsNotNull(splashScreenInteractor, "splashScreenInteractor");
        super(splashScreenViewModel, splashScreenInteractor);
        this.splashScreenInteractor = splashScreenInteractor;
    }

    @NotNull
    public final SplashScreenInteractor getSplashScreenInteractor() {
        return this.splashScreenInteractor;
    }

    public void onCreate() {
        this.splashScreenInteractor.sendAnalytics();
    }
}
