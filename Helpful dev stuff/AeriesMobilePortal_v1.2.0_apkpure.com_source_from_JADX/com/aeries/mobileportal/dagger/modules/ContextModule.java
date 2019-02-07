package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ContextModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ContextModule.kt */
public final class ContextModule {
    private final Context mContext;

    public ContextModule(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context.applicationContext");
        this.mContext = context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final Context context() {
        return this.mContext;
    }
}
