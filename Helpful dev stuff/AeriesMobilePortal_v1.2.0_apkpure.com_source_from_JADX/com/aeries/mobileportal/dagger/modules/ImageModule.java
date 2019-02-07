package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.dagger.qualifiers.ImgLoader;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ImageModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "client", "Lokhttp3/OkHttpClient;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "downloader", "Lcom/squareup/picasso/OkHttp3Downloader;", "imageLoader", "Lcom/aeries/mobileportal/utils/ImageLoader;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "picasso", "Lcom/squareup/picasso/Picasso;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ImageModule.kt */
public final class ImageModule {
    @NotNull
    private final Context context;

    public ImageModule(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final ImageLoader imageLoader(@NotNull NetworkRepo networkRepo, @NotNull Picasso picasso) {
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(picasso, "picasso");
        return new ImageLoader(networkRepo, picasso);
    }

    @PSPApplicationScope
    @NotNull
    @ImgLoader
    @Provides
    public final OkHttpClient client(@NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        tokenProvider = new Builder().addInterceptor(new ImageModule$client$1(tokenProvider)).cache(new Cache(this.context.getCacheDir(), 26214400)).build();
        Intrinsics.checkExpressionValueIsNotNull(tokenProvider, "OkHttpClient.Builder()\n …                 .build()");
        return tokenProvider;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final OkHttp3Downloader downloader(@NotNull @ImgLoader OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        return new OkHttp3Downloader(okHttpClient);
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final Picasso picasso(@NotNull OkHttp3Downloader okHttp3Downloader) {
        Intrinsics.checkParameterIsNotNull(okHttp3Downloader, "downloader");
        okHttp3Downloader = new Picasso.Builder(this.context).downloader(okHttp3Downloader).loggingEnabled(true).build();
        Intrinsics.checkExpressionValueIsNotNull(okHttp3Downloader, "Picasso.Builder(context)…rue)\n            .build()");
        return okHttp3Downloader;
    }
}
