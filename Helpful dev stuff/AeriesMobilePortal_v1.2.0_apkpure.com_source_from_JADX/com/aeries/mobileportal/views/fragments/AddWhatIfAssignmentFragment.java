package com.aeries.mobileportal.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0002EFB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J*\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020)H\u0007J\u0012\u00102\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020)H\u0007J\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J(\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010A\u001a\u00020)H\u0016J\b\u0010B\u001a\u00020)H\u0016J*\u0010C\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001bH\u0016J\b\u0010D\u001a\u00020)H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006G"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment;", "Landroid/support/v4/app/DialogFragment;", "Landroid/text/TextWatcher;", "()V", "addAssignmentButton", "Landroid/widget/Button;", "getAddAssignmentButton", "()Landroid/widget/Button;", "setAddAssignmentButton", "(Landroid/widget/Button;)V", "cancelTV", "Landroid/widget/TextView;", "getCancelTV", "()Landroid/widget/TextView;", "setCancelTV", "(Landroid/widget/TextView;)V", "categorySpinner", "Landroid/widget/Spinner;", "getCategorySpinner", "()Landroid/widget/Spinner;", "setCategorySpinner", "(Landroid/widget/Spinner;)V", "mGradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment$AddWhatIfAssignmentListener;", "mSelectedCatIndx", "", "nameET", "Landroid/widget/EditText;", "getNameET", "()Landroid/widget/EditText;", "setNameET", "(Landroid/widget/EditText;)V", "numCorrectET", "getNumCorrectET", "setNumCorrectET", "numPossibleET", "getNumPossibleET", "setNumPossibleET", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "p2", "p3", "cancel", "onAttach", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "onTextChanged", "setupViews", "AddWhatIfAssignmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddWhatIfAssignmentFragment.kt */
public final class AddWhatIfAssignmentFragment extends DialogFragment implements TextWatcher {
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String GRADEBOOK = "GRADEBOOK";
    @NotNull
    private static final String SELECTED_CAT_INDX = "SELECTED_CAT_INDX";
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361822)
    public Button addAssignmentButton;
    @NotNull
    @BindView(2131361855)
    public TextView cancelTV;
    @NotNull
    @BindView(2131361862)
    public Spinner categorySpinner;
    private Gradebook mGradebook;
    private AddWhatIfAssignmentListener mListener;
    private int mSelectedCatIndx;
    @NotNull
    @BindView(2131362050)
    public EditText nameET;
    @NotNull
    @BindView(2131362077)
    public EditText numCorrectET;
    @NotNull
    @BindView(2131362078)
    public EditText numPossibleET;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment$AddWhatIfAssignmentListener;", "", "onAddWhatIfAssignment", "", "assignmentRowViewModel", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "gradebookNumber", "", "termCode", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AddWhatIfAssignmentFragment.kt */
    public interface AddWhatIfAssignmentListener {
        void onAddWhatIfAssignment(@NotNull AssignmentRowViewModel assignmentRowViewModel, int i, @NotNull String str);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment$Companion;", "", "()V", "GRADEBOOK", "", "getGRADEBOOK", "()Ljava/lang/String;", "SELECTED_CAT_INDX", "getSELECTED_CAT_INDX", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "selectedCategoryIndex", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AddWhatIfAssignmentFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getGRADEBOOK() {
            return AddWhatIfAssignmentFragment.GRADEBOOK;
        }

        @NotNull
        public final String getSELECTED_CAT_INDX() {
            return AddWhatIfAssignmentFragment.SELECTED_CAT_INDX;
        }

        @NotNull
        public final AddWhatIfAssignmentFragment newInstance(@NotNull Gradebook gradebook, int i) {
            Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
            AddWhatIfAssignmentFragment addWhatIfAssignmentFragment = new AddWhatIfAssignmentFragment();
            Bundle bundle = new Bundle();
            Companion companion = this;
            bundle.putParcelable(getGRADEBOOK(), gradebook);
            bundle.putInt(getSELECTED_CAT_INDX(), i);
            addWhatIfAssignmentFragment.setArguments(bundle);
            return addWhatIfAssignmentFragment;
        }
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

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final EditText getNameET() {
        EditText editText = this.nameET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameET");
        }
        return editText;
    }

    public final void setNameET(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.nameET = editText;
    }

    @NotNull
    public final Spinner getCategorySpinner() {
        Spinner spinner = this.categorySpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySpinner");
        }
        return spinner;
    }

    public final void setCategorySpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.categorySpinner = spinner;
    }

    @NotNull
    public final EditText getNumCorrectET() {
        EditText editText = this.numCorrectET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numCorrectET");
        }
        return editText;
    }

    public final void setNumCorrectET(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.numCorrectET = editText;
    }

    @NotNull
    public final EditText getNumPossibleET() {
        EditText editText = this.numPossibleET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numPossibleET");
        }
        return editText;
    }

    public final void setNumPossibleET(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.numPossibleET = editText;
    }

    @NotNull
    public final Button getAddAssignmentButton() {
        Button button = this.addAssignmentButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAssignmentButton");
        }
        return button;
    }

    public final void setAddAssignmentButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.addAssignmentButton = button;
    }

    @NotNull
    public final TextView getCancelTV() {
        TextView textView = this.cancelTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelTV");
        }
        return textView;
    }

    public final void setCancelTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.cancelTV = textView;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mGradebook = (Gradebook) getArguments().getParcelable(GRADEBOOK);
            this.mSelectedCatIndx = getArguments().getInt(SELECTED_CAT_INDX);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        bundle = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        bundle.getWindow().requestFeature(1);
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_add_what_if_assignment, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        EditText editText = this.nameET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameET");
        }
        TextWatcher textWatcher = this;
        editText.addTextChangedListener(textWatcher);
        editText = this.numCorrectET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numCorrectET");
        }
        editText.addTextChangedListener(textWatcher);
        editText = this.numPossibleET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numPossibleET");
        }
        editText.addTextChangedListener(textWatcher);
        Gradebook gradebook = this.mGradebook;
        if (gradebook == null) {
            Intrinsics.throwNpe();
        }
        RealmList categories = gradebook.getCategories();
        if (categories == null) {
            Intrinsics.throwNpe();
        }
        Collection arrayList = new ArrayList();
        for (Object next : categories) {
            if ((Intrinsics.areEqual(((AssignmentCategory) next).getName(), (Object) "Overall") ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        Iterable<AssignmentCategory> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AssignmentCategory name : iterable) {
            String name2 = name.getName();
            if (name2 == null) {
                Intrinsics.throwNpe();
            }
            arrayList2.add(name2);
        }
        ArrayList arrayList3 = new ArrayList((List) arrayList2);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), 17367049, arrayList3);
        Spinner spinner = this.categorySpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySpinner");
        }
        spinner.setAdapter(arrayAdapter);
        Spinner spinner2 = this.categorySpinner;
        if (spinner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySpinner");
        }
        spinner2.setSelection(this.mSelectedCatIndx < arrayList3.size() ? this.mSelectedCatIndx : 0);
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setLayout(-1, -2);
        dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setGravity(17);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        bundle = super.onCreateDialog(bundle);
        bundle.requestWindowFeature(1);
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        return bundle;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        charSequence = this.addAssignmentButton;
        if (charSequence == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAssignmentButton");
        }
        i = this.nameET;
        if (i == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("nameET");
        }
        i2 = 1;
        if ((Intrinsics.areEqual(i.getText().toString(), (Object) "") ^ 1) != 0) {
            i = this.numCorrectET;
            if (i == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("numCorrectET");
            }
            if ((Intrinsics.areEqual(i.getText().toString(), (Object) "") ^ 1) != 0) {
                i = this.numPossibleET;
                if (i == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("numPossibleET");
                }
                if ((Intrinsics.areEqual(i.getText().toString(), (Object) "") ^ 1) != 0) {
                    charSequence.setEnabled(i2);
                }
            }
        }
        i2 = 0;
        charSequence.setEnabled(i2);
    }

    @OnClick({2131361855})
    public final void cancel() {
        dismiss();
    }

    @OnClick({2131361822})
    public final void onButtonPressed() {
        Assignment assignment = new Assignment();
        assignment.setAssignmentNumber(Integer.valueOf(0 - new Random().nextInt()));
        EditText editText = this.nameET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameET");
        }
        assignment.setDescription(editText.getText().toString());
        Spinner spinner = this.categorySpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categorySpinner");
        }
        assignment.setCategory(spinner.getSelectedItem().toString());
        editText = this.numPossibleET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numPossibleET");
        }
        assignment.setMaxScore(Double.valueOf((double) Integer.parseInt(editText.getText().toString())));
        editText = this.numCorrectET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numCorrectET");
        }
        assignment.setScore(Double.valueOf((double) Integer.parseInt(editText.getText().toString())));
        assignment.setNumberPossible(assignment.getMaxScore());
        assignment.setNumberCorrect(assignment.getScore());
        assignment.setScoreVisibleToParents(Boolean.valueOf(true));
        AssignmentRowViewModel assignmentRowViewModel = new AssignmentRowViewModel(assignment, false, false, false, true, true, true, 14, null);
        if (this.mListener != null) {
            AddWhatIfAssignmentListener addWhatIfAssignmentListener = this.mListener;
            if (addWhatIfAssignmentListener == null) {
                Intrinsics.throwNpe();
            }
            Gradebook gradebook = this.mGradebook;
            String str = null;
            Integer gradebookNumber = gradebook != null ? gradebook.getGradebookNumber() : null;
            if (gradebookNumber == null) {
                Intrinsics.throwNpe();
            }
            int intValue = gradebookNumber.intValue();
            Gradebook gradebook2 = this.mGradebook;
            if (gradebook2 != null) {
                str = gradebook2.getTermCode();
            }
            if (str == null) {
                Intrinsics.throwNpe();
            }
            addWhatIfAssignmentListener.onAddWhatIfAssignment(assignmentRowViewModel, intValue, str);
        }
        dismiss();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AddWhatIfAssignmentListener) {
            this.mListener = (AddWhatIfAssignmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AddWhatIfAssignmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AddWhatIfAssignmentListener) null;
    }
}
