package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter.DetailListener;
import com.aeries.mobileportal.dagger.components.MainFragmentComponent;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.MainFragmentPresenter;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.views.viewmodels.MainFragmentViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.RealmList;
import java.util.HashMap;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002XYB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020?H\u0007J\b\u0010C\u001a\u00020?H\u0016J\u0012\u0010C\u001a\u00020?2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J(\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010L\u001a\u00020?H\u0016J \u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020?H\u0016J\b\u0010T\u001a\u00020?H\u0007J\b\u0010U\u001a\u00020?H\u0002J\u0010\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020QH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006Z"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/MainFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;)V", "badge", "Landroid/support/v7/widget/CardView;", "getBadge", "()Landroid/support/v7/widget/CardView;", "setBadge", "(Landroid/support/v7/widget/CardView;)V", "badgeNumber", "Landroid/widget/TextView;", "getBadgeNumber", "()Landroid/widget/TextView;", "setBadgeNumber", "(Landroid/widget/TextView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/MainFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/MainFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "detailsRV", "Landroid/support/v7/widget/RecyclerView;", "getDetailsRV", "()Landroid/support/v7/widget/RecyclerView;", "setDetailsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/MainFragment$MainFragmentListener;", "mStudent", "Lcom/aeries/mobileportal/models/Student;", "presenter", "Lcom/aeries/mobileportal/presenters/MainFragmentPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/MainFragmentPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/MainFragmentPresenter;)V", "studentHeader", "Landroid/widget/ImageView;", "getStudentHeader", "()Landroid/widget/ImageView;", "setStudentHeader", "(Landroid/widget/ImageView;)V", "studentNameTV", "getStudentNameTV", "setStudentNameTV", "studentPicture", "Lde/hdodenhof/circleimageview/CircleImageView;", "getStudentPicture", "()Lde/hdodenhof/circleimageview/CircleImageView;", "setStudentPicture", "(Lde/hdodenhof/circleimageview/CircleImageView;)V", "getReportCardsEnabled", "", "onAttach", "", "context", "Landroid/content/Context;", "onBadgeClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onDetailSelected", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "positionX", "", "positionY", "onResume", "onStudentSelectClick", "setupViews", "showNotificationNumber", "notificationNumber", "Companion", "MainFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainFragment.kt */
public final class MainFragment extends Fragment implements DetailListener, MainFragmentViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/MainFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private static final String STUDENT = "STUDENT";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public StudentDetailsAdapter adapter;
    @NotNull
    @BindView(2131361847)
    public CardView badge;
    @NotNull
    @BindView(2131361848)
    public TextView badgeNumber;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new MainFragment$component$2(this));
    @NotNull
    @BindView(2131361930)
    public RecyclerView detailsRV;
    private MainFragmentListener mListener;
    private Student mStudent;
    @Inject
    @NotNull
    public MainFragmentPresenter presenter;
    @NotNull
    @BindView(2131362171)
    public ImageView studentHeader;
    @NotNull
    @BindView(2131362189)
    public TextView studentNameTV;
    @NotNull
    @BindView(2131362096)
    public CircleImageView studentPicture;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/MainFragment$Companion;", "", "()V", "STUDENT", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/MainFragment;", "student", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: MainFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MainFragment newInstance(@NotNull Student student) {
            Intrinsics.checkParameterIsNotNull(student, "student");
            MainFragment mainFragment = new MainFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(MainFragment.STUDENT, student);
            mainFragment.setArguments(bundle);
            return mainFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/MainFragment$MainFragmentListener;", "", "onDetailSelected", "", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "positionX", "", "positionY", "onHeaderClick", "openNotifications", "", "showStudentPictures", "imageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: MainFragment.kt */
    public interface MainFragmentListener {
        void onDetailSelected(@NotNull ViewPermission viewPermission, int i, int i2);

        void onHeaderClick(boolean z);

        void showStudentPictures(@NotNull CircleImageView circleImageView, @NotNull Student student);
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
    public final MainFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MainFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final ImageView getStudentHeader() {
        ImageView imageView = this.studentHeader;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentHeader");
        }
        return imageView;
    }

    public final void setStudentHeader(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.studentHeader = imageView;
    }

    @NotNull
    public final CircleImageView getStudentPicture() {
        CircleImageView circleImageView = this.studentPicture;
        if (circleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentPicture");
        }
        return circleImageView;
    }

    public final void setStudentPicture(@NotNull CircleImageView circleImageView) {
        Intrinsics.checkParameterIsNotNull(circleImageView, "<set-?>");
        this.studentPicture = circleImageView;
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

    @NotNull
    public final RecyclerView getDetailsRV() {
        RecyclerView recyclerView = this.detailsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsRV");
        }
        return recyclerView;
    }

    public final void setDetailsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.detailsRV = recyclerView;
    }

    @NotNull
    public final CardView getBadge() {
        CardView cardView = this.badge;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        return cardView;
    }

    public final void setBadge(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.badge = cardView;
    }

    @NotNull
    public final TextView getBadgeNumber() {
        TextView textView = this.badgeNumber;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgeNumber");
        }
        return textView;
    }

    public final void setBadgeNumber(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.badgeNumber = textView;
    }

    @NotNull
    public final StudentDetailsAdapter getAdapter() {
        StudentDetailsAdapter studentDetailsAdapter = this.adapter;
        if (studentDetailsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return studentDetailsAdapter;
    }

    public final void setAdapter(@NotNull StudentDetailsAdapter studentDetailsAdapter) {
        Intrinsics.checkParameterIsNotNull(studentDetailsAdapter, "<set-?>");
        this.adapter = studentDetailsAdapter;
    }

    @NotNull
    public final MainFragmentPresenter getPresenter() {
        MainFragmentPresenter mainFragmentPresenter = this.presenter;
        if (mainFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainFragmentPresenter;
    }

    public final void setPresenter(@NotNull MainFragmentPresenter mainFragmentPresenter) {
        Intrinsics.checkParameterIsNotNull(mainFragmentPresenter, "<set-?>");
        this.presenter = mainFragmentPresenter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mStudent = (Student) getArguments().getParcelable(STUDENT);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_main, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.detailsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView = this.detailsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsRV");
        }
        StudentDetailsAdapter studentDetailsAdapter = this.adapter;
        if (studentDetailsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(studentDetailsAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView2 = this.detailsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        TextView textView = this.studentNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("studentNameTV");
        }
        com.aeries.mobileportal.utils.StringUtils.Companion companion = StringUtils.Companion;
        Student student = this.mStudent;
        if (student == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(companion.getNameNoMiddle(student));
        MainFragmentListener mainFragmentListener = this.mListener;
        if (mainFragmentListener != null) {
            CircleImageView circleImageView = this.studentPicture;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("studentPicture");
            }
            student = this.mStudent;
            if (student == null) {
                Intrinsics.throwNpe();
            }
            mainFragmentListener.showStudentPictures(circleImageView, student);
        }
        StudentDetailsAdapter studentDetailsAdapter2 = this.adapter;
        if (studentDetailsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Student student2 = this.mStudent;
        RealmList views = student2 != null ? student2.getViews() : null;
        if (views == null) {
            Intrinsics.throwNpe();
        }
        studentDetailsAdapter2.update(views);
    }

    @OnClick({2131361985})
    public final void onStudentSelectClick() {
        MainFragmentListener mainFragmentListener = this.mListener;
        if (mainFragmentListener != null) {
            mainFragmentListener.onHeaderClick(false);
        }
    }

    @OnClick({2131361847})
    public final void onBadgeClick() {
        MainFragmentListener mainFragmentListener = this.mListener;
        if (mainFragmentListener != null) {
            mainFragmentListener.onHeaderClick(true);
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentListener) {
            this.mListener = (MainFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement MainFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onResume() {
        super.onResume();
        MainFragmentPresenter mainFragmentPresenter = this.presenter;
        if (mainFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainFragmentPresenter.getNotifications();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (MainFragmentListener) null;
    }

    public void onDetailSelected(@NotNull ViewPermission viewPermission, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewPermission, "viewPermission");
        MainFragmentListener mainFragmentListener = this.mListener;
        if (mainFragmentListener != null) {
            mainFragmentListener.onDetailSelected(viewPermission, i, i2);
        }
    }

    public boolean getReportCardsEnabled() {
        MainFragmentPresenter mainFragmentPresenter = this.presenter;
        if (mainFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainFragmentPresenter.getReportCardsEnabled();
    }

    public void showNotificationNumber(int i) {
        CardView cardView = this.badge;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        cardView.setVisibility(i > 0 ? 0 : 8);
        TextView textView = this.badgeNumber;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgeNumber");
        }
        textView.setText(String.valueOf(i));
    }
}
