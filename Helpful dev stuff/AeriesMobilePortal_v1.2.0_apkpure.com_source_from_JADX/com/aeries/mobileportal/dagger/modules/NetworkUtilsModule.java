package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.dagger.qualifiers.Analytics;
import com.aeries.mobileportal.dagger.qualifiers.TokenRefresh;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.PSPTokenAuthenticator;
import com.aeries.mobileportal.web_services.TokenManager;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¨\u0006 "}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/NetworkUtilsModule;", "", "()V", "analyticsOkHttpClient", "Lokhttp3/OkHttpClient;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "cookieJar", "Lokhttp3/CookieJar;", "analyticsRetrofit", "Lretrofit2/Retrofit;", "gson", "Lcom/google/gson/Gson;", "converterFactory", "Lretrofit2/Converter$Factory;", "okHttpClient", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "retrofit", "authenticator", "Lcom/aeries/mobileportal/web_services/PSPTokenAuthenticator;", "tokenManager", "Lcom/aeries/mobileportal/web_services/TokenManager;", "context", "Landroid/content/Context;", "pspTokenAuthenticator", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module(includes = {ContextModule.class})
/* compiled from: NetworkUtilsModule.kt */
public final class NetworkUtilsModule {
    @NotNull
    @PSPApplicationScope
    @Provides
    public final Gson gson() {
        Gson create = new GsonBuilder().setExclusionStrategies(new NetworkUtilsModule$gson$1()).excludeFieldsWithoutExposeAnnotation().setLenient().create();
        Intrinsics.checkExpressionValueIsNotNull(create, "GsonBuilder().setExclusi…                .create()");
        return create;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final OkHttpClient okHttpClient(@NotNull HttpLoggingInterceptor httpLoggingInterceptor, @NotNull PSPTokenAuthenticator pSPTokenAuthenticator, @NotNull CookieJar cookieJar) {
        Intrinsics.checkParameterIsNotNull(httpLoggingInterceptor, "loggingInterceptor");
        Intrinsics.checkParameterIsNotNull(pSPTokenAuthenticator, "pspTokenAuthenticator");
        Intrinsics.checkParameterIsNotNull(cookieJar, "cookieJar");
        httpLoggingInterceptor = new Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).authenticator(pSPTokenAuthenticator).cookieJar(cookieJar).build();
        Intrinsics.checkExpressionValueIsNotNull(httpLoggingInterceptor, "builder.build()");
        return httpLoggingInterceptor;
    }

    @Analytics
    @PSPApplicationScope
    @NotNull
    @Provides
    public final OkHttpClient analyticsOkHttpClient(@NotNull HttpLoggingInterceptor httpLoggingInterceptor, @NotNull CookieJar cookieJar) {
        Intrinsics.checkParameterIsNotNull(httpLoggingInterceptor, "loggingInterceptor");
        Intrinsics.checkParameterIsNotNull(cookieJar, "cookieJar");
        httpLoggingInterceptor = new Builder().connectTimeout(70, TimeUnit.SECONDS).readTimeout(70, TimeUnit.SECONDS).cookieJar(cookieJar).build();
        Intrinsics.checkExpressionValueIsNotNull(httpLoggingInterceptor, "builder.build()");
        return httpLoggingInterceptor;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(Level.BODY);
        return httpLoggingInterceptor;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final PSPTokenAuthenticator authenticator(@NotNull TokenManager tokenManager) {
        Intrinsics.checkParameterIsNotNull(tokenManager, "tokenManager");
        return new PSPTokenAuthenticator(tokenManager);
    }

    @NotNull
    @TokenRefresh
    @Provides
    public final Retrofit retrofit(@NotNull Gson gson, @NotNull NetworkRepo networkRepo, @NotNull Factory factory) {
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(factory, "converterFactory");
        gson = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(factory).addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(networkRepo.getCurrentBaseURL()).build();
        Intrinsics.checkExpressionValueIsNotNull(gson, "Retrofit.Builder()\n     …\n                .build()");
        return gson;
    }

    @NotNull
    @Analytics
    @Provides
    public final Retrofit analyticsRetrofit(@NotNull Gson gson, @NotNull Factory factory, @NotNull @Analytics OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        Intrinsics.checkParameterIsNotNull(factory, "converterFactory");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        gson = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(factory).addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).baseUrl(AppConstants.Companion.getANALYTICS_URL()).build();
        Intrinsics.checkExpressionValueIsNotNull(gson, "Retrofit.Builder()\n     …\n                .build()");
        return gson;
    }

    @NotNull
    @Provides
    public final AnalyticsService analyticsService(@NotNull @Analytics Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        retrofit = retrofit.create(AnalyticsService.class);
        Intrinsics.checkExpressionValueIsNotNull(retrofit, "retrofit.create(AnalyticsService::class.java)");
        return (AnalyticsService) retrofit;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final Factory converterFactory() {
        return new NetworkUtilsModule$converterFactory$1();
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final TokenManager tokenManager(@NotNull UserRepository userRepository, @NotNull TokenProvider tokenProvider, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new TokenManager(userRepository, tokenProvider, context);
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final CookieJar cookieJar(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
    }
}
