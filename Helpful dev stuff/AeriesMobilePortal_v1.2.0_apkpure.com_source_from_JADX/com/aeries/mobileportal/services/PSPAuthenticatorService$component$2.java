package com.aeries.mobileportal.services;

import android.app.Service;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerPSPAuthenticatorServiceComponent;
import com.aeries.mobileportal.dagger.components.PSPAuthenticatorServiceComponent;
import com.aeries.mobileportal.dagger.modules.PSPAuthenticatorModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/PSPAuthenticatorServiceComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: PSPAuthenticatorService.kt */
final class PSPAuthenticatorService$component$2 extends Lambda implements Function0<PSPAuthenticatorServiceComponent> {
    final /* synthetic */ PSPAuthenticatorService this$0;

    PSPAuthenticatorService$component$2(PSPAuthenticatorService pSPAuthenticatorService) {
        this.this$0 = pSPAuthenticatorService;
        super(0);
    }

    public final PSPAuthenticatorServiceComponent invoke() {
        return DaggerPSPAuthenticatorServiceComponent.builder().pSPComponent(PSPApplication.Companion.get((Service) this.this$0)).pSPAuthenticatorModule(new PSPAuthenticatorModule(this.this$0)).build();
    }
}
