package com.aeries.mobileportal.interactors.contacts;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ContactsInteractor.kt */
final class ContactsInteractor$sendAnalytics$2<T> implements Consumer<Throwable> {
    public static final ContactsInteractor$sendAnalytics$2 INSTANCE = new ContactsInteractor$sendAnalytics$2();

    ContactsInteractor$sendAnalytics$2() {
    }

    public final void accept(Throwable th) {
        th.printStackTrace();
    }
}
