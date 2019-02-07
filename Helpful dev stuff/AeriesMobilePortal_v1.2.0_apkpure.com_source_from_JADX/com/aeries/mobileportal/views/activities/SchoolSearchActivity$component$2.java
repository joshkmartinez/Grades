package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerSchoolSearchActivityComponent;
import com.aeries.mobileportal.dagger.components.SchoolSearchActivityComponent;
import com.aeries.mobileportal.dagger.modules.SchoolSearchPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/SchoolSearchActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SchoolSearchActivity.kt */
final class SchoolSearchActivity$component$2 extends Lambda implements Function0<SchoolSearchActivityComponent> {
    final /* synthetic */ SchoolSearchActivity this$0;

    SchoolSearchActivity$component$2(SchoolSearchActivity schoolSearchActivity) {
        this.this$0 = schoolSearchActivity;
        super(0);
    }

    public final SchoolSearchActivityComponent invoke() {
        return DaggerSchoolSearchActivityComponent.builder().schoolSearchPresenterModule(new SchoolSearchPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
