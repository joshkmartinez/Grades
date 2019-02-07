package com.aeries.mobileportal.presenters.report_cards;

import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentCallback;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsFragmentViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsFragmentPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentCallback;", "rcViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;", "getRcViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "downloadReport", "", "report", "Lcom/aeries/mobileportal/models/ReportCard;", "isEnglish", "", "getReportCards", "onCreate", "onReportCardsError", "e", "", "onReportCardsRetrieved", "reports", "", "onServerConnectionError", "response", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentPresenter.kt */
public final class ReportCardsFragmentPresenter extends BasePresenter<ReportCardsFragmentViewModel> implements ReportCardsFragmentCallback {
    @NotNull
    private final ReportCardsFragmentInteractor interactor;
    @NotNull
    private final ReportCardsFragmentViewModel rcViewModel;

    public void onCreate() {
    }

    @NotNull
    public final ReportCardsFragmentInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final ReportCardsFragmentViewModel getRcViewModel() {
        return this.rcViewModel;
    }

    public ReportCardsFragmentPresenter(@NotNull ReportCardsFragmentViewModel reportCardsFragmentViewModel, @NotNull ReportCardsFragmentInteractor reportCardsFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentViewModel, "rcViewModel");
        Intrinsics.checkParameterIsNotNull(reportCardsFragmentInteractor, "interactor");
        super(reportCardsFragmentViewModel, reportCardsFragmentInteractor);
        this.rcViewModel = reportCardsFragmentViewModel;
        this.interactor = reportCardsFragmentInteractor;
    }

    public final void getReportCards() {
        this.interactor.getReports(this);
    }

    public final void downloadReport(@NotNull ReportCard reportCard, boolean z) {
        Intrinsics.checkParameterIsNotNull(reportCard, "report");
        this.interactor.downloadReport(reportCard, z, this);
    }

    public void onReportCardsRetrieved(@NotNull List<ReportCard> list) {
        Intrinsics.checkParameterIsNotNull(list, "reports");
        this.rcViewModel.showReportCards(list);
    }

    public void onReportCardsError(@Nullable Throwable th) {
        ReportCardsFragmentViewModel reportCardsFragmentViewModel = this.rcViewModel;
        if (th != null) {
            th = th.getMessage();
            if (th != null) {
                reportCardsFragmentViewModel.showError(th);
            }
        }
        th = "Error";
        reportCardsFragmentViewModel.showError(th);
    }

    public void onServerConnectionError(@Nullable Response<ResponseBody> response) {
        ReportCardsFragmentViewModel reportCardsFragmentViewModel = this.rcViewModel;
        if (response != null) {
            response = response.message();
            if (response != null) {
                reportCardsFragmentViewModel.showError(response);
            }
        }
        response = "Error";
        reportCardsFragmentViewModel.showError(response);
    }
}
