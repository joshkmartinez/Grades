package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.SchoolListAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_SchoolSearchFragmentInteractorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_GsonFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_LoggingInterceptorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_OkHttpClientFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchFragmentModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchFragmentModule_SchoolListAdapterFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchFragmentModule_SchoolSearchFragmentPresenterFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule_SchoolSearchRetrofitFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule_SchoolSearchServiceFactory;
import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment_MembersInjector;
import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import com.google.gson.Gson;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class DaggerSchoolSearchFragmentComponent implements SchoolSearchFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<Gson> gsonProvider;
    private Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private Provider<OkHttpClient> okHttpClientProvider;
    private Provider<SchoolListAdapter> schoolListAdapterProvider;
    private Provider<SchoolSearchFragmentInteractor> schoolSearchFragmentInteractorProvider;
    private MembersInjector<SchoolSearchFragment> schoolSearchFragmentMembersInjector;
    private Provider<SchoolSearchFragmentPresenter> schoolSearchFragmentPresenterProvider;
    private Provider<Retrofit> schoolSearchRetrofitProvider;
    private Provider<SchoolSearchService> schoolSearchServiceProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private NetworkUtilsSchoolModule networkUtilsSchoolModule;
        private PSPComponent pSPComponent;
        private SchoolSearchFragmentModule schoolSearchFragmentModule;
        private SchoolSearchNetworkModule schoolSearchNetworkModule;

        private Builder() {
        }

        public SchoolSearchFragmentComponent build() {
            if (this.schoolSearchFragmentModule != null) {
                if (this.networkUtilsSchoolModule == null) {
                    this.networkUtilsSchoolModule = new NetworkUtilsSchoolModule();
                }
                if (this.schoolSearchNetworkModule == null) {
                    this.schoolSearchNetworkModule = new SchoolSearchNetworkModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerSchoolSearchFragmentComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(SchoolSearchFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder schoolSearchFragmentModule(SchoolSearchFragmentModule schoolSearchFragmentModule) {
            this.schoolSearchFragmentModule = (SchoolSearchFragmentModule) Preconditions.checkNotNull(schoolSearchFragmentModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder schoolSearchNetworkModule(SchoolSearchNetworkModule schoolSearchNetworkModule) {
            this.schoolSearchNetworkModule = (SchoolSearchNetworkModule) Preconditions.checkNotNull(schoolSearchNetworkModule);
            return this;
        }

        public Builder networkUtilsSchoolModule(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
            this.networkUtilsSchoolModule = (NetworkUtilsSchoolModule) Preconditions.checkNotNull(networkUtilsSchoolModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private DaggerSchoolSearchFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.schoolListAdapterProvider = DoubleCheck.provider(SchoolSearchFragmentModule_SchoolListAdapterFactory.create(builder.schoolSearchFragmentModule));
        this.gsonProvider = NetworkUtilsSchoolModule_GsonFactory.create(builder.networkUtilsSchoolModule);
        this.loggingInterceptorProvider = NetworkUtilsSchoolModule_LoggingInterceptorFactory.create(builder.networkUtilsSchoolModule);
        this.okHttpClientProvider = NetworkUtilsSchoolModule_OkHttpClientFactory.create(builder.networkUtilsSchoolModule, this.loggingInterceptorProvider);
        this.schoolSearchRetrofitProvider = SchoolSearchNetworkModule_SchoolSearchRetrofitFactory.create(builder.schoolSearchNetworkModule, this.gsonProvider, this.okHttpClientProvider);
        this.schoolSearchServiceProvider = SchoolSearchNetworkModule_SchoolSearchServiceFactory.create(builder.schoolSearchNetworkModule, this.schoolSearchRetrofitProvider);
        this.schoolSearchFragmentInteractorProvider = DoubleCheck.provider(InteractorModule_SchoolSearchFragmentInteractorFactory.create(builder.interactorModule, this.schoolSearchServiceProvider));
        this.schoolSearchFragmentPresenterProvider = DoubleCheck.provider(SchoolSearchFragmentModule_SchoolSearchFragmentPresenterFactory.create(builder.schoolSearchFragmentModule, this.schoolSearchFragmentInteractorProvider));
        this.schoolSearchFragmentMembersInjector = SchoolSearchFragment_MembersInjector.create(this.schoolListAdapterProvider, this.schoolSearchFragmentPresenterProvider);
    }

    public void inject(SchoolSearchFragment schoolSearchFragment) {
        this.schoolSearchFragmentMembersInjector.injectMembers(schoolSearchFragment);
    }
}
