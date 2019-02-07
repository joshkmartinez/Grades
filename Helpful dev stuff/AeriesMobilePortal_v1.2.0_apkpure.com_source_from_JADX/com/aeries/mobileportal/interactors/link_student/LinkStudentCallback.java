package com.aeries.mobileportal.interactors.link_student;

import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/interactors/link_student/LinkStudentCallback;", "", "onContactUpdatedError", "", "e", "", "onContactUpdatedFail", "genericServiceResponse", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "onContactUpdatedSuccess", "onStudentAddedError", "onStudentAddedFail", "error", "", "onStudentAddedSuccess", "addStudentResponse", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "onStudentAddedSuccessNoContacts", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentCallback.kt */
public interface LinkStudentCallback {
    void onContactUpdatedError(@NotNull Throwable th);

    void onContactUpdatedFail(@NotNull GenericServiceResponse genericServiceResponse);

    void onContactUpdatedSuccess(@NotNull GenericServiceResponse genericServiceResponse);

    void onStudentAddedError(@NotNull Throwable th);

    void onStudentAddedFail(@NotNull String str);

    void onStudentAddedSuccess(@NotNull AddStudentResponse addStudentResponse);

    void onStudentAddedSuccessNoContacts(@NotNull AddStudentResponse addStudentResponse);
}
