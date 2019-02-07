package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.dagger.components.DaggerSessionSelectFragmentComponent;
import com.aeries.mobileportal.dagger.components.SessionSelectFragmentComponent;
import com.aeries.mobileportal.dagger.modules.SessionsAdapterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/SessionSelectFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SessionSelectFragment.kt */
final class SessionSelectFragment$component$2 extends Lambda implements Function0<SessionSelectFragmentComponent> {
    final /* synthetic */ SessionSelectFragment this$0;

    SessionSelectFragment$component$2(SessionSelectFragment sessionSelectFragment) {
        this.this$0 = sessionSelectFragment;
        super(0);
    }

    public final SessionSelectFragmentComponent invoke() {
        return DaggerSessionSelectFragmentComponent.builder().sessionsAdapterModule(new SessionsAdapterModule(this.this$0)).build();
    }
}
