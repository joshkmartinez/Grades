package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerMainActivityComponent;
import com.aeries.mobileportal.dagger.components.MainActivityComponent;
import com.aeries.mobileportal.dagger.modules.MainActivityModule;
import com.aeries.mobileportal.dagger.modules.MainPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/MainActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainActivity.kt */
final class MainActivity$component$2 extends Lambda implements Function0<MainActivityComponent> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$component$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(0);
    }

    public final MainActivityComponent invoke() {
        return DaggerMainActivityComponent.builder().pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).mainActivityModule(new MainActivityModule(this.this$0)).mainPresenterModule(new MainPresenterModule(this.this$0)).build();
    }
}
