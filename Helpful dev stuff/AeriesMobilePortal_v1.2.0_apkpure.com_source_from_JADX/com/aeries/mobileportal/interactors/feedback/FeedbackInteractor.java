package com.aeries.mobileportal.interactors.feedback;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.Feedback;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "feedbackService", "Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "(Lcom/aeries/mobileportal/web_services/services/FeedbackService;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;)V", "getFeedbackService", "()Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getDefaultEmail", "", "callback", "Lcom/aeries/mobileportal/interactors/feedback/FeedbackCallback;", "sendFeedback", "feedback", "Lcom/aeries/mobileportal/models/Feedback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackInteractor.kt */
public final class FeedbackInteractor extends BaseInteractor {
    @NotNull
    private final FeedbackService feedbackService;
    @NotNull
    private final UserRepository userRepository;

    public FeedbackInteractor(@NotNull FeedbackService feedbackService, @NotNull UserRepository userRepository) {
        Intrinsics.checkParameterIsNotNull(feedbackService, "feedbackService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        this.feedbackService = feedbackService;
        this.userRepository = userRepository;
    }

    @NotNull
    public final FeedbackService getFeedbackService() {
        return this.feedbackService;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    public final void getDefaultEmail(@NotNull FeedbackCallback feedbackCallback) {
        Intrinsics.checkParameterIsNotNull(feedbackCallback, "callback");
        feedbackCallback.onEmailRetreived(this.userRepository.getUserName());
    }

    public final void sendFeedback(@NotNull Feedback feedback, @NotNull FeedbackCallback feedbackCallback) {
        Intrinsics.checkParameterIsNotNull(feedback, "feedback");
        Intrinsics.checkParameterIsNotNull(feedbackCallback, "callback");
        feedback = this.feedbackService.sendFeedback("https://stats.aeries.com/mobile-portal-feedback/feedback-listener.php", feedback.getEmail(), feedback.getComment()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new FeedbackInteractor$sendFeedback$1(feedbackCallback), new FeedbackInteractor$sendFeedback$2(feedbackCallback));
        Intrinsics.checkExpressionValueIsNotNull(feedback, "feedbackService.sendFeed…      }\n                )");
        addToCompositeDisposable(feedback);
    }
}
