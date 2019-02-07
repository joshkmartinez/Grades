package com.aeries.mobileportal.enums;

import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.utils.StringUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/enums/ScoreType;", "", "(Ljava/lang/String;I)V", "getMockedString", "", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "grade", "getScoreString", "Mark", "Score", "NumberCorrect", "CorrectOverPossible", "CheckMark", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ScoreType.kt */
public enum ScoreType {
    ;
    
    @NotNull
    private static final String CHECK_MARK = "{mark}";
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/enums/ScoreType$Companion;", "", "()V", "CHECK_MARK", "", "getCHECK_MARK", "()Ljava/lang/String;", "getScoreType", "Lcom/aeries/mobileportal/enums/ScoreType;", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ScoreType.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getCHECK_MARK() {
            return ScoreType.CHECK_MARK;
        }

        @NotNull
        public final ScoreType getScoreType(@NotNull Assignment assignment) {
            Intrinsics.checkParameterIsNotNull(assignment, "assignment");
            if (Intrinsics.areEqual(assignment.isScoreValueACheckMark(), Boolean.valueOf(true))) {
                return ScoreType.CheckMark;
            }
            if (assignment.isExtraCredit() && StringUtils.Companion.checkIfNumber(assignment.getMark())) {
                return ScoreType.Score;
            }
            if (!(Intrinsics.areEqual(assignment.getMark(), (Object) "NA") || Intrinsics.areEqual(assignment.getMark(), (Object) "TX"))) {
                if (StringUtils.Companion.checkIfNumber(assignment.getMark()) || (Intrinsics.areEqual(assignment.getMark(), (Object) "") ^ 1) == 0) {
                    if (assignment.getRubricAssignMent() || (Intrinsics.areEqual(assignment.getNumberPossible(), 0.0d) ^ 1) == null) {
                        return ScoreType.NumberCorrect;
                    }
                    return ScoreType.CorrectOverPossible;
                }
            }
            return ScoreType.Mark;
        }
    }

    static {
        Companion = new Companion();
    }

    @NotNull
    public final String getScoreString(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        switch (this) {
            case Mark:
                return String.valueOf(assignment.getMark());
            case Score:
                return String.valueOf(assignment.getScore());
            case NumberCorrect:
                return String.valueOf(assignment.getNumberCorrect());
            case CorrectOverPossible:
                String str = "%s/%s";
                Object[] objArr = new Object[2];
                com.aeries.mobileportal.utils.StringUtils.Companion companion = StringUtils.Companion;
                Double numberCorrect = assignment.getNumberCorrect();
                double d = 0.0d;
                objArr[0] = companion.formatDecimals(numberCorrect != null ? numberCorrect.doubleValue() : 0.0d);
                companion = StringUtils.Companion;
                assignment = assignment.getNumberPossible();
                if (assignment != null) {
                    d = assignment.doubleValue();
                }
                objArr[1] = companion.formatDecimals(d);
                assignment = String.format(str, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(assignment, "java.lang.String.format(this, *args)");
                return assignment;
            case CheckMark:
                return CHECK_MARK;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String getMockedString(@NotNull Assignment assignment, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        Intrinsics.checkParameterIsNotNull(str, "grade");
        switch (this) {
            case Mark:
                return String.valueOf(assignment.getMark());
            case Score:
            case NumberCorrect:
                return str;
            case CorrectOverPossible:
                String str2 = "%s/%s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                com.aeries.mobileportal.utils.StringUtils.Companion companion = StringUtils.Companion;
                assignment = assignment.getNumberPossible();
                objArr[1] = companion.formatDecimals(assignment != null ? assignment.doubleValue() : 0.0d);
                str = String.format(str2, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
                return str;
            case CheckMark:
                return CHECK_MARK;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
