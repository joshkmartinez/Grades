package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.DemographicsAdapter;
import com.aeries.mobileportal.dagger.modules.DemographicsAdapterModule;
import com.aeries.mobileportal.dagger.modules.DemographicsAdapterModule_DemographicsAdapterFactory;
import com.aeries.mobileportal.views.fragments.DemographicsFragment;
import com.aeries.mobileportal.views.fragments.DemographicsFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerDemographicsFragmentComponent implements DemographicsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<DemographicsAdapter> demographicsAdapterProvider;
    private MembersInjector<DemographicsFragment> demographicsFragmentMembersInjector;

    public static final class Builder {
        private DemographicsAdapterModule demographicsAdapterModule;

        private Builder() {
        }

        public DemographicsFragmentComponent build() {
            if (this.demographicsAdapterModule != null) {
                return new DaggerDemographicsFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DemographicsAdapterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder demographicsAdapterModule(DemographicsAdapterModule demographicsAdapterModule) {
            this.demographicsAdapterModule = (DemographicsAdapterModule) Preconditions.checkNotNull(demographicsAdapterModule);
            return this;
        }
    }

    private DaggerDemographicsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.demographicsAdapterProvider = DoubleCheck.provider(DemographicsAdapterModule_DemographicsAdapterFactory.create(builder.demographicsAdapterModule));
        this.demographicsFragmentMembersInjector = DemographicsFragment_MembersInjector.create(this.demographicsAdapterProvider);
    }

    public void inject(DemographicsFragment demographicsFragment) {
        this.demographicsFragmentMembersInjector.injectMembers(demographicsFragment);
    }
}
