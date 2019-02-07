package com.aeries.mobileportal.interactors.report_cards;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.utils.DateUtils;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ReportCardsFragmentInteractor.kt */
final class ReportCardsFragmentInteractor$downloadReport$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ boolean $isEnglish;
    final /* synthetic */ ReportCard $reportCard;
    final /* synthetic */ ReportCardsFragmentInteractor this$0;

    ReportCardsFragmentInteractor$downloadReport$1(ReportCardsFragmentInteractor reportCardsFragmentInteractor, ReportCard reportCard, boolean z) {
        this.this$0 = reportCardsFragmentInteractor;
        this.$reportCard = reportCard;
        this.$isEnglish = z;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        Call downloadReport = this.this$0.getReportCardService().downloadReport(Integer.valueOf(this.$reportCard.getSchoolCode()), Integer.valueOf(this.$reportCard.getStudentId()), Integer.valueOf(this.$reportCard.getYear()), this.$reportCard.getTermCode(), this.$reportCard.getType(), this.$isEnglish, str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(File.separator);
        stringBuilder.append(DateUtils.Companion.parseSimpleDotNetDateForFiles(this.$reportCard.getCreatedDate(), this.this$0.getContext()));
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(StringsKt.replace$default(this.$reportCard.getReportTitle(), " ", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, false, 4, null));
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(this.$isEnglish ? "english" : this.$reportCard.getCorrespondenceReportTitle());
        stringBuilder.append(".pdf");
        String stringBuilder2 = stringBuilder.toString();
        Object systemService = this.this$0.getContext().getSystemService("download");
        if (systemService != null) {
            DownloadManager downloadManager = (DownloadManager) systemService;
            Request request = new Request(Uri.parse(downloadReport.request().url().toString()));
            request.setTitle(this.$reportCard.getReportTitle());
            request.setDestinationInExternalFilesDir(this.this$0.getContext(), Environment.DIRECTORY_DOWNLOADS, stringBuilder2);
            request.setNotificationVisibility(1);
            request.addRequestHeader(HttpRequest.HEADER_AUTHORIZATION, str);
            Log.d("DOWNLOAD_LINK", downloadReport.request().url().toString());
            downloadManager.enqueue(request);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
    }
}
