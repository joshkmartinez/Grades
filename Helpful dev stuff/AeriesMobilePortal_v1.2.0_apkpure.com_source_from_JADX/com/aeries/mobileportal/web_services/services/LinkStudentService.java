package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.AddStudentRequest;
import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.UpdateStudentContactRequest;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "", "addStudent", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "addStudentRequest", "Lcom/aeries/mobileportal/models/AddStudentRequest;", "token", "", "updateStudentContact", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "updateStudentContactRequest", "Lcom/aeries/mobileportal/models/UpdateStudentContactRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentService.kt */
public interface LinkStudentService {
    @NotNull
    @POST("addstudent")
    Observable<AddStudentResponse> addStudent(@NotNull @Body AddStudentRequest addStudentRequest, @NotNull @Header("Authorization") String str);

    @NotNull
    @POST("updatestudentcontact")
    Observable<GenericServiceResponse> updateStudentContact(@NotNull @Body UpdateStudentContactRequest updateStudentContactRequest, @NotNull @Header("Authorization") String str);
}
