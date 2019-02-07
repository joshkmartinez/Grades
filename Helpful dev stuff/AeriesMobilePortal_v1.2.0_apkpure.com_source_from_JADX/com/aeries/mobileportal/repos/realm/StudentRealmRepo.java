package com.aeries.mobileportal.repos.realm;

import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import io.realm.Realm;
import io.realm.RealmModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/aeries/mobileportal/repos/realm/StudentRealmRepo;", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "()V", "addFeedbackPermission", "", "studentID", "", "addSignalKitPermission", "deleteStudents", "findStudent", "Lcom/aeries/mobileportal/models/Student;", "realm", "Lio/realm/Realm;", "getStudent", "getStudents", "", "replaceStudents", "students", "", "updateStudents", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: StudentRealmRepo.kt */
public final class StudentRealmRepo implements StudentRepo {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replaceStudents(@org.jetbrains.annotations.NotNull java.util.List<? extends com.aeries.mobileportal.models.Student> r6) {
        /*
        r5 = this;
        r0 = "students";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0);
        r0 = r6.iterator();
    L_0x0009:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0087;
    L_0x000f:
        r1 = r0.next();
        r1 = (com.aeries.mobileportal.models.Student) r1;
        r2 = r1.getDemographics();
        r2 = r2.getStudentId();
        r1.setStudentID(r2);
        r1 = r1.getViews();
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
    L_0x002a:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0009;
    L_0x0030:
        r2 = r1.next();
        r2 = (com.aeries.mobileportal.models.ViewPermission) r2;
        r3 = r2.getViewCode();
        if (r3 != 0) goto L_0x003d;
    L_0x003c:
        goto L_0x0081;
    L_0x003d:
        r4 = r3.hashCode();
        switch(r4) {
            case 65137: goto L_0x0077;
            case 65153: goto L_0x006d;
            case 66914: goto L_0x0063;
            case 70360: goto L_0x0059;
            case 82172: goto L_0x004f;
            case 82452: goto L_0x0045;
            default: goto L_0x0044;
        };
    L_0x0044:
        goto L_0x0081;
    L_0x0045:
        r4 = "STU";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x004d:
        r3 = 3;
        goto L_0x0083;
    L_0x004f:
        r4 = "SKT";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x0057:
        r3 = 5;
        goto L_0x0083;
    L_0x0059:
        r4 = "GBS";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x0061:
        r3 = 0;
        goto L_0x0083;
    L_0x0063:
        r4 = "CON";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x006b:
        r3 = 2;
        goto L_0x0083;
    L_0x006d:
        r4 = "ATT";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x0075:
        r3 = 1;
        goto L_0x0083;
    L_0x0077:
        r4 = "ATD";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0081;
    L_0x007f:
        r3 = 4;
        goto L_0x0083;
    L_0x0081:
        r3 = 8;
    L_0x0083:
        r2.setPosition(r3);
        goto L_0x002a;
    L_0x0087:
        r0 = io.realm.Realm.getDefaultInstance();
        r0.beginTransaction();
        r1 = com.aeries.mobileportal.models.Student.class;
        r1 = r0.where(r1);
        r1 = r1.findAll();
        r1.deleteAllFromRealm();
        r6 = (java.lang.Iterable) r6;
        r0.copyToRealmOrUpdate(r6);
        r0.commitTransaction();
        r0.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.repos.realm.StudentRealmRepo.replaceStudents(java.util.List):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateStudents(@org.jetbrains.annotations.NotNull java.util.List<? extends com.aeries.mobileportal.models.Student> r11) {
        /*
        r10 = this;
        r0 = "students";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0);
        r0 = r11.iterator();
    L_0x0009:
        r1 = r0.hasNext();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0089;
    L_0x0011:
        r1 = r0.next();
        r1 = (com.aeries.mobileportal.models.Student) r1;
        r4 = r1.getDemographics();
        r4 = r4.getStudentId();
        r1.setStudentID(r4);
        r1 = r1.getViews();
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
    L_0x002c:
        r4 = r1.hasNext();
        if (r4 == 0) goto L_0x0009;
    L_0x0032:
        r4 = r1.next();
        r4 = (com.aeries.mobileportal.models.ViewPermission) r4;
        r5 = r4.getViewCode();
        if (r5 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0083;
    L_0x003f:
        r6 = r5.hashCode();
        switch(r6) {
            case 65137: goto L_0x0079;
            case 65153: goto L_0x006f;
            case 66914: goto L_0x0065;
            case 70360: goto L_0x005b;
            case 82172: goto L_0x0051;
            case 82452: goto L_0x0047;
            default: goto L_0x0046;
        };
    L_0x0046:
        goto L_0x0083;
    L_0x0047:
        r6 = "STU";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x004f:
        r5 = 3;
        goto L_0x0085;
    L_0x0051:
        r6 = "SKT";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x0059:
        r5 = 5;
        goto L_0x0085;
    L_0x005b:
        r6 = "GBS";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x0063:
        r5 = r3;
        goto L_0x0085;
    L_0x0065:
        r6 = "CON";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x006d:
        r5 = 2;
        goto L_0x0085;
    L_0x006f:
        r6 = "ATT";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x0077:
        r5 = r2;
        goto L_0x0085;
    L_0x0079:
        r6 = "ATD";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0083;
    L_0x0081:
        r5 = 4;
        goto L_0x0085;
    L_0x0083:
        r5 = 8;
    L_0x0085:
        r4.setPosition(r5);
        goto L_0x002c;
    L_0x0089:
        r0 = io.realm.Realm.getDefaultInstance();
        r0.beginTransaction();
        r1 = com.aeries.mobileportal.models.Student.class;
        r1 = r0.where(r1);
        r1 = r1.findAll();
        r11 = (java.lang.Iterable) r11;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r4 = (java.util.Collection) r4;
        r11 = r11.iterator();
    L_0x00a7:
        r5 = r11.hasNext();
        if (r5 == 0) goto L_0x00f2;
    L_0x00ad:
        r5 = r11.next();
        r6 = r5;
        r6 = (com.aeries.mobileportal.models.Student) r6;
        r7 = "savedStudent";
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7);
        r7 = r1;
        r7 = (java.lang.Iterable) r7;
        r8 = r7 instanceof java.util.Collection;
        if (r8 == 0) goto L_0x00cb;
    L_0x00c0:
        r8 = r7;
        r8 = (java.util.Collection) r8;
        r8 = r8.isEmpty();
        if (r8 == 0) goto L_0x00cb;
    L_0x00c9:
        r6 = r3;
        goto L_0x00eb;
    L_0x00cb:
        r7 = r7.iterator();
    L_0x00cf:
        r8 = r7.hasNext();
        if (r8 == 0) goto L_0x00c9;
    L_0x00d5:
        r8 = r7.next();
        r8 = (com.aeries.mobileportal.models.Student) r8;
        r8 = r8.getStudentID();
        r9 = r6.getStudentID();
        if (r8 != r9) goto L_0x00e7;
    L_0x00e5:
        r8 = r2;
        goto L_0x00e8;
    L_0x00e7:
        r8 = r3;
    L_0x00e8:
        if (r8 == 0) goto L_0x00cf;
    L_0x00ea:
        r6 = r2;
    L_0x00eb:
        r6 = r6 ^ r2;
        if (r6 == 0) goto L_0x00a7;
    L_0x00ee:
        r4.add(r5);
        goto L_0x00a7;
    L_0x00f2:
        r4 = (java.util.List) r4;
        r4 = (java.lang.Iterable) r4;
        r0.copyToRealmOrUpdate(r4);
        r0.commitTransaction();
        r0.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aeries.mobileportal.repos.realm.StudentRealmRepo.updateStudents(java.util.List):void");
    }

    @NotNull
    public List<Student> getStudents() {
        Realm defaultInstance = Realm.getDefaultInstance();
        List<Student> copyFromRealm = defaultInstance.copyFromRealm(defaultInstance.where(Student.class).findAll());
        defaultInstance.close();
        Intrinsics.checkExpressionValueIsNotNull(copyFromRealm, "list");
        return copyFromRealm;
    }

    @Nullable
    public Student getStudent(int i) {
        Realm defaultInstance = Realm.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(defaultInstance, "realm");
        i = findStudent(defaultInstance, i);
        i = i != 0 ? (Student) defaultInstance.copyFromRealm((RealmModel) i) : new Student();
        defaultInstance.close();
        return i;
    }

    public void addSignalKitPermission(int i) {
        Realm defaultInstance = Realm.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(defaultInstance, "realm");
        i = findStudent(defaultInstance, i);
        if (i != 0) {
            ViewPermission viewPermission = new ViewPermission();
            viewPermission.setViewDescription("Communication");
            viewPermission.setViewCode("SKT");
            viewPermission.setPosition(10);
            Collection arrayList = new ArrayList();
            for (Object next : i.getViews()) {
                if (Intrinsics.areEqual(((ViewPermission) next).getViewCode(), viewPermission.getViewCode())) {
                    arrayList.add(next);
                }
            }
            Object obj = null;
            for (ViewPermission viewPermission2 : (List) arrayList) {
                obj = 1;
            }
            if (obj == null) {
                defaultInstance.beginTransaction();
                i.getViews().add(viewPermission);
                defaultInstance.commitTransaction();
            }
        }
        defaultInstance.close();
    }

    public void addFeedbackPermission(int i) {
        i = getStudent(i);
        if (i != 0) {
            ViewPermission viewPermission = new ViewPermission();
            viewPermission.setViewDescription("Feedback");
            viewPermission.setViewCode("Feedback");
            viewPermission.setPosition(10);
            Collection arrayList = new ArrayList();
            for (Object next : i.getViews()) {
                if (Intrinsics.areEqual(((ViewPermission) next).getViewCode(), viewPermission.getViewCode())) {
                    arrayList.add(next);
                }
            }
            Object obj = null;
            for (ViewPermission viewPermission2 : (List) arrayList) {
                obj = 1;
            }
            if (obj == null) {
                Realm defaultInstance = Realm.getDefaultInstance();
                defaultInstance.beginTransaction();
                i.getViews().add(viewPermission);
                defaultInstance.commitTransaction();
                defaultInstance.close();
            }
        }
    }

    public void deleteStudents() {
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.beginTransaction();
        defaultInstance.where(Student.class).findAll().deleteAllFromRealm();
        defaultInstance.commitTransaction();
        defaultInstance.close();
    }

    private final Student findStudent(Realm realm, int i) {
        realm = realm.where(Student.class);
        if (i != 0) {
            realm.equalTo("studentID", Integer.valueOf(i));
        }
        return (Student) realm.findFirst();
    }
}
