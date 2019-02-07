package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.presenters.splashscreen.SplashScreenPresenter;
import com.aeries.mobileportal.views.viewmodels.splash_screen.SplashScreenViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SplashScreenPresenterModule;", "", "splashScreenViewModel", "Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;)V", "getSplashScreenViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;", "splashScreenPresenter", "Lcom/aeries/mobileportal/presenters/splashscreen/SplashScreenPresenter;", "splashScreenInteractor", "Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SplashScreenPresenterModule.kt */
public final class SplashScreenPresenterModule {
    @NotNull
    private final SplashScreenViewModel splashScreenViewModel;

    public SplashScreenPresenterModule(@NotNull SplashScreenViewModel splashScreenViewModel) {
        Intrinsics.checkParameterIsNotNull(splashScreenViewModel, "splashScreenViewModel");
        this.splashScreenViewModel = splashScreenViewModel;
    }

    @NotNull
    public final SplashScreenViewModel getSplashScreenViewModel() {
        return this.splashScreenViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SplashScreenPresenter splashScreenPresenter(@NotNull SplashScreenInteractor splashScreenInteractor) {
        Intrinsics.checkParameterIsNotNull(splashScreenInteractor, "splashScreenInteractor");
        return new SplashScreenPresenter(this.splashScreenViewModel, splashScreenInteractor);
    }
}
