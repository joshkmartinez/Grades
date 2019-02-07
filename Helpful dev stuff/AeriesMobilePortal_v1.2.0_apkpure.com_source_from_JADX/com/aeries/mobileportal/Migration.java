package com.aeries.mobileportal;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/Migration;", "Lio/realm/RealmMigration;", "()V", "migrate", "", "realm", "Lio/realm/DynamicRealm;", "oldVersion", "", "newVersion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Migration.kt */
public final class Migration implements RealmMigration {
    public void migrate(@Nullable DynamicRealm dynamicRealm, long j, long j2) {
        RealmObjectSchema realmObjectSchema;
        dynamicRealm = dynamicRealm != null ? dynamicRealm.getSchema() : null;
        if (j2 == 1) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Attendance");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("schoolName", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("AttendanceDetail");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("schoolCode", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("ClassSummary");
                if (realmObjectSchema != null) {
                    Class cls = Boolean.TYPE;
                    FieldAttribute[] fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("doingRubric", cls, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.addField("cn_temp", String.class, new FieldAttribute[]{r7});
                        if (realmObjectSchema != null) {
                            realmObjectSchema = realmObjectSchema.transform(Migration$migrate$1.INSTANCE);
                            if (realmObjectSchema != null) {
                                realmObjectSchema = realmObjectSchema.removeField("courseNumber");
                                if (realmObjectSchema != null) {
                                    realmObjectSchema = realmObjectSchema.renameField("cn_temp", "courseNumber");
                                    if (realmObjectSchema != null) {
                                        realmObjectSchema = realmObjectSchema.addField("rn_temp", String.class, new FieldAttribute[]{r7});
                                        if (realmObjectSchema != null) {
                                            realmObjectSchema = realmObjectSchema.transform(Migration$migrate$2.INSTANCE);
                                            if (realmObjectSchema != null) {
                                                realmObjectSchema = realmObjectSchema.removeField("roomNumber");
                                                if (realmObjectSchema != null) {
                                                    realmObjectSchema = realmObjectSchema.renameField("rn_temp", "roomNumber");
                                                    if (realmObjectSchema != null) {
                                                        realmObjectSchema = realmObjectSchema.addField("average_temp", String.class, new FieldAttribute[]{r7});
                                                        if (realmObjectSchema != null) {
                                                            realmObjectSchema = realmObjectSchema.transform(Migration$migrate$3.INSTANCE);
                                                            if (realmObjectSchema != null) {
                                                                realmObjectSchema = realmObjectSchema.removeField("average");
                                                                if (realmObjectSchema != null) {
                                                                    realmObjectSchema.renameField("average_temp", "average");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("School");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("selected", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
        }
        if (j == 1) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("SchoolClassSummary");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("showPeriod", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("ClassSummary");
                if (realmObjectSchema != null) {
                    cls = Boolean.TYPE;
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("showPeriod", cls, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema.addField("schoolName", String.class, new FieldAttribute[]{r7});
                    }
                }
            }
            j++;
        }
        if (j == 2) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Demographics");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("schoolName", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 3) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Assignment");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("isExtraCredit", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 4) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("SchoolClassSummary");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("hideScores", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("ClassSummary");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("hideScores", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 5) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Assignment");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("category", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 6) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("ClassSummary");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("lastUpdated", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 7) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("ClassSummary");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("termCode", String.class, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 8) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.create("AssignmentCategory");
                if (realmObjectSchema != null) {
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("name", String.class, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.addField("numberOfAssignment", Integer.TYPE, new FieldAttribute[]{r7});
                        if (realmObjectSchema != null) {
                            realmObjectSchema = realmObjectSchema.addField("mark", String.class, new FieldAttribute[]{r7});
                            if (realmObjectSchema != null) {
                                realmObjectSchema = realmObjectSchema.addField("totalScore", Integer.TYPE, new FieldAttribute[]{r7});
                                if (realmObjectSchema != null) {
                                    realmObjectSchema = realmObjectSchema.addField("totalMaxScore", Integer.TYPE, new FieldAttribute[]{r7});
                                    if (realmObjectSchema != null) {
                                        realmObjectSchema.addField("percent", Double.TYPE, new FieldAttribute[]{r7});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Gradebook");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addRealmListField("categories", dynamicRealm.get("AssignmentCategory"));
                }
            }
            j++;
        }
        if (j == 9) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Assignment");
                if (realmObjectSchema != null) {
                    cls = JvmClassMappingKt.getJavaObjectType(Reflection.getOrCreateKotlinClass(Double.TYPE));
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("assign_tmp", cls, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.transform(Migration$migrate$4.INSTANCE);
                        if (realmObjectSchema != null) {
                            realmObjectSchema = realmObjectSchema.removeField("numberCorrect");
                            if (realmObjectSchema != null) {
                                realmObjectSchema = realmObjectSchema.renameField("assign_tmp", "numberCorrect");
                                if (realmObjectSchema != null) {
                                    realmObjectSchema = realmObjectSchema.addField("poss_tmp", JvmClassMappingKt.getJavaObjectType(Reflection.getOrCreateKotlinClass(Double.TYPE)), new FieldAttribute[]{r7});
                                    if (realmObjectSchema != null) {
                                        realmObjectSchema = realmObjectSchema.transform(Migration$migrate$5.INSTANCE);
                                        if (realmObjectSchema != null) {
                                            realmObjectSchema = realmObjectSchema.removeField("numberPossible");
                                            if (realmObjectSchema != null) {
                                                realmObjectSchema.renameField("poss_tmp", "numberPossible");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            j++;
        }
        if (j == 10) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.create("MockAssignment");
                if (realmObjectSchema != null) {
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("category", String.class, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.addField("assignmentNumber", String.class, new FieldAttribute[]{r7});
                        if (realmObjectSchema != null) {
                            realmObjectSchema = realmObjectSchema.addField("mark", String.class, new FieldAttribute[]{r7});
                            if (realmObjectSchema != null) {
                                realmObjectSchema = realmObjectSchema.addField(Param.SCORE, String.class, new FieldAttribute[]{r7});
                                if (realmObjectSchema != null) {
                                    realmObjectSchema.addField("maxScore", String.class, new FieldAttribute[]{r7});
                                }
                            }
                        }
                    }
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.create("MockGradebook");
                if (realmObjectSchema != null) {
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("gradebookNumber", String.class, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.addField("termCode", String.class, new FieldAttribute[]{r7});
                        if (realmObjectSchema != null) {
                            realmObjectSchema.addRealmListField("assignments", dynamicRealm.get("MockAssignment"));
                        }
                    }
                }
            }
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.create("CalculateScoreRequest");
                if (realmObjectSchema != null) {
                    fieldAttributeArr = new FieldAttribute[1];
                    fieldAttributeArr[0] = (FieldAttribute) null;
                    realmObjectSchema = realmObjectSchema.addField("schoolNumber", String.class, fieldAttributeArr);
                    if (realmObjectSchema != null) {
                        realmObjectSchema = realmObjectSchema.addField("studentId", String.class, new FieldAttribute[]{r7});
                        if (realmObjectSchema != null) {
                            realmObjectSchema.addRealmObjectField("gradebook", dynamicRealm.get("MockGradebook"));
                        }
                    }
                }
            }
            j++;
        }
        if (j == 11) {
            if (dynamicRealm != null) {
                realmObjectSchema = dynamicRealm.get("Gradebook");
                if (realmObjectSchema != null) {
                    realmObjectSchema.addField("showWhatIf", Boolean.TYPE, new FieldAttribute[]{(FieldAttribute) null});
                }
            }
            j++;
        }
        if (j == 12 && dynamicRealm != null && dynamicRealm.contains("Notification") == null) {
            dynamicRealm = dynamicRealm.create("Notification");
            if (dynamicRealm != null) {
                FieldAttribute[] fieldAttributeArr2 = new FieldAttribute[1];
                fieldAttributeArr2[0] = (FieldAttribute) null;
                dynamicRealm = dynamicRealm.addField("notificationID", String.class, fieldAttributeArr2);
                if (dynamicRealm != null) {
                    dynamicRealm = dynamicRealm.addField("notificationMessage", String.class, new FieldAttribute[]{r0});
                    if (dynamicRealm != null) {
                        dynamicRealm = dynamicRealm.addField("userID", Integer.TYPE, new FieldAttribute[]{r0});
                        if (dynamicRealm != null) {
                            dynamicRealm = dynamicRealm.addField("name", String.class, new FieldAttribute[]{r0});
                            if (dynamicRealm != null) {
                                dynamicRealm = dynamicRealm.addField("schoolCode", Integer.TYPE, new FieldAttribute[]{r0});
                                if (dynamicRealm != null) {
                                    dynamicRealm = dynamicRealm.addField("schoolName", String.class, new FieldAttribute[]{r0});
                                    if (dynamicRealm != null) {
                                        dynamicRealm = dynamicRealm.addField("userType", String.class, new FieldAttribute[]{r0});
                                        if (dynamicRealm != null) {
                                            dynamicRealm = dynamicRealm.addField("status", String.class, new FieldAttribute[]{r0});
                                            if (dynamicRealm != null) {
                                                dynamicRealm = dynamicRealm.addField("ssoUrl", String.class, new FieldAttribute[]{r0});
                                                if (dynamicRealm != null) {
                                                    dynamicRealm = dynamicRealm.addField("dateRead", String.class, new FieldAttribute[]{r0});
                                                    if (dynamicRealm != null) {
                                                        dynamicRealm.addField("dateCreated", String.class, new FieldAttribute[]{r0});
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
