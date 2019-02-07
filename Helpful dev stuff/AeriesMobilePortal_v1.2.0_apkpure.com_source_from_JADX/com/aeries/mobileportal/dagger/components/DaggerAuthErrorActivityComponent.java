package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.AuthErrorPresenterModule;
import com.aeries.mobileportal.dagger.modules.AuthErrorPresenterModule_AuthErrorPresenterFactory;
import com.aeries.mobileportal.dagger.modules.AuthErrorPresenterModule_AuthErrorViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AuthErrorInteractorFactory;
import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.presenters.auth_error.AuthErrorPresenter;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.views.activities.AuthErrorActivity;
import com.aeries.mobileportal.views.activities.AuthErrorActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAuthErrorActivityComponent implements AuthErrorActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<AuthErrorActivity> authErrorActivityMembersInjector;
    private Provider<AuthErrorInteractor> authErrorInteractorProvider;
    private Provider<AuthErrorPresenter> authErrorPresenterProvider;
    private Provider<AuthErrorViewModel> authErrorViewModelProvider;
    private Provider<TokenRepository> tokenRepoProvider;

    public static final class Builder {
        private AuthErrorPresenterModule authErrorPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;

        private Builder() {
        }

        public AuthErrorActivityComponent build() {
            if (this.authErrorPresenterModule != null) {
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerAuthErrorActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(AuthErrorPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder authErrorPresenterModule(AuthErrorPresenterModule authErrorPresenterModule) {
            this.authErrorPresenterModule = (AuthErrorPresenterModule) Preconditions.checkNotNull(authErrorPresenterModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo implements Provider<TokenRepository> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenRepository get() {
            return (TokenRepository) Preconditions.checkNotNull(this.pSPComponent.tokenRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAuthErrorActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.authErrorViewModelProvider = DoubleCheck.provider(AuthErrorPresenterModule_AuthErrorViewModelFactory.create(builder.authErrorPresenterModule));
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.authErrorInteractorProvider = DoubleCheck.provider(InteractorModule_AuthErrorInteractorFactory.create(builder.interactorModule, this.tokenRepoProvider));
        this.authErrorPresenterProvider = DoubleCheck.provider(AuthErrorPresenterModule_AuthErrorPresenterFactory.create(builder.authErrorPresenterModule, this.authErrorViewModelProvider, this.authErrorInteractorProvider));
        this.authErrorActivityMembersInjector = AuthErrorActivity_MembersInjector.create(this.authErrorPresenterProvider);
    }

    public void inject(AuthErrorActivity authErrorActivity) {
        this.authErrorActivityMembersInjector.injectMembers(authErrorActivity);
    }
}
