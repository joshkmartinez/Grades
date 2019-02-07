package com.aeries.mobileportal.dagger.modules;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ImageModule_PicassoFactory implements Factory<Picasso> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<OkHttp3Downloader> downloaderProvider;
    private final ImageModule module;

    public ImageModule_PicassoFactory(ImageModule imageModule, Provider<OkHttp3Downloader> provider) {
        this.module = imageModule;
        this.downloaderProvider = provider;
    }

    public Picasso get() {
        return (Picasso) Preconditions.checkNotNull(this.module.picasso((OkHttp3Downloader) this.downloaderProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Picasso> create(ImageModule imageModule, Provider<OkHttp3Downloader> provider) {
        return new ImageModule_PicassoFactory(imageModule, provider);
    }
}
