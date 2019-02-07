package com.aeries.mobileportal.presenters.feedback;

import com.aeries.mobileportal.interactors.feedback.FeedbackCallback;
import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.models.Feedback;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/presenters/feedback/FeedbackPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "Lcom/aeries/mobileportal/interactors/feedback/FeedbackCallback;", "feedbackViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;)V", "getFeedbackViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/feedback/FeedbackViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;", "getDefaultEmail", "", "onCreate", "onEmailRetreived", "email", "", "onFeedbackError", "message", "onFeedbackFail", "onFeedbackSent", "sendFeedback", "feedback", "Lcom/aeries/mobileportal/models/Feedback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackPresenter.kt */
public final class FeedbackPresenter extends BasePresenter<FeedbackViewModel> implements FeedbackCallback {
    @NotNull
    private final FeedbackViewModel feedbackViewModel;
    @NotNull
    private final FeedbackInteractor interactor;

    public void onCreate() {
    }

    public FeedbackPresenter(@NotNull FeedbackViewModel feedbackViewModel, @NotNull FeedbackInteractor feedbackInteractor) {
        Intrinsics.checkParameterIsNotNull(feedbackViewModel, "feedbackViewModel");
        Intrinsics.checkParameterIsNotNull(feedbackInteractor, "interactor");
        super(feedbackViewModel, feedbackInteractor);
        this.feedbackViewModel = feedbackViewModel;
        this.interactor = feedbackInteractor;
    }

    @NotNull
    public final FeedbackViewModel getFeedbackViewModel() {
        return this.feedbackViewModel;
    }

    @NotNull
    public final FeedbackInteractor getInteractor() {
        return this.interactor;
    }

    public final void sendFeedback(@NotNull Feedback feedback) {
        Intrinsics.checkParameterIsNotNull(feedback, "feedback");
        this.interactor.sendFeedback(feedback, this);
    }

    public final void getDefaultEmail() {
        this.interactor.getDefaultEmail(this);
    }

    public void onFeedbackSent() {
        this.feedbackViewModel.showThankYouScreen();
    }

    public void onFeedbackFail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.feedbackViewModel.showError(str);
    }

    public void onFeedbackError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.feedbackViewModel.showError(str);
    }

    public void onEmailRetreived(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        this.feedbackViewModel.autoFillEmail(str);
    }
}
