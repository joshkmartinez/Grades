package com.aeries.mobileportal.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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
import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.models.AttendancePeriod;
import com.aeries.mobileportal.utils.DateUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0007#$%&'()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u001e\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0014\u0010!\u001a\u00020\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\"R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolder;", "listener", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;)V", "DAILY", "", "getDAILY", "()I", "DAILY_HEADER", "getDAILY_HEADER", "PERIOD", "getPERIOD", "PERIOD_HEADER", "getPERIOD_HEADER", "attendances", "", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "getAttendances", "()Ljava/util/List;", "getListener", "()Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "AttendanceHolder", "AttendanceHolderDaily", "AttendanceHolderDailyHeader", "AttendanceHolderPeriod", "AttendanceHolderPeriodHeader", "AttendanceListener", "PeriodAdapter", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceAdapter.kt */
public final class AttendanceAdapter extends Adapter<AttendanceHolder> {
    private final int DAILY;
    private final int DAILY_HEADER = 2;
    private final int PERIOD = 1;
    private final int PERIOD_HEADER = 3;
    @NotNull
    private final List<AttendanceDetail> attendances = ((List) new ArrayList());
    @NotNull
    private final AttendanceListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "", "onAttendanceSelected", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public interface AttendanceListener {
        void onAttendanceSelected(@NotNull AttendanceDetail attendanceDetail);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Landroid/view/View;)V", "bindView", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public abstract class AttendanceHolder extends ViewHolder {
        final /* synthetic */ AttendanceAdapter this$0;

        public abstract void bindView(@NotNull AttendanceDetail attendanceDetail);

        public AttendanceHolder(@NotNull AttendanceAdapter attendanceAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = attendanceAdapter;
            super(view);
        }
    }

    public class AttendanceHolderDaily_ViewBinding implements Unbinder {
        private AttendanceHolderDaily target;

        @UiThread
        public AttendanceHolderDaily_ViewBinding(AttendanceHolderDaily attendanceHolderDaily, View view) {
            this.target = attendanceHolderDaily;
            attendanceHolderDaily.description = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.period, "field 'description'", TextView.class);
            attendanceHolderDaily.weekDay = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.weekday, "field 'weekDay'", TextView.class);
            attendanceHolderDaily.day = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.day, "field 'day'", TextView.class);
            attendanceHolderDaily.month = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.month, "field 'month'", TextView.class);
        }

        @CallSuper
        public void unbind() {
            AttendanceHolderDaily attendanceHolderDaily = this.target;
            if (attendanceHolderDaily != null) {
                this.target = null;
                attendanceHolderDaily.description = null;
                attendanceHolderDaily.weekDay = null;
                attendanceHolderDaily.day = null;
                attendanceHolderDaily.month = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class AttendanceHolderPeriod_ViewBinding implements Unbinder {
        private AttendanceHolderPeriod target;

        @UiThread
        public AttendanceHolderPeriod_ViewBinding(AttendanceHolderPeriod attendanceHolderPeriod, View view) {
            this.target = attendanceHolderPeriod;
            attendanceHolderPeriod.periods = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.period_list, "field 'periods'", RecyclerView.class);
            attendanceHolderPeriod.weekDay = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.weekday, "field 'weekDay'", TextView.class);
            attendanceHolderPeriod.day = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.day, "field 'day'", TextView.class);
            attendanceHolderPeriod.month = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.month, "field 'month'", TextView.class);
        }

        @CallSuper
        public void unbind() {
            AttendanceHolderPeriod attendanceHolderPeriod = this.target;
            if (attendanceHolderPeriod != null) {
                this.target = null;
                attendanceHolderPeriod.periods = null;
                attendanceHolderPeriod.weekDay = null;
                attendanceHolderPeriod.day = null;
                attendanceHolderPeriod.month = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0018\u00010\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\"\u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$PeriodAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$PeriodAdapter$PeriodHolder;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "periods", "", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Ljava/util/List;Lcom/aeries/mobileportal/models/AttendanceDetail;)V", "getAttendance", "()Lcom/aeries/mobileportal/models/AttendanceDetail;", "getPeriods", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PeriodHolder", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public final class PeriodAdapter extends Adapter<PeriodHolder> {
        @NotNull
        private final AttendanceDetail attendance;
        @NotNull
        private final List<AttendancePeriod> periods;
        final /* synthetic */ AttendanceAdapter this$0;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$PeriodAdapter$PeriodHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter$PeriodAdapter;Landroid/view/View;)V", "periodIndicator", "Landroid/support/v7/widget/CardView;", "getPeriodIndicator", "()Landroid/support/v7/widget/CardView;", "setPeriodIndicator", "(Landroid/support/v7/widget/CardView;)V", "periodNumber", "Landroid/widget/TextView;", "getPeriodNumber", "()Landroid/widget/TextView;", "setPeriodNumber", "(Landroid/widget/TextView;)V", "bindView", "", "attendancePeriod", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
        /* compiled from: AttendanceAdapter.kt */
        public final class PeriodHolder extends ViewHolder {
            @NotNull
            @BindView(2131362092)
            public CardView periodIndicator;
            @NotNull
            @BindView(2131362094)
            public TextView periodNumber;
            final /* synthetic */ PeriodAdapter this$0;

            public PeriodHolder(@NotNull PeriodAdapter periodAdapter, View view) {
                Intrinsics.checkParameterIsNotNull(view, "itemView");
                this.this$0 = periodAdapter;
                super(view);
                ButterKnife.bind((Object) this, view);
            }

            @NotNull
            public final TextView getPeriodNumber() {
                TextView textView = this.periodNumber;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("periodNumber");
                }
                return textView;
            }

            public final void setPeriodNumber(@NotNull TextView textView) {
                Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
                this.periodNumber = textView;
            }

            @NotNull
            public final CardView getPeriodIndicator() {
                CardView cardView = this.periodIndicator;
                if (cardView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("periodIndicator");
                }
                return cardView;
            }

            public final void setPeriodIndicator(@NotNull CardView cardView) {
                Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
                this.periodIndicator = cardView;
            }

            public final void bindView(@Nullable AttendancePeriod attendancePeriod, @NotNull AttendanceDetail attendanceDetail) {
                Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
                TextView textView = this.periodNumber;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("periodNumber");
                }
                Object obj = null;
                textView.setText(String.valueOf(attendancePeriod != null ? Integer.valueOf(attendancePeriod.getPeriod()) : null));
                if (attendancePeriod != null) {
                    obj = attendancePeriod.getCode();
                }
                if ((Intrinsics.areEqual(obj, (Object) "") ^ 1) != null) {
                    attendancePeriod = this.periodIndicator;
                    if (attendancePeriod == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("periodIndicator");
                    }
                    View view = this.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
                    attendancePeriod.setCardBackgroundColor(ContextCompat.getColor(view.getContext(), C0316R.color.aeries_red));
                } else {
                    attendancePeriod = this.periodIndicator;
                    if (attendancePeriod == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("periodIndicator");
                    }
                    attendancePeriod.setBackgroundResource(C0316R.drawable.bg_period_indicator);
                }
                this.itemView.setOnClickListener(new AttendanceAdapter$PeriodAdapter$PeriodHolder$bindView$1(this, attendanceDetail));
            }
        }

        public final class PeriodHolder_ViewBinding implements Unbinder {
            private PeriodHolder target;

            @UiThread
            public PeriodHolder_ViewBinding(PeriodHolder periodHolder, View view) {
                this.target = periodHolder;
                periodHolder.periodNumber = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.period_number, "field 'periodNumber'", TextView.class);
                periodHolder.periodIndicator = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.period_indicator, "field 'periodIndicator'", CardView.class);
            }

            public void unbind() {
                PeriodHolder periodHolder = this.target;
                if (periodHolder != null) {
                    this.target = null;
                    periodHolder.periodNumber = null;
                    periodHolder.periodIndicator = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public PeriodAdapter(@NotNull AttendanceAdapter attendanceAdapter, @NotNull List<AttendancePeriod> list, AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(list, "periods");
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
            this.this$0 = attendanceAdapter;
            this.periods = list;
            this.attendance = attendanceDetail;
        }

        @NotNull
        public final AttendanceDetail getAttendance() {
            return this.attendance;
        }

        @NotNull
        public final List<AttendancePeriod> getPeriods() {
            return this.periods;
        }

        public void onBindViewHolder(@Nullable PeriodHolder periodHolder, int i) {
            if (periodHolder != null) {
                periodHolder.bindView((AttendancePeriod) this.periods.get(i), this.attendance);
            }
        }

        public int getItemCount() {
            return this.periods.size();
        }

        @NotNull
        public PeriodHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
            viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_period, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return new PeriodHolder(this, viewGroup);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderDaily;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolder;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Landroid/view/View;)V", "day", "Landroid/widget/TextView;", "getDay", "()Landroid/widget/TextView;", "setDay", "(Landroid/widget/TextView;)V", "description", "getDescription", "setDescription", "month", "getMonth", "setMonth", "weekDay", "getWeekDay", "setWeekDay", "bindView", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public class AttendanceHolderDaily extends AttendanceHolder {
        @NotNull
        @BindView(2131361910)
        public TextView day;
        @NotNull
        @BindView(2131362090)
        public TextView description;
        @NotNull
        @BindView(2131362047)
        public TextView month;
        final /* synthetic */ AttendanceAdapter this$0;
        @NotNull
        @BindView(2131362281)
        public TextView weekDay;

        public AttendanceHolderDaily(@NotNull AttendanceAdapter attendanceAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = attendanceAdapter;
            super(attendanceAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getDescription() {
            TextView textView = this.description;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
            }
            return textView;
        }

        public final void setDescription(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.description = textView;
        }

        @NotNull
        public final TextView getWeekDay() {
            TextView textView = this.weekDay;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weekDay");
            }
            return textView;
        }

        public final void setWeekDay(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.weekDay = textView;
        }

        @NotNull
        public final TextView getDay() {
            TextView textView = this.day;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("day");
            }
            return textView;
        }

        public final void setDay(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.day = textView;
        }

        @NotNull
        public final TextView getMonth() {
            TextView textView = this.month;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("month");
            }
            return textView;
        }

        public final void setMonth(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.month = textView;
        }

        public void bindView(@NotNull AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
            TextView textView = this.weekDay;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weekDay");
            }
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            textView.setText(view.getContext().getText(DateUtils.Companion.getWeekDay(attendanceDetail.getAttendanceDate())));
            textView = this.day;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("day");
            }
            textView.setText(DateUtils.Companion.getDayInMonth(attendanceDetail.getAttendanceDate()));
            textView = this.month;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("month");
            }
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            textView.setText(view.getContext().getText(DateUtils.Companion.getMonth(attendanceDetail.getAttendanceDate())));
            textView = this.description;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
            }
            textView.setText(attendanceDetail.getAllDayDescription());
        }
    }

    public final class AttendanceHolderDailyHeader_ViewBinding extends AttendanceHolderDaily_ViewBinding {
        private AttendanceHolderDailyHeader target;

        @UiThread
        public AttendanceHolderDailyHeader_ViewBinding(AttendanceHolderDailyHeader attendanceHolderDailyHeader, View view) {
            super(attendanceHolderDailyHeader, view);
            this.target = attendanceHolderDailyHeader;
            attendanceHolderDailyHeader.header = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.header, "field 'header'", TextView.class);
        }

        public void unbind() {
            AttendanceHolderDailyHeader attendanceHolderDailyHeader = this.target;
            if (attendanceHolderDailyHeader != null) {
                this.target = null;
                attendanceHolderDailyHeader.header = null;
                super.unbind();
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderPeriod;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolder;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Landroid/view/View;)V", "day", "Landroid/widget/TextView;", "getDay", "()Landroid/widget/TextView;", "setDay", "(Landroid/widget/TextView;)V", "month", "getMonth", "setMonth", "periods", "Landroid/support/v7/widget/RecyclerView;", "getPeriods", "()Landroid/support/v7/widget/RecyclerView;", "setPeriods", "(Landroid/support/v7/widget/RecyclerView;)V", "weekDay", "getWeekDay", "setWeekDay", "bindView", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public class AttendanceHolderPeriod extends AttendanceHolder {
        @NotNull
        @BindView(2131361910)
        public TextView day;
        @NotNull
        @BindView(2131362047)
        public TextView month;
        @NotNull
        @BindView(2131362093)
        public RecyclerView periods;
        final /* synthetic */ AttendanceAdapter this$0;
        @NotNull
        @BindView(2131362281)
        public TextView weekDay;

        public AttendanceHolderPeriod(@NotNull AttendanceAdapter attendanceAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = attendanceAdapter;
            super(attendanceAdapter, view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final RecyclerView getPeriods() {
            RecyclerView recyclerView = this.periods;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("periods");
            }
            return recyclerView;
        }

        public final void setPeriods(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
            this.periods = recyclerView;
        }

        @NotNull
        public final TextView getWeekDay() {
            TextView textView = this.weekDay;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weekDay");
            }
            return textView;
        }

        public final void setWeekDay(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.weekDay = textView;
        }

        @NotNull
        public final TextView getDay() {
            TextView textView = this.day;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("day");
            }
            return textView;
        }

        public final void setDay(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.day = textView;
        }

        @NotNull
        public final TextView getMonth() {
            TextView textView = this.month;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("month");
            }
            return textView;
        }

        public final void setMonth(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.month = textView;
        }

        public void bindView(@NotNull AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            C0961x4826acde c0961x4826acde = new C0961x4826acde(this, view.getContext(), 0, false);
            RecyclerView recyclerView = this.periods;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("periods");
            }
            recyclerView.setLayoutManager(c0961x4826acde);
            RecyclerView recyclerView2 = this.periods;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("periods");
            }
            AttendanceAdapter attendanceAdapter = this.this$0;
            List attendancePeriods = attendanceDetail.getAttendancePeriods();
            if (attendancePeriods == null) {
                Intrinsics.throwNpe();
            }
            recyclerView2.setAdapter(new PeriodAdapter(attendanceAdapter, attendancePeriods, attendanceDetail));
            TextView textView = this.weekDay;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weekDay");
            }
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            textView.setText(view.getContext().getText(DateUtils.Companion.getWeekDay(attendanceDetail.getAttendanceDate())));
            textView = this.day;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("day");
            }
            textView.setText(DateUtils.Companion.getDayInMonth(attendanceDetail.getAttendanceDate()));
            textView = this.month;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("month");
            }
            view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            textView.setText(view.getContext().getText(DateUtils.Companion.getMonth(attendanceDetail.getAttendanceDate())));
            this.itemView.setOnClickListener(new AttendanceAdapter$AttendanceHolderPeriod$bindView$1(this, attendanceDetail));
        }
    }

    public final class AttendanceHolderPeriodHeader_ViewBinding extends AttendanceHolderPeriod_ViewBinding {
        private AttendanceHolderPeriodHeader target;

        @UiThread
        public AttendanceHolderPeriodHeader_ViewBinding(AttendanceHolderPeriodHeader attendanceHolderPeriodHeader, View view) {
            super(attendanceHolderPeriodHeader, view);
            this.target = attendanceHolderPeriodHeader;
            attendanceHolderPeriodHeader.header = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.header, "field 'header'", TextView.class);
        }

        public void unbind() {
            AttendanceHolderPeriodHeader attendanceHolderPeriodHeader = this.target;
            if (attendanceHolderPeriodHeader != null) {
                this.target = null;
                attendanceHolderPeriodHeader.header = null;
                super.unbind();
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderDailyHeader;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderDaily;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Landroid/view/View;)V", "header", "Landroid/widget/TextView;", "getHeader", "()Landroid/widget/TextView;", "setHeader", "(Landroid/widget/TextView;)V", "bindView", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public final class AttendanceHolderDailyHeader extends AttendanceHolderDaily {
        @NotNull
        @BindView(2131361984)
        public TextView header;
        final /* synthetic */ AttendanceAdapter this$0;

        public AttendanceHolderDailyHeader(@NotNull AttendanceAdapter attendanceAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = attendanceAdapter;
            super(attendanceAdapter, view);
        }

        @NotNull
        public final TextView getHeader() {
            TextView textView = this.header;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("header");
            }
            return textView;
        }

        public final void setHeader(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.header = textView;
        }

        public void bindView(@NotNull AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
            super.bindView(attendanceDetail);
            TextView textView = this.header;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("header");
            }
            textView.setText(attendanceDetail.getSchoolName());
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderPeriodHeader;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderPeriod;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;Landroid/view/View;)V", "header", "Landroid/widget/TextView;", "getHeader", "()Landroid/widget/TextView;", "setHeader", "(Landroid/widget/TextView;)V", "bindView", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceAdapter.kt */
    public final class AttendanceHolderPeriodHeader extends AttendanceHolderPeriod {
        @NotNull
        @BindView(2131361984)
        public TextView header;
        final /* synthetic */ AttendanceAdapter this$0;

        public AttendanceHolderPeriodHeader(@NotNull AttendanceAdapter attendanceAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = attendanceAdapter;
            super(attendanceAdapter, view);
        }

        @NotNull
        public final TextView getHeader() {
            TextView textView = this.header;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("header");
            }
            return textView;
        }

        public final void setHeader(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.header = textView;
        }

        public void bindView(@NotNull AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
            super.bindView(attendanceDetail);
            TextView textView = this.header;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("header");
            }
            textView.setText(attendanceDetail.getSchoolName());
        }
    }

    public AttendanceAdapter(@NotNull AttendanceListener attendanceListener) {
        Intrinsics.checkParameterIsNotNull(attendanceListener, CastExtraArgs.LISTENER);
        this.listener = attendanceListener;
    }

    @NotNull
    public final AttendanceListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<AttendanceDetail> getAttendances() {
        return this.attendances;
    }

    public final int getDAILY() {
        return this.DAILY;
    }

    public final int getPERIOD() {
        return this.PERIOD;
    }

    public final int getDAILY_HEADER() {
        return this.DAILY_HEADER;
    }

    public final int getPERIOD_HEADER() {
        return this.PERIOD_HEADER;
    }

    public void onBindViewHolder(@Nullable AttendanceHolder attendanceHolder, int i) {
        if (attendanceHolder != null) {
            attendanceHolder.bindView((AttendanceDetail) this.attendances.get(i));
        }
    }

    @NotNull
    public AttendanceHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null);
        if (i == this.DAILY) {
            viewGroup = from.inflate(C0316R.layout.holder_attendance_daily, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (AttendanceHolder) new AttendanceHolderDaily(this, viewGroup);
        } else if (i == this.PERIOD) {
            viewGroup = from.inflate(C0316R.layout.holder_attendance_period, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (AttendanceHolder) new AttendanceHolderPeriod(this, viewGroup);
        } else if (i == this.DAILY_HEADER) {
            viewGroup = from.inflate(C0316R.layout.holder_attendance_daily_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (AttendanceHolder) new AttendanceHolderDailyHeader(this, viewGroup);
        } else if (i == this.PERIOD_HEADER) {
            viewGroup = from.inflate(C0316R.layout.holder_attendance_period_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (AttendanceHolder) new AttendanceHolderPeriodHeader(this, viewGroup);
        } else {
            viewGroup = from.inflate(C0316R.layout.holder_attendance_period_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
            return (AttendanceHolder) new AttendanceHolderPeriodHeader(this, viewGroup);
        }
    }

    public int getItemViewType(int i) {
        if ((Intrinsics.areEqual(((AttendanceDetail) this.attendances.get(i)).getAllDayCode(), (Object) "") ^ 1) != 0) {
            if (((AttendanceDetail) this.attendances.get(i)).getSchoolName() == 0) {
                return this.DAILY;
            }
            return this.DAILY_HEADER;
        } else if (((AttendanceDetail) this.attendances.get(i)).getSchoolName() == 0) {
            return this.PERIOD;
        } else {
            return this.PERIOD_HEADER;
        }
    }

    public int getItemCount() {
        return this.attendances.size();
    }

    public final void update(@NotNull List<AttendanceDetail> list) {
        Intrinsics.checkParameterIsNotNull(list, "attendances");
        this.attendances.clear();
        this.attendances.addAll(list);
        notifyDataSetChanged();
    }
}
