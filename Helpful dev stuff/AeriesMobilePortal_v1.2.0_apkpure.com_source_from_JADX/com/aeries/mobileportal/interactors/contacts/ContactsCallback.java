package com.aeries.mobileportal.interactors.contacts;

import com.aeries.mobileportal.models.StudentContacts;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/interactors/contacts/ContactsCallback;", "", "canViewDetails", "", "b", "", "onContactsError", "e", "", "onContactsReceived", "studentContacts", "Lcom/aeries/mobileportal/models/StudentContacts;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsCallback.kt */
public interface ContactsCallback {
    void canViewDetails(boolean z);

    void onContactsError(@NotNull Throwable th);

    void onContactsReceived(@NotNull StudentContacts studentContacts);
}
