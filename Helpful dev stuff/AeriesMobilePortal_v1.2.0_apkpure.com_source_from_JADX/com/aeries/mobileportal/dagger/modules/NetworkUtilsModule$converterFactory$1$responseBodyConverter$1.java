package com.aeries.mobileportal.dagger.modules;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016RE\u0010\u0005\u001a6\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0006*\u001a\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"com/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1$responseBodyConverter$1", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "", "(Lcom/aeries/mobileportal/dagger/modules/NetworkUtilsModule$converterFactory$1;Lretrofit2/Retrofit;Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;)V", "delegate", "kotlin.jvm.PlatformType", "getDelegate", "()Lretrofit2/Converter;", "convert", "value", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NetworkUtilsModule.kt */
public final class NetworkUtilsModule$converterFactory$1$responseBodyConverter$1 implements Converter<ResponseBody, Object> {
    final /* synthetic */ Annotation[] $annotations;
    final /* synthetic */ Retrofit $retrofit;
    final /* synthetic */ Type $type;
    private final Converter<ResponseBody, Object> delegate;
    final /* synthetic */ NetworkUtilsModule$converterFactory$1 this$0;

    NetworkUtilsModule$converterFactory$1$responseBodyConverter$1(NetworkUtilsModule$converterFactory$1 networkUtilsModule$converterFactory$1, Retrofit retrofit, Type type, Annotation[] annotationArr) {
        this.this$0 = networkUtilsModule$converterFactory$1;
        this.$retrofit = retrofit;
        this.$type = type;
        this.$annotations = annotationArr;
        this.delegate = retrofit.nextResponseBodyConverter(networkUtilsModule$converterFactory$1.converterFactory(), type, annotationArr);
    }

    public final Converter<ResponseBody, Object> getDelegate() {
        return this.delegate;
    }

    @Nullable
    public Object convert(@NotNull ResponseBody responseBody) {
        Intrinsics.checkParameterIsNotNull(responseBody, Param.VALUE);
        return responseBody.contentLength() != 0 ? this.delegate.convert(responseBody) : null;
    }
}
