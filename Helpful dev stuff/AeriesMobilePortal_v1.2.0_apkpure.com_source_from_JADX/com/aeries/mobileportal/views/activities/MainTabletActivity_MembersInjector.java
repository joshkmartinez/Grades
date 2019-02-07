package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.tablet.MainTabletPresenter;
import com.aeries.mobileportal.utils.ImageLoader;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainTabletActivity_MembersInjector implements MembersInjector<MainTabletActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ImageLoader> imageLoaderProvider;
    private final Provider<MainTabletPresenter> presenterProvider;

    public MainTabletActivity_MembersInjector(Provider<MainTabletPresenter> provider, Provider<ImageLoader> provider2) {
        this.presenterProvider = provider;
        this.imageLoaderProvider = provider2;
    }

    public static MembersInjector<MainTabletActivity> create(Provider<MainTabletPresenter> provider, Provider<ImageLoader> provider2) {
        return new MainTabletActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(MainTabletActivity mainTabletActivity) {
        if (mainTabletActivity != null) {
            mainTabletActivity.presenter = (MainTabletPresenter) this.presenterProvider.get();
            mainTabletActivity.imageLoader = (ImageLoader) this.imageLoaderProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
