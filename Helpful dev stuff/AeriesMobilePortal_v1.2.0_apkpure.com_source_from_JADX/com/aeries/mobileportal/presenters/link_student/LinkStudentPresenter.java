package com.aeries.mobileportal.presenters.link_student;

import com.aeries.mobileportal.interactors.link_student.LinkStudentCallback;
import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.LinkContact;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.link_student.LinkStudentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/aeries/mobileportal/presenters/link_student/LinkStudentPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;", "Lcom/aeries/mobileportal/interactors/link_student/LinkStudentCallback;", "linkStudentViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/link_student/LinkStudentViewModel;Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;", "addStudent", "", "studentID", "", "studentPhone", "verificationCode", "logout", "onContactUpdatedError", "e", "", "onContactUpdatedFail", "genericServiceResponse", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "onContactUpdatedSuccess", "onCreate", "onStudentAddedError", "onStudentAddedFail", "error", "onStudentAddedSuccess", "addStudentResponse", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "onStudentAddedSuccessNoContacts", "setLinkingStudent", "b", "", "updateContact", "linkContact", "Lcom/aeries/mobileportal/models/LinkContact;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentPresenter.kt */
public final class LinkStudentPresenter extends BasePresenter<LinkStudentViewModel> implements LinkStudentCallback {
    @NotNull
    private final LinkStudentInteractor interactor;
    private final LinkStudentViewModel linkStudentViewModel;

    @NotNull
    public final LinkStudentInteractor getInteractor() {
        return this.interactor;
    }

    public LinkStudentPresenter(@NotNull LinkStudentViewModel linkStudentViewModel, @NotNull LinkStudentInteractor linkStudentInteractor) {
        Intrinsics.checkParameterIsNotNull(linkStudentViewModel, "linkStudentViewModel");
        Intrinsics.checkParameterIsNotNull(linkStudentInteractor, "interactor");
        super(linkStudentViewModel, linkStudentInteractor);
        this.linkStudentViewModel = linkStudentViewModel;
        this.interactor = linkStudentInteractor;
    }

    public final void addStudent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "studentID");
        Intrinsics.checkParameterIsNotNull(str2, "studentPhone");
        Intrinsics.checkParameterIsNotNull(str3, "verificationCode");
        this.interactor.addStudent(str, str2, str3, this);
    }

    public final void updateContact(@NotNull LinkContact linkContact) {
        Intrinsics.checkParameterIsNotNull(linkContact, "linkContact");
        this.interactor.updateContact(linkContact, this);
    }

    public final void setLinkingStudent(boolean z) {
        this.interactor.setLinkingStudent(z);
    }

    public final void logout() {
        this.interactor.deleteAll();
    }

    public void onStudentAddedSuccess(@NotNull AddStudentResponse addStudentResponse) {
        Intrinsics.checkParameterIsNotNull(addStudentResponse, "addStudentResponse");
        this.linkStudentViewModel.showUpdateContactScreen(addStudentResponse);
    }

    public void onStudentAddedSuccessNoContacts(@NotNull AddStudentResponse addStudentResponse) {
        Intrinsics.checkParameterIsNotNull(addStudentResponse, "addStudentResponse");
        this.interactor.sendSuccessAnalytics();
        this.linkStudentViewModel.showCompleteMessage(addStudentResponse.getError());
    }

    public void onStudentAddedFail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.linkStudentViewModel.showError(str);
    }

    public void onStudentAddedError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        LinkStudentViewModel linkStudentViewModel = this.linkStudentViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        linkStudentViewModel.showError(th);
    }

    public void onContactUpdatedSuccess(@NotNull GenericServiceResponse genericServiceResponse) {
        Intrinsics.checkParameterIsNotNull(genericServiceResponse, "genericServiceResponse");
        this.interactor.sendSuccessAnalytics();
        this.linkStudentViewModel.showCompleteMessage();
    }

    public void onContactUpdatedFail(@NotNull GenericServiceResponse genericServiceResponse) {
        Intrinsics.checkParameterIsNotNull(genericServiceResponse, "genericServiceResponse");
        this.linkStudentViewModel.showError(genericServiceResponse.getError());
    }

    public void onContactUpdatedError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        LinkStudentViewModel linkStudentViewModel = this.linkStudentViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        linkStudentViewModel.showError(th);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
