package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.DistrictsAdapter;
import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictsListener;
import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/DistrictsAdapterModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "(Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/DistrictsAdapter$DistrictsListener;", "districtsAdapter", "Lcom/aeries/mobileportal/adapters/DistrictsAdapter;", "districtsListener", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: DistrictsAdapterModule.kt */
public final class DistrictsAdapterModule {
    @NotNull
    private final DistrictsListener listener;

    public DistrictsAdapterModule(@NotNull DistrictsListener districtsListener) {
        Intrinsics.checkParameterIsNotNull(districtsListener, CastExtraArgs.LISTENER);
        this.listener = districtsListener;
    }

    @NotNull
    public final DistrictsListener getListener() {
        return this.listener;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final DistrictsListener districtsListener() {
        return this.listener;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final DistrictsAdapter districtsAdapter(@NotNull DistrictsListener districtsListener) {
        Intrinsics.checkParameterIsNotNull(districtsListener, CastExtraArgs.LISTENER);
        return new DistrictsAdapter(districtsListener);
    }
}
