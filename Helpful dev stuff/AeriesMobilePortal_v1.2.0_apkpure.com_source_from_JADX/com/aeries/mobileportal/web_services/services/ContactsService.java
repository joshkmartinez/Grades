package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.StudentContacts;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/ContactsService;", "", "getContacts", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/StudentContacts;", "schoolCode", "", "studentId", "token", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsService.kt */
public interface ContactsService {
    @NotNull
    @GET("{schoolCode}/student/{studentId}/contacts")
    Observable<StudentContacts> getContacts(@Nullable @Path("schoolCode") Integer num, @Nullable @Path("studentId") Integer num2, @NotNull @Header("Authorization") String str);
}
