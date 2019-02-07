package com.aeries.mobileportal;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.aeries.mobileportal.dagger.components.DaggerPSPComponent;
import com.aeries.mobileportal.dagger.components.PSPComponent;
import com.aeries.mobileportal.dagger.modules.ContextModule;
import com.aeries.mobileportal.dagger.modules.ImageModule;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.utils.RealmManager;
import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;
import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/PSPApplication;", "Landroid/support/multidex/MultiDexApplication;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/PSPComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/PSPComponent;", "setComponent", "(Lcom/aeries/mobileportal/dagger/components/PSPComponent;)V", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "setTokenRepository", "(Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;)V", "onCreate", "", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PSPApplication.kt */
public class PSPApplication extends MultiDexApplication {
    public static final Companion Companion = new Companion();
    @NotNull
    public PSPComponent component;
    @Inject
    @NotNull
    public TokenRepository tokenRepository;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/PSPApplication$Companion;", "", "()V", "get", "Lcom/aeries/mobileportal/dagger/components/PSPComponent;", "activity", "Landroid/app/Activity;", "service", "Landroid/app/Service;", "fragment", "Landroid/support/v4/app/Fragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PSPApplication.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PSPComponent get(@NotNull Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            activity = activity.getApplication();
            if (activity != null) {
                return ((PSPApplication) activity).getComponent();
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.PSPApplication");
        }

        @NotNull
        public final PSPComponent get(@NotNull Fragment fragment) {
            Intrinsics.checkParameterIsNotNull(fragment, "fragment");
            fragment = fragment.getActivity();
            Intrinsics.checkExpressionValueIsNotNull(fragment, "fragment.activity");
            fragment = fragment.getApplication();
            if (fragment != null) {
                return ((PSPApplication) fragment).getComponent();
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.PSPApplication");
        }

        @NotNull
        public final PSPComponent get(@NotNull Service service) {
            Intrinsics.checkParameterIsNotNull(service, NotificationCompat.CATEGORY_SERVICE);
            service = service.getApplication();
            if (service != null) {
                return ((PSPApplication) service).getComponent();
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.PSPApplication");
        }
    }

    @NotNull
    public final PSPComponent getComponent() {
        PSPComponent pSPComponent = this.component;
        if (pSPComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return pSPComponent;
    }

    public final void setComponent(@NotNull PSPComponent pSPComponent) {
        Intrinsics.checkParameterIsNotNull(pSPComponent, "<set-?>");
        this.component = pSPComponent;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        TokenRepository tokenRepository = this.tokenRepository;
        if (tokenRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenRepository");
        }
        return tokenRepository;
    }

    public final void setTokenRepository(@NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "<set-?>");
        this.tokenRepository = tokenRepository;
    }

    public void onCreate() {
        Context context = this;
        PSPComponent build = DaggerPSPComponent.builder().contextModule(new ContextModule(context)).imageModule(new ImageModule(context)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "DaggerPSPComponent.build…\n                .build()");
        this.component = build;
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Stetho.initializeWithDefaults(context);
        PSPComponent pSPComponent = this.component;
        if (pSPComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        pSPComponent.inject(this);
        Fabric.with(context, new Crashlytics());
        new RealmManager(context).initRealm();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = getSystemService("window");
        if (systemService != null) {
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            AppConstants.Companion.setScreenRes(displayMetrics);
            Stetho.initialize(Stetho.newInitializerBuilder(context).enableDumpapp(Stetho.defaultDumperPluginsProvider(context)).enableWebKitInspector(RealmInspectorModulesProvider.builder(context).withLimit(1000000).build()).build());
            Builder builder = new Builder(context);
            builder.listener(PSPApplication$onCreate$1.INSTANCE);
            Picasso build2 = builder.build();
            build2.setIndicatorsEnabled(true);
            Intrinsics.checkExpressionValueIsNotNull(build2, "picasso");
            build2.setLoggingEnabled(true);
            Picasso.setSingletonInstance(build2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
