package com.aeries.mobileportal.dagger.modules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0000\u0006\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000b\u0010\u0003\u001a\u00020\u0000¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"com/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1", "Lretrofit2/Converter$Factory;", "()V", "converterFactory", "()Lcom/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1;", "responseBodyConverter", "com/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1$responseBodyConverter$1", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lcom/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1$responseBodyConverter$1;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NetworkUtilsModule.kt */
public final class NetworkUtilsModule$converterFactory$1 extends Factory {
    @NotNull
    public final NetworkUtilsModule$converterFactory$1 converterFactory() {
        return this;
    }

    NetworkUtilsModule$converterFactory$1() {
    }

    @NotNull
    public NetworkUtilsModule$converterFactory$1$responseBodyConverter$1 responseBodyConverter(@Nullable Type type, @Nullable Annotation[] annotationArr, @NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        return new NetworkUtilsModule$converterFactory$1$responseBodyConverter$1(this, retrofit, type, annotationArr);
    }
}
