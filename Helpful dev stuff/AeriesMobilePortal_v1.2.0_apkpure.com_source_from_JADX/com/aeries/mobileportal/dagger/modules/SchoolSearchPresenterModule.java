package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.presenters.school.select.SchoolSearchPresenter;
import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SchoolSearchPresenterModule;", "", "schoolSearchViewModel", "Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;)V", "getSchoolSearchViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/school_select/SchoolSearchViewModel;", "schoolSearchPresenter", "Lcom/aeries/mobileportal/presenters/school/select/SchoolSearchPresenter;", "schoolSearchInteractor", "Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SchoolSearchPresenterModule.kt */
public final class SchoolSearchPresenterModule {
    @NotNull
    private final SchoolSearchViewModel schoolSearchViewModel;

    public SchoolSearchPresenterModule(@NotNull SchoolSearchViewModel schoolSearchViewModel) {
        Intrinsics.checkParameterIsNotNull(schoolSearchViewModel, "schoolSearchViewModel");
        this.schoolSearchViewModel = schoolSearchViewModel;
    }

    @NotNull
    public final SchoolSearchViewModel getSchoolSearchViewModel() {
        return this.schoolSearchViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SchoolSearchViewModel schoolSearchViewModel() {
        return this.schoolSearchViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SchoolSearchPresenter schoolSearchPresenter(@NotNull SchoolSearchViewModel schoolSearchViewModel, @NotNull SchoolSearchInteractor schoolSearchInteractor) {
        Intrinsics.checkParameterIsNotNull(schoolSearchViewModel, "schoolSearchViewModel");
        Intrinsics.checkParameterIsNotNull(schoolSearchInteractor, "schoolSearchInteractor");
        return new SchoolSearchPresenter(schoolSearchViewModel, schoolSearchInteractor);
    }
}