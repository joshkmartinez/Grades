package com.aeries.mobileportal.interactors.report_cards;

import com.aeries.mobileportal.models.ReportCard;
import java.util.List;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0018\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentCallback;", "", "onReportCardsError", "", "e", "", "onReportCardsRetrieved", "reports", "", "Lcom/aeries/mobileportal/models/ReportCard;", "onServerConnectionError", "response", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentCallback.kt */
public interface ReportCardsFragmentCallback {
    void onReportCardsError(@Nullable Throwable th);

    void onReportCardsRetrieved(@NotNull List<ReportCard> list);

    void onServerConnectionError(@Nullable Response<ResponseBody> response);
}
