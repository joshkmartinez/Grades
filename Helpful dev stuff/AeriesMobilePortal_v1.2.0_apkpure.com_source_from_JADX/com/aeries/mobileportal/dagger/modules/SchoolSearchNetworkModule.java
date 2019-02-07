package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.qualifiers.SchoolSearch;
import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SchoolSearchNetworkModule;", "", "()V", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationStartupService;", "retrofit", "Lretrofit2/Retrofit;", "schoolSearchRetrofit", "gson", "Lcom/google/gson/Gson;", "okHttpClient", "Lokhttp3/OkHttpClient;", "schoolSearchService", "Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module(includes = {NetworkUtilsSchoolModule.class})
/* compiled from: SchoolSearchNetworkModule.kt */
public final class SchoolSearchNetworkModule {
    @NotNull
    @SchoolSearch
    @Provides
    public final Retrofit schoolSearchRetrofit(@NotNull Gson gson, @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        gson = new Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).baseUrl("https://ping.aeries.com/api/v1/").build();
        Intrinsics.checkExpressionValueIsNotNull(gson, "Retrofit.Builder()\n     …\n                .build()");
        return gson;
    }

    @NotNull
    @Provides
    public final SchoolSearchService schoolSearchService(@NotNull @SchoolSearch Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        retrofit = retrofit.create(SchoolSearchService.class);
        Intrinsics.checkExpressionValueIsNotNull(retrofit, "retrofit.create(SchoolSearchService::class.java)");
        return (SchoolSearchService) retrofit;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ApplicationStartupService applicationService(@NotNull @SchoolSearch Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        retrofit = retrofit.create(ApplicationStartupService.class);
        Intrinsics.checkExpressionValueIsNotNull(retrofit, "retrofit.create(Applicat…artupService::class.java)");
        return (ApplicationStartupService) retrofit;
    }
}
