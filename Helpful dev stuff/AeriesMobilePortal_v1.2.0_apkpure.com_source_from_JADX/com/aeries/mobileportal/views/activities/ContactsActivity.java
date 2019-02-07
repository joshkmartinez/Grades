package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.ContactsActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.Contact;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.contacts.ContactsPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.utils.IntentUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.ContactDetailFragment;
import com.aeries.mobileportal.views.fragments.ContactDetailFragment.ContactDetailFragmentListener;
import com.aeries.mobileportal.views.fragments.ContactListFragment;
import com.aeries.mobileportal.views.fragments.ContactListFragment.ContactListFragmentListener;
import com.aeries.mobileportal.views.viewmodels.contacts.ContactsViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010Q\u001a\u00020RH\u0007J\u0010\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0007H\u0016J\u000f\u0010U\u001a\u0004\u0018\u00010JH\u0014¢\u0006\u0002\u0010VJ\u0010\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010WH\u0014J\n\u0010X\u001a\u0004\u0018\u00010YH\u0014J\b\u0010Z\u001a\u00020RH\u0016J\u0012\u0010[\u001a\u00020R2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020RH\u0016J\u0010\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020aH\u0016J\b\u0010b\u001a\u00020RH\u0016J\u0012\u0010c\u001a\u00020R2\b\u0010d\u001a\u0004\u0018\u00010]H\u0016J\b\u0010e\u001a\u00020RH\u0014J\u0010\u0010f\u001a\u00020R2\u0006\u0010g\u001a\u00020\u0007H\u0016J\b\u0010h\u001a\u00020RH\u0002J\b\u0010i\u001a\u00020RH\u0002J\u0018\u0010j\u001a\u00020R2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010lH\u0016J\u0010\u0010m\u001a\u00020R2\u0006\u0010n\u001a\u00020oH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010\u000bR\u001b\u0010I\u001a\u00020J8FX\u0002¢\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020J8FX\u0002¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bO\u0010L¨\u0006p"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ContactsActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/contacts/ContactsViewModel;", "Lcom/aeries/mobileportal/views/fragments/ContactListFragment$ContactListFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment$ContactDetailFragmentListener;", "()V", "canViewDetails", "", "getCanViewDetails", "()Z", "setCanViewDetails", "(Z)V", "component", "Lcom/aeries/mobileportal/dagger/components/ContactsActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ContactsActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "contactDetailFragment", "Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment;", "getContactDetailFragment", "()Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment;", "setContactDetailFragment", "(Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment;)V", "contactListFragment", "Lcom/aeries/mobileportal/views/fragments/ContactListFragment;", "getContactListFragment", "()Lcom/aeries/mobileportal/views/fragments/ContactListFragment;", "contactListFragment$delegate", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "presenter", "Lcom/aeries/mobileportal/presenters/contacts/ContactsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/contacts/ContactsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/contacts/ContactsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "startAnimationEnded", "getStartAnimationEnded", "setStartAnimationEnded", "x", "", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "closeActivity", "", "enableDetails", "b", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onAddressPressed", "address", "", "onCloseButtonPressed", "onContactSelected", "contact", "Lcom/aeries/mobileportal/models/Contact;", "onCreate", "onPhonePressed", "phone", "onStop", "onWindowFocusChanged", "hasFocus", "performInitialSetup", "setupViews", "showContacts", "contacts", "", "showContactsError", "e", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsActivity.kt */
public final class ContactsActivity extends BaseActivity<ContactsViewModel> implements ContactsViewModel, ContactListFragmentListener, ContactDetailFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactsActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactsActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactsActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactsActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ContactsActivityComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactsActivity.class), "contactListFragment", "getContactListFragment()Lcom/aeries/mobileportal/views/fragments/ContactListFragment;"))};
    private HashMap _$_findViewCache;
    private boolean canViewDetails;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ContactsActivity$component$2(this));
    @NotNull
    public ContactDetailFragment contactDetailFragment;
    @NotNull
    private final Lazy contactListFragment$delegate = LazyKt.lazy(ContactsActivity$contactListFragment$2.INSTANCE);
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new ContactsActivity$data$2(this));
    @NotNull
    @BindView(2131361924)
    public ImageView detailIcon;
    @NotNull
    @BindView(2131361925)
    public TextView detailName;
    @NotNull
    @BindView(2131361927)
    public CardView detailTitle;
    @NotNull
    @BindView(2131361968)
    public RelativeLayout fragmentContainer;
    @Inject
    @NotNull
    public ContactsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean startAnimationEnded;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new ContactsActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new ContactsActivity$y$2(this));

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
    public final ContactsActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (ContactsActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ContactListFragment getContactListFragment() {
        Lazy lazy = this.contactListFragment$delegate;
        KProperty kProperty = $$delegatedProperties[4];
        return (ContactListFragment) lazy.getValue();
    }

    @NotNull
    public final ViewPermission getData() {
        Lazy lazy = this.data$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (ViewPermission) lazy.getValue();
    }

    public final int getX() {
        Lazy lazy = this.x$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    public final int getY() {
        Lazy lazy = this.y$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
    }

    public final boolean getStartAnimationEnded() {
        return this.startAnimationEnded;
    }

    public final void setStartAnimationEnded(boolean z) {
        this.startAnimationEnded = z;
    }

    @NotNull
    public final CardView getDetailTitle() {
        CardView cardView = this.detailTitle;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        return cardView;
    }

    public final void setDetailTitle(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.detailTitle = cardView;
    }

    @NotNull
    public final TextView getDetailName() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        return textView;
    }

    public final void setDetailName(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.detailName = textView;
    }

    @NotNull
    public final ImageView getDetailIcon() {
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        return imageView;
    }

    public final void setDetailIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.detailIcon = imageView;
    }

    @NotNull
    public final RelativeLayout getFragmentContainer() {
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        return relativeLayout;
    }

    public final void setFragmentContainer(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkParameterIsNotNull(relativeLayout, "<set-?>");
        this.fragmentContainer = relativeLayout;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final ContactDetailFragment getContactDetailFragment() {
        ContactDetailFragment contactDetailFragment = this.contactDetailFragment;
        if (contactDetailFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactDetailFragment");
        }
        return contactDetailFragment;
    }

    public final void setContactDetailFragment(@NotNull ContactDetailFragment contactDetailFragment) {
        Intrinsics.checkParameterIsNotNull(contactDetailFragment, "<set-?>");
        this.contactDetailFragment = contactDetailFragment;
    }

    @NotNull
    public final ContactsPresenter m100getPresenter() {
        ContactsPresenter contactsPresenter = this.presenter;
        if (contactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return contactsPresenter;
    }

    public final void setPresenter(@NotNull ContactsPresenter contactsPresenter) {
        Intrinsics.checkParameterIsNotNull(contactsPresenter, "<set-?>");
        this.presenter = contactsPresenter;
    }

    public final boolean getCanViewDetails() {
        return this.canViewDetails;
    }

    public final void setCanViewDetails(boolean z) {
        this.canViewDetails = z;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    @Nullable
    protected BasePresenter<ContactsViewModel> getPresenter() {
        ContactsPresenter contactsPresenter = this.presenter;
        if (contactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return contactsPresenter;
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
        setupViews();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new ContactsActivity$onWindowFocusChanged$1(this));
        }
    }

    protected void onStop() {
        super.onStop();
        ContactsPresenter contactsPresenter = this.presenter;
        if (contactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactsPresenter.onStop();
    }

    @OnClick({2131361925})
    public final void closeActivity() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setClickable(false);
        Companion companion = AnimationUtils.Companion;
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        companion.fadeOut(relativeLayout);
        companion = AnimationUtils.Companion;
        CardView cardView = this.detailTitle;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new ContactsActivity$closeActivity$1(this));
    }

    private final void performInitialSetup() {
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, getContactListFragment()).commit();
        this.startAnimationEnded = true;
        ContactsPresenter contactsPresenter = this.presenter;
        if (contactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactsPresenter.getCurrentStudentContacts();
    }

    private final void setupViews() {
        String viewCode = getData().getViewCode();
        if (viewCode == null) {
            Intrinsics.throwNpe();
        }
        Permissions valueOf = Permissions.valueOf(viewCode);
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setText(getText(valueOf.getPermissionName()));
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setImageResource(valueOf.getImageID());
    }

    public void showContacts(@Nullable List<Contact> list) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        ContactListFragment contactListFragment = getContactListFragment();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        contactListFragment.updateContacts(list);
    }

    public void enableDetails(boolean z) {
        this.canViewDetails = z;
    }

    public void showContactsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (Intrinsics.areEqual(th.getMessage(), (Object) "HTTP 401 Unauthorized")) {
            th = "There was a problem, please try again.";
        } else {
            th = th.getMessage();
            if (th == null) {
                th = "";
            }
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, th).setButton((int) C0316R.string.got_it, (Function0) new ContactsActivity$showContactsError$1(this)).setCancelable(false).show();
    }

    public void onContactSelected(@NotNull Contact contact) {
        Intrinsics.checkParameterIsNotNull(contact, "contact");
        if (this.canViewDetails) {
            this.contactDetailFragment = ContactDetailFragment.Companion.newInstance(contact);
            contact = getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_bottom, C0316R.anim.fade_out, C0316R.anim.fade_in, C0316R.anim.slide_out_bottom);
            ContactDetailFragment contactDetailFragment = this.contactDetailFragment;
            if (contactDetailFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactDetailFragment");
            }
            contact.replace(C0316R.id.fragment_container, contactDetailFragment).addToBackStack(null).commit();
            contact = this.presenter;
            if (contact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            contact.sendDetailsAnalytics();
        }
    }

    public void onCloseButtonPressed() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    public void onAddressPressed(@Nullable String str) {
        startActivity(IntentUtils.Companion.getLocationIntent(str));
    }

    public void onPhonePressed(@Nullable String str) {
        if (str != null && (Intrinsics.areEqual((Object) str, (Object) "") ^ 1) != 0) {
            startActivity(IntentUtils.Companion.getPhoneIntent(str));
        }
    }
}
