package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.TokenProvider;
import io.fabric.sdk.android.services.network.HttpRequest;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "kotlin.jvm.PlatformType", "it", "Lokhttp3/Interceptor$Chain;", "intercept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ImageModule.kt */
final class ImageModule$client$1 implements Interceptor {
    final /* synthetic */ TokenProvider $tokenProvider;

    ImageModule$client$1(TokenProvider tokenProvider) {
        this.$tokenProvider = tokenProvider;
    }

    public final Response intercept(Chain chain) {
        return chain.proceed(chain.request().newBuilder().header(HttpRequest.HEADER_AUTHORIZATION, this.$tokenProvider.provideToken()).build());
    }
}
