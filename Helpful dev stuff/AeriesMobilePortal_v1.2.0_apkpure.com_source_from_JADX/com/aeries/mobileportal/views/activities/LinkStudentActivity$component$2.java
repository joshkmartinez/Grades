package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerLinkStudentActivityComponent;
import com.aeries.mobileportal.dagger.components.LinkStudentActivityComponent;
import com.aeries.mobileportal.dagger.modules.LinkStudentPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/LinkStudentActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: LinkStudentActivity.kt */
final class LinkStudentActivity$component$2 extends Lambda implements Function0<LinkStudentActivityComponent> {
    final /* synthetic */ LinkStudentActivity this$0;

    LinkStudentActivity$component$2(LinkStudentActivity linkStudentActivity) {
        this.this$0 = linkStudentActivity;
        super(0);
    }

    public final LinkStudentActivityComponent invoke() {
        return DaggerLinkStudentActivityComponent.builder().linkStudentPresenterModule(new LinkStudentPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
