package com.aeries.mobileportal.dagger.modules;

import com.squareup.picasso.OkHttp3Downloader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ImageModule_DownloaderFactory implements Factory<OkHttp3Downloader> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<OkHttpClient> clientProvider;
    private final ImageModule module;

    public ImageModule_DownloaderFactory(ImageModule imageModule, Provider<OkHttpClient> provider) {
        this.module = imageModule;
        this.clientProvider = provider;
    }

    public OkHttp3Downloader get() {
        return (OkHttp3Downloader) Preconditions.checkNotNull(this.module.downloader((OkHttpClient) this.clientProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttp3Downloader> create(ImageModule imageModule, Provider<OkHttpClient> provider) {
        return new ImageModule_DownloaderFactory(imageModule, provider);
    }
}
