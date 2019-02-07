package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.utils.ImageLoader;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ImageModule_ImageLoaderFactory implements Factory<ImageLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ImageModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<Picasso> picassoProvider;

    public ImageModule_ImageLoaderFactory(ImageModule imageModule, Provider<NetworkRepo> provider, Provider<Picasso> provider2) {
        this.module = imageModule;
        this.networkRepositoryProvider = provider;
        this.picassoProvider = provider2;
    }

    public ImageLoader get() {
        return (ImageLoader) Preconditions.checkNotNull(this.module.imageLoader((NetworkRepo) this.networkRepositoryProvider.get(), (Picasso) this.picassoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ImageLoader> create(ImageModule imageModule, Provider<NetworkRepo> provider, Provider<Picasso> provider2) {
        return new ImageModule_ImageLoaderFactory(imageModule, provider, provider2);
    }
}
