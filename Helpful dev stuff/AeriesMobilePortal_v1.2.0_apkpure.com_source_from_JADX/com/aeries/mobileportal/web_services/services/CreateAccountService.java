package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.AccountTakenResponse;
import com.aeries.mobileportal.models.ConfirmAccountRequest;
import com.aeries.mobileportal.models.CreateAccountRequest;
import com.aeries.mobileportal.models.CreateAccountResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "", "checkAccountTaken", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/AccountTakenResponse;", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "confirmAccount", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "confirmAccountRequest", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "createAccount", "Lcom/aeries/mobileportal/models/CreateAccountResponse;", "createAccountRequest", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountService.kt */
public interface CreateAccountService {
    @NotNull
    @POST("accounttaken")
    Observable<AccountTakenResponse> checkAccountTaken(@NotNull @Body AccountTakenRequest accountTakenRequest);

    @NotNull
    @POST("confirmaccount")
    Observable<GenericServiceResponse> confirmAccount(@NotNull @Body ConfirmAccountRequest confirmAccountRequest);

    @NotNull
    @POST("createaccount")
    Observable<CreateAccountResponse> createAccount(@NotNull @Body CreateAccountRequest createAccountRequest);
}
