package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.TokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ImageModule_ClientFactory implements Factory<OkHttpClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ImageModule module;
    private final Provider<TokenProvider> tokenProvider;

    public ImageModule_ClientFactory(ImageModule imageModule, Provider<TokenProvider> provider) {
        this.module = imageModule;
        this.tokenProvider = provider;
    }

    public OkHttpClient get() {
        return (OkHttpClient) Preconditions.checkNotNull(this.module.client((TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttpClient> create(ImageModule imageModule, Provider<TokenProvider> provider) {
        return new ImageModule_ClientFactory(imageModule, provider);
    }
}
