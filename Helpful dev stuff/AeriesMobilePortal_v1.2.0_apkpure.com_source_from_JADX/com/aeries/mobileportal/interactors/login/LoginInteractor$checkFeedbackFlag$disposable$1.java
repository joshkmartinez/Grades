package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.models.FeedbackFlag;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/FeedbackFlag;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$checkFeedbackFlag$disposable$1<T> implements Consumer<FeedbackFlag> {
    final /* synthetic */ LoginInteractor this$0;

    LoginInteractor$checkFeedbackFlag$disposable$1(LoginInteractor loginInteractor) {
        this.this$0 = loginInteractor;
    }

    public final void accept(FeedbackFlag feedbackFlag) {
        ConfigurationRepository configurationRepository = this.this$0.getConfigurationRepository();
        boolean z = true;
        if (feedbackFlag.getResponse() != 1) {
            z = false;
        }
        configurationRepository.setFeedbackEnabled(z);
    }
}
