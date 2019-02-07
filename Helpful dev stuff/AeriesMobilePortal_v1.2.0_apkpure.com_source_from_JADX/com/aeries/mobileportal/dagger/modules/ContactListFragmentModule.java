package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.ContactsAdapter;
import com.aeries.mobileportal.adapters.ContactsAdapter.ContactsListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ContactListFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "(Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "contactsAdapter", "Lcom/aeries/mobileportal/adapters/ContactsAdapter;", "contactsListener", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ContactListFragmentModule.kt */
public final class ContactListFragmentModule {
    @NotNull
    private final ContactsListener listener;

    public ContactListFragmentModule(@NotNull ContactsListener contactsListener) {
        Intrinsics.checkParameterIsNotNull(contactsListener, CastExtraArgs.LISTENER);
        this.listener = contactsListener;
    }

    @NotNull
    public final ContactsListener getListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final ContactsListener contactsListener() {
        return this.listener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final ContactsAdapter contactsAdapter(@NotNull ContactsListener contactsListener) {
        Intrinsics.checkParameterIsNotNull(contactsListener, CastExtraArgs.LISTENER);
        return new ContactsAdapter(contactsListener);
    }
}
