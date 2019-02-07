package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.DaggerComponent;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchFragmentModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.views.fragments.SchoolSearchFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/dagger/components/SchoolSearchFragmentComponent;", "Lcom/aeries/mobileportal/dagger/DaggerComponent;", "inject", "", "fragment", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
@FragmentScope
@Component(dependencies = {PSPComponent.class}, modules = {SchoolSearchFragmentModule.class, InteractorModule.class, SchoolSearchNetworkModule.class})
/* compiled from: SchoolSearchFragmentComponent.kt */
public interface SchoolSearchFragmentComponent extends DaggerComponent {
    void inject(@NotNull SchoolSearchFragment schoolSearchFragment);
}
