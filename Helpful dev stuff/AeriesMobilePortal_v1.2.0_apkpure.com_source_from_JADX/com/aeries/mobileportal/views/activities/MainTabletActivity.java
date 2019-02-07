package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.MainTabletActivityComponent;
import com.aeries.mobileportal.enums.Settings;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.tablet.MainTabletPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.utils.FragmentUtils;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.AccountSettingsFragment.AccountSettingsFragmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment.AssignmentDetailsFragmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentsFragment.AssignmentsFragmentListener;
import com.aeries.mobileportal.views.fragments.AttendanceListFragment;
import com.aeries.mobileportal.views.fragments.ContactListFragment;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment.CourseSelectFragmentListener;
import com.aeries.mobileportal.views.fragments.DemographicsFragment;
import com.aeries.mobileportal.views.fragments.MainFragment;
import com.aeries.mobileportal.views.fragments.MainFragment.Companion;
import com.aeries.mobileportal.views.fragments.MainFragment.MainFragmentListener;
import com.aeries.mobileportal.views.fragments.SettingsFragment;
import com.aeries.mobileportal.views.fragments.SettingsFragment.SettingsFragmentListener;
import com.aeries.mobileportal.views.fragments.StudentSelectFragment.StudentSelectionListener;
import com.aeries.mobileportal.views.viewmodels.main_tablet.MainTabletViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u0005¢\u0006\u0002\u0010\nJ\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020*H\u0016J.\u00100\u001a\u00020*2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\f\u00105\u001a\b\u0012\u0004\u0012\u00020.06H\u0016J \u00107\u001a\u00020*2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4H\u0016J\u000f\u00108\u001a\u0004\u0018\u000109H\u0014¢\u0006\u0002\u0010:J\n\u0010;\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010<H\u0014J\n\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u00020*H\u0016J\b\u0010@\u001a\u00020*H\u0016J\b\u0010A\u001a\u00020*H\u0016J \u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002032\u0006\u0010F\u001a\u000203H\u0016J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0016J \u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020*H\u0016J \u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u0002092\u0006\u0010V\u001a\u000209H\u0016J\u0010\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020NH\u0016J'\u0010Y\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u0001092\u0006\u0010F\u001a\u000203H\u0016¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020*H\u0016J\u0010\u0010_\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020NH\u0002J\u0016\u0010b\u001a\u00020*2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020d06H\u0016J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020*2\u0006\u0010i\u001a\u00020N2\u0006\u0010j\u001a\u00020NH\u0016J\u0018\u0010k\u001a\u00020*2\u0006\u0010l\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006m"}, d2 = {"Lcom/aeries/mobileportal/views/activities/MainTabletActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/main_tablet/MainTabletViewModel;", "Lcom/aeries/mobileportal/views/fragments/MainFragment$MainFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/SettingsFragment$SettingsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment$AccountSettingsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment$StudentSelectionListener;", "Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment$CourseSelectFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment$AssignmentDetailsFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/MainTabletActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/MainTabletActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "courseSelectFragment", "Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment;", "getCourseSelectFragment", "()Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment;", "setCourseSelectFragment", "(Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment;)V", "imageLoader", "Lcom/aeries/mobileportal/utils/ImageLoader;", "getImageLoader", "()Lcom/aeries/mobileportal/utils/ImageLoader;", "setImageLoader", "(Lcom/aeries/mobileportal/utils/ImageLoader;)V", "presenter", "Lcom/aeries/mobileportal/presenters/tablet/MainTabletPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/tablet/MainTabletPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/tablet/MainTabletPresenter;)V", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "setProgress", "(Landroid/widget/ProgressBar;)V", "bindStudentImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "close", "displaySettingsParent", "settings", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "students", "", "displaySettingsStudent", "getLayout", "", "()Ljava/lang/Integer;", "getPortalVersion", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "invalidateToken", "onAccountSettingsOnScreen", "onAssignmentMocked", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "gradebookNumber", "termCode", "onAssignmentSelected", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onCourseSelect", "course", "Lcom/aeries/mobileportal/models/ClassSummary;", "showLastUpdated", "", "uiArguments", "Landroid/os/Bundle;", "onCreate", "onDetailSelected", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "positionX", "positionY", "onHeaderClick", "openNotifications", "onRemoveMockAssignment", "(Lcom/aeries/mobileportal/models/MockAssignment;Ljava/lang/Integer;Ljava/lang/String;)V", "onSettingSelected", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "onStudentSelectOnScreen", "onStudentSelected", "setProgressVisible", "b", "showCourses", "courses", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "showError", "e", "", "showGradesFragment", "dropdown", "lastUpdated", "showStudentPictures", "imageView", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainTabletActivity.kt */
public final class MainTabletActivity extends BaseActivity<MainTabletViewModel> implements MainTabletViewModel, MainFragmentListener, SettingsFragmentListener, AccountSettingsFragmentListener, StudentSelectionListener, CourseSelectFragmentListener, AssignmentsFragmentListener, AssignmentDetailsFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainTabletActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/MainTabletActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new MainTabletActivity$component$2(this));
    @NotNull
    public CourseSelectFragment courseSelectFragment;
    @Inject
    @NotNull
    public ImageLoader imageLoader;
    @Inject
    @NotNull
    public MainTabletPresenter presenter;
    @NotNull
    @BindView(2131361926)
    public ProgressBar progress;

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
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    @NotNull
    public final MainTabletActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MainTabletActivityComponent) lazy.getValue();
    }

    @Nullable
    public String getPortalVersion() {
        return null;
    }

    public void invalidateToken() {
    }

    public void onAccountSettingsOnScreen() {
    }

    public void onAssignmentMocked(@NotNull MockAssignment mockAssignment, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        Intrinsics.checkParameterIsNotNull(str, "gradebookNumber");
        Intrinsics.checkParameterIsNotNull(str2, "termCode");
    }

    public void onCourseSelect(@NotNull ClassSummary classSummary, boolean z, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "course");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
    }

    public void onRemoveMockAssignment(@NotNull MockAssignment mockAssignment, @Nullable Integer num, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        Intrinsics.checkParameterIsNotNull(str, "termCode");
    }

    public void onStudentSelectOnScreen() {
    }

    public void onStudentSelected(@NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(student, "student");
    }

    public void showCourses(@NotNull List<SchoolClassSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "courses");
    }

    @NotNull
    public final ProgressBar getProgress() {
        ProgressBar progressBar = this.progress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_PROGRESS);
        }
        return progressBar;
    }

    public final void setProgress(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progress = progressBar;
    }

    @NotNull
    public final MainTabletPresenter m112getPresenter() {
        MainTabletPresenter mainTabletPresenter = this.presenter;
        if (mainTabletPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainTabletPresenter;
    }

    public final void setPresenter(@NotNull MainTabletPresenter mainTabletPresenter) {
        Intrinsics.checkParameterIsNotNull(mainTabletPresenter, "<set-?>");
        this.presenter = mainTabletPresenter;
    }

    @NotNull
    public final ImageLoader getImageLoader() {
        ImageLoader imageLoader = this.imageLoader;
        if (imageLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageLoader");
        }
        return imageLoader;
    }

    public final void setImageLoader(@NotNull ImageLoader imageLoader) {
        Intrinsics.checkParameterIsNotNull(imageLoader, "<set-?>");
        this.imageLoader = imageLoader;
    }

    @NotNull
    public final CourseSelectFragment getCourseSelectFragment() {
        CourseSelectFragment courseSelectFragment = this.courseSelectFragment;
        if (courseSelectFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseSelectFragment");
        }
        return courseSelectFragment;
    }

    public final void setCourseSelectFragment(@NotNull CourseSelectFragment courseSelectFragment) {
        Intrinsics.checkParameterIsNotNull(courseSelectFragment, "<set-?>");
        this.courseSelectFragment = courseSelectFragment;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_main_tablet);
    }

    @Nullable
    protected BasePresenter<MainTabletViewModel> getPresenter() {
        MainTabletPresenter mainTabletPresenter = this.presenter;
        if (mainTabletPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainTabletPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Companion companion = MainFragment.Companion;
        MainTabletPresenter mainTabletPresenter = this.presenter;
        if (mainTabletPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Student selectedStudent = mainTabletPresenter.getSelectedStudent();
        if (selectedStudent == null) {
            Intrinsics.throwNpe();
        }
        beginTransaction.replace(C0316R.id.master, companion.newInstance(selectedStudent)).commit();
    }

    public void onHeaderClick(boolean z) {
        z = this.presenter;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        z.getSettingsType();
    }

    public void showStudentPictures(@NotNull CircleImageView circleImageView, @NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(circleImageView, "imageView");
        Intrinsics.checkParameterIsNotNull(student, "student");
        ImageLoader imageLoader = this.imageLoader;
        if (imageLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageLoader");
        }
        imageLoader.loadImage(circleImageView, student);
    }

    public void displaySettingsParent(@NotNull ArrayList<String> arrayList, @NotNull List<Student> list) {
        Intrinsics.checkParameterIsNotNull(arrayList, "settings");
        Intrinsics.checkParameterIsNotNull(list, "students");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_top, C0316R.anim.fade_out, 0, C0316R.anim.slide_out_top).replace(C0316R.id.master, SettingsFragment.Companion.newInstance("Parent", false, false)).addToBackStack(null).commit();
    }

    public void displaySettingsStudent(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "settings");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_top, C0316R.anim.fade_out, 0, C0316R.anim.slide_out_top).replace(C0316R.id.master, SettingsFragment.Companion.newInstance("Student", false, false)).addToBackStack(null).commit();
    }

    public void close() {
        getSupportFragmentManager().popBackStack();
    }

    public void bindStudentImage(@NotNull CircleImageView circleImageView, @NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(circleImageView, "circleImageView");
        Intrinsics.checkParameterIsNotNull(student, "student");
        ImageLoader imageLoader = this.imageLoader;
        if (imageLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageLoader");
        }
        imageLoader.loadImage(circleImageView, student);
    }

    public void onSettingSelected(@NotNull Settings settings) {
        Intrinsics.checkParameterIsNotNull(settings, "setting");
        startActivity(settings.getIntent(this));
    }

    public void onDetailSelected(@NotNull ViewPermission viewPermission, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewPermission, "viewPermission");
        i = viewPermission.getViewCode();
        if (i != 0) {
            switch (i.hashCode()) {
                case -126857307:
                    if (i.equals("Feedback") != null) {
                        startActivity(new Intent(this, FeedbackActivity.class));
                        return;
                    }
                    return;
                case 65137:
                    if (i.equals("ATD") != null) {
                        startActivity(new Intent(this, SupplementalAttendanceActivity.class));
                        return;
                    }
                    return;
                case 65153:
                    if (i.equals("ATT") != null) {
                        viewPermission = FragmentUtils.Companion;
                        i = getSupportFragmentManager();
                        Intrinsics.checkExpressionValueIsNotNull(i, "supportFragmentManager");
                        viewPermission.replaceFragment(i, C0316R.id.detail, AttendanceListFragment.Companion.newInstance());
                        return;
                    }
                    return;
                case 66914:
                    if (i.equals("CON") != null) {
                        viewPermission = FragmentUtils.Companion;
                        i = getSupportFragmentManager();
                        Intrinsics.checkExpressionValueIsNotNull(i, "supportFragmentManager");
                        viewPermission.replaceFragment(i, C0316R.id.detail, ContactListFragment.Companion.newInstance());
                        return;
                    }
                    return;
                case 70360:
                    if (i.equals("GBS") != null) {
                        viewPermission = this.presenter;
                        if (viewPermission == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        viewPermission.checkGradesViewPermissions();
                        setProgressVisible(true);
                        return;
                    }
                    return;
                case 70841:
                    if (i.equals("GRD") != null) {
                        viewPermission = this.presenter;
                        if (viewPermission == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        viewPermission.checkGradesViewPermissions();
                        setProgressVisible(true);
                        return;
                    }
                    return;
                case 82172:
                    if (i.equals("SKT") != 0) {
                        i = new Intent(this, CommunicationsActivity.class);
                        i.putExtra(DataBufferSafeParcelable.DATA_FIELD, viewPermission);
                        startActivity(i);
                        return;
                    }
                    return;
                case 82452:
                    if (i.equals("STU") != null) {
                        Demographics demographics;
                        viewPermission = FragmentUtils.Companion;
                        i = getSupportFragmentManager();
                        Intrinsics.checkExpressionValueIsNotNull(i, "supportFragmentManager");
                        i2 = DemographicsFragment.Companion;
                        MainTabletPresenter mainTabletPresenter = this.presenter;
                        if (mainTabletPresenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        Student selectedStudent = mainTabletPresenter.getSelectedStudent();
                        if (selectedStudent != null) {
                            demographics = selectedStudent.getDemographics();
                            if (demographics != null) {
                                viewPermission.replaceFragment(i, C0316R.id.detail, i2.newInstance(demographics));
                                return;
                            }
                        }
                        demographics = new Demographics();
                        viewPermission.replaceFragment(i, C0316R.id.detail, i2.newInstance(demographics));
                        return;
                    }
                    return;
                case 1935849800:
                    if (i.equals("LoopAccess") != null) {
                        startActivity(new Intent(this, CommunicationsActivity.class));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void showGradesFragment(boolean z, boolean z2) {
        setProgressVisible(false);
        FragmentUtils.Companion companion = FragmentUtils.Companion;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        companion.replaceFragmentBackstack(supportFragmentManager, true, CourseSelectFragment.Companion.newInstance(z, z2));
    }

    private final void setProgressVisible(boolean z) {
        ProgressBar progressBar = this.progress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_PROGRESS);
        }
        progressBar.setVisibility(z ? false : true);
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        DialogUtils.Companion.getErrorDialogBuilder(this, th.getMessage()).setButton((int) C0316R.string.got_it, null).show();
    }

    public void onAssignmentSelected(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        AssignmentDetailsFragment.Companion.newInstance(assignment).show(getSupportFragmentManager().beginTransaction().addToBackStack(null), AssignmentDetailsFragment.Companion.getTAG());
    }
}
