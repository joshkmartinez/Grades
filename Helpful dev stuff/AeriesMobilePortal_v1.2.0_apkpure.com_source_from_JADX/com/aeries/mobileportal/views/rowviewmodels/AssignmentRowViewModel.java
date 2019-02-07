package com.aeries.mobileportal.views.rowviewmodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aeries.mobileportal.enums.ScoreType;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.utils.AssignmentUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BI\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003JO\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\b\u00107\u001a\u00020*H\u0016J\u0013\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020*HÖ\u0001J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0012J\u0006\u0010?\u001a\u00020=J\t\u0010@\u001a\u00020\u0012HÖ\u0001J\u0018\u0010A\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020*H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0011\u0010\u001e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,¨\u0006E"}, d2 = {"Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "isEditShowing", "", "isModifying", "isDeleted", "isModified", "isMocked", "isAnimated", "(Lcom/aeries/mobileportal/models/Assignment;ZZZZZZ)V", "getAssignment", "()Lcom/aeries/mobileportal/models/Assignment;", "gradeText", "", "getGradeText", "()Ljava/lang/String;", "()Z", "setAnimated", "(Z)V", "setDeleted", "isEditDisabled", "setEditShowing", "isMissing", "setModified", "setModifying", "isSeekbarShowing", "mockedGrade", "getMockedGrade", "setMockedGrade", "(Ljava/lang/String;)V", "mockedProgress", "", "getMockedProgress", "()D", "setMockedProgress", "(D)V", "seekBarInitProgress", "", "getSeekBarInitProgress", "()I", "seekBarMax", "getSeekBarMax", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "grade", "mockDeletedAssignment", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentRowViewModel.kt */
public final class AssignmentRowViewModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @NotNull
    private final Assignment assignment;
    @NotNull
    private final String gradeText;
    private boolean isAnimated;
    private boolean isDeleted;
    private final boolean isEditDisabled;
    private boolean isEditShowing;
    private final boolean isMissing;
    private final boolean isMocked;
    private boolean isModified;
    private boolean isModifying;
    private final boolean isSeekbarShowing;
    @NotNull
    private String mockedGrade;
    private double mockedProgress;
    private final int seekBarInitProgress;
    private final int seekBarMax;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentRowViewModel.kt */
    public static final class CREATOR implements Creator<AssignmentRowViewModel> {
        private CREATOR() {
        }

        @NotNull
        public AssignmentRowViewModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AssignmentRowViewModel(parcel);
        }

        @NotNull
        public AssignmentRowViewModel[] newArray(int i) {
            return new AssignmentRowViewModel[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AssignmentRowViewModel copy$default(AssignmentRowViewModel assignmentRowViewModel, Assignment assignment, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            assignment = assignmentRowViewModel.assignment;
        }
        if ((i & 2) != 0) {
            z = assignmentRowViewModel.isEditShowing;
        }
        boolean z7 = z;
        if ((i & 4) != 0) {
            z2 = assignmentRowViewModel.isModifying;
        }
        boolean z8 = z2;
        if ((i & 8) != 0) {
            z3 = assignmentRowViewModel.isDeleted;
        }
        boolean z9 = z3;
        if ((i & 16) != 0) {
            z4 = assignmentRowViewModel.isModified;
        }
        boolean z10 = z4;
        if ((i & 32) != 0) {
            z5 = assignmentRowViewModel.isMocked;
        }
        boolean z11 = z5;
        if ((i & 64) != 0) {
            z6 = assignmentRowViewModel.isAnimated;
        }
        return assignmentRowViewModel.copy(assignment, z7, z8, z9, z10, z11, z6);
    }

    @NotNull
    public final Assignment component1() {
        return this.assignment;
    }

    public final boolean component2() {
        return this.isEditShowing;
    }

    public final boolean component3() {
        return this.isModifying;
    }

    public final boolean component4() {
        return this.isDeleted;
    }

    public final boolean component5() {
        return this.isModified;
    }

    public final boolean component6() {
        return this.isMocked;
    }

    public final boolean component7() {
        return this.isAnimated;
    }

    @NotNull
    public final AssignmentRowViewModel copy(@NotNull Assignment assignment, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Assignment assignment2 = assignment;
        Intrinsics.checkParameterIsNotNull(assignment2, "assignment");
        return new AssignmentRowViewModel(assignment2, z, z2, z3, z4, z5, z6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AssignmentRowViewModel) {
                AssignmentRowViewModel assignmentRowViewModel = (AssignmentRowViewModel) obj;
                if (Intrinsics.areEqual(this.assignment, assignmentRowViewModel.assignment)) {
                    if (this.isEditShowing == assignmentRowViewModel.isEditShowing) {
                        if (this.isModifying == assignmentRowViewModel.isModifying) {
                            if (this.isDeleted == assignmentRowViewModel.isDeleted) {
                                if (this.isModified == assignmentRowViewModel.isModified) {
                                    if (this.isMocked == assignmentRowViewModel.isMocked) {
                                        if (this.isAnimated == assignmentRowViewModel.isAnimated) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Assignment assignment = this.assignment;
        int hashCode = (assignment != null ? assignment.hashCode() : 0) * 31;
        int i = this.isEditShowing;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isModifying;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isDeleted;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isModified;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isMocked;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.isAnimated;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AssignmentRowViewModel(assignment=");
        stringBuilder.append(this.assignment);
        stringBuilder.append(", isEditShowing=");
        stringBuilder.append(this.isEditShowing);
        stringBuilder.append(", isModifying=");
        stringBuilder.append(this.isModifying);
        stringBuilder.append(", isDeleted=");
        stringBuilder.append(this.isDeleted);
        stringBuilder.append(", isModified=");
        stringBuilder.append(this.isModified);
        stringBuilder.append(", isMocked=");
        stringBuilder.append(this.isMocked);
        stringBuilder.append(", isAnimated=");
        stringBuilder.append(this.isAnimated);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AssignmentRowViewModel(@NotNull Assignment assignment, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        this.assignment = assignment;
        this.isEditShowing = z;
        this.isModifying = z2;
        this.isDeleted = z3;
        this.isModified = z4;
        this.isMocked = z5;
        this.isAnimated = z6;
        this.isMissing = AssignmentUtils.Companion.isAssignmentMissing(this.assignment);
        this.isEditDisabled = AssignmentUtils.Companion.isAssignmentEditDisabled(this.assignment);
        z2 = false;
        this.isSeekbarShowing = ScoreType.Companion.getScoreType(this.assignment) == ScoreType.CorrectOverPossible ? true : null;
        this.gradeText = ScoreType.Companion.getScoreType(this.assignment).getScoreString(this.assignment);
        assignment = this.assignment.getMaxScore();
        this.seekBarMax = assignment != null ? (int) (assignment.doubleValue() * ((double) 10)) : null;
        assignment = this.assignment.getScore();
        if (assignment != null) {
            z2 = (int) (assignment.doubleValue() * ((double) 10));
        }
        this.seekBarInitProgress = z2;
        this.mockedGrade = "";
    }

    @NotNull
    public final Assignment getAssignment() {
        return this.assignment;
    }

    public final boolean isEditShowing() {
        return this.isEditShowing;
    }

    public final void setEditShowing(boolean z) {
        this.isEditShowing = z;
    }

    public final boolean isModifying() {
        return this.isModifying;
    }

    public final void setModifying(boolean z) {
        this.isModifying = z;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public final boolean isModified() {
        return this.isModified;
    }

    public final void setModified(boolean z) {
        this.isModified = z;
    }

    public final boolean isMocked() {
        return this.isMocked;
    }

    public /* synthetic */ AssignmentRowViewModel(Assignment assignment, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assignment, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? false : z6);
    }

    public final boolean isAnimated() {
        return this.isAnimated;
    }

    public final void setAnimated(boolean z) {
        this.isAnimated = z;
    }

    public final boolean isMissing() {
        return this.isMissing;
    }

    public final boolean isEditDisabled() {
        return this.isEditDisabled;
    }

    public final boolean isSeekbarShowing() {
        return this.isSeekbarShowing;
    }

    @NotNull
    public final String getGradeText() {
        return this.gradeText;
    }

    public final int getSeekBarMax() {
        return this.seekBarMax;
    }

    public final int getSeekBarInitProgress() {
        return this.seekBarInitProgress;
    }

    @NotNull
    public final String getMockedGrade() {
        return this.mockedGrade;
    }

    public final void setMockedGrade(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mockedGrade = str;
    }

    public final double getMockedProgress() {
        return this.mockedProgress;
    }

    public final void setMockedProgress(double d) {
        this.mockedProgress = d;
    }

    public AssignmentRowViewModel(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Parcelable readParcelable = parcel.readParcelable(Assignment.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(readParcelable, "parcel.readParcelable(As…::class.java.classLoader)");
        byte b = (byte) null;
        this((Assignment) readParcelable, parcel.readByte() != b, parcel.readByte() != b, parcel.readByte() != b, parcel.readByte() != b, parcel.readByte() != b, parcel.readByte() != b);
    }

    @NotNull
    public final MockAssignment mockAssignment(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "grade");
        this.mockedGrade = str;
        this.mockedProgress = Double.parseDouble(str);
        MockAssignment mockAssignment = new MockAssignment();
        String category = this.assignment.getCategory();
        if (category == null) {
            category = "";
        }
        mockAssignment.setCategory(category);
        mockAssignment.setAssignmentNumber(String.valueOf(this.assignment.getAssignmentNumber()));
        mockAssignment.setMark("");
        mockAssignment.setScore(str);
        mockAssignment.setMaxScore(String.valueOf(this.assignment.getMaxScore()));
        return mockAssignment;
    }

    @NotNull
    public final MockAssignment mockDeletedAssignment() {
        this.mockedGrade = ScoreType.Companion.getScoreType(this.assignment).getScoreString(this.assignment);
        MockAssignment mockAssignment = new MockAssignment();
        String category = this.assignment.getCategory();
        if (category == null) {
            category = "";
        }
        mockAssignment.setCategory(category);
        mockAssignment.setAssignmentNumber(String.valueOf(this.assignment.getAssignmentNumber()));
        mockAssignment.setMaxScore(String.valueOf(this.assignment.getMaxScore()));
        mockAssignment.setScore(String.valueOf(this.assignment.getScore()));
        mockAssignment.setMark("NA");
        return mockAssignment;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(this.assignment, i);
        parcel.writeByte(this.isEditShowing);
        parcel.writeByte(this.isModifying);
        parcel.writeByte(this.isDeleted);
        parcel.writeByte(this.isModified);
        parcel.writeByte(this.isMocked);
        parcel.writeByte(this.isAnimated);
    }
}
