package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.StudentSelectAdapter;
import com.aeries.mobileportal.adapters.StudentSelectAdapter.StudentSelectListener;
import com.aeries.mobileportal.dagger.components.StudentSelectFragmentComponent;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.presenters.StudentSelectPresenter;
import com.aeries.mobileportal.views.viewmodels.StudentSelectViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002EFB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020&H\u0007J\u0012\u0010,\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020&H\u0016J \u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000203H\u0016J(\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020&H\u0016J\u0010\u0010@\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010A\u001a\u00020&H\u0002J\u0016\u0010B\u001a\u00020&2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020*0DH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006G"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter$StudentSelectListener;", "Lcom/aeries/mobileportal/views/viewmodels/StudentSelectViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/StudentSelectAdapter;)V", "closeIcon", "Landroid/widget/ImageView;", "getCloseIcon", "()Landroid/widget/ImageView;", "setCloseIcon", "(Landroid/widget/ImageView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/StudentSelectFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/StudentSelectFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment$StudentSelectionListener;", "presenter", "Lcom/aeries/mobileportal/presenters/StudentSelectPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/StudentSelectPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/StudentSelectPresenter;)V", "studentRV", "Landroid/support/v7/widget/RecyclerView;", "getStudentRV", "()Landroid/support/v7/widget/RecyclerView;", "setStudentRV", "(Landroid/support/v7/widget/RecyclerView;)V", "bindStudentImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "close", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onStudentSelected", "setupViews", "showStudents", "students", "", "Companion", "StudentSelectionListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentSelectFragment.kt */
public final class StudentSelectFragment extends Fragment implements StudentSelectListener, StudentSelectViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StudentSelectFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/StudentSelectFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String STUDENTS = "STUDENTS";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public StudentSelectAdapter adapter;
    @NotNull
    @BindView(2131361882)
    public ImageView closeIcon;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new StudentSelectFragment$component$2(this));
    private StudentSelectionListener mListener;
    @Inject
    @NotNull
    public StudentSelectPresenter presenter;
    @NotNull
    @BindView(2131362103)
    public RecyclerView studentRV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment$Companion;", "", "()V", "STUDENTS", "", "getSTUDENTS", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentSelectFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getSTUDENTS() {
            return StudentSelectFragment.STUDENTS;
        }

        @NotNull
        public final StudentSelectFragment newInstance() {
            StudentSelectFragment studentSelectFragment = new StudentSelectFragment();
            studentSelectFragment.setArguments(new Bundle());
            return studentSelectFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment$StudentSelectionListener;", "", "bindStudentImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "close", "onStudentSelected", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: StudentSelectFragment.kt */
    public interface StudentSelectionListener {
        void bindStudentImage(@NotNull CircleImageView circleImageView, @NotNull Student student);

        void close();

        void onStudentSelected(@NotNull Student student);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    @NotNull
    public final StudentSelectFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (StudentSelectFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getStudentRV() {
        RecyclerView recyclerView = this.studentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentRV");
        }
        return recyclerView;
    }

    public final void setStudentRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.studentRV = recyclerView;
    }

    @NotNull
    public final ImageView getCloseIcon() {
        ImageView imageView = this.closeIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIcon");
        }
        return imageView;
    }

    public final void setCloseIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.closeIcon = imageView;
    }

    @NotNull
    public final StudentSelectAdapter getAdapter() {
        StudentSelectAdapter studentSelectAdapter = this.adapter;
        if (studentSelectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return studentSelectAdapter;
    }

    public final void setAdapter(@NotNull StudentSelectAdapter studentSelectAdapter) {
        Intrinsics.checkParameterIsNotNull(studentSelectAdapter, "<set-?>");
        this.adapter = studentSelectAdapter;
    }

    @NotNull
    public final StudentSelectPresenter getPresenter() {
        StudentSelectPresenter studentSelectPresenter = this.presenter;
        if (studentSelectPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return studentSelectPresenter;
    }

    public final void setPresenter(@NotNull StudentSelectPresenter studentSelectPresenter) {
        Intrinsics.checkParameterIsNotNull(studentSelectPresenter, "<set-?>");
        this.presenter = studentSelectPresenter;
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_student_select, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof StudentSelectionListener) {
            this.mListener = (StudentSelectionListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AccountSettingsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    @OnClick({2131361882})
    public final void close() {
        if (this.mListener != null) {
            StudentSelectionListener studentSelectionListener = this.mListener;
            if (studentSelectionListener != null) {
                studentSelectionListener.close();
            }
        }
    }

    private final void setupViews() {
        RecyclerView recyclerView = this.studentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentRV");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView = this.studentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentRV");
        }
        StudentSelectAdapter studentSelectAdapter = this.adapter;
        if (studentSelectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(studentSelectAdapter);
        StudentSelectPresenter studentSelectPresenter = this.presenter;
        if (studentSelectPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        studentSelectPresenter.getStudents();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (StudentSelectionListener) null;
    }

    public void showStudents(@NotNull List<? extends Student> list) {
        Intrinsics.checkParameterIsNotNull(list, "students");
        StudentSelectAdapter studentSelectAdapter = this.adapter;
        if (studentSelectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        studentSelectAdapter.update(list);
    }

    @NotNull
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        i = new AlphaAnimation(1.0f, 1.0f);
        z = getContext();
        Intrinsics.checkExpressionValueIsNotNull(z, "context");
        i.setDuration((long) z.getResources().getInteger(17694722));
        return (Animation) i;
    }

    public void onStudentSelected(@NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(student, "student");
        StudentSelectionListener studentSelectionListener = this.mListener;
        if (studentSelectionListener != null) {
            studentSelectionListener.onStudentSelected(student);
        }
    }

    public void bindStudentImage(@NotNull CircleImageView circleImageView, @NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(circleImageView, "circleImageView");
        Intrinsics.checkParameterIsNotNull(student, "student");
        StudentSelectionListener studentSelectionListener = this.mListener;
        if (studentSelectionListener != null) {
            studentSelectionListener.bindStudentImage(circleImageView, student);
        }
    }
}
