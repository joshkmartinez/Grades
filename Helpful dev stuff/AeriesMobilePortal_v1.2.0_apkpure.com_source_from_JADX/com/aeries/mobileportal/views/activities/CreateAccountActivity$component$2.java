package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.CreateAccountComponent;
import com.aeries.mobileportal.dagger.components.DaggerCreateAccountComponent;
import com.aeries.mobileportal.dagger.modules.CreateAccountPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/CreateAccountComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: CreateAccountActivity.kt */
final class CreateAccountActivity$component$2 extends Lambda implements Function0<CreateAccountComponent> {
    final /* synthetic */ CreateAccountActivity this$0;

    CreateAccountActivity$component$2(CreateAccountActivity createAccountActivity) {
        this.this$0 = createAccountActivity;
        super(0);
    }

    public final CreateAccountComponent invoke() {
        return DaggerCreateAccountComponent.builder().pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).createAccountPresenterModule(new CreateAccountPresenterModule(this.this$0)).build();
    }
}
