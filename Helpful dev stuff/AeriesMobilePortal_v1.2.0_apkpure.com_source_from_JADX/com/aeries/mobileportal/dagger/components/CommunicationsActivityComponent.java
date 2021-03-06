package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.CommunicationsPresenterModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.views.activities.CommunicationsActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/dagger/components/CommunicationsActivityComponent;", "", "inject", "", "activity", "Lcom/aeries/mobileportal/views/activities/CommunicationsActivity;", "app_release"}, k = 1, mv = {1, 1, 10})
@Component(dependencies = {PSPComponent.class}, modules = {InteractorModule.class, CommunicationsPresenterModule.class, RepoModule.class})
@ActivityScope
/* compiled from: CommunicationsActivityComponent.kt */
public interface CommunicationsActivityComponent {
    void inject(@NotNull CommunicationsActivity communicationsActivity);
}
