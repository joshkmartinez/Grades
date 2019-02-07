package com.aeries.mobileportal.interactors.feedback;

import com.aeries.mobileportal.models.GenericServiceResponse;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: FeedbackInteractor.kt */
final class FeedbackInteractor$sendFeedback$1<T> implements Consumer<GenericServiceResponse> {
    final /* synthetic */ FeedbackCallback $callback;

    FeedbackInteractor$sendFeedback$1(FeedbackCallback feedbackCallback) {
        this.$callback = feedbackCallback;
    }

    public final void accept(GenericServiceResponse genericServiceResponse) {
        if (Intrinsics.areEqual(genericServiceResponse.getStatus(), Param.SUCCESS)) {
            this.$callback.onFeedbackSent();
        } else {
            this.$callback.onFeedbackFail(genericServiceResponse.getError());
        }
    }
}
