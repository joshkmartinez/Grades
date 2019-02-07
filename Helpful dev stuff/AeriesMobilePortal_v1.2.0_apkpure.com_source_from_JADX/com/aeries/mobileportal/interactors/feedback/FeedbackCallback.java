package com.aeries.mobileportal.interactors.feedback;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/interactors/feedback/FeedbackCallback;", "", "onEmailRetreived", "", "email", "", "onFeedbackError", "message", "onFeedbackFail", "onFeedbackSent", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackCallback.kt */
public interface FeedbackCallback {
    void onEmailRetreived(@NotNull String str);

    void onFeedbackError(@NotNull String str);

    void onFeedbackFail(@NotNull String str);

    void onFeedbackSent();
}
