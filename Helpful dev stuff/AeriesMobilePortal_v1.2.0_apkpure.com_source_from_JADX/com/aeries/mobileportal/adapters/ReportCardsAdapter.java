package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.ReportCard;
import com.aeries.mobileportal.utils.DateUtils;
import com.aeries.mobileportal.utils.DateUtils.Companion;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001e\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardHolder;", "listener", "Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "(Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "reports", "", "Lcom/aeries/mobileportal/models/ReportCard;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "ReportCardHolder", "ReportCardsListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsAdapter.kt */
public final class ReportCardsAdapter extends Adapter<ReportCardHolder> {
    @NotNull
    private final ReportCardsListener listener;
    private final List<ReportCard> reports = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardsListener;", "", "onReportCardSelected", "", "report", "Lcom/aeries/mobileportal/models/ReportCard;", "isEnglish", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ReportCardsAdapter.kt */
    public interface ReportCardsListener {
        void onReportCardSelected(@NotNull ReportCard reportCard, boolean z);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001e\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001e\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\n¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/adapters/ReportCardsAdapter$ReportCardHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/ReportCardsAdapter;Landroid/view/View;)V", "dateTV", "Landroid/widget/TextView;", "getDateTV", "()Landroid/widget/TextView;", "setDateTV", "(Landroid/widget/TextView;)V", "englishReportTV", "getEnglishReportTV", "setEnglishReportTV", "gradeTV", "getGradeTV", "setGradeTV", "nonEnglishReportTV", "getNonEnglishReportTV", "setNonEnglishReportTV", "reportTitleTV", "getReportTitleTV", "setReportTitleTV", "schoolNameTV", "getSchoolNameTV", "setSchoolNameTV", "termDescriptionTV", "getTermDescriptionTV", "setTermDescriptionTV", "yearTV", "getYearTV", "setYearTV", "bindView", "", "report", "Lcom/aeries/mobileportal/models/ReportCard;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ReportCardsAdapter.kt */
    public final class ReportCardHolder extends ViewHolder {
        @NotNull
        @BindView(2131361909)
        public TextView dateTV;
        @NotNull
        @BindView(2131361949)
        public TextView englishReportTV;
        @NotNull
        @BindView(2131361974)
        public TextView gradeTV;
        @NotNull
        @BindView(2131362068)
        public TextView nonEnglishReportTV;
        @NotNull
        @BindView(2131362107)
        public TextView reportTitleTV;
        @NotNull
        @BindView(2131362119)
        public TextView schoolNameTV;
        @NotNull
        @BindView(2131362187)
        public TextView termDescriptionTV;
        final /* synthetic */ ReportCardsAdapter this$0;
        @NotNull
        @BindView(2131362291)
        public TextView yearTV;

        public ReportCardHolder(@NotNull ReportCardsAdapter reportCardsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = reportCardsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getReportTitleTV() {
            TextView textView = this.reportTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reportTitleTV");
            }
            return textView;
        }

        public final void setReportTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.reportTitleTV = textView;
        }

        @NotNull
        public final TextView getSchoolNameTV() {
            TextView textView = this.schoolNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
            }
            return textView;
        }

        public final void setSchoolNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.schoolNameTV = textView;
        }

        @NotNull
        public final TextView getTermDescriptionTV() {
            TextView textView = this.termDescriptionTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("termDescriptionTV");
            }
            return textView;
        }

        public final void setTermDescriptionTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.termDescriptionTV = textView;
        }

        @NotNull
        public final TextView getYearTV() {
            TextView textView = this.yearTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yearTV");
            }
            return textView;
        }

        public final void setYearTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.yearTV = textView;
        }

        @NotNull
        public final TextView getGradeTV() {
            TextView textView = this.gradeTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeTV");
            }
            return textView;
        }

        public final void setGradeTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.gradeTV = textView;
        }

        @NotNull
        public final TextView getDateTV() {
            TextView textView = this.dateTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateTV");
            }
            return textView;
        }

        public final void setDateTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.dateTV = textView;
        }

        @NotNull
        public final TextView getEnglishReportTV() {
            TextView textView = this.englishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("englishReportTV");
            }
            return textView;
        }

        public final void setEnglishReportTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.englishReportTV = textView;
        }

        @NotNull
        public final TextView getNonEnglishReportTV() {
            TextView textView = this.nonEnglishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonEnglishReportTV");
            }
            return textView;
        }

        public final void setNonEnglishReportTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.nonEnglishReportTV = textView;
        }

        public final void bindView(@NotNull ReportCard reportCard) {
            Intrinsics.checkParameterIsNotNull(reportCard, "report");
            TextView textView = this.reportTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reportTitleTV");
            }
            textView.setText(reportCard.getReportTitle());
            textView = this.termDescriptionTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("termDescriptionTV");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            String string = view.getContext().getString(C0316R.string.rch_term);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getString(R.string.rch_term)");
            Object[] objArr = new Object[1];
            int i = 0;
            objArr[0] = reportCard.getTermDescription();
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            textView = this.dateTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateTV");
            }
            stringCompanionObject = StringCompanionObject.INSTANCE;
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            string = view.getContext().getString(C0316R.string.rch_date);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getString(R.string.rch_date)");
            objArr = new Object[1];
            Companion companion = DateUtils.Companion;
            String createdDate = reportCard.getCreatedDate();
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
            objArr[0] = companion.parseSimpleDotNetDate(createdDate, context);
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            textView = this.yearTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yearTV");
            }
            stringCompanionObject = StringCompanionObject.INSTANCE;
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            string = view.getContext().getString(C0316R.string.report_card_year);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri….string.report_card_year)");
            objArr = new Object[]{Integer.valueOf(reportCard.getYear())};
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            textView = this.gradeTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeTV");
            }
            stringCompanionObject = StringCompanionObject.INSTANCE;
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            string = view.getContext().getString(C0316R.string.report_card_grade);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri…string.report_card_grade)");
            objArr = new Object[]{reportCard.getGrade()};
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            textView = this.schoolNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
            }
            textView.setText(reportCard.getSchoolName());
            textView = this.nonEnglishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonEnglishReportTV");
            }
            stringCompanionObject = StringCompanionObject.INSTANCE;
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            string = view.getContext().getString(C0316R.string.download_non_english);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri…ing.download_non_english)");
            Object[] objArr2 = new Object[]{StringsKt.capitalize(reportCard.getCorrespondenceReportTitle())};
            string = String.format(string, Arrays.copyOf(objArr2, objArr2.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            textView = this.nonEnglishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonEnglishReportTV");
            }
            if (!reportCard.getCorrespondenceReport()) {
                i = 4;
            }
            textView.setVisibility(i);
            textView = this.englishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("englishReportTV");
            }
            textView.setOnClickListener(new ReportCardsAdapter$ReportCardHolder$bindView$1(this, reportCard));
            textView = this.nonEnglishReportTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonEnglishReportTV");
            }
            textView.setOnClickListener(new ReportCardsAdapter$ReportCardHolder$bindView$2(this, reportCard));
        }
    }

    public final class ReportCardHolder_ViewBinding implements Unbinder {
        private ReportCardHolder target;

        @UiThread
        public ReportCardHolder_ViewBinding(ReportCardHolder reportCardHolder, View view) {
            this.target = reportCardHolder;
            reportCardHolder.reportTitleTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.report_title, "field 'reportTitleTV'", TextView.class);
            reportCardHolder.schoolNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.school_name, "field 'schoolNameTV'", TextView.class);
            reportCardHolder.termDescriptionTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.term_description, "field 'termDescriptionTV'", TextView.class);
            reportCardHolder.yearTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.year, "field 'yearTV'", TextView.class);
            reportCardHolder.gradeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.grade, "field 'gradeTV'", TextView.class);
            reportCardHolder.dateTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.date, "field 'dateTV'", TextView.class);
            reportCardHolder.englishReportTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.english_report, "field 'englishReportTV'", TextView.class);
            reportCardHolder.nonEnglishReportTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.non_english_report, "field 'nonEnglishReportTV'", TextView.class);
        }

        public void unbind() {
            ReportCardHolder reportCardHolder = this.target;
            if (reportCardHolder != null) {
                this.target = null;
                reportCardHolder.reportTitleTV = null;
                reportCardHolder.schoolNameTV = null;
                reportCardHolder.termDescriptionTV = null;
                reportCardHolder.yearTV = null;
                reportCardHolder.gradeTV = null;
                reportCardHolder.dateTV = null;
                reportCardHolder.englishReportTV = null;
                reportCardHolder.nonEnglishReportTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ReportCardsAdapter(@NotNull ReportCardsListener reportCardsListener) {
        Intrinsics.checkParameterIsNotNull(reportCardsListener, CastExtraArgs.LISTENER);
        this.listener = reportCardsListener;
    }

    @NotNull
    public final ReportCardsListener getListener() {
        return this.listener;
    }

    public int getItemCount() {
        return this.reports.size();
    }

    public void onBindViewHolder(@Nullable ReportCardHolder reportCardHolder, int i) {
        if (reportCardHolder != null) {
            reportCardHolder.bindView((ReportCard) this.reports.get(i));
        }
    }

    @NotNull
    public ReportCardHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_report_card, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new ReportCardHolder(this, viewGroup);
    }

    public final void update(@NotNull List<ReportCard> list) {
        Intrinsics.checkParameterIsNotNull(list, "reports");
        this.reports.clear();
        this.reports.addAll(list);
        notifyDataSetChanged();
    }
}
