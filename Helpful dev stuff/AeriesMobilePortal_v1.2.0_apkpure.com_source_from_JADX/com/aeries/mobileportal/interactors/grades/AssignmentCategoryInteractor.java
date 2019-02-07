package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.GradesService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "(Lcom/aeries/mobileportal/web_services/services/GradesService;Lcom/aeries/mobileportal/web_services/TokenProvider;)V", "getGradesService", "()Lcom/aeries/mobileportal/web_services/services/GradesService;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getGradebook", "", "course", "Lcom/aeries/mobileportal/models/ClassSummary;", "callback", "Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryCallback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategoryInteractor.kt */
public final class AssignmentCategoryInteractor extends BaseInteractor {
    @NotNull
    private final GradesService gradesService;
    @NotNull
    private final TokenProvider tokenProvider;

    @NotNull
    public final GradesService getGradesService() {
        return this.gradesService;
    }

    public AssignmentCategoryInteractor(@NotNull GradesService gradesService, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(gradesService, "gradesService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        this.gradesService = gradesService;
        this.tokenProvider = tokenProvider;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public final void getGradebook(@Nullable ClassSummary classSummary, @NotNull AssignmentCategoryCallback assignmentCategoryCallback) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoryCallback, "callback");
        this.tokenProvider.performAuthCall(new AssignmentCategoryInteractor$getGradebook$1(this, classSummary, assignmentCategoryCallback));
    }
}
