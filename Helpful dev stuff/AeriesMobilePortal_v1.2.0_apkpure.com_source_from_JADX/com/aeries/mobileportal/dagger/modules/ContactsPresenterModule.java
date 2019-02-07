package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.contacts.ContactsInteractor;
import com.aeries.mobileportal.presenters.contacts.ContactsPresenter;
import com.aeries.mobileportal.views.viewmodels.contacts.ContactsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ContactsPresenterModule;", "", "contactsViewModel", "Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;)V", "getContactsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "contactsPresenter", "Lcom/aeries/mobileportal/presenters/contacts/ContactsPresenter;", "contactsInteractor", "Lcom/aeries/mobileportal/interactors/contacts/ContactsInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ContactsPresenterModule.kt */
public final class ContactsPresenterModule {
    @NotNull
    private final ContactsViewModel contactsViewModel;

    public ContactsPresenterModule(@NotNull ContactsViewModel contactsViewModel) {
        Intrinsics.checkParameterIsNotNull(contactsViewModel, "contactsViewModel");
        this.contactsViewModel = contactsViewModel;
    }

    @NotNull
    public final ContactsViewModel getContactsViewModel() {
        return this.contactsViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ContactsViewModel contactsViewModel() {
        return this.contactsViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ContactsPresenter contactsPresenter(@NotNull ContactsViewModel contactsViewModel, @NotNull ContactsInteractor contactsInteractor) {
        Intrinsics.checkParameterIsNotNull(contactsViewModel, "contactsViewModel");
        Intrinsics.checkParameterIsNotNull(contactsInteractor, "contactsInteractor");
        return new ContactsPresenter(contactsViewModel, contactsInteractor);
    }
}
