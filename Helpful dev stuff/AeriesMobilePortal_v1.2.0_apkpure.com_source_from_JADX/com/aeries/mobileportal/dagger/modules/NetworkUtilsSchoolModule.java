package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/NetworkUtilsSchoolModule;", "", "()V", "gson", "Lcom/google/gson/Gson;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: NetworkUtilsSchoolModule.kt */
public final class NetworkUtilsSchoolModule {
    @NotNull
    @Provides
    public final Gson gson() {
        Gson create = new GsonBuilder().setExclusionStrategies(new NetworkUtilsSchoolModule$gson$1()).create();
        Intrinsics.checkExpressionValueIsNotNull(create, "GsonBuilder().setExclusi…    }\n        }).create()");
        return create;
    }

    @NotNull
    @Provides
    public final OkHttpClient okHttpClient(@NotNull HttpLoggingInterceptor httpLoggingInterceptor) {
        Intrinsics.checkParameterIsNotNull(httpLoggingInterceptor, "loggingInterceptor");
        httpLoggingInterceptor = new Builder().build();
        Intrinsics.checkExpressionValueIsNotNull(httpLoggingInterceptor, "builder.build()");
        return httpLoggingInterceptor;
    }

    @NotNull
    @Provides
    public final HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(Level.BODY);
        return httpLoggingInterceptor;
    }
}
