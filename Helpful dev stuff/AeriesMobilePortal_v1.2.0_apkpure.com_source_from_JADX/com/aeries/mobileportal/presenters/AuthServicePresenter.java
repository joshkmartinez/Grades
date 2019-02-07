package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.login.LoginInteractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/presenters/AuthServicePresenter;", "", "interactor", "Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "(Lcom/aeries/mobileportal/interactors/login/LoginInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "getAuthToken", "", "password", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthServicePresenter.kt */
public final class AuthServicePresenter {
    @NotNull
    private final LoginInteractor interactor;

    public AuthServicePresenter(@NotNull LoginInteractor loginInteractor) {
        Intrinsics.checkParameterIsNotNull(loginInteractor, "interactor");
        this.interactor = loginInteractor;
    }

    @NotNull
    public final LoginInteractor getInteractor() {
        return this.interactor;
    }

    @Nullable
    public final String getAuthToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        str = this.interactor.login(str);
        if (str == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bearer ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
