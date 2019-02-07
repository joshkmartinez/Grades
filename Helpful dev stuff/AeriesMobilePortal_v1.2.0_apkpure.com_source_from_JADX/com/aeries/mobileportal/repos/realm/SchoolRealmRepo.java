package com.aeries.mobileportal.repos.realm;

import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import io.realm.Realm;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/repos/realm/SchoolRealmRepo;", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "()V", "addSchool", "", "school", "Lcom/aeries/mobileportal/models/School;", "deleteSchool", "cds", "", "getSchool", "getSchools", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolRealmRepo.kt */
public final class SchoolRealmRepo implements SchoolRepo {
    public boolean addSchool(@org.jetbrains.annotations.NotNull com.aeries.mobileportal.models.School r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:13:? in {3, 5, 10, 12, 15, 16} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = "school";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0);
        r0 = io.realm.Realm.getDefaultInstance();
        r0.beginTransaction();	 Catch:{ Throwable -> 0x001b, all -> 0x0019 }
        r2 = (io.realm.RealmModel) r2;	 Catch:{ Throwable -> 0x001b, all -> 0x0019 }
        r0.copyToRealm(r2);	 Catch:{ Throwable -> 0x001b, all -> 0x0019 }
        r0.commitTransaction();
        r0.close();
        r2 = 1;
        return r2;
    L_0x0019:
        r2 = move-exception;
        goto L_0x0027;
    L_0x001b:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ Throwable -> 0x001b, all -> 0x0019 }
        r2 = 0;
        r0.commitTransaction();
        r0.close();
        return r2;
    L_0x0027:
        r0.commitTransaction();
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.repos.realm.SchoolRealmRepo.addSchool(com.aeries.mobileportal.models.School):boolean");
    }

    @NotNull
    public List<School> getSchools() {
        Realm defaultInstance = Realm.getDefaultInstance();
        List<School> copyFromRealm = defaultInstance.copyFromRealm(defaultInstance.where(School.class).findAll());
        defaultInstance.close();
        Intrinsics.checkExpressionValueIsNotNull(copyFromRealm, "list");
        return copyFromRealm;
    }

    @Nullable
    public School getSchool(@Nullable String str) {
        Realm defaultInstance = Realm.getDefaultInstance();
        School school = (School) defaultInstance.where(School.class).equalTo("CDS", str).findFirst();
        str = school != null ? (School) defaultInstance.copyFromRealm(school) : null;
        defaultInstance.close();
        return str;
    }

    public boolean deleteSchool(@Nullable String str) {
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.beginTransaction();
        try {
            defaultInstance.where(School.class).equalTo("CDS", str).findAll().deleteAllFromRealm();
            str = true;
        } catch (String str2) {
            str2.printStackTrace();
            str2 = null;
        } catch (Throwable th) {
            defaultInstance.commitTransaction();
            defaultInstance.close();
        }
        defaultInstance.commitTransaction();
        defaultInstance.close();
        return str2;
    }
}
