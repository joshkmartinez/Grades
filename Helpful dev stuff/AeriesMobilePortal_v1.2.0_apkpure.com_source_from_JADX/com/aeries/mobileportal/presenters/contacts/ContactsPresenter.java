package com.aeries.mobileportal.presenters.contacts;

import com.aeries.mobileportal.interactors.contacts.ContactsCallback;
import com.aeries.mobileportal.interactors.contacts.ContactsInteractor;
import com.aeries.mobileportal.models.StudentContacts;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.contacts.ContactsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/aeries/mobileportal/presenters/contacts/ContactsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "Lcom/aeries/mobileportal/interactors/contacts/ContactsCallback;", "contactsViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/contacts/ContactsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;Lcom/aeries/mobileportal/interactors/contacts/ContactsInteractor;)V", "getContactsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/contacts/ContactsInteractor;", "canViewDetails", "", "b", "", "getCurrentStudentContacts", "onContactsError", "e", "", "onContactsReceived", "studentContacts", "Lcom/aeries/mobileportal/models/StudentContacts;", "onCreate", "onStop", "sendDetailsAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsPresenter.kt */
public final class ContactsPresenter extends BasePresenter<ContactsViewModel> implements ContactsCallback {
    @NotNull
    private final ContactsViewModel contactsViewModel;
    @NotNull
    private final ContactsInteractor interactor;

    public ContactsPresenter(@NotNull ContactsViewModel contactsViewModel, @NotNull ContactsInteractor contactsInteractor) {
        Intrinsics.checkParameterIsNotNull(contactsViewModel, "contactsViewModel");
        Intrinsics.checkParameterIsNotNull(contactsInteractor, "interactor");
        super(contactsViewModel, contactsInteractor);
        this.contactsViewModel = contactsViewModel;
        this.interactor = contactsInteractor;
    }

    @NotNull
    public final ContactsViewModel getContactsViewModel() {
        return this.contactsViewModel;
    }

    @NotNull
    public final ContactsInteractor getInteractor() {
        return this.interactor;
    }

    public final void getCurrentStudentContacts() {
        ContactsCallback contactsCallback = this;
        this.interactor.getCurrentStudentContacts(contactsCallback);
        this.interactor.canViewDetails(contactsCallback);
    }

    public final void onStop() {
        this.interactor.cancelRequests();
    }

    public final void sendDetailsAnalytics() {
        this.interactor.sendDetailsAnalytics();
    }

    public void canViewDetails(boolean z) {
        this.contactsViewModel.enableDetails(z);
    }

    public void onContactsReceived(@NotNull StudentContacts studentContacts) {
        Intrinsics.checkParameterIsNotNull(studentContacts, "studentContacts");
        this.contactsViewModel.showContacts(studentContacts.getContactDetails());
    }

    public void onContactsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.contactsViewModel.showContactsError(th);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
