package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.DemographicsAdapter;
import com.aeries.mobileportal.adapters.DemographicsAdapter.DemographicsListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.models.Demographics;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/DemographicsAdapterModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;Lcom/aeries/mobileportal/models/Demographics;)V", "getDemographics", "()Lcom/aeries/mobileportal/models/Demographics;", "getListener", "()Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "demographicsAdapter", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: DemographicsAdapterModule.kt */
public final class DemographicsAdapterModule {
    @NotNull
    private final Demographics demographics;
    @NotNull
    private final DemographicsListener listener;

    public DemographicsAdapterModule(@NotNull DemographicsListener demographicsListener, @NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographicsListener, CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        this.listener = demographicsListener;
        this.demographics = demographics;
    }

    @NotNull
    public final Demographics getDemographics() {
        return this.demographics;
    }

    @NotNull
    public final DemographicsListener getListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final DemographicsAdapter demographicsAdapter() {
        return new DemographicsAdapter(this.listener, this.demographics);
    }
}
