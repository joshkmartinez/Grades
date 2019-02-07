package com.aeries.mobileportal.views.viewmodels.report_cards;

import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsFragmentViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showError", "", "message", "", "showReportCards", "reports", "", "Lcom/aeries/mobileportal/models/ReportCard;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentViewModel.kt */
public interface ReportCardsFragmentViewModel extends BaseViewModel {
    void showError(@Nullable String str);

    void showReportCards(@NotNull List<ReportCard> list);
}
