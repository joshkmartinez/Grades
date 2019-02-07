package com.aeries.mobileportal.adapters;

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
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.utils.StringUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentHolder;", "listener", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "(Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "students", "", "Lcom/aeries/mobileportal/models/Student;", "getStudents", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "update", "", "StudentHolder", "StudentSelectListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentSelectAdapter.kt */
public final class StudentSelectAdapter extends Adapter<StudentHolder> {
    @NotNull
    private final StudentSelectListener listener;
    @NotNull
    private final List<Student> students = ((List) new ArrayList());

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "", "bindStudentImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "onStudentSelected", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentSelectAdapter.kt */
    public interface StudentSelectListener {
        void bindStudentImage(@NotNull CircleImageView circleImageView, @NotNull Student student);

        void onStudentSelected(@NotNull Student student);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;Landroid/view/View;)V", "studentNameTV", "Landroid/widget/TextView;", "getStudentNameTV", "()Landroid/widget/TextView;", "setStudentNameTV", "(Landroid/widget/TextView;)V", "studentPicView", "Lde/hdodenhof/circleimageview/CircleImageView;", "getStudentPicView", "()Lde/hdodenhof/circleimageview/CircleImageView;", "setStudentPicView", "(Lde/hdodenhof/circleimageview/CircleImageView;)V", "bindData", "", "student", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentSelectAdapter.kt */
    public final class StudentHolder extends ViewHolder {
        @NotNull
        @BindView(2131362189)
        public TextView studentNameTV;
        @NotNull
        @BindView(2131362096)
        public CircleImageView studentPicView;
        final /* synthetic */ StudentSelectAdapter this$0;

        public StudentHolder(@NotNull StudentSelectAdapter studentSelectAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = studentSelectAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final CircleImageView getStudentPicView() {
            CircleImageView circleImageView = this.studentPicView;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentPicView");
            }
            return circleImageView;
        }

        public final void setStudentPicView(@NotNull CircleImageView circleImageView) {
            Intrinsics.checkParameterIsNotNull(circleImageView, "<set-?>");
            this.studentPicView = circleImageView;
        }

        @NotNull
        public final TextView getStudentNameTV() {
            TextView textView = this.studentNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentNameTV");
            }
            return textView;
        }

        public final void setStudentNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.studentNameTV = textView;
        }

        public final void bindData(@NotNull Student student) {
            Intrinsics.checkParameterIsNotNull(student, "student");
            TextView textView = this.studentNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentNameTV");
            }
            textView.setText(StringUtils.Companion.getFullName(student));
            this.itemView.setOnClickListener(new StudentSelectAdapter$StudentHolder$bindData$1(this, student));
            StudentSelectListener listener = this.this$0.getListener();
            CircleImageView circleImageView = this.studentPicView;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentPicView");
            }
            listener.bindStudentImage(circleImageView, student);
        }
    }

    public final class StudentHolder_ViewBinding implements Unbinder {
        private StudentHolder target;

        @UiThread
        public StudentHolder_ViewBinding(StudentHolder studentHolder, View view) {
            this.target = studentHolder;
            studentHolder.studentPicView = (CircleImageView) Utils.findRequiredViewAsType(view, C0316R.id.picture, "field 'studentPicView'", CircleImageView.class);
            studentHolder.studentNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.text, "field 'studentNameTV'", TextView.class);
        }

        public void unbind() {
            StudentHolder studentHolder = this.target;
            if (studentHolder != null) {
                this.target = null;
                studentHolder.studentPicView = null;
                studentHolder.studentNameTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public StudentSelectAdapter(@NotNull StudentSelectListener studentSelectListener) {
        Intrinsics.checkParameterIsNotNull(studentSelectListener, CastExtraArgs.LISTENER);
        this.listener = studentSelectListener;
    }

    @NotNull
    public final StudentSelectListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<Student> getStudents() {
        return this.students;
    }

    public void onBindViewHolder(@Nullable StudentHolder studentHolder, int i) {
        if (studentHolder != null) {
            studentHolder.bindData((Student) this.students.get(i));
        }
    }

    public int getItemCount() {
        return this.students.size();
    }

    @NotNull
    public StudentHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_circleimage_text, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "inflater.inflate(R.layou…cleimage_text, p0, false)");
        return new StudentHolder(this, viewGroup);
    }

    public final void update(@NotNull List<? extends Student> list) {
        Intrinsics.checkParameterIsNotNull(list, "students");
        this.students.clear();
        this.students.addAll(list);
        notifyDataSetChanged();
    }
}
