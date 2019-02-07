package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import com.aeries.mobileportal.dagger.qualifiers.ConfigurationPreferences;
import com.aeries.mobileportal.dagger.qualifiers.NetworkPreferences;
import com.aeries.mobileportal.dagger.qualifiers.RestrictionPreferences;
import com.aeries.mobileportal.dagger.qualifiers.TokenPreferences;
import com.aeries.mobileportal.dagger.qualifiers.UserPreferences;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.NetworkRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0010H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0015\u001a\u00020\u0010H\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0019\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0015\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u0015\u001a\u00020\u0010H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SharedPreferencesModule;", "", "()V", "CONFIGURATION_PREFERENCES", "", "getCONFIGURATION_PREFERENCES", "()Ljava/lang/String;", "NETWORK_PREFERENCES", "getNETWORK_PREFERENCES", "RESTRICTION_PREFERENCES", "getRESTRICTION_PREFERENCES", "TOKEN_PREFERENCES", "getTOKEN_PREFERENCES", "USER_PREFERENCES", "getUSER_PREFERENCES", "configurationPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "userPreferences", "networkPreferences", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "restrictionPreferences", "restrictionRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "tokenPreferences", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module(includes = {ContextModule.class})
/* compiled from: SharedPreferencesModule.kt */
public final class SharedPreferencesModule {
    @NotNull
    private final String CONFIGURATION_PREFERENCES = "CONFIGURATION_PREFERENCES";
    @NotNull
    private final String NETWORK_PREFERENCES = "NETWORK_PREFERENCES";
    @NotNull
    private final String RESTRICTION_PREFERENCES = "RESTRICTION_PREFERENCES";
    @NotNull
    private final String TOKEN_PREFERENCES = "TOKEN_PREFERENCES";
    @NotNull
    private final String USER_PREFERENCES = "USER_PREFERENCES";

    @NotNull
    public final String getUSER_PREFERENCES() {
        return this.USER_PREFERENCES;
    }

    @NotNull
    public final String getTOKEN_PREFERENCES() {
        return this.TOKEN_PREFERENCES;
    }

    @NotNull
    public final String getNETWORK_PREFERENCES() {
        return this.NETWORK_PREFERENCES;
    }

    @NotNull
    public final String getCONFIGURATION_PREFERENCES() {
        return this.CONFIGURATION_PREFERENCES;
    }

    @NotNull
    public final String getRESTRICTION_PREFERENCES() {
        return this.RESTRICTION_PREFERENCES;
    }

    @PSPApplicationScope
    @NotNull
    @UserPreferences
    @Provides
    public final SharedPreferences userPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getSharedPreferences(this.USER_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(context, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final UserRepository userRepository(@NotNull @UserPreferences SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        return new UserRepository(sharedPreferences);
    }

    @TokenPreferences
    @PSPApplicationScope
    @NotNull
    @Provides
    public final SharedPreferences tokenPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getSharedPreferences(this.TOKEN_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(context, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final TokenRepository tokenRepository(@NotNull @TokenPreferences SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        return new TokenRepository(sharedPreferences);
    }

    @PSPApplicationScope
    @NetworkPreferences
    @NotNull
    @Provides
    public final SharedPreferences networkPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getSharedPreferences(this.NETWORK_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(context, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final NetworkRepo networkRepository(@NotNull @NetworkPreferences SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        return new NetworkRepository(sharedPreferences);
    }

    @ConfigurationPreferences
    @PSPApplicationScope
    @NotNull
    @Provides
    public final SharedPreferences configurationPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getSharedPreferences(this.CONFIGURATION_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(context, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final ConfigurationRepository configurationRepository(@ConfigurationPreferences @NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "userPreferences");
        return new ConfigurationRepository(sharedPreferences);
    }

    @PSPApplicationScope
    @NotNull
    @RestrictionPreferences
    @Provides
    public final SharedPreferences restrictionPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getSharedPreferences(this.RESTRICTION_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(context, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final RestrictionRepository restrictionRepository(@NotNull @RestrictionPreferences SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "restrictionPreferences");
        return new RestrictionRepository(sharedPreferences);
    }
}
