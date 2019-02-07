package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Contact;
import com.aeries.mobileportal.utils.StringUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0002ABB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u000202H\u0007J\u0012\u00106\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J(\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010?\u001a\u000202H\u0016J\b\u0010@\u001a\u000202H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001e\u0010%\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001e\u0010+\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001e\u0010.\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000e¨\u0006C"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment;", "Landroid/support/v4/app/Fragment;", "()V", "addressIcon", "Landroid/widget/ImageView;", "getAddressIcon", "()Landroid/widget/ImageView;", "setAddressIcon", "(Landroid/widget/ImageView;)V", "addressTV", "Landroid/widget/TextView;", "getAddressTV", "()Landroid/widget/TextView;", "setAddressTV", "(Landroid/widget/TextView;)V", "closeButton", "Landroid/widget/Button;", "getCloseButton", "()Landroid/widget/Button;", "setCloseButton", "(Landroid/widget/Button;)V", "fullNameTV", "getFullNameTV", "setFullNameTV", "mContact", "Lcom/aeries/mobileportal/models/Contact;", "mListener", "Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment$ContactDetailFragmentListener;", "mPhoneIcon", "getMPhoneIcon", "setMPhoneIcon", "mobilePhoneTV", "getMobilePhoneTV", "setMobilePhoneTV", "relationshipTV", "getRelationshipTV", "setRelationshipTV", "telephoneIcon", "getTelephoneIcon", "setTelephoneIcon", "telephoneTV", "getTelephoneTV", "setTelephoneTV", "wPhoneIcon", "getWPhoneIcon", "setWPhoneIcon", "workPhoneTV", "getWorkPhoneTV", "setWorkPhoneTV", "onAttach", "", "context", "Landroid/content/Context;", "onCloseButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setupViews", "Companion", "ContactDetailFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactDetailFragment.kt */
public final class ContactDetailFragment extends Fragment {
    private static final String CONTACT = "param1";
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361825)
    public ImageView addressIcon;
    @NotNull
    @BindView(2131361824)
    public TextView addressTV;
    @NotNull
    @BindView(2131361870)
    public Button closeButton;
    @NotNull
    @BindView(2131361969)
    public TextView fullNameTV;
    private Contact mContact;
    private ContactDetailFragmentListener mListener;
    @NotNull
    @BindView(2131362048)
    public ImageView mPhoneIcon;
    @NotNull
    @BindView(2131362041)
    public TextView mobilePhoneTV;
    @NotNull
    @BindView(2131362104)
    public TextView relationshipTV;
    @NotNull
    @BindView(2131362185)
    public ImageView telephoneIcon;
    @NotNull
    @BindView(2131362184)
    public TextView telephoneTV;
    @NotNull
    @BindView(2131362288)
    public ImageView wPhoneIcon;
    @NotNull
    @BindView(2131362286)
    public TextView workPhoneTV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment$Companion;", "", "()V", "CONTACT", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment;", "contact", "Lcom/aeries/mobileportal/models/Contact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ContactDetailFragment newInstance(@NotNull Contact contact) {
            Intrinsics.checkParameterIsNotNull(contact, "contact");
            ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ContactDetailFragment.CONTACT, contact);
            contactDetailFragment.setArguments(bundle);
            return contactDetailFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactDetailFragment$ContactDetailFragmentListener;", "", "onAddressPressed", "", "address", "", "onCloseButtonPressed", "onPhonePressed", "phone", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactDetailFragment.kt */
    public interface ContactDetailFragmentListener {
        void onAddressPressed(@Nullable String str);

        void onCloseButtonPressed();

        void onPhonePressed(@Nullable String str);
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final TextView getFullNameTV() {
        TextView textView = this.fullNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullNameTV");
        }
        return textView;
    }

    public final void setFullNameTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.fullNameTV = textView;
    }

    @NotNull
    public final TextView getRelationshipTV() {
        TextView textView = this.relationshipTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relationshipTV");
        }
        return textView;
    }

    public final void setRelationshipTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.relationshipTV = textView;
    }

    @NotNull
    public final TextView getMobilePhoneTV() {
        TextView textView = this.mobilePhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobilePhoneTV");
        }
        return textView;
    }

    public final void setMobilePhoneTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mobilePhoneTV = textView;
    }

    @NotNull
    public final TextView getWorkPhoneTV() {
        TextView textView = this.workPhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workPhoneTV");
        }
        return textView;
    }

    public final void setWorkPhoneTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.workPhoneTV = textView;
    }

    @NotNull
    public final TextView getTelephoneTV() {
        TextView textView = this.telephoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("telephoneTV");
        }
        return textView;
    }

    public final void setTelephoneTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.telephoneTV = textView;
    }

    @NotNull
    public final TextView getAddressTV() {
        TextView textView = this.addressTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTV");
        }
        return textView;
    }

    public final void setAddressTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.addressTV = textView;
    }

    @NotNull
    public final Button getCloseButton() {
        Button button = this.closeButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        }
        return button;
    }

    public final void setCloseButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.closeButton = button;
    }

    @NotNull
    public final ImageView getWPhoneIcon() {
        ImageView imageView = this.wPhoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wPhoneIcon");
        }
        return imageView;
    }

    public final void setWPhoneIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.wPhoneIcon = imageView;
    }

    @NotNull
    public final ImageView getTelephoneIcon() {
        ImageView imageView = this.telephoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("telephoneIcon");
        }
        return imageView;
    }

    public final void setTelephoneIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.telephoneIcon = imageView;
    }

    @NotNull
    public final ImageView getMPhoneIcon() {
        ImageView imageView = this.mPhoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneIcon");
        }
        return imageView;
    }

    public final void setMPhoneIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.mPhoneIcon = imageView;
    }

    @NotNull
    public final ImageView getAddressIcon() {
        ImageView imageView = this.addressIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
        }
        return imageView;
    }

    public final void setAddressIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.addressIcon = imageView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mContact = (Contact) getArguments().getParcelable(CONTACT);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_contact_detail, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        String relationshipToStudentDescription;
        ImageView imageView;
        TextView textView = this.fullNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullNameTV");
        }
        com.aeries.mobileportal.utils.StringUtils.Companion companion = StringUtils.Companion;
        Contact contact = this.mContact;
        if (contact == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(companion.getFullName(contact));
        textView = this.relationshipTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relationshipTV");
        }
        Contact contact2 = this.mContact;
        if (contact2 != null) {
            relationshipToStudentDescription = contact2.getRelationshipToStudentDescription();
            if (relationshipToStudentDescription != null) {
                textView.setText(relationshipToStudentDescription);
                textView = this.mobilePhoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mobilePhoneTV");
                }
                companion = StringUtils.Companion;
                contact = this.mContact;
                textView.setText(companion.getFormattedPhone(contact == null ? contact.getCellPhone() : null));
                textView = this.mobilePhoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mobilePhoneTV");
                }
                textView.setOnClickListener(new ContactDetailFragment$setupViews$1(this));
                imageView = this.mPhoneIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPhoneIcon");
                }
                imageView.setOnClickListener(new ContactDetailFragment$setupViews$2(this));
                textView = this.workPhoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("workPhoneTV");
                }
                companion = StringUtils.Companion;
                contact = this.mContact;
                if (contact == null) {
                    Intrinsics.throwNpe();
                }
                textView.setText(companion.getFormattedPhone(contact.getWorkPhone()));
                textView = this.workPhoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("workPhoneTV");
                }
                textView.setOnClickListener(new ContactDetailFragment$setupViews$3(this));
                imageView = this.wPhoneIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wPhoneIcon");
                }
                imageView.setOnClickListener(new ContactDetailFragment$setupViews$4(this));
                textView = this.telephoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("telephoneTV");
                }
                companion = StringUtils.Companion;
                contact = this.mContact;
                if (contact == null) {
                    Intrinsics.throwNpe();
                }
                textView.setText(companion.getFormattedPhone(contact.getHomePhone()));
                textView = this.telephoneTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("telephoneTV");
                }
                textView.setOnClickListener(new ContactDetailFragment$setupViews$5(this));
                imageView = this.telephoneIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("telephoneIcon");
                }
                imageView.setOnClickListener(new ContactDetailFragment$setupViews$6(this));
                textView = this.addressTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressTV");
                }
                companion = StringUtils.Companion;
                contact = this.mContact;
                if (contact == null) {
                    Intrinsics.throwNpe();
                }
                textView.setText(companion.getFormattedAddress(contact));
                textView = this.addressTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressTV");
                }
                textView.setOnClickListener(new ContactDetailFragment$setupViews$7(this));
                imageView = this.addressIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
                }
                imageView.setOnClickListener(new ContactDetailFragment$setupViews$8(this));
            }
        }
        relationshipToStudentDescription = "N/A";
        textView.setText(relationshipToStudentDescription);
        textView = this.mobilePhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobilePhoneTV");
        }
        companion = StringUtils.Companion;
        contact = this.mContact;
        if (contact == null) {
        }
        textView.setText(companion.getFormattedPhone(contact == null ? contact.getCellPhone() : null));
        textView = this.mobilePhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobilePhoneTV");
        }
        textView.setOnClickListener(new ContactDetailFragment$setupViews$1(this));
        imageView = this.mPhoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneIcon");
        }
        imageView.setOnClickListener(new ContactDetailFragment$setupViews$2(this));
        textView = this.workPhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workPhoneTV");
        }
        companion = StringUtils.Companion;
        contact = this.mContact;
        if (contact == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(companion.getFormattedPhone(contact.getWorkPhone()));
        textView = this.workPhoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("workPhoneTV");
        }
        textView.setOnClickListener(new ContactDetailFragment$setupViews$3(this));
        imageView = this.wPhoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wPhoneIcon");
        }
        imageView.setOnClickListener(new ContactDetailFragment$setupViews$4(this));
        textView = this.telephoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("telephoneTV");
        }
        companion = StringUtils.Companion;
        contact = this.mContact;
        if (contact == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(companion.getFormattedPhone(contact.getHomePhone()));
        textView = this.telephoneTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("telephoneTV");
        }
        textView.setOnClickListener(new ContactDetailFragment$setupViews$5(this));
        imageView = this.telephoneIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("telephoneIcon");
        }
        imageView.setOnClickListener(new ContactDetailFragment$setupViews$6(this));
        textView = this.addressTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTV");
        }
        companion = StringUtils.Companion;
        contact = this.mContact;
        if (contact == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(companion.getFormattedAddress(contact));
        textView = this.addressTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressTV");
        }
        textView.setOnClickListener(new ContactDetailFragment$setupViews$7(this));
        imageView = this.addressIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
        }
        imageView.setOnClickListener(new ContactDetailFragment$setupViews$8(this));
    }

    @OnClick({2131361870})
    public final void onCloseButtonPressed() {
        if (this.mListener != null) {
            ContactDetailFragmentListener contactDetailFragmentListener = this.mListener;
            if (contactDetailFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            contactDetailFragmentListener.onCloseButtonPressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ContactDetailFragmentListener) {
            this.mListener = (ContactDetailFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ContactDetailFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (ContactDetailFragmentListener) null;
    }
}
