package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.SessionsAdapter;
import com.aeries.mobileportal.adapters.SessionsAdapter.SessionsAdapterListener;
import com.aeries.mobileportal.dagger.modules.SessionsAdapterModule;
import com.aeries.mobileportal.dagger.modules.SessionsAdapterModule_SessionsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.SessionsAdapterModule_SessionsAdapterListenerFactory;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerSessionSelectFragmentComponent implements SessionSelectFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<SessionSelectFragment> sessionSelectFragmentMembersInjector;
    private Provider<SessionsAdapterListener> sessionsAdapterListenerProvider;
    private Provider<SessionsAdapter> sessionsAdapterProvider;

    public static final class Builder {
        private SessionsAdapterModule sessionsAdapterModule;

        private Builder() {
        }

        public SessionSelectFragmentComponent build() {
            if (this.sessionsAdapterModule != null) {
                return new DaggerSessionSelectFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SessionsAdapterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder sessionsAdapterModule(SessionsAdapterModule sessionsAdapterModule) {
            this.sessionsAdapterModule = (SessionsAdapterModule) Preconditions.checkNotNull(sessionsAdapterModule);
            return this;
        }
    }

    private DaggerSessionSelectFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.sessionsAdapterListenerProvider = DoubleCheck.provider(SessionsAdapterModule_SessionsAdapterListenerFactory.create(builder.sessionsAdapterModule));
        this.sessionsAdapterProvider = DoubleCheck.provider(SessionsAdapterModule_SessionsAdapterFactory.create(builder.sessionsAdapterModule, this.sessionsAdapterListenerProvider));
        this.sessionSelectFragmentMembersInjector = SessionSelectFragment_MembersInjector.create(this.sessionsAdapterProvider);
    }

    public void inject(SessionSelectFragment sessionSelectFragment) {
        this.sessionSelectFragmentMembersInjector.injectMembers(sessionSelectFragment);
    }
}
