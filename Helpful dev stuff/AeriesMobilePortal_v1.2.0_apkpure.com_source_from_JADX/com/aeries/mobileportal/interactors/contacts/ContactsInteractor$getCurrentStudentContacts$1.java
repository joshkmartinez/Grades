package com.aeries.mobileportal.interactors.contacts;

import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.StudentContacts;
import com.aeries.mobileportal.web_services.services.ContactsService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ContactsInteractor.kt */
final class ContactsInteractor$getCurrentStudentContacts$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ContactsCallback $callback;
    final /* synthetic */ Student $student;
    final /* synthetic */ int $studentID;
    final /* synthetic */ ContactsInteractor this$0;

    ContactsInteractor$getCurrentStudentContacts$1(ContactsInteractor contactsInteractor, Student student, int i, ContactsCallback contactsCallback) {
        this.this$0 = contactsInteractor;
        this.$student = student;
        this.$studentID = i;
        this.$callback = contactsCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Integer valueOf;
        Intrinsics.checkParameterIsNotNull(str, "it");
        ContactsInteractor contactsInteractor = this.this$0;
        ContactsService contactsService = this.this$0.getContactsService();
        Student student = this.$student;
        if (student != null) {
            Demographics demographics = student.getDemographics();
            if (demographics != null) {
                valueOf = Integer.valueOf(demographics.getSchoolCode());
                str = contactsService.getContacts(valueOf, Integer.valueOf(this.$studentID), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<StudentContacts>() {
                    public final void accept(StudentContacts studentContacts) {
                        ContactsCallback contactsCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(studentContacts, "it");
                        contactsCallback.onContactsReceived(studentContacts);
                    }
                }, new Consumer<Throwable>() {
                    public final void accept(Throwable th) {
                        ContactsCallback contactsCallback = this.$callback;
                        Intrinsics.checkExpressionValueIsNotNull(th, "it");
                        contactsCallback.onContactsError(th);
                    }
                });
                Intrinsics.checkExpressionValueIsNotNull(str, "contactsService.getConta…t)}\n                    )");
                contactsInteractor.addToCompositeDisposable(str);
            }
        }
        valueOf = null;
        str = contactsService.getContacts(valueOf, Integer.valueOf(this.$studentID), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(/* anonymous class already generated */, /* anonymous class already generated */);
        Intrinsics.checkExpressionValueIsNotNull(str, "contactsService.getConta…t)}\n                    )");
        contactsInteractor.addToCompositeDisposable(str);
    }
}
