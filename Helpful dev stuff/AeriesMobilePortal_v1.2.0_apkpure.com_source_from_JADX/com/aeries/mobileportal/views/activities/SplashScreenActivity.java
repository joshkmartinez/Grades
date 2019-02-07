package com.aeries.mobileportal.views.activities;

import android.content.Intent;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.SplashScreenActivityComponent;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.splashscreen.SplashScreenPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.viewmodels.splash_screen.SplashScreenViewModel;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\"\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0002\u0010$J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%H\u0014J\n\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/aeries/mobileportal/views/activities/SplashScreenActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/splash_screen/SplashScreenViewModel;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/SplashScreenActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SplashScreenActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "configurationsRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getConfigurationsRepo", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "setConfigurationsRepo", "(Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;)V", "networkRepo", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "getNetworkRepo", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "setNetworkRepo", "(Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;)V", "presenter", "Lcom/aeries/mobileportal/presenters/splashscreen/SplashScreenPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/splashscreen/SplashScreenPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/splashscreen/SplashScreenPresenter;)V", "tokenRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getTokenRepo", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "setTokenRepo", "(Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "", "onCreate", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SplashScreenActivity.kt */
public final class SplashScreenActivity extends BaseActivity<SplashScreenViewModel> implements SplashScreenViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SplashScreenActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SplashScreenActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SplashScreenActivity$component$2(this));
    @Inject
    @NotNull
    public ConfigurationRepository configurationsRepo;
    @Inject
    @NotNull
    public NetworkRepo networkRepo;
    @Inject
    @NotNull
    public SplashScreenPresenter presenter;
    @Inject
    @NotNull
    public TokenRepository tokenRepo;

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    @NotNull
    public final SplashScreenActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SplashScreenActivityComponent) lazy.getValue();
    }

    @Nullable
    protected Integer getLayout() {
        return null;
    }

    @NotNull
    public final TokenRepository getTokenRepo() {
        TokenRepository tokenRepository = this.tokenRepo;
        if (tokenRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenRepo");
        }
        return tokenRepository;
    }

    public final void setTokenRepo(@NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "<set-?>");
        this.tokenRepo = tokenRepository;
    }

    @NotNull
    public final SplashScreenPresenter m113getPresenter() {
        SplashScreenPresenter splashScreenPresenter = this.presenter;
        if (splashScreenPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return splashScreenPresenter;
    }

    public final void setPresenter(@NotNull SplashScreenPresenter splashScreenPresenter) {
        Intrinsics.checkParameterIsNotNull(splashScreenPresenter, "<set-?>");
        this.presenter = splashScreenPresenter;
    }

    @NotNull
    public final NetworkRepo getNetworkRepo() {
        NetworkRepo networkRepo = this.networkRepo;
        if (networkRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkRepo");
        }
        return networkRepo;
    }

    public final void setNetworkRepo(@NotNull NetworkRepo networkRepo) {
        Intrinsics.checkParameterIsNotNull(networkRepo, "<set-?>");
        this.networkRepo = networkRepo;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationsRepo() {
        ConfigurationRepository configurationRepository = this.configurationsRepo;
        if (configurationRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configurationsRepo");
        }
        return configurationRepository;
    }

    public final void setConfigurationsRepo(@NotNull ConfigurationRepository configurationRepository) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "<set-?>");
        this.configurationsRepo = configurationRepository;
    }

    @Nullable
    protected BasePresenter<SplashScreenViewModel> getPresenter() {
        SplashScreenPresenter splashScreenPresenter = this.presenter;
        if (splashScreenPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return splashScreenPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        Intent intent;
        TokenRepository tokenRepository = this.tokenRepo;
        if (tokenRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenRepo");
        }
        Object accessToken = tokenRepository.getAccessToken();
        NetworkRepo networkRepo = this.networkRepo;
        if (networkRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkRepo");
        }
        Object currentBaseURL = networkRepo.getCurrentBaseURL();
        ConfigurationRepository configurationRepository = this.configurationsRepo;
        if (configurationRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configurationsRepo");
        }
        boolean isLinkingStudent = configurationRepository.isLinkingStudent();
        getResources().getBoolean(C0316R.bool.isTablet);
        if (isLinkingStudent) {
            intent = new Intent(this, LinkStudentActivity.class);
        } else if (Intrinsics.areEqual(currentBaseURL, (Object) "")) {
            intent = new Intent(this, SchoolSearchActivity.class);
        } else if (Intrinsics.areEqual(accessToken, (Object) "")) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
    }
}
