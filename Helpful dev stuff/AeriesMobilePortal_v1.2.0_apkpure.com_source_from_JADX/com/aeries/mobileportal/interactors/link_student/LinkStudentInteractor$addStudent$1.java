package com.aeries.mobileportal.interactors.link_student;

import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.models.AddStudentRequest;
import com.aeries.mobileportal.models.AddStudentResponse;
import com.aeries.mobileportal.models.ServerInfo;
import com.aeries.mobileportal.models.Student;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: LinkStudentInteractor.kt */
final class LinkStudentInteractor$addStudent$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AddStudentRequest $addStudentRequest;
    final /* synthetic */ LinkStudentCallback $callback;
    final /* synthetic */ LinkStudentInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ServerInfo;", "apply"}, k = 3, mv = {1, 1, 10})
    /* compiled from: LinkStudentInteractor.kt */
    static final class C07491<T, R> implements Function<T, R> {
        public static final C07491 INSTANCE = new C07491();

        C07491() {
        }

        @NotNull
        public final String apply(@NotNull ServerInfo serverInfo) {
            Intrinsics.checkParameterIsNotNull(serverInfo, "it");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[]{Integer.valueOf(serverInfo.getVersion().getMajor()), Integer.valueOf(serverInfo.getVersion().getMinor()), Integer.valueOf(serverInfo.getVersion().getBuild()), Integer.valueOf(serverInfo.getVersion().getRevision())};
            serverInfo = String.format("%02d%02d%02d%02d", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(serverInfo, "java.lang.String.format(format, *args)");
            return serverInfo;
        }
    }

    LinkStudentInteractor$addStudent$1(LinkStudentInteractor linkStudentInteractor, AddStudentRequest addStudentRequest, LinkStudentCallback linkStudentCallback) {
        this.this$0 = linkStudentInteractor;
        this.$addStudentRequest = addStudentRequest;
        this.$callback = linkStudentCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        LinkStudentInteractor linkStudentInteractor = this.this$0;
        str = this.this$0.getApplicationService().getServerInfo(str).map(C07491.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>() {
            @NotNull
            public final Observable<AddStudentResponse> apply(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "it");
                if (str.compareTo(BuildConfig.ENCRYPTION) < 0) {
                    this.$addStudentRequest.useOldKeys();
                }
                return this.this$0.getLinkStudentService().addStudent(this.$addStudentRequest, str);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<AddStudentResponse>() {
            public final void accept(AddStudentResponse addStudentResponse) {
                if (Intrinsics.areEqual(addStudentResponse.getStatus(), Param.SUCCESS)) {
                    LinkStudentCallback linkStudentCallback;
                    if (Intrinsics.areEqual(this.this$0.getUserRepository().getUserType(), (Object) "Parent")) {
                        List<Student> students = addStudentResponse.getAuthenticationData().getStudents();
                        if (students != null) {
                            for (Student views : students) {
                                CollectionsKt.removeAll(views.getViews(), LinkStudentInteractor$addStudent$1$3$1$1.INSTANCE);
                            }
                        }
                    }
                    this.this$0.updateAuthData(addStudentResponse.getAuthenticationData());
                    if (addStudentResponse.getContacts() != null) {
                        if (!addStudentResponse.getContacts().isEmpty()) {
                            linkStudentCallback = this.$callback;
                            Intrinsics.checkExpressionValueIsNotNull(addStudentResponse, "it");
                            linkStudentCallback.onStudentAddedSuccess(addStudentResponse);
                            return;
                        }
                    }
                    linkStudentCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(addStudentResponse, "it");
                    linkStudentCallback.onStudentAddedSuccessNoContacts(addStudentResponse);
                    return;
                }
                this.$callback.onStudentAddedFail(addStudentResponse.getError());
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                LinkStudentCallback linkStudentCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                linkStudentCallback.onStudentAddedError(th);
                th.printStackTrace();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "applicationService.getSe…  }\n                    )");
        linkStudentInteractor.addToCompositeDisposable(str);
    }
}
