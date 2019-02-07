package io.realm;

import android.util.JsonReader;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.CalculateScoreRequest;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.GenericAddress;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.models.MockGradebook;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import io.realm.BaseRealm.RealmObjectContext;
import io.realm.annotations.RealmModule;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    DefaultRealmModuleMediator() {
    }

    static {
        Set hashSet = new HashSet();
        hashSet.add(Demographics.class);
        hashSet.add(ClassSummary.class);
        hashSet.add(GenericAddress.class);
        hashSet.add(Gradebook.class);
        hashSet.add(AssignmentCategory.class);
        hashSet.add(School.class);
        hashSet.add(CalculateScoreRequest.class);
        hashSet.add(MockGradebook.class);
        hashSet.add(SchoolClassSummary.class);
        hashSet.add(MockAssignment.class);
        hashSet.add(Assignment.class);
        hashSet.add(Notification.class);
        hashSet.add(ViewPermission.class);
        hashSet.add(Student.class);
        MODEL_CLASSES = Collections.unmodifiableSet(hashSet);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> hashMap = new HashMap();
        hashMap.put(Demographics.class, DemographicsRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(ClassSummary.class, ClassSummaryRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(GenericAddress.class, GenericAddressRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Gradebook.class, GradebookRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(AssignmentCategory.class, AssignmentCategoryRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(School.class, SchoolRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(CalculateScoreRequest.class, CalculateScoreRequestRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(MockGradebook.class, MockGradebookRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(SchoolClassSummary.class, SchoolClassSummaryRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(MockAssignment.class, MockAssignmentRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Assignment.class, AssignmentRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Notification.class, NotificationRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(ViewPermission.class, ViewPermissionRealmProxy.getExpectedObjectSchemaInfo());
        hashMap.put(Student.class, StudentRealmProxy.getExpectedObjectSchemaInfo());
        return hashMap;
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> cls, SharedRealm sharedRealm, boolean z) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(Demographics.class)) {
            return DemographicsRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(ClassSummary.class)) {
            return ClassSummaryRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(GenericAddress.class)) {
            return GenericAddressRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(Gradebook.class)) {
            return GradebookRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(AssignmentCategory.class)) {
            return AssignmentCategoryRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(School.class)) {
            return SchoolRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(CalculateScoreRequest.class)) {
            return CalculateScoreRequestRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(MockGradebook.class)) {
            return MockGradebookRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(SchoolClassSummary.class)) {
            return SchoolClassSummaryRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(MockAssignment.class)) {
            return MockAssignmentRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(Assignment.class)) {
            return AssignmentRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(Notification.class)) {
            return NotificationRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(ViewPermission.class)) {
            return ViewPermissionRealmProxy.validateTable(sharedRealm, z);
        }
        if (cls.equals(Student.class)) {
            return StudentRealmProxy.validateTable(sharedRealm, z);
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(Demographics.class)) {
            return DemographicsRealmProxy.getFieldNames();
        }
        if (cls.equals(ClassSummary.class)) {
            return ClassSummaryRealmProxy.getFieldNames();
        }
        if (cls.equals(GenericAddress.class)) {
            return GenericAddressRealmProxy.getFieldNames();
        }
        if (cls.equals(Gradebook.class)) {
            return GradebookRealmProxy.getFieldNames();
        }
        if (cls.equals(AssignmentCategory.class)) {
            return AssignmentCategoryRealmProxy.getFieldNames();
        }
        if (cls.equals(School.class)) {
            return SchoolRealmProxy.getFieldNames();
        }
        if (cls.equals(CalculateScoreRequest.class)) {
            return CalculateScoreRequestRealmProxy.getFieldNames();
        }
        if (cls.equals(MockGradebook.class)) {
            return MockGradebookRealmProxy.getFieldNames();
        }
        if (cls.equals(SchoolClassSummary.class)) {
            return SchoolClassSummaryRealmProxy.getFieldNames();
        }
        if (cls.equals(MockAssignment.class)) {
            return MockAssignmentRealmProxy.getFieldNames();
        }
        if (cls.equals(Assignment.class)) {
            return AssignmentRealmProxy.getFieldNames();
        }
        if (cls.equals(Notification.class)) {
            return NotificationRealmProxy.getFieldNames();
        }
        if (cls.equals(ViewPermission.class)) {
            return ViewPermissionRealmProxy.getFieldNames();
        }
        if (cls.equals(Student.class)) {
            return StudentRealmProxy.getFieldNames();
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public String getTableName(Class<? extends RealmModel> cls) {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(Demographics.class)) {
            return DemographicsRealmProxy.getTableName();
        }
        if (cls.equals(ClassSummary.class)) {
            return ClassSummaryRealmProxy.getTableName();
        }
        if (cls.equals(GenericAddress.class)) {
            return GenericAddressRealmProxy.getTableName();
        }
        if (cls.equals(Gradebook.class)) {
            return GradebookRealmProxy.getTableName();
        }
        if (cls.equals(AssignmentCategory.class)) {
            return AssignmentCategoryRealmProxy.getTableName();
        }
        if (cls.equals(School.class)) {
            return SchoolRealmProxy.getTableName();
        }
        if (cls.equals(CalculateScoreRequest.class)) {
            return CalculateScoreRequestRealmProxy.getTableName();
        }
        if (cls.equals(MockGradebook.class)) {
            return MockGradebookRealmProxy.getTableName();
        }
        if (cls.equals(SchoolClassSummary.class)) {
            return SchoolClassSummaryRealmProxy.getTableName();
        }
        if (cls.equals(MockAssignment.class)) {
            return MockAssignmentRealmProxy.getTableName();
        }
        if (cls.equals(Assignment.class)) {
            return AssignmentRealmProxy.getTableName();
        }
        if (cls.equals(Notification.class)) {
            return NotificationRealmProxy.getTableName();
        }
        if (cls.equals(ViewPermission.class)) {
            return ViewPermissionRealmProxy.getTableName();
        }
        if (cls.equals(Student.class)) {
            return StudentRealmProxy.getTableName();
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        try {
            realmObjectContext.set((BaseRealm) obj, row, columnInfo, z, list);
            RealmProxyMediator.checkClass(cls);
            RealmModel realmModel;
            if (cls.equals(Demographics.class) != null) {
                realmModel = (RealmModel) cls.cast(new DemographicsRealmProxy());
                return realmModel;
            } else if (cls.equals(ClassSummary.class) != null) {
                realmModel = (RealmModel) cls.cast(new ClassSummaryRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(GenericAddress.class) != null) {
                realmModel = (RealmModel) cls.cast(new GenericAddressRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(Gradebook.class) != null) {
                realmModel = (RealmModel) cls.cast(new GradebookRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(AssignmentCategory.class) != null) {
                realmModel = (RealmModel) cls.cast(new AssignmentCategoryRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(School.class) != null) {
                realmModel = (RealmModel) cls.cast(new SchoolRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(CalculateScoreRequest.class) != null) {
                realmModel = (RealmModel) cls.cast(new CalculateScoreRequestRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(MockGradebook.class) != null) {
                realmModel = (RealmModel) cls.cast(new MockGradebookRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(SchoolClassSummary.class) != null) {
                realmModel = (RealmModel) cls.cast(new SchoolClassSummaryRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(MockAssignment.class) != null) {
                realmModel = (RealmModel) cls.cast(new MockAssignmentRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(Assignment.class) != null) {
                realmModel = (RealmModel) cls.cast(new AssignmentRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(Notification.class) != null) {
                realmModel = (RealmModel) cls.cast(new NotificationRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(ViewPermission.class) != null) {
                realmModel = (RealmModel) cls.cast(new ViewPermissionRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else if (cls.equals(Student.class) != null) {
                realmModel = (RealmModel) cls.cast(new StudentRealmProxy());
                realmObjectContext.clear();
                return realmModel;
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(cls);
            }
        } finally {
            realmObjectContext.clear();
        }
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        Class superclass = e instanceof RealmObjectProxy ? e.getClass().getSuperclass() : e.getClass();
        if (superclass.equals(Demographics.class)) {
            return (RealmModel) superclass.cast(DemographicsRealmProxy.copyOrUpdate(realm, (Demographics) e, z, map));
        }
        if (superclass.equals(ClassSummary.class)) {
            return (RealmModel) superclass.cast(ClassSummaryRealmProxy.copyOrUpdate(realm, (ClassSummary) e, z, map));
        }
        if (superclass.equals(GenericAddress.class)) {
            return (RealmModel) superclass.cast(GenericAddressRealmProxy.copyOrUpdate(realm, (GenericAddress) e, z, map));
        }
        if (superclass.equals(Gradebook.class)) {
            return (RealmModel) superclass.cast(GradebookRealmProxy.copyOrUpdate(realm, (Gradebook) e, z, map));
        }
        if (superclass.equals(AssignmentCategory.class)) {
            return (RealmModel) superclass.cast(AssignmentCategoryRealmProxy.copyOrUpdate(realm, (AssignmentCategory) e, z, map));
        }
        if (superclass.equals(School.class)) {
            return (RealmModel) superclass.cast(SchoolRealmProxy.copyOrUpdate(realm, (School) e, z, map));
        }
        if (superclass.equals(CalculateScoreRequest.class)) {
            return (RealmModel) superclass.cast(CalculateScoreRequestRealmProxy.copyOrUpdate(realm, (CalculateScoreRequest) e, z, map));
        }
        if (superclass.equals(MockGradebook.class)) {
            return (RealmModel) superclass.cast(MockGradebookRealmProxy.copyOrUpdate(realm, (MockGradebook) e, z, map));
        }
        if (superclass.equals(SchoolClassSummary.class)) {
            return (RealmModel) superclass.cast(SchoolClassSummaryRealmProxy.copyOrUpdate(realm, (SchoolClassSummary) e, z, map));
        }
        if (superclass.equals(MockAssignment.class)) {
            return (RealmModel) superclass.cast(MockAssignmentRealmProxy.copyOrUpdate(realm, (MockAssignment) e, z, map));
        }
        if (superclass.equals(Assignment.class)) {
            return (RealmModel) superclass.cast(AssignmentRealmProxy.copyOrUpdate(realm, (Assignment) e, z, map));
        }
        if (superclass.equals(Notification.class)) {
            return (RealmModel) superclass.cast(NotificationRealmProxy.copyOrUpdate(realm, (Notification) e, z, map));
        }
        if (superclass.equals(ViewPermission.class)) {
            return (RealmModel) superclass.cast(ViewPermissionRealmProxy.copyOrUpdate(realm, (ViewPermission) e, z, map));
        }
        if (superclass.equals(Student.class)) {
            return (RealmModel) superclass.cast(StudentRealmProxy.copyOrUpdate(realm, (Student) e, z, map));
        }
        throw RealmProxyMediator.getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(Demographics.class)) {
            DemographicsRealmProxy.insert(realm, (Demographics) realmModel, (Map) map);
        } else if (superclass.equals(ClassSummary.class)) {
            ClassSummaryRealmProxy.insert(realm, (ClassSummary) realmModel, (Map) map);
        } else if (superclass.equals(GenericAddress.class)) {
            GenericAddressRealmProxy.insert(realm, (GenericAddress) realmModel, (Map) map);
        } else if (superclass.equals(Gradebook.class)) {
            GradebookRealmProxy.insert(realm, (Gradebook) realmModel, (Map) map);
        } else if (superclass.equals(AssignmentCategory.class)) {
            AssignmentCategoryRealmProxy.insert(realm, (AssignmentCategory) realmModel, (Map) map);
        } else if (superclass.equals(School.class)) {
            SchoolRealmProxy.insert(realm, (School) realmModel, (Map) map);
        } else if (superclass.equals(CalculateScoreRequest.class)) {
            CalculateScoreRequestRealmProxy.insert(realm, (CalculateScoreRequest) realmModel, (Map) map);
        } else if (superclass.equals(MockGradebook.class)) {
            MockGradebookRealmProxy.insert(realm, (MockGradebook) realmModel, (Map) map);
        } else if (superclass.equals(SchoolClassSummary.class)) {
            SchoolClassSummaryRealmProxy.insert(realm, (SchoolClassSummary) realmModel, (Map) map);
        } else if (superclass.equals(MockAssignment.class)) {
            MockAssignmentRealmProxy.insert(realm, (MockAssignment) realmModel, (Map) map);
        } else if (superclass.equals(Assignment.class)) {
            AssignmentRealmProxy.insert(realm, (Assignment) realmModel, (Map) map);
        } else if (superclass.equals(Notification.class)) {
            NotificationRealmProxy.insert(realm, (Notification) realmModel, (Map) map);
        } else if (superclass.equals(ViewPermission.class)) {
            ViewPermissionRealmProxy.insert(realm, (ViewPermission) realmModel, (Map) map);
        } else if (superclass.equals(Student.class)) {
            StudentRealmProxy.insert(realm, (Student) realmModel, (Map) map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    public void insert(Realm realm, Collection<? extends RealmModel> collection) {
        Iterator it = collection.iterator();
        Map hashMap = new HashMap(collection.size());
        if (it.hasNext() != null) {
            RealmModel realmModel = (RealmModel) it.next();
            Class superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
            if (superclass.equals(Demographics.class)) {
                DemographicsRealmProxy.insert(realm, (Demographics) realmModel, hashMap);
            } else if (superclass.equals(ClassSummary.class)) {
                ClassSummaryRealmProxy.insert(realm, (ClassSummary) realmModel, hashMap);
            } else if (superclass.equals(GenericAddress.class)) {
                GenericAddressRealmProxy.insert(realm, (GenericAddress) realmModel, hashMap);
            } else if (superclass.equals(Gradebook.class)) {
                GradebookRealmProxy.insert(realm, (Gradebook) realmModel, hashMap);
            } else if (superclass.equals(AssignmentCategory.class)) {
                AssignmentCategoryRealmProxy.insert(realm, (AssignmentCategory) realmModel, hashMap);
            } else if (superclass.equals(School.class)) {
                SchoolRealmProxy.insert(realm, (School) realmModel, hashMap);
            } else if (superclass.equals(CalculateScoreRequest.class)) {
                CalculateScoreRequestRealmProxy.insert(realm, (CalculateScoreRequest) realmModel, hashMap);
            } else if (superclass.equals(MockGradebook.class)) {
                MockGradebookRealmProxy.insert(realm, (MockGradebook) realmModel, hashMap);
            } else if (superclass.equals(SchoolClassSummary.class)) {
                SchoolClassSummaryRealmProxy.insert(realm, (SchoolClassSummary) realmModel, hashMap);
            } else if (superclass.equals(MockAssignment.class)) {
                MockAssignmentRealmProxy.insert(realm, (MockAssignment) realmModel, hashMap);
            } else if (superclass.equals(Assignment.class)) {
                AssignmentRealmProxy.insert(realm, (Assignment) realmModel, hashMap);
            } else if (superclass.equals(Notification.class)) {
                NotificationRealmProxy.insert(realm, (Notification) realmModel, hashMap);
            } else if (superclass.equals(ViewPermission.class)) {
                ViewPermissionRealmProxy.insert(realm, (ViewPermission) realmModel, hashMap);
            } else if (superclass.equals(Student.class)) {
                StudentRealmProxy.insert(realm, (Student) realmModel, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(superclass);
            }
            if (it.hasNext() == null) {
                return;
            }
            if (superclass.equals(Demographics.class) != null) {
                DemographicsRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(ClassSummary.class) != null) {
                ClassSummaryRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(GenericAddress.class) != null) {
                GenericAddressRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Gradebook.class) != null) {
                GradebookRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(AssignmentCategory.class) != null) {
                AssignmentCategoryRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(School.class) != null) {
                SchoolRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(CalculateScoreRequest.class) != null) {
                CalculateScoreRequestRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(MockGradebook.class) != null) {
                MockGradebookRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(SchoolClassSummary.class) != null) {
                SchoolClassSummaryRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(MockAssignment.class) != null) {
                MockAssignmentRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Assignment.class) != null) {
                AssignmentRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Notification.class) != null) {
                NotificationRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(ViewPermission.class) != null) {
                ViewPermissionRealmProxy.insert(realm, it, hashMap);
            } else if (superclass.equals(Student.class) != null) {
                StudentRealmProxy.insert(realm, it, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        Class superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
        if (superclass.equals(Demographics.class)) {
            DemographicsRealmProxy.insertOrUpdate(realm, (Demographics) realmModel, (Map) map);
        } else if (superclass.equals(ClassSummary.class)) {
            ClassSummaryRealmProxy.insertOrUpdate(realm, (ClassSummary) realmModel, (Map) map);
        } else if (superclass.equals(GenericAddress.class)) {
            GenericAddressRealmProxy.insertOrUpdate(realm, (GenericAddress) realmModel, (Map) map);
        } else if (superclass.equals(Gradebook.class)) {
            GradebookRealmProxy.insertOrUpdate(realm, (Gradebook) realmModel, (Map) map);
        } else if (superclass.equals(AssignmentCategory.class)) {
            AssignmentCategoryRealmProxy.insertOrUpdate(realm, (AssignmentCategory) realmModel, (Map) map);
        } else if (superclass.equals(School.class)) {
            SchoolRealmProxy.insertOrUpdate(realm, (School) realmModel, (Map) map);
        } else if (superclass.equals(CalculateScoreRequest.class)) {
            CalculateScoreRequestRealmProxy.insertOrUpdate(realm, (CalculateScoreRequest) realmModel, (Map) map);
        } else if (superclass.equals(MockGradebook.class)) {
            MockGradebookRealmProxy.insertOrUpdate(realm, (MockGradebook) realmModel, (Map) map);
        } else if (superclass.equals(SchoolClassSummary.class)) {
            SchoolClassSummaryRealmProxy.insertOrUpdate(realm, (SchoolClassSummary) realmModel, (Map) map);
        } else if (superclass.equals(MockAssignment.class)) {
            MockAssignmentRealmProxy.insertOrUpdate(realm, (MockAssignment) realmModel, (Map) map);
        } else if (superclass.equals(Assignment.class)) {
            AssignmentRealmProxy.insertOrUpdate(realm, (Assignment) realmModel, (Map) map);
        } else if (superclass.equals(Notification.class)) {
            NotificationRealmProxy.insertOrUpdate(realm, (Notification) realmModel, (Map) map);
        } else if (superclass.equals(ViewPermission.class)) {
            ViewPermissionRealmProxy.insertOrUpdate(realm, (ViewPermission) realmModel, (Map) map);
        } else if (superclass.equals(Student.class)) {
            StudentRealmProxy.insertOrUpdate(realm, (Student) realmModel, (Map) map);
        } else {
            throw RealmProxyMediator.getMissingProxyClassException(superclass);
        }
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection) {
        Iterator it = collection.iterator();
        Map hashMap = new HashMap(collection.size());
        if (it.hasNext() != null) {
            RealmModel realmModel = (RealmModel) it.next();
            Class superclass = realmModel instanceof RealmObjectProxy ? realmModel.getClass().getSuperclass() : realmModel.getClass();
            if (superclass.equals(Demographics.class)) {
                DemographicsRealmProxy.insertOrUpdate(realm, (Demographics) realmModel, hashMap);
            } else if (superclass.equals(ClassSummary.class)) {
                ClassSummaryRealmProxy.insertOrUpdate(realm, (ClassSummary) realmModel, hashMap);
            } else if (superclass.equals(GenericAddress.class)) {
                GenericAddressRealmProxy.insertOrUpdate(realm, (GenericAddress) realmModel, hashMap);
            } else if (superclass.equals(Gradebook.class)) {
                GradebookRealmProxy.insertOrUpdate(realm, (Gradebook) realmModel, hashMap);
            } else if (superclass.equals(AssignmentCategory.class)) {
                AssignmentCategoryRealmProxy.insertOrUpdate(realm, (AssignmentCategory) realmModel, hashMap);
            } else if (superclass.equals(School.class)) {
                SchoolRealmProxy.insertOrUpdate(realm, (School) realmModel, hashMap);
            } else if (superclass.equals(CalculateScoreRequest.class)) {
                CalculateScoreRequestRealmProxy.insertOrUpdate(realm, (CalculateScoreRequest) realmModel, hashMap);
            } else if (superclass.equals(MockGradebook.class)) {
                MockGradebookRealmProxy.insertOrUpdate(realm, (MockGradebook) realmModel, hashMap);
            } else if (superclass.equals(SchoolClassSummary.class)) {
                SchoolClassSummaryRealmProxy.insertOrUpdate(realm, (SchoolClassSummary) realmModel, hashMap);
            } else if (superclass.equals(MockAssignment.class)) {
                MockAssignmentRealmProxy.insertOrUpdate(realm, (MockAssignment) realmModel, hashMap);
            } else if (superclass.equals(Assignment.class)) {
                AssignmentRealmProxy.insertOrUpdate(realm, (Assignment) realmModel, hashMap);
            } else if (superclass.equals(Notification.class)) {
                NotificationRealmProxy.insertOrUpdate(realm, (Notification) realmModel, hashMap);
            } else if (superclass.equals(ViewPermission.class)) {
                ViewPermissionRealmProxy.insertOrUpdate(realm, (ViewPermission) realmModel, hashMap);
            } else if (superclass.equals(Student.class)) {
                StudentRealmProxy.insertOrUpdate(realm, (Student) realmModel, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(superclass);
            }
            if (it.hasNext() == null) {
                return;
            }
            if (superclass.equals(Demographics.class) != null) {
                DemographicsRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(ClassSummary.class) != null) {
                ClassSummaryRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(GenericAddress.class) != null) {
                GenericAddressRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Gradebook.class) != null) {
                GradebookRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(AssignmentCategory.class) != null) {
                AssignmentCategoryRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(School.class) != null) {
                SchoolRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(CalculateScoreRequest.class) != null) {
                CalculateScoreRequestRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(MockGradebook.class) != null) {
                MockGradebookRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(SchoolClassSummary.class) != null) {
                SchoolClassSummaryRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(MockAssignment.class) != null) {
                MockAssignmentRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Assignment.class) != null) {
                AssignmentRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Notification.class) != null) {
                NotificationRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(ViewPermission.class) != null) {
                ViewPermissionRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else if (superclass.equals(Student.class) != null) {
                StudentRealmProxy.insertOrUpdate(realm, it, hashMap);
            } else {
                throw RealmProxyMediator.getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(Demographics.class)) {
            return (RealmModel) cls.cast(DemographicsRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(ClassSummary.class)) {
            return (RealmModel) cls.cast(ClassSummaryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(GenericAddress.class)) {
            return (RealmModel) cls.cast(GenericAddressRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(Gradebook.class)) {
            return (RealmModel) cls.cast(GradebookRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(AssignmentCategory.class)) {
            return (RealmModel) cls.cast(AssignmentCategoryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(School.class)) {
            return (RealmModel) cls.cast(SchoolRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(CalculateScoreRequest.class)) {
            return (RealmModel) cls.cast(CalculateScoreRequestRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(MockGradebook.class)) {
            return (RealmModel) cls.cast(MockGradebookRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(SchoolClassSummary.class)) {
            return (RealmModel) cls.cast(SchoolClassSummaryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(MockAssignment.class)) {
            return (RealmModel) cls.cast(MockAssignmentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(Assignment.class)) {
            return (RealmModel) cls.cast(AssignmentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(Notification.class)) {
            return (RealmModel) cls.cast(NotificationRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(ViewPermission.class)) {
            return (RealmModel) cls.cast(ViewPermissionRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        if (cls.equals(Student.class)) {
            return (RealmModel) cls.cast(StudentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject, z));
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        RealmProxyMediator.checkClass(cls);
        if (cls.equals(Demographics.class)) {
            return (RealmModel) cls.cast(DemographicsRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(ClassSummary.class)) {
            return (RealmModel) cls.cast(ClassSummaryRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(GenericAddress.class)) {
            return (RealmModel) cls.cast(GenericAddressRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(Gradebook.class)) {
            return (RealmModel) cls.cast(GradebookRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(AssignmentCategory.class)) {
            return (RealmModel) cls.cast(AssignmentCategoryRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(School.class)) {
            return (RealmModel) cls.cast(SchoolRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(CalculateScoreRequest.class)) {
            return (RealmModel) cls.cast(CalculateScoreRequestRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(MockGradebook.class)) {
            return (RealmModel) cls.cast(MockGradebookRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(SchoolClassSummary.class)) {
            return (RealmModel) cls.cast(SchoolClassSummaryRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(MockAssignment.class)) {
            return (RealmModel) cls.cast(MockAssignmentRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(Assignment.class)) {
            return (RealmModel) cls.cast(AssignmentRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(Notification.class)) {
            return (RealmModel) cls.cast(NotificationRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(ViewPermission.class)) {
            return (RealmModel) cls.cast(ViewPermissionRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        if (cls.equals(Student.class)) {
            return (RealmModel) cls.cast(StudentRealmProxy.createUsingJsonStream(realm, jsonReader));
        }
        throw RealmProxyMediator.getMissingProxyClassException(cls);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, CacheData<RealmModel>> map) {
        Class superclass = e.getClass().getSuperclass();
        if (superclass.equals(Demographics.class)) {
            return (RealmModel) superclass.cast(DemographicsRealmProxy.createDetachedCopy((Demographics) e, 0, i, map));
        }
        if (superclass.equals(ClassSummary.class)) {
            return (RealmModel) superclass.cast(ClassSummaryRealmProxy.createDetachedCopy((ClassSummary) e, 0, i, map));
        }
        if (superclass.equals(GenericAddress.class)) {
            return (RealmModel) superclass.cast(GenericAddressRealmProxy.createDetachedCopy((GenericAddress) e, 0, i, map));
        }
        if (superclass.equals(Gradebook.class)) {
            return (RealmModel) superclass.cast(GradebookRealmProxy.createDetachedCopy((Gradebook) e, 0, i, map));
        }
        if (superclass.equals(AssignmentCategory.class)) {
            return (RealmModel) superclass.cast(AssignmentCategoryRealmProxy.createDetachedCopy((AssignmentCategory) e, 0, i, map));
        }
        if (superclass.equals(School.class)) {
            return (RealmModel) superclass.cast(SchoolRealmProxy.createDetachedCopy((School) e, 0, i, map));
        }
        if (superclass.equals(CalculateScoreRequest.class)) {
            return (RealmModel) superclass.cast(CalculateScoreRequestRealmProxy.createDetachedCopy((CalculateScoreRequest) e, 0, i, map));
        }
        if (superclass.equals(MockGradebook.class)) {
            return (RealmModel) superclass.cast(MockGradebookRealmProxy.createDetachedCopy((MockGradebook) e, 0, i, map));
        }
        if (superclass.equals(SchoolClassSummary.class)) {
            return (RealmModel) superclass.cast(SchoolClassSummaryRealmProxy.createDetachedCopy((SchoolClassSummary) e, 0, i, map));
        }
        if (superclass.equals(MockAssignment.class)) {
            return (RealmModel) superclass.cast(MockAssignmentRealmProxy.createDetachedCopy((MockAssignment) e, 0, i, map));
        }
        if (superclass.equals(Assignment.class)) {
            return (RealmModel) superclass.cast(AssignmentRealmProxy.createDetachedCopy((Assignment) e, 0, i, map));
        }
        if (superclass.equals(Notification.class)) {
            return (RealmModel) superclass.cast(NotificationRealmProxy.createDetachedCopy((Notification) e, 0, i, map));
        }
        if (superclass.equals(ViewPermission.class)) {
            return (RealmModel) superclass.cast(ViewPermissionRealmProxy.createDetachedCopy((ViewPermission) e, 0, i, map));
        }
        if (superclass.equals(Student.class)) {
            return (RealmModel) superclass.cast(StudentRealmProxy.createDetachedCopy((Student) e, 0, i, map));
        }
        throw RealmProxyMediator.getMissingProxyClassException(superclass);
    }
}
