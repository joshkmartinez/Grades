package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter.DetailListener;
import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/MainActivityModule;", "", "detailListener", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;)V", "getDetailListener", "()Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "studentDetailsAdapter", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: MainActivityModule.kt */
public final class MainActivityModule {
    @NotNull
    private final DetailListener detailListener;

    public MainActivityModule(@NotNull DetailListener detailListener) {
        Intrinsics.checkParameterIsNotNull(detailListener, "detailListener");
        this.detailListener = detailListener;
    }

    @NotNull
    public final DetailListener getDetailListener() {
        return this.detailListener;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final StudentDetailsAdapter studentDetailsAdapter() {
        return new StudentDetailsAdapter(this.detailListener);
    }
}
