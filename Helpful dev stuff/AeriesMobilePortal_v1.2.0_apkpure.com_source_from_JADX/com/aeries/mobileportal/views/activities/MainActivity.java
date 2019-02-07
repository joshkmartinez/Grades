package com.aeries.mobileportal.views.activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter.DetailListener;
import com.aeries.mobileportal.dagger.components.MainActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.enums.Settings;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.MainPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.custom.AeriesDialogI.Builder;
import com.aeries.mobileportal.views.fragments.AccountSettingsFragment.AccountSettingsFragmentListener;
import com.aeries.mobileportal.views.fragments.MainFragment;
import com.aeries.mobileportal.views.fragments.MainFragment.MainFragmentListener;
import com.aeries.mobileportal.views.fragments.NotificationsFragment.NotificationsFragmentListener;
import com.aeries.mobileportal.views.fragments.SettingsFragment;
import com.aeries.mobileportal.views.fragments.SettingsFragment.Companion;
import com.aeries.mobileportal.views.fragments.SettingsFragment.SettingsFragmentListener;
import com.aeries.mobileportal.views.fragments.StudentSelectFragment.StudentSelectionListener;
import com.aeries.mobileportal.views.viewmodels.main.MainViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import de.hdodenhof.circleimageview.CircleImageView;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001/\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0005¢\u0006\u0002\u0010\tJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000202H\u0016J\u000f\u00108\u001a\u0004\u0018\u000109H\u0014¢\u0006\u0002\u0010:J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020\u0011H\u0016J\n\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000202H\u0016J\b\u0010B\u001a\u000202H\u0016J\b\u0010C\u001a\u000202H\u0016J\b\u0010D\u001a\u000202H\u0016J\b\u0010E\u001a\u000202H\u0014J \u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u0002092\u0006\u0010J\u001a\u000209H\u0016J\u0010\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\u0011H\u0016J\b\u0010M\u001a\u000202H\u0014J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020\u0011H\u0007J\b\u0010R\u001a\u00020\u0011H\u0007J\b\u0010S\u001a\u000202H\u0007J\b\u0010T\u001a\u000202H\u0016J\u0010\u0010U\u001a\u0002022\u0006\u00105\u001a\u000206H\u0016J\b\u0010V\u001a\u000202H\u0002J\u0010\u0010W\u001a\u0002022\u0006\u0010X\u001a\u00020<H\u0016J\b\u0010Y\u001a\u000202H\u0016J\u0010\u0010Z\u001a\u0002022\u0006\u0010X\u001a\u00020<H\u0016J\u0010\u0010[\u001a\u0002022\u0006\u0010X\u001a\u00020<H\u0016J\u0012\u0010\\\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010]\u001a\u0002022\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0018\u0010^\u001a\u0002022\u0006\u0010_\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\b\u0010`\u001a\u000202H\u0016R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u00020/X\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006a"}, d2 = {"Lcom/aeries/mobileportal/views/activities/MainActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/main/MainViewModel;", "Lcom/aeries/mobileportal/views/fragments/MainFragment$MainFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/SettingsFragment$SettingsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/StudentSelectFragment$StudentSelectionListener;", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "Lcom/aeries/mobileportal/views/fragments/AccountSettingsFragment$AccountSettingsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/NotificationsFragment$NotificationsFragmentListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;)V", "comesFromBackground", "", "getComesFromBackground", "()Z", "setComesFromBackground", "(Z)V", "component", "Lcom/aeries/mobileportal/dagger/components/MainActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/MainActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "imageLoader", "Lcom/aeries/mobileportal/utils/ImageLoader;", "getImageLoader", "()Lcom/aeries/mobileportal/utils/ImageLoader;", "setImageLoader", "(Lcom/aeries/mobileportal/utils/ImageLoader;)V", "presenter", "Lcom/aeries/mobileportal/presenters/MainPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/MainPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/MainPresenter;)V", "unbinder", "Lbutterknife/Unbinder;", "getUnbinder", "()Lbutterknife/Unbinder;", "setUnbinder", "(Lbutterknife/Unbinder;)V", "unlockReceiver", "com/aeries/mobileportal/views/activities/MainActivity$unlockReceiver$1", "Lcom/aeries/mobileportal/views/activities/MainActivity$unlockReceiver$1;", "bindStudentImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "close", "getLayout", "", "()Ljava/lang/Integer;", "getPortalVersion", "", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getReportCardsEnabled", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "invalidateToken", "onAccountSettingsOnScreen", "onCreate", "onDestroy", "onDetailSelected", "viewPermission", "Lcom/aeries/mobileportal/models/ViewPermission;", "positionX", "positionY", "onHeaderClick", "openNotifications", "onResume", "onSettingSelected", "setting", "Lcom/aeries/mobileportal/enums/Settings;", "onStudentNameLongClick", "onStudentPictureLongClick", "onStudentSelectClick", "onStudentSelectOnScreen", "onStudentSelected", "setupViews", "showError", "message", "showInvalidatedAccessTokenToast", "showRestrictionMessage", "showRestrictionMessageLogout", "showSelectedStudent", "showSettings", "showStudentPictures", "imageView", "startLoginActivity", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseActivity<MainViewModel> implements MainViewModel, MainFragmentListener, SettingsFragmentListener, StudentSelectionListener, DetailListener, AccountSettingsFragmentListener, NotificationsFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/MainActivityComponent;"))};
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public StudentDetailsAdapter adapter;
    private boolean comesFromBackground = true;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new MainActivity$component$2(this));
    @Inject
    @NotNull
    public ImageLoader imageLoader;
    @Inject
    @NotNull
    public MainPresenter presenter;
    @NotNull
    public Unbinder unbinder;
    private final MainActivity$unlockReceiver$1 unlockReceiver = new MainActivity$unlockReceiver$1(this);

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
    public final MainActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MainActivityComponent) lazy.getValue();
    }

    public boolean getReportCardsEnabled() {
        return true;
    }

    @OnLongClick({2131362189})
    public final boolean onStudentNameLongClick() {
        return true;
    }

    @OnLongClick({2131362096})
    public final boolean onStudentPictureLongClick() {
        return true;
    }

    @NotNull
    public final MainPresenter m105getPresenter() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainPresenter;
    }

    public final void setPresenter(@NotNull MainPresenter mainPresenter) {
        Intrinsics.checkParameterIsNotNull(mainPresenter, "<set-?>");
        this.presenter = mainPresenter;
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
    public final Unbinder getUnbinder() {
        Unbinder unbinder = this.unbinder;
        if (unbinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unbinder");
        }
        return unbinder;
    }

    public final void setUnbinder(@NotNull Unbinder unbinder) {
        Intrinsics.checkParameterIsNotNull(unbinder, "<set-?>");
        this.unbinder = unbinder;
    }

    public final boolean getComesFromBackground() {
        return this.comesFromBackground;
    }

    public final void setComesFromBackground(boolean z) {
        this.comesFromBackground = z;
    }

    @OnClick({2131361985})
    public final void onStudentSelectClick() {
        showSettings(false);
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_main);
    }

    @Nullable
    protected BasePresenter<MainViewModel> getPresenter() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainPresenter;
    }

    public void inject() {
        getComponent().inject(this);
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void onCreate() {
        registerReceiver(this.unlockReceiver, new IntentFilter("android.intent.action.SCREEN_ON"));
        setupViews();
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (mainPresenter.getLogoutForPortalVersion()) {
            new Builder(this).setMessage((int) C0316R.string.logout_for_portal_version).setButton((int) C0316R.string.got_it, (Function0) new MainActivity$onCreate$1(this)).setOnCancelListener(new MainActivity$onCreate$2(this)).show();
            return;
        }
        mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.getRestrictions();
    }

    private final void setupViews() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.getSelectedStudent();
    }

    protected void onResume() {
        super.onResume();
        this.comesFromBackground = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.unlockReceiver);
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.setMessageShown(false);
    }

    public void onHeaderClick(boolean z) {
        showSettings(z);
    }

    private final void showSettings(boolean z) {
        FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_top, C0316R.anim.fade_out, 0, C0316R.anim.slide_out_top);
        Companion companion = SettingsFragment.Companion;
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        String userType = mainPresenter.getUserType();
        MainPresenter mainPresenter2 = this.presenter;
        if (mainPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        customAnimations.replace(C0316R.id.main_screen, companion.newInstance(userType, mainPresenter2.areNotificationsEnabled(), z)).addToBackStack(null).commit();
    }

    public void showSelectedStudent(@Nullable Student student) {
        if (student != null) {
            getSupportFragmentManager().beginTransaction().replace(C0316R.id.main_screen, MainFragment.Companion.newInstance(student)).commit();
        }
    }

    public void onStudentSelected(@NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(student, "student");
        getSupportFragmentManager().popBackStackImmediate();
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.setSelectedStudent(student);
        showSelectedStudent(student);
        student = this.presenter;
        if (student == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        student.getRestrictions();
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

    public void onDetailSelected(@NotNull ViewPermission viewPermission, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewPermission, "viewPermission");
        String viewCode = viewPermission.getViewCode();
        if (viewCode == null) {
            Intrinsics.throwNpe();
        }
        Context context = this;
        Intent permissionIntent = Permissions.valueOf(viewCode).getPermissionIntent(context);
        permissionIntent.putExtra("positionX", i);
        permissionIntent.putExtra("positionY", i2);
        permissionIntent.putExtra(DataBufferSafeParcelable.DATA_FIELD, viewPermission);
        viewPermission = ActivityOptions.makeCustomAnimation(context, 17432576, 17432577).toBundle();
        Intrinsics.checkExpressionValueIsNotNull(viewPermission, "ActivityOptions.makeCust…anim.fade_out).toBundle()");
        this.comesFromBackground = false;
        startActivity(permissionIntent, viewPermission);
    }

    public void showInvalidatedAccessTokenToast() {
        Toast.makeText(this, "Token invalidated", 0).show();
    }

    public void onSettingSelected(@NotNull Settings settings) {
        Intrinsics.checkParameterIsNotNull(settings, "setting");
        this.comesFromBackground = false;
        if (settings == Settings.Logout) {
            settings = this.presenter;
            if (settings == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            settings.logout();
            return;
        }
        Context context = this;
        if (settings.getIntent(context) != null) {
            startActivity(settings.getIntent(context));
        }
    }

    @Nullable
    public String getPortalVersion() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return mainPresenter.getPortalVersion();
    }

    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    public void showRestrictionMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        new Builder(this).setMessage(str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void close() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    public void showRestrictionMessageLogout(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        new Builder(this).setMessage(str).setButton((int) C0316R.string.got_it, (Function0) new MainActivity$showRestrictionMessageLogout$1(this)).setCancelable(false).show();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void invalidateToken() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.invalidateAccessToken();
    }

    public void onAccountSettingsOnScreen() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.sendAccountSettingsAnalytics();
    }

    public void onStudentSelectOnScreen() {
        MainPresenter mainPresenter = this.presenter;
        if (mainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mainPresenter.sendStudentSelectAnalytics();
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
}
