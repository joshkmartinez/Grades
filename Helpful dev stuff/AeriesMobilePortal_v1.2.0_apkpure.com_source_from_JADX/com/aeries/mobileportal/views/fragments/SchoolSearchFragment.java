package com.aeries.mobileportal.views.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.SchoolListAdapter;
import com.aeries.mobileportal.adapters.SchoolListAdapter.SchoolListAdapterListener;
import com.aeries.mobileportal.dagger.components.SchoolSearchFragmentComponent;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.viewmodels.SchoolSearchFragmentViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010W\u001a\u00020X2\u0006\u0010T\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002J\u0012\u0010Y\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020XH\u0016J\u0012\u0010\\\u001a\u00020X2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J(\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010e\u001a\u00020XH\u0016J-\u0010f\u001a\u00020X2\u0006\u0010g\u001a\u00020\u00062\u000e\u0010h\u001a\n\u0012\u0006\b\u0001\u0012\u00020j0i2\u0006\u0010k\u001a\u00020lH\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020XH\u0016J\b\u0010o\u001a\u00020XH\u0016J\b\u0010p\u001a\u00020XH\u0016J\u0010\u0010q\u001a\u00020X2\u0006\u0010r\u001a\u00020sH\u0016J\b\u0010t\u001a\u00020XH\u0002J\b\u0010u\u001a\u00020XH\u0002J\b\u0010v\u001a\u00020XH\u0002J\b\u0010w\u001a\u00020XH\u0002J\b\u0010x\u001a\u00020XH\u0002J\b\u0010y\u001a\u00020XH\u0002J\u0010\u0010z\u001a\u00020X2\u0006\u0010\u001f\u001a\u00020jH\u0016J\u0010\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u00020\u001cH\u0016J\u0016\u0010}\u001a\u00020X2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020s0H\u0016J\u0011\u0010\u0001\u001a\u00020X2\u0006\u0010|\u001a\u00020\u001cH\u0002J\u0017\u0010\u0001\u001a\u00020X2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020s0H\u0016J\u0011\u0010\u0001\u001a\u00020X2\u0006\u0010|\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001e\u0010\"\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001e\u0010%\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u00020;8FX\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020F8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010Q\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014R\u001e\u0010T\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0012\"\u0004\bV\u0010\u0014¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "()V", "LOCATION_REQUEST_CODE", "", "component", "Lcom/aeries/mobileportal/dagger/components/SchoolSearchFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SchoolSearchFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "learnMoreTV", "Landroid/widget/TextView;", "getLearnMoreTV", "()Landroid/widget/TextView;", "setLearnMoreTV", "(Landroid/widget/TextView;)V", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "mIsAddDistrict", "", "mListener", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment$SchoolSearchFragmentListener;", "message", "getMessage", "setMessage", "nearYouMessage", "getNearYouMessage", "setNearYouMessage", "nearbySchoolsMessage", "getNearbySchoolsMessage", "setNearbySchoolsMessage", "nearbyScoolsProgress", "Landroid/widget/ProgressBar;", "getNearbyScoolsProgress", "()Landroid/widget/ProgressBar;", "setNearbyScoolsProgress", "(Landroid/widget/ProgressBar;)V", "noResult", "Landroid/widget/LinearLayout;", "getNoResult", "()Landroid/widget/LinearLayout;", "setNoResult", "(Landroid/widget/LinearLayout;)V", "presenter", "Lcom/aeries/mobileportal/presenters/SchoolSearchFragmentPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/SchoolSearchFragmentPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/SchoolSearchFragmentPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "progressDialog$delegate", "schoolRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getSchoolRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setSchoolRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "schoolsAdapter", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "getSchoolsAdapter", "()Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "setSchoolsAdapter", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter;)V", "searchview", "Landroid/widget/SearchView;", "getSearchview", "()Landroid/widget/SearchView;", "setSearchview", "(Landroid/widget/SearchView;)V", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", "setTitle", "changeHeaderText", "", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSchoolNoURL", "onSchoolNotFoundSelected", "onSchoolSelected", "school", "Lcom/aeries/mobileportal/models/School;", "openNotFoundURL", "requestPermission", "requestSchoolsByLocation", "setUpProgressDialog", "setupLocation", "setupViews", "showError", "showNearbySchoolProgress", "show", "showNearbySchools", "schools", "", "showNoResults", "showSchools", "showSearchSchoolProgress", "Companion", "SchoolSearchFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragment.kt */
public final class SchoolSearchFragment extends Fragment implements SchoolListAdapterListener, SchoolSearchFragmentViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SchoolSearchFragment.class), "progressDialog", "getProgressDialog()Landroid/app/ProgressDialog;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SchoolSearchFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SchoolSearchFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private static final String IS_ADD_DISTRICT = "IS_ADD_DISTRICT";
    private final int LOCATION_REQUEST_CODE = 1432;
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SchoolSearchFragment$component$2(this));
    private FusedLocationProviderClient fusedLocationClient;
    @NotNull
    @BindView(2131362017)
    public TextView learnMoreTV;
    @NotNull
    public LocationCallback locationCallback;
    private boolean mIsAddDistrict;
    private SchoolSearchFragmentListener mListener;
    @NotNull
    @BindView(2131362037)
    public TextView message;
    @NotNull
    @BindView(2131362124)
    public TextView nearYouMessage;
    @NotNull
    @BindView(2131362052)
    public TextView nearbySchoolsMessage;
    @NotNull
    @BindView(2131362053)
    public ProgressBar nearbyScoolsProgress;
    @NotNull
    @BindView(2131362120)
    public LinearLayout noResult;
    @Inject
    @NotNull
    public SchoolSearchFragmentPresenter presenter;
    @NotNull
    private final Lazy progressDialog$delegate = LazyKt.lazy(new SchoolSearchFragment$progressDialog$2(this));
    @NotNull
    @BindView(2131362121)
    public RecyclerView schoolRecyclerView;
    @Inject
    @NotNull
    public SchoolListAdapter schoolsAdapter;
    @NotNull
    @BindView(2131362122)
    public SearchView searchview;
    @NotNull
    @BindView(2131362177)
    public TextView subtitle;
    @NotNull
    @BindView(2131362257)
    public TextView title;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment$Companion;", "", "()V", "IS_ADD_DISTRICT", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment;", "b", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolSearchFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SchoolSearchFragment newInstance(boolean z) {
            SchoolSearchFragment schoolSearchFragment = new SchoolSearchFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(SchoolSearchFragment.IS_ADD_DISTRICT, z);
            schoolSearchFragment.setArguments(bundle);
            return schoolSearchFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/SchoolSearchFragment$SchoolSearchFragmentListener;", "", "onSchoolNoUrl", "", "showSchoolDetails", "school", "Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SchoolSearchFragment.kt */
    public interface SchoolSearchFragmentListener {
        void onSchoolNoUrl();

        void showSchoolDetails(@NotNull School school);
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
    public final SchoolSearchFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (SchoolSearchFragmentComponent) lazy.getValue();
    }

    @NotNull
    public final ProgressDialog getProgressDialog() {
        Lazy lazy = this.progressDialog$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProgressDialog) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public static final /* synthetic */ FusedLocationProviderClient access$getFusedLocationClient$p(SchoolSearchFragment schoolSearchFragment) {
        schoolSearchFragment = schoolSearchFragment.fusedLocationClient;
        if (schoolSearchFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
        }
        return schoolSearchFragment;
    }

    @NotNull
    public final SearchView getSearchview() {
        SearchView searchView = this.searchview;
        if (searchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchview");
        }
        return searchView;
    }

    public final void setSearchview(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "<set-?>");
        this.searchview = searchView;
    }

    @NotNull
    public final TextView getTitle() {
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_TITLE_KEY);
        }
        return textView;
    }

    public final void setTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.title = textView;
    }

    @NotNull
    public final TextView getSubtitle() {
        TextView textView = this.subtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
        }
        return textView;
    }

    public final void setSubtitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.subtitle = textView;
    }

    @NotNull
    public final TextView getNearYouMessage() {
        TextView textView = this.nearYouMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearYouMessage");
        }
        return textView;
    }

    public final void setNearYouMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.nearYouMessage = textView;
    }

    @NotNull
    public final TextView getMessage() {
        TextView textView = this.message;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        return textView;
    }

    public final void setMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.message = textView;
    }

    @NotNull
    public final RecyclerView getSchoolRecyclerView() {
        RecyclerView recyclerView = this.schoolRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolRecyclerView");
        }
        return recyclerView;
    }

    public final void setSchoolRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.schoolRecyclerView = recyclerView;
    }

    @NotNull
    public final LinearLayout getNoResult() {
        LinearLayout linearLayout = this.noResult;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noResult");
        }
        return linearLayout;
    }

    public final void setNoResult(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.noResult = linearLayout;
    }

    @NotNull
    public final TextView getLearnMoreTV() {
        TextView textView = this.learnMoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("learnMoreTV");
        }
        return textView;
    }

    public final void setLearnMoreTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.learnMoreTV = textView;
    }

    @NotNull
    public final ProgressBar getNearbyScoolsProgress() {
        ProgressBar progressBar = this.nearbyScoolsProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyScoolsProgress");
        }
        return progressBar;
    }

    public final void setNearbyScoolsProgress(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.nearbyScoolsProgress = progressBar;
    }

    @NotNull
    public final TextView getNearbySchoolsMessage() {
        TextView textView = this.nearbySchoolsMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbySchoolsMessage");
        }
        return textView;
    }

    public final void setNearbySchoolsMessage(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.nearbySchoolsMessage = textView;
    }

    @NotNull
    public final SchoolListAdapter getSchoolsAdapter() {
        SchoolListAdapter schoolListAdapter = this.schoolsAdapter;
        if (schoolListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
        }
        return schoolListAdapter;
    }

    public final void setSchoolsAdapter(@NotNull SchoolListAdapter schoolListAdapter) {
        Intrinsics.checkParameterIsNotNull(schoolListAdapter, "<set-?>");
        this.schoolsAdapter = schoolListAdapter;
    }

    @NotNull
    public final LocationCallback getLocationCallback() {
        LocationCallback locationCallback = this.locationCallback;
        if (locationCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationCallback");
        }
        return locationCallback;
    }

    public final void setLocationCallback(@NotNull LocationCallback locationCallback) {
        Intrinsics.checkParameterIsNotNull(locationCallback, "<set-?>");
        this.locationCallback = locationCallback;
    }

    @NotNull
    public final SchoolSearchFragmentPresenter getPresenter() {
        SchoolSearchFragmentPresenter schoolSearchFragmentPresenter = this.presenter;
        if (schoolSearchFragmentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return schoolSearchFragmentPresenter;
    }

    public final void setPresenter(@NotNull SchoolSearchFragmentPresenter schoolSearchFragmentPresenter) {
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentPresenter, "<set-?>");
        this.presenter = schoolSearchFragmentPresenter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mIsAddDistrict = getArguments().getBoolean(IS_ADD_DISTRICT, false);
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_school_search, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupLocation();
        setupViews();
        requestPermission();
        return inflate;
    }

    private final void setupLocation() {
        this.fusedLocationClient = new FusedLocationProviderClient(getContext());
        this.locationCallback = new SchoolSearchFragment$setupLocation$1(this);
    }

    private final void requestPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            requestSchoolsByLocation();
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_REQUEST_CODE);
        }
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == this.LOCATION_REQUEST_CODE) {
            if ((1 ^ (iArr.length == 0 ? 1 : 0)) != null && iArr[0] == 0) {
                requestSchoolsByLocation();
            }
        }
    }

    private final void requestSchoolsByLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new SchoolSearchFragment$requestSchoolsByLocation$1(this));
    }

    private final void setupViews() {
        setUpProgressDialog();
        TextView textView = this.learnMoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("learnMoreTV");
        }
        textView.setOnClickListener(new SchoolSearchFragment$setupViews$1(this));
        SearchView searchView = this.searchview;
        if (searchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchview");
        }
        searchView.setOnQueryTextListener(new SchoolSearchFragment$setupViews$2(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.schoolRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolRecyclerView");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.schoolRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolRecyclerView");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.schoolRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolRecyclerView");
        }
        SchoolListAdapter schoolListAdapter = this.schoolsAdapter;
        if (schoolListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
        }
        recyclerView2.setAdapter(schoolListAdapter);
        if (this.mIsAddDistrict) {
            changeHeaderText(C0316R.string.locate_account, C0316R.string.add_district_message);
        }
    }

    private final void setUpProgressDialog() {
        getProgressDialog().setMessage(getString(C0316R.string.searching));
        getProgressDialog().setCancelable(false);
    }

    private final void openNotFoundURL() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://apps.aeries.com/mobile-portal/troubleshoot/cant-find-my-district/"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), 1).show();
        }
    }

    public void onResume() {
        super.onResume();
        setupViews();
    }

    private final void showNoResults(boolean z) {
        RecyclerView recyclerView = this.schoolRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolRecyclerView");
        }
        int i = 0;
        recyclerView.setVisibility(z ? 8 : 0);
        LinearLayout linearLayout = this.noResult;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noResult");
        }
        if (!z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        z = this.searchview;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("searchview");
        }
        z.clearFocus();
    }

    private final void changeHeaderText(int i, int i2) {
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_TITLE_KEY);
        }
        textView.setText(i);
        i = this.subtitle;
        if (i == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
        }
        i.setText(i2);
        i = this.message;
        if (i == 0) {
            Intrinsics.throwUninitializedPropertyAccessException(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        }
        i.setVisibility(8);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof SchoolSearchFragmentListener) {
            this.mListener = (SchoolSearchFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement SchoolSearchFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (SchoolSearchFragmentListener) null;
    }

    public void onSchoolSelected(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        SchoolSearchFragmentListener schoolSearchFragmentListener = this.mListener;
        if (schoolSearchFragmentListener != null) {
            schoolSearchFragmentListener.showSchoolDetails(school);
        }
    }

    public void onSchoolNoURL() {
        SchoolSearchFragmentListener schoolSearchFragmentListener = this.mListener;
        if (schoolSearchFragmentListener != null) {
            schoolSearchFragmentListener.onSchoolNoUrl();
        }
    }

    public void onSchoolNotFoundSelected() {
        openNotFoundURL();
    }

    public void showSchools(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        TextView textView = this.nearYouMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearYouMessage");
        }
        textView.setVisibility(8);
        SchoolListAdapter schoolListAdapter = this.schoolsAdapter;
        if (schoolListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
        }
        schoolListAdapter.updateList(list);
        showNoResults(list.isEmpty());
    }

    public void showNearbySchools(@NotNull List<? extends School> list) {
        Intrinsics.checkParameterIsNotNull(list, "schools");
        SchoolListAdapter schoolListAdapter = this.schoolsAdapter;
        if (schoolListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
        }
        if (schoolListAdapter.getItemCount() == 0) {
            TextView textView = this.nearYouMessage;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nearYouMessage");
            }
            textView.setVisibility(0);
            schoolListAdapter = this.schoolsAdapter;
            if (schoolListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
            }
            schoolListAdapter.updateList(list);
        }
    }

    public void showNearbySchoolProgress(boolean z) {
        TextView textView;
        ProgressBar progressBar;
        if (z) {
            z = this.schoolsAdapter;
            if (!z) {
                Intrinsics.throwUninitializedPropertyAccessException("schoolsAdapter");
            }
            if (!z.getItemCount()) {
                z = false;
                textView = this.nearbySchoolsMessage;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearbySchoolsMessage");
                }
                textView.setVisibility(z);
                progressBar = this.nearbyScoolsProgress;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nearbyScoolsProgress");
                }
                progressBar.setVisibility(z);
            }
        }
        z = true;
        textView = this.nearbySchoolsMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbySchoolsMessage");
        }
        textView.setVisibility(z);
        progressBar = this.nearbyScoolsProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nearbyScoolsProgress");
        }
        progressBar.setVisibility(z);
    }

    public void showSearchSchoolProgress(boolean z) {
        if (z) {
            getProgressDialog().show();
        } else {
            getProgressDialog().dismiss();
        }
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, str).setButton((int) C0316R.string.got_it, null).show();
    }
}
