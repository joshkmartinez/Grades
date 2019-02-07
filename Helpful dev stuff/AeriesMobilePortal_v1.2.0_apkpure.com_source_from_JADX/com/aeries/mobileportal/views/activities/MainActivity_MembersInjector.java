package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.presenters.MainPresenter;
import com.aeries.mobileportal.utils.ImageLoader;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<StudentDetailsAdapter> adapterProvider;
    private final Provider<ImageLoader> imageLoaderProvider;
    private final Provider<MainPresenter> presenterProvider;

    public MainActivity_MembersInjector(Provider<MainPresenter> provider, Provider<ImageLoader> provider2, Provider<StudentDetailsAdapter> provider3) {
        this.presenterProvider = provider;
        this.imageLoaderProvider = provider2;
        this.adapterProvider = provider3;
    }

    public static MembersInjector<MainActivity> create(Provider<MainPresenter> provider, Provider<ImageLoader> provider2, Provider<StudentDetailsAdapter> provider3) {
        return new MainActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(MainActivity mainActivity) {
        if (mainActivity != null) {
            mainActivity.presenter = (MainPresenter) this.presenterProvider.get();
            mainActivity.imageLoader = (ImageLoader) this.imageLoaderProvider.get();
            mainActivity.adapter = (StudentDetailsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
