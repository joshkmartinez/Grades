package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.presenters.link_student.LinkStudentPresenter;
import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/LinkStudentPresenterModule;", "", "linkStudentViewModel", "Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;)V", "getLinkStudentViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;", "linkStudentPresenter", "Lcom/aeries/mobileportal/presenters/link_student/LinkStudentPresenter;", "linkStudentInteractor", "Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: LinkStudentPresenterModule.kt */
public final class LinkStudentPresenterModule {
    @NotNull
    private final LinkStudentViewModel linkStudentViewModel;

    public LinkStudentPresenterModule(@NotNull LinkStudentViewModel linkStudentViewModel) {
        Intrinsics.checkParameterIsNotNull(linkStudentViewModel, "linkStudentViewModel");
        this.linkStudentViewModel = linkStudentViewModel;
    }

    @NotNull
    public final LinkStudentViewModel getLinkStudentViewModel() {
        return this.linkStudentViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final LinkStudentViewModel linkStudentViewModel() {
        return this.linkStudentViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final LinkStudentPresenter linkStudentPresenter(@NotNull LinkStudentViewModel linkStudentViewModel, @NotNull LinkStudentInteractor linkStudentInteractor) {
        Intrinsics.checkParameterIsNotNull(linkStudentViewModel, "linkStudentViewModel");
        Intrinsics.checkParameterIsNotNull(linkStudentInteractor, "linkStudentInteractor");
        return new LinkStudentPresenter(linkStudentViewModel, linkStudentInteractor);
    }
}
