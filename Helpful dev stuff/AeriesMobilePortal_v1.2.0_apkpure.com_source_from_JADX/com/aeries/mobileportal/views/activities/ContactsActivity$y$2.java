package com.aeries.mobileportal.views.activities;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ContactsActivity.kt */
final class ContactsActivity$y$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ContactsActivity this$0;

    ContactsActivity$y$2(ContactsActivity contactsActivity) {
        this.this$0 = contactsActivity;
        super(0);
    }

    public final int invoke() {
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        return intent.getExtras().getInt("positionY");
    }
}
