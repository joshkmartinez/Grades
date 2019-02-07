package com.aeries.mobileportal.utils;

import com.aeries.mobileportal.models.Assignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/AssignmentUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentUtils.kt */
public final class AssignmentUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/utils/AssignmentUtils$Companion;", "", "()V", "isAssignmentEditDisabled", "", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "isAssignmentMissing", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isAssignmentMissing(@NotNull Assignment assignment) {
            Intrinsics.checkParameterIsNotNull(assignment, "assignment");
            return (Intrinsics.areEqual(assignment.getScore(), 0.0d) && assignment.getDateCompleted() == null && assignment.isGraded() && assignment.isExtraCredit() == null) ? true : null;
        }

        public final boolean isAssignmentEditDisabled(@NotNull Assignment assignment) {
            Intrinsics.checkParameterIsNotNull(assignment, "assignment");
            if ((!Intrinsics.areEqual(assignment.getMark(), (Object) "NA") || !Intrinsics.areEqual(assignment.getMaxScore(), 0.0d) || !Intrinsics.areEqual(assignment.getNumberPossible(), 0.0d)) && Intrinsics.areEqual(assignment.isScoreVisibleToParents(), Boolean.valueOf(false)) == null) {
                return false;
            }
            return true;
        }
    }
}
