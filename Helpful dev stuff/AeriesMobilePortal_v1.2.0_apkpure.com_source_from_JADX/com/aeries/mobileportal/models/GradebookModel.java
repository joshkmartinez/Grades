package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/models/GradebookModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "assignmentRowViewModels", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "(Lcom/aeries/mobileportal/models/Gradebook;Ljava/util/List;)V", "getAssignmentRowViewModels", "()Ljava/util/List;", "getGradebook", "()Lcom/aeries/mobileportal/models/Gradebook;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradebookModel.kt */
public final class GradebookModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @NotNull
    private final List<AssignmentRowViewModel> assignmentRowViewModels;
    @NotNull
    private final Gradebook gradebook;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/GradebookModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/GradebookModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/GradebookModel;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: GradebookModel.kt */
    public static final class CREATOR implements Creator<GradebookModel> {
        private CREATOR() {
        }

        @NotNull
        public GradebookModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new GradebookModel(parcel);
        }

        @NotNull
        public GradebookModel[] newArray(int i) {
            return new GradebookModel[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ GradebookModel copy$default(GradebookModel gradebookModel, Gradebook gradebook, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            gradebook = gradebookModel.gradebook;
        }
        if ((i & 2) != 0) {
            list = gradebookModel.assignmentRowViewModels;
        }
        return gradebookModel.copy(gradebook, list);
    }

    @NotNull
    public final Gradebook component1() {
        return this.gradebook;
    }

    @NotNull
    public final List<AssignmentRowViewModel> component2() {
        return this.assignmentRowViewModels;
    }

    @NotNull
    public final GradebookModel copy(@NotNull Gradebook gradebook, @NotNull List<AssignmentRowViewModel> list) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        Intrinsics.checkParameterIsNotNull(list, "assignmentRowViewModels");
        return new GradebookModel(gradebook, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GradebookModel) {
                GradebookModel gradebookModel = (GradebookModel) obj;
                if (Intrinsics.areEqual(this.gradebook, gradebookModel.gradebook) && Intrinsics.areEqual(this.assignmentRowViewModels, gradebookModel.assignmentRowViewModels)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Gradebook gradebook = this.gradebook;
        int i = 0;
        int hashCode = (gradebook != null ? gradebook.hashCode() : 0) * 31;
        List list = this.assignmentRowViewModels;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GradebookModel(gradebook=");
        stringBuilder.append(this.gradebook);
        stringBuilder.append(", assignmentRowViewModels=");
        stringBuilder.append(this.assignmentRowViewModels);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public GradebookModel(@NotNull Gradebook gradebook, @NotNull List<AssignmentRowViewModel> list) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        Intrinsics.checkParameterIsNotNull(list, "assignmentRowViewModels");
        this.gradebook = gradebook;
        this.assignmentRowViewModels = list;
    }

    @NotNull
    public final Gradebook getGradebook() {
        return this.gradebook;
    }

    @NotNull
    public final List<AssignmentRowViewModel> getAssignmentRowViewModels() {
        return this.assignmentRowViewModels;
    }

    public GradebookModel(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Parcelable readParcelable = parcel.readParcelable(Gradebook.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(readParcelable, "parcel.readParcelable(Gr…::class.java.classLoader)");
        Gradebook gradebook = (Gradebook) readParcelable;
        parcel = parcel.createTypedArrayList(AssignmentRowViewModel.CREATOR);
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.createTypedArrayL…t(AssignmentRowViewModel)");
        this(gradebook, (List) parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(this.gradebook, i);
        parcel.writeTypedList(this.assignmentRowViewModels);
    }
}
