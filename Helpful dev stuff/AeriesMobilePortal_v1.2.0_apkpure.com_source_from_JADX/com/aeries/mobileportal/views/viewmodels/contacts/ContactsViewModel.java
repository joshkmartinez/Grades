package com.aeries.mobileportal.views.viewmodels.contacts;

import com.aeries.mobileportal.models.Contact;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "enableDetails", "", "b", "", "showContacts", "contacts", "", "Lcom/aeries/mobileportal/models/Contact;", "showContactsError", "e", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsViewModel.kt */
public interface ContactsViewModel extends BaseViewModel {
    void enableDetails(boolean z);

    void showContacts(@Nullable List<Contact> list);

    void showContactsError(@NotNull Throwable th);
}
