package com.aeries.mobileportal.views.rowviewmodels;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aeries.mobileportal.models.ClassSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "classSummary", "Lcom/aeries/mobileportal/models/ClassSummary;", "lastUpdatedVisibility", "", "uiArguments", "Landroid/os/Bundle;", "(Lcom/aeries/mobileportal/models/ClassSummary;ZLandroid/os/Bundle;)V", "getClassSummary", "()Lcom/aeries/mobileportal/models/ClassSummary;", "getLastUpdatedVisibility", "()Z", "getUiArguments", "()Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CourseRowViewModel.kt */
public final class CourseRowViewModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @NotNull
    private final ClassSummary classSummary;
    private final boolean lastUpdatedVisibility;
    @NotNull
    private final Bundle uiArguments;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CourseRowViewModel.kt */
    public static final class CREATOR implements Creator<CourseRowViewModel> {
        private CREATOR() {
        }

        @NotNull
        public CourseRowViewModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new CourseRowViewModel(parcel);
        }

        @NotNull
        public CourseRowViewModel[] newArray(int i) {
            return new CourseRowViewModel[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ CourseRowViewModel copy$default(CourseRowViewModel courseRowViewModel, ClassSummary classSummary, boolean z, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            classSummary = courseRowViewModel.classSummary;
        }
        if ((i & 2) != 0) {
            z = courseRowViewModel.lastUpdatedVisibility;
        }
        if ((i & 4) != 0) {
            bundle = courseRowViewModel.uiArguments;
        }
        return courseRowViewModel.copy(classSummary, z, bundle);
    }

    @NotNull
    public final ClassSummary component1() {
        return this.classSummary;
    }

    public final boolean component2() {
        return this.lastUpdatedVisibility;
    }

    @NotNull
    public final Bundle component3() {
        return this.uiArguments;
    }

    @NotNull
    public final CourseRowViewModel copy(@NotNull ClassSummary classSummary, boolean z, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "classSummary");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        return new CourseRowViewModel(classSummary, z, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CourseRowViewModel) {
                CourseRowViewModel courseRowViewModel = (CourseRowViewModel) obj;
                if (Intrinsics.areEqual(this.classSummary, courseRowViewModel.classSummary)) {
                    if ((this.lastUpdatedVisibility == courseRowViewModel.lastUpdatedVisibility) && Intrinsics.areEqual(this.uiArguments, courseRowViewModel.uiArguments)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        ClassSummary classSummary = this.classSummary;
        int i = 0;
        int hashCode = (classSummary != null ? classSummary.hashCode() : 0) * 31;
        int i2 = this.lastUpdatedVisibility;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Bundle bundle = this.uiArguments;
        if (bundle != null) {
            i = bundle.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CourseRowViewModel(classSummary=");
        stringBuilder.append(this.classSummary);
        stringBuilder.append(", lastUpdatedVisibility=");
        stringBuilder.append(this.lastUpdatedVisibility);
        stringBuilder.append(", uiArguments=");
        stringBuilder.append(this.uiArguments);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CourseRowViewModel(@NotNull ClassSummary classSummary, boolean z, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "classSummary");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        this.classSummary = classSummary;
        this.lastUpdatedVisibility = z;
        this.uiArguments = bundle;
    }

    @NotNull
    public final ClassSummary getClassSummary() {
        return this.classSummary;
    }

    public final boolean getLastUpdatedVisibility() {
        return this.lastUpdatedVisibility;
    }

    @NotNull
    public final Bundle getUiArguments() {
        return this.uiArguments;
    }

    public CourseRowViewModel(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Parcelable readParcelable = parcel.readParcelable(ClassSummary.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(readParcelable, "parcel.readParcelable(Cl…::class.java.classLoader)");
        ClassSummary classSummary = (ClassSummary) readParcelable;
        boolean z = false;
        if (parcel.readByte() != ((byte) null)) {
            z = true;
        }
        parcel = parcel.readBundle(Bundle.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readBundle(Bundle::class.java.classLoader)");
        this(classSummary, z, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(this.classSummary, i);
        parcel.writeByte(this.lastUpdatedVisibility);
        parcel.writeBundle(this.uiArguments);
    }
}
