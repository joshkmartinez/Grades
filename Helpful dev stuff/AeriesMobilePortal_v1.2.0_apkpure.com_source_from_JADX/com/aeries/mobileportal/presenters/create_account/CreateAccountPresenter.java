package com.aeries.mobileportal.presenters.create_account;

import com.aeries.mobileportal.interactors.create_account.CreateAccountCallback;
import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.AccountTakenResponse;
import com.aeries.mobileportal.models.ConfirmAccountRequest;
import com.aeries.mobileportal.models.CreateAccountRequest;
import com.aeries.mobileportal.models.CreateAccountResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\rH\u0016J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020%R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006/"}, d2 = {"Lcom/aeries/mobileportal/presenters/create_account/CreateAccountPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;", "Lcom/aeries/mobileportal/interactors/create_account/CreateAccountCallback;", "createAccountViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;)V", "getCreateAccountViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;", "checkIfAccountTaken", "", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "confirmAccount", "confirmAccountRequest", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "createAccount", "createAccountRequest", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "onAccountConfirmed", "genericServiceResponse", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "onAccountConfirmedError", "e", "", "onAccountCreated", "createAccountResponse", "Lcom/aeries/mobileportal/models/CreateAccountResponse;", "onAccountCreatedError", "onAccountDontRequirePassword", "accountTakenResponse", "Lcom/aeries/mobileportal/models/AccountTakenResponse;", "onAccountNotConfirmed", "error", "", "onAccountNotCreated", "onAccountRequirePassword", "onAccountTaken", "onAccountTakenError", "onCreate", "sendCompletedAnalytics", "sendScreenAnalytics", "setNewDefaultEmail", "emailaddress", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountPresenter.kt */
public final class CreateAccountPresenter extends BasePresenter<CreateAccountViewModel> implements CreateAccountCallback {
    @NotNull
    private final CreateAccountViewModel createAccountViewModel;
    @NotNull
    private final CreateAccountInteractor interactor;

    public CreateAccountPresenter(@NotNull CreateAccountViewModel createAccountViewModel, @NotNull CreateAccountInteractor createAccountInteractor) {
        Intrinsics.checkParameterIsNotNull(createAccountViewModel, "createAccountViewModel");
        Intrinsics.checkParameterIsNotNull(createAccountInteractor, "interactor");
        super(createAccountViewModel, createAccountInteractor);
        this.createAccountViewModel = createAccountViewModel;
        this.interactor = createAccountInteractor;
    }

    @NotNull
    public final CreateAccountViewModel getCreateAccountViewModel() {
        return this.createAccountViewModel;
    }

    @NotNull
    public final CreateAccountInteractor getInteractor() {
        return this.interactor;
    }

    public final void sendScreenAnalytics() {
        this.interactor.sendAnalytics();
    }

    public final void sendCompletedAnalytics() {
        this.interactor.sendCompletedAnalytics();
    }

    public final void checkIfAccountTaken(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        this.interactor.checkAccountTaken(accountTakenRequest, this);
    }

    public final void createAccount(@NotNull CreateAccountRequest createAccountRequest) {
        Intrinsics.checkParameterIsNotNull(createAccountRequest, "createAccountRequest");
        this.interactor.createAccount(createAccountRequest, this);
    }

    public final void confirmAccount(@NotNull ConfirmAccountRequest confirmAccountRequest) {
        Intrinsics.checkParameterIsNotNull(confirmAccountRequest, "confirmAccountRequest");
        this.interactor.confirmAccount(confirmAccountRequest, this);
    }

    public final void setNewDefaultEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "emailaddress");
        this.interactor.setDefaultEmail(str);
    }

    public void onAccountTaken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.createAccountViewModel.showError(str);
    }

    public void onAccountRequirePassword(@NotNull AccountTakenResponse accountTakenResponse) {
        Intrinsics.checkParameterIsNotNull(accountTakenResponse, "accountTakenResponse");
        this.createAccountViewModel.showPasswordScreen();
    }

    public void onAccountDontRequirePassword(@NotNull AccountTakenResponse accountTakenResponse) {
        Intrinsics.checkParameterIsNotNull(accountTakenResponse, "accountTakenResponse");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append("What happens with the sender email");
        throw ((Throwable) new NotImplementedError(stringBuilder.toString()));
    }

    public void onAccountTakenError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        CreateAccountViewModel createAccountViewModel = this.createAccountViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "";
        }
        createAccountViewModel.showError(th);
    }

    public void onAccountCreated(@NotNull CreateAccountResponse createAccountResponse) {
        Intrinsics.checkParameterIsNotNull(createAccountResponse, "createAccountResponse");
        this.createAccountViewModel.showVerificationScreen(createAccountResponse.getSender());
    }

    public void onAccountNotCreated(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.createAccountViewModel.showErrorAndFinish(str);
    }

    public void onAccountCreatedError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        CreateAccountViewModel createAccountViewModel = this.createAccountViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "";
        }
        createAccountViewModel.showError(th);
    }

    public void onAccountConfirmed(@NotNull GenericServiceResponse genericServiceResponse) {
        Intrinsics.checkParameterIsNotNull(genericServiceResponse, "genericServiceResponse");
        sendCompletedAnalytics();
        this.createAccountViewModel.showDoneScreen();
    }

    public void onAccountNotConfirmed(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.createAccountViewModel.showError(str);
    }

    public void onAccountConfirmedError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        CreateAccountViewModel createAccountViewModel = this.createAccountViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "";
        }
        createAccountViewModel.showError(th);
    }

    public void onCreate() {
        sendScreenAnalytics();
    }
}
