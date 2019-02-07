package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.presenters.feedback.FeedbackPresenter;
import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/FeedbackPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "feedbackPresenter", "Lcom/aeries/mobileportal/presenters/feedback/FeedbackPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;", "feedbackViewModel", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: FeedbackPresenterModule.kt */
public final class FeedbackPresenterModule {
    @NotNull
    private final FeedbackViewModel viewModel;

    public FeedbackPresenterModule(@NotNull FeedbackViewModel feedbackViewModel) {
        Intrinsics.checkParameterIsNotNull(feedbackViewModel, "viewModel");
        this.viewModel = feedbackViewModel;
    }

    @NotNull
    public final FeedbackViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final FeedbackViewModel feedbackViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final FeedbackPresenter feedbackPresenter(@NotNull FeedbackViewModel feedbackViewModel, @NotNull FeedbackInteractor feedbackInteractor) {
        Intrinsics.checkParameterIsNotNull(feedbackViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(feedbackInteractor, "interactor");
        return new FeedbackPresenter(feedbackViewModel, feedbackInteractor);
    }
}
