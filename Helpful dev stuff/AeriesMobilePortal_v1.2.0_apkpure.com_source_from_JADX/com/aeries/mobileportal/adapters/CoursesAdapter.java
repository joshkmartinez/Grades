package com.aeries.mobileportal.adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import com.aeries.mobileportal.ColorConstants;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.views.custom.CourseRowView;
import com.aeries.mobileportal.views.custom.CourseRowView.CourseRowListener;
import com.aeries.mobileportal.views.rowviewmodels.CourseRowViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002-.B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u001e\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\rJ\u001c\u0010(\u001a\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110)2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/aeries/mobileportal/adapters/CoursesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/CoursesAdapter$ViewHolder;", "Lcom/aeries/mobileportal/views/custom/CourseRowView$CourseRowListener;", "listener", "Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "(Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;)V", "courses", "", "Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "headers", "", "isLastUpdatedVisible", "", "getListener", "()Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "summaries", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "getItemCount", "getItemViewType", "position", "getTermName", "", "int", "getUIBundle", "Landroid/os/Bundle;", "index", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onHeaderClick", "summary", "Lcom/aeries/mobileportal/models/ClassSummary;", "uiArguments", "setLastUpdatedVisibility", "boolean", "update", "", "term", "updateTerm", "time", "CourseListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoursesAdapter.kt */
public final class CoursesAdapter extends Adapter<ViewHolder> implements CourseRowListener {
    private final List<CourseRowViewModel> courses = ((List) new ArrayList());
    private final List<Integer> headers = ((List) new ArrayList());
    private boolean isLastUpdatedVisible;
    @NotNull
    private final CourseListener listener;
    private final List<SchoolClassSummary> summaries = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "", "onCourseSelect", "", "summary", "Lcom/aeries/mobileportal/models/ClassSummary;", "uiArguments", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CoursesAdapter.kt */
    public interface CourseListener {
        void onCourseSelect(@NotNull ClassSummary classSummary, @NotNull Bundle bundle);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/adapters/CoursesAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/CoursesAdapter;Landroid/view/View;)V", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CoursesAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        final /* synthetic */ CoursesAdapter this$0;

        public ViewHolder(@NotNull CoursesAdapter coursesAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = coursesAdapter;
            super(view);
        }
    }

    private final String getTermName(int i) {
        switch (i) {
            case 0:
                return "Current Terms";
            case 1:
                return "Prior Terms";
            case 2:
                return "Future Terms";
            default:
                return "Current Terms";
        }
    }

    public CoursesAdapter(@NotNull CourseListener courseListener) {
        Intrinsics.checkParameterIsNotNull(courseListener, CastExtraArgs.LISTENER);
        this.listener = courseListener;
    }

    @NotNull
    public final CourseListener getListener() {
        return this.listener;
    }

    public void onBindViewHolder(@Nullable ViewHolder viewHolder, int i) {
        viewHolder = viewHolder != null ? viewHolder.itemView : null;
        if (viewHolder != null) {
            CourseRowView courseRowView = (CourseRowView) viewHolder;
            courseRowView.setData((CourseRowViewModel) this.courses.get(i));
            courseRowView.setListener(this);
            courseRowView.setViewType(getItemViewType(i));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.custom.CourseRowView");
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        return new ViewHolder(this, new CourseRowView(viewGroup != null ? viewGroup.getContext() : null));
    }

    public int getItemViewType(int i) {
        return this.headers.contains(Integer.valueOf(i)) ^ 1;
    }

    public int getItemCount() {
        return this.courses.size();
    }

    public final void update(@NotNull List<? extends SchoolClassSummary> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "summaries");
        this.summaries.clear();
        this.courses.clear();
        this.headers.clear();
        this.summaries.addAll(list);
        this.headers.add(Integer.valueOf(0));
        int i2 = 0;
        for (SchoolClassSummary schoolClassSummary : list) {
            Iterator it = schoolClassSummary.getClassSummaries().iterator();
            while (it.hasNext()) {
                ClassSummary classSummary = (ClassSummary) it.next();
                if (StringsKt.equals$default(classSummary.getTerm(), getTermName(i), false, 2, null)) {
                    classSummary.setStudentID(schoolClassSummary.getStudentID());
                    classSummary.setSchoolCode(schoolClassSummary.getSchoolCode());
                    String schoolName = schoolClassSummary.getSchoolName();
                    if (schoolName == null) {
                        schoolName = "";
                    }
                    classSummary.setSchoolName(schoolName);
                    classSummary.setShowPeriod(schoolClassSummary.getShowPeriod());
                    classSummary.setHideScores(schoolClassSummary.getHideScores());
                    List list2 = this.courses;
                    Intrinsics.checkExpressionValueIsNotNull(classSummary, "course");
                    list2.add(new CourseRowViewModel(classSummary, this.isLastUpdatedVisible, getUIBundle(i2)));
                    i2++;
                }
            }
            this.headers.add(Integer.valueOf(this.courses.size()));
        }
        notifyDataSetChanged();
    }

    public final void updateTerm(int i) {
        this.courses.clear();
        this.headers.clear();
        this.headers.add(Integer.valueOf(0));
        int i2 = 0;
        for (SchoolClassSummary schoolClassSummary : this.summaries) {
            Iterator it = schoolClassSummary.getClassSummaries().iterator();
            while (it.hasNext()) {
                ClassSummary classSummary = (ClassSummary) it.next();
                if (StringsKt.equals$default(classSummary.getTerm(), getTermName(i), false, 2, null)) {
                    classSummary.setStudentID(schoolClassSummary.getStudentID());
                    classSummary.setSchoolCode(schoolClassSummary.getSchoolCode());
                    String schoolName = schoolClassSummary.getSchoolName();
                    if (schoolName == null) {
                        schoolName = "";
                    }
                    classSummary.setSchoolName(schoolName);
                    classSummary.setShowPeriod(schoolClassSummary.getShowPeriod());
                    classSummary.setHideScores(schoolClassSummary.getHideScores());
                    List list = this.courses;
                    Intrinsics.checkExpressionValueIsNotNull(classSummary, "course");
                    list.add(new CourseRowViewModel(classSummary, this.isLastUpdatedVisible, getUIBundle(i2)));
                    i2++;
                }
            }
            this.headers.add(Integer.valueOf(this.courses.size()));
        }
        notifyDataSetChanged();
    }

    public final void setLastUpdatedVisibility(boolean z) {
        this.isLastUpdatedVisible = z;
        notifyDataSetChanged();
    }

    private final Bundle getUIBundle(int i) {
        i = ColorConstants.Companion.getCourseColors()[i % ((Object[]) ColorConstants.Companion.getCourseColors()).length];
        int intValue = i[0].intValue();
        i = i[1].intValue();
        int[] iArr = new int[2];
        Bundle bundle = new Bundle();
        bundle.putInt("textColor", i);
        bundle.putInt("buttonColor", intValue);
        bundle.putInt("positionX", iArr[0]);
        bundle.putInt("positionY", iArr[1]);
        bundle.putFloat("rotation", 180.0f);
        return bundle;
    }

    public void onHeaderClick(@NotNull ClassSummary classSummary, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "summary");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        this.listener.onCourseSelect(classSummary, bundle);
    }
}
