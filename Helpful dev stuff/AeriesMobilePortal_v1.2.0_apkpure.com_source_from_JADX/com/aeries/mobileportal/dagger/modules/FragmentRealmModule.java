package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.repos.realm.SchoolRealmRepo;
import com.aeries.mobileportal.repos.realm.StudentRealmRepo;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/FragmentRealmModule;", "", "()V", "schoolsRealmRepo", "Lcom/aeries/mobileportal/repos/realm/SchoolRealmRepo;", "studentRealmRepo", "Lcom/aeries/mobileportal/repos/realm/StudentRealmRepo;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: FragmentRealmModule.kt */
public final class FragmentRealmModule {
    @NotNull
    @FragmentScope
    @Provides
    public final StudentRealmRepo studentRealmRepo() {
        return new StudentRealmRepo();
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SchoolRealmRepo schoolsRealmRepo() {
        return new SchoolRealmRepo();
    }
}
