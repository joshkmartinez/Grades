package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\bN\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\t\u0010ª\u0001\u001a\u00020FH\u0016J\u001b\u0010«\u0001\u001a\u00030¬\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010­\u0001\u001a\u00020FH\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR \u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR \u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR \u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR \u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR \u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR \u0010'\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR \u0010*\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR \u0010-\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR \u00100\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR \u0010<\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR \u0010?\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR \u0010B\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR\"\u0010E\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR \u0010L\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\t\"\u0004\bN\u0010\u000bR \u0010O\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\t\"\u0004\bQ\u0010\u000bR \u0010R\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\t\"\u0004\bT\u0010\u000bR \u0010U\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR \u0010X\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\t\"\u0004\bZ\u0010\u000bR \u0010[\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\t\"\u0004\b]\u0010\u000bR \u0010^\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\t\"\u0004\b`\u0010\u000bR \u0010a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\t\"\u0004\bc\u0010\u000bR \u0010d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\t\"\u0004\bf\u0010\u000bR \u0010g\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\t\"\u0004\bi\u0010\u000bR \u0010j\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\t\"\u0004\bl\u0010\u000bR \u0010m\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\t\"\u0004\bo\u0010\u000bR \u0010p\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\t\"\u0004\br\u0010\u000bR \u0010s\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\t\"\u0004\bu\u0010\u000bR \u0010v\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\t\"\u0004\bx\u0010\u000bR \u0010y\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\t\"\u0004\b{\u0010\u000bR \u0010|\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\t\"\u0004\b~\u0010\u000bR\"\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR)\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0015\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b\u0001\u0010\u000bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\t\"\u0005\b \u0001\u0010\u000bR#\u0010¡\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\t\"\u0005\b£\u0001\u0010\u000bR#\u0010¤\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\t\"\u0005\b¦\u0001\u0010\u000bR#\u0010§\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\t\"\u0005\b©\u0001\u0010\u000b¨\u0006¯\u0001"}, d2 = {"Lcom/aeries/mobileportal/models/Contact;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "accessToPortalCode", "", "getAccessToPortalCode", "()Ljava/lang/String;", "setAccessToPortalCode", "(Ljava/lang/String;)V", "accessToPortalDescription", "getAccessToPortalDescription", "setAccessToPortalDescription", "additionalContactNumber1", "getAdditionalContactNumber1", "setAdditionalContactNumber1", "additionalContactNumber2", "getAdditionalContactNumber2", "setAdditionalContactNumber2", "additionalContactNumber3", "getAdditionalContactNumber3", "setAdditionalContactNumber3", "additionalContactNumber4", "getAdditionalContactNumber4", "setAdditionalContactNumber4", "additionalContactType1Code", "getAdditionalContactType1Code", "setAdditionalContactType1Code", "additionalContactType1Description", "getAdditionalContactType1Description", "setAdditionalContactType1Description", "additionalContactType2Code", "getAdditionalContactType2Code", "setAdditionalContactType2Code", "additionalContactType2Description", "getAdditionalContactType2Description", "setAdditionalContactType2Description", "additionalContactType3Code", "getAdditionalContactType3Code", "setAdditionalContactType3Code", "additionalContactType3Description", "getAdditionalContactType3Description", "setAdditionalContactType3Description", "additionalContactType4Code", "getAdditionalContactType4Code", "setAdditionalContactType4Code", "additionalContactType4Description", "getAdditionalContactType4Description", "setAdditionalContactType4Description", "address", "Lcom/aeries/mobileportal/models/GenericAddress;", "getAddress", "()Lcom/aeries/mobileportal/models/GenericAddress;", "setAddress", "(Lcom/aeries/mobileportal/models/GenericAddress;)V", "cellPhone", "getCellPhone", "setCellPhone", "code", "getCode", "setCode", "codeDescription", "getCodeDescription", "setCodeDescription", "comment", "getComment", "setComment", "contactOrder", "", "getContactOrder", "()Ljava/lang/Integer;", "setContactOrder", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "correspondanceLanguageCode", "getCorrespondanceLanguageCode", "setCorrespondanceLanguageCode", "correspondanceLanguageDescription", "getCorrespondanceLanguageDescription", "setCorrespondanceLanguageDescription", "emailAddress", "getEmailAddress", "setEmailAddress", "employerLocation", "getEmployerLocation", "setEmployerLocation", "employerName", "getEmployerName", "setEmployerName", "firstName", "getFirstName", "setFirstName", "homePhone", "getHomePhone", "setHomePhone", "lastName", "getLastName", "setLastName", "livesWithStudentCode", "getLivesWithStudentCode", "setLivesWithStudentCode", "livesWithStudentDescription", "getLivesWithStudentDescription", "setLivesWithStudentDescription", "mailingName", "getMailingName", "setMailingName", "mailingTagCode", "getMailingTagCode", "setMailingTagCode", "mailingTagDescription", "getMailingTagDescription", "setMailingTagDescription", "middleName", "getMiddleName", "setMiddleName", "militaryBranchCode", "getMilitaryBranchCode", "setMilitaryBranchCode", "militaryBranchDescription", "getMilitaryBranchDescription", "setMilitaryBranchDescription", "militaryRankCode", "getMilitaryRankCode", "setMilitaryRankCode", "militaryRankDescription", "getMilitaryRankDescription", "setMilitaryRankDescription", "militaryStatusCode", "getMilitaryStatusCode", "setMilitaryStatusCode", "militaryStatusDescription", "getMilitaryStatusDescription", "setMilitaryStatusDescription", "militarySupervisorName", "getMilitarySupervisorName", "setMilitarySupervisorName", "militarySupervisorPhone", "getMilitarySupervisorPhone", "setMilitarySupervisorPhone", "nameSuffix", "getNameSuffix", "setNameSuffix", "pager", "getPager", "setPager", "redFlag", "", "getRedFlag", "()Ljava/lang/Boolean;", "setRedFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "relationshipToStudentCode", "getRelationshipToStudentCode", "setRelationshipToStudentCode", "relationshipToStudentDescription", "getRelationshipToStudentDescription", "setRelationshipToStudentDescription", "verificationDate", "getVerificationDate", "setVerificationDate", "workPhone", "getWorkPhone", "setWorkPhone", "workPhoneExt", "getWorkPhoneExt", "setWorkPhoneExt", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Contact.kt */
public final class Contact implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AccessToPortalCode")
    @Nullable
    @Expose
    private String accessToPortalCode;
    @SerializedName("AccessToPortalDescription")
    @Nullable
    @Expose
    private String accessToPortalDescription;
    @SerializedName("AdditionalContactNumber1")
    @Nullable
    @Expose
    private String additionalContactNumber1;
    @SerializedName("AdditionalContactNumber2")
    @Nullable
    @Expose
    private String additionalContactNumber2;
    @SerializedName("AdditionalContactNumber3")
    @Nullable
    @Expose
    private String additionalContactNumber3;
    @SerializedName("AdditionalContactNumber4")
    @Nullable
    @Expose
    private String additionalContactNumber4;
    @SerializedName("AdditionalContactType1Code")
    @Nullable
    @Expose
    private String additionalContactType1Code;
    @SerializedName("AdditionalContactType1Description")
    @Nullable
    @Expose
    private String additionalContactType1Description;
    @SerializedName("AdditionalContactType2Code")
    @Nullable
    @Expose
    private String additionalContactType2Code;
    @SerializedName("AdditionalContactType2Description")
    @Nullable
    @Expose
    private String additionalContactType2Description;
    @SerializedName("AdditionalContactType3Code")
    @Nullable
    @Expose
    private String additionalContactType3Code;
    @SerializedName("AdditionalContactType3Description")
    @Nullable
    @Expose
    private String additionalContactType3Description;
    @SerializedName("AdditionalContactType4Code")
    @Nullable
    @Expose
    private String additionalContactType4Code;
    @SerializedName("AdditionalContactType4Description")
    @Nullable
    @Expose
    private String additionalContactType4Description;
    @SerializedName("Address")
    @Nullable
    @Expose
    private GenericAddress address;
    @SerializedName("CellPhone")
    @Nullable
    @Expose
    private String cellPhone;
    @SerializedName("Code")
    @Nullable
    @Expose
    private String code;
    @SerializedName("CodeDescription")
    @Nullable
    @Expose
    private String codeDescription;
    @SerializedName("Comment")
    @Nullable
    @Expose
    private String comment;
    @SerializedName("ContactOrder")
    @Nullable
    @Expose
    private Integer contactOrder;
    @SerializedName("CorrespondanceLanguageCode")
    @Nullable
    @Expose
    private String correspondanceLanguageCode;
    @SerializedName("CorrespondanceLanguageDescription")
    @Nullable
    @Expose
    private String correspondanceLanguageDescription;
    @SerializedName("EmailAddress")
    @Nullable
    @Expose
    private String emailAddress;
    @SerializedName("EmployerLocation")
    @Nullable
    @Expose
    private String employerLocation;
    @SerializedName("EmployerName")
    @Nullable
    @Expose
    private String employerName;
    @SerializedName("FirstName")
    @Nullable
    @Expose
    private String firstName;
    @SerializedName("HomePhone")
    @Nullable
    @Expose
    private String homePhone;
    @SerializedName("LastName")
    @Nullable
    @Expose
    private String lastName;
    @SerializedName("LivesWithStudentCode")
    @Nullable
    @Expose
    private String livesWithStudentCode;
    @SerializedName("LivesWithStudentDescription")
    @Nullable
    @Expose
    private String livesWithStudentDescription;
    @SerializedName("MailingName")
    @Nullable
    @Expose
    private String mailingName;
    @SerializedName("MailingTagCode")
    @Nullable
    @Expose
    private String mailingTagCode;
    @SerializedName("MailingTagDescription")
    @Nullable
    @Expose
    private String mailingTagDescription;
    @SerializedName("MiddleName")
    @Nullable
    @Expose
    private String middleName;
    @SerializedName("MilitaryBranchCode")
    @Nullable
    @Expose
    private String militaryBranchCode;
    @SerializedName("MilitaryBranchDescription")
    @Nullable
    @Expose
    private String militaryBranchDescription;
    @SerializedName("MilitaryRankCode")
    @Nullable
    @Expose
    private String militaryRankCode;
    @SerializedName("MilitaryRankDescription")
    @Nullable
    @Expose
    private String militaryRankDescription;
    @SerializedName("MilitaryStatusCode")
    @Nullable
    @Expose
    private String militaryStatusCode;
    @SerializedName("MilitaryStatusDescription")
    @Nullable
    @Expose
    private String militaryStatusDescription;
    @SerializedName("MilitarySupervisorName")
    @Nullable
    @Expose
    private String militarySupervisorName;
    @SerializedName("MilitarySupervisorPhone")
    @Nullable
    @Expose
    private String militarySupervisorPhone;
    @SerializedName("NameSuffix")
    @Nullable
    @Expose
    private String nameSuffix;
    @SerializedName("Pager")
    @Nullable
    @Expose
    private String pager;
    @SerializedName("RedFlag")
    @Nullable
    @Expose
    private Boolean redFlag;
    @SerializedName("RelationshipToStudentCode")
    @Nullable
    @Expose
    private String relationshipToStudentCode;
    @SerializedName("RelationshipToStudentDescription")
    @Nullable
    @Expose
    private String relationshipToStudentDescription;
    @SerializedName("VerificationDate")
    @Nullable
    @Expose
    private String verificationDate;
    @SerializedName("WorkPhone")
    @Nullable
    @Expose
    private String workPhone;
    @SerializedName("WorkPhoneExt")
    @Nullable
    @Expose
    private String workPhoneExt;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Contact$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Contact;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Contact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Contact.kt */
    public static final class CREATOR implements Creator<Contact> {
        private CREATOR() {
        }

        @NotNull
        public Contact createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Contact(parcel);
        }

        @NotNull
        public Contact[] newArray(int i) {
            return new Contact[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public Contact() {
        this.mailingName = "";
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.nameSuffix = "";
        this.address = new GenericAddress();
        this.homePhone = "";
        this.comment = "";
        this.code = "";
        this.codeDescription = "";
        this.mailingTagCode = "";
        this.mailingTagDescription = "";
        this.workPhone = "";
        this.workPhoneExt = "";
        this.cellPhone = "";
        this.pager = "";
        this.emailAddress = "";
        this.contactOrder = Integer.valueOf(0);
        this.relationshipToStudentCode = "";
        this.relationshipToStudentDescription = "";
        this.additionalContactType1Code = "";
        this.additionalContactType1Description = "";
        this.additionalContactNumber1 = "";
        this.additionalContactType2Code = "";
        this.additionalContactType2Description = "";
        this.additionalContactNumber2 = "";
        this.additionalContactType3Code = "";
        this.additionalContactType3Description = "";
        this.additionalContactNumber3 = "";
        this.additionalContactType4Code = "";
        this.additionalContactType4Description = "";
        this.additionalContactNumber4 = "";
        this.verificationDate = "";
        this.redFlag = Boolean.valueOf(false);
        this.correspondanceLanguageCode = "";
        this.correspondanceLanguageDescription = "";
        this.employerName = "";
        this.employerLocation = "";
        this.accessToPortalCode = "";
        this.accessToPortalDescription = "";
        this.livesWithStudentCode = "";
        this.livesWithStudentDescription = "";
        this.militaryBranchCode = "";
        this.militaryBranchDescription = "";
        this.militaryRankCode = "";
        this.militaryRankDescription = "";
        this.militaryStatusCode = "";
        this.militaryStatusDescription = "";
        this.militarySupervisorName = "";
        this.militarySupervisorPhone = "";
    }

    @Nullable
    public final String getMailingName() {
        return this.mailingName;
    }

    public final void setMailingName(@Nullable String str) {
        this.mailingName = str;
    }

    @Nullable
    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(@Nullable String str) {
        this.firstName = str;
    }

    @Nullable
    public final String getMiddleName() {
        return this.middleName;
    }

    public final void setMiddleName(@Nullable String str) {
        this.middleName = str;
    }

    @Nullable
    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(@Nullable String str) {
        this.lastName = str;
    }

    @Nullable
    public final String getNameSuffix() {
        return this.nameSuffix;
    }

    public final void setNameSuffix(@Nullable String str) {
        this.nameSuffix = str;
    }

    @Nullable
    public final GenericAddress getAddress() {
        return this.address;
    }

    public final void setAddress(@Nullable GenericAddress genericAddress) {
        this.address = genericAddress;
    }

    @Nullable
    public final String getHomePhone() {
        return this.homePhone;
    }

    public final void setHomePhone(@Nullable String str) {
        this.homePhone = str;
    }

    @Nullable
    public final String getComment() {
        return this.comment;
    }

    public final void setComment(@Nullable String str) {
        this.comment = str;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    @Nullable
    public final String getCodeDescription() {
        return this.codeDescription;
    }

    public final void setCodeDescription(@Nullable String str) {
        this.codeDescription = str;
    }

    @Nullable
    public final String getMailingTagCode() {
        return this.mailingTagCode;
    }

    public final void setMailingTagCode(@Nullable String str) {
        this.mailingTagCode = str;
    }

    @Nullable
    public final String getMailingTagDescription() {
        return this.mailingTagDescription;
    }

    public final void setMailingTagDescription(@Nullable String str) {
        this.mailingTagDescription = str;
    }

    @Nullable
    public final String getWorkPhone() {
        return this.workPhone;
    }

    public final void setWorkPhone(@Nullable String str) {
        this.workPhone = str;
    }

    @Nullable
    public final String getWorkPhoneExt() {
        return this.workPhoneExt;
    }

    public final void setWorkPhoneExt(@Nullable String str) {
        this.workPhoneExt = str;
    }

    @Nullable
    public final String getCellPhone() {
        return this.cellPhone;
    }

    public final void setCellPhone(@Nullable String str) {
        this.cellPhone = str;
    }

    @Nullable
    public final String getPager() {
        return this.pager;
    }

    public final void setPager(@Nullable String str) {
        this.pager = str;
    }

    @Nullable
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final void setEmailAddress(@Nullable String str) {
        this.emailAddress = str;
    }

    @Nullable
    public final Integer getContactOrder() {
        return this.contactOrder;
    }

    public final void setContactOrder(@Nullable Integer num) {
        this.contactOrder = num;
    }

    @Nullable
    public final String getRelationshipToStudentCode() {
        return this.relationshipToStudentCode;
    }

    public final void setRelationshipToStudentCode(@Nullable String str) {
        this.relationshipToStudentCode = str;
    }

    @Nullable
    public final String getRelationshipToStudentDescription() {
        return this.relationshipToStudentDescription;
    }

    public final void setRelationshipToStudentDescription(@Nullable String str) {
        this.relationshipToStudentDescription = str;
    }

    @Nullable
    public final String getAdditionalContactType1Code() {
        return this.additionalContactType1Code;
    }

    public final void setAdditionalContactType1Code(@Nullable String str) {
        this.additionalContactType1Code = str;
    }

    @Nullable
    public final String getAdditionalContactType1Description() {
        return this.additionalContactType1Description;
    }

    public final void setAdditionalContactType1Description(@Nullable String str) {
        this.additionalContactType1Description = str;
    }

    @Nullable
    public final String getAdditionalContactNumber1() {
        return this.additionalContactNumber1;
    }

    public final void setAdditionalContactNumber1(@Nullable String str) {
        this.additionalContactNumber1 = str;
    }

    @Nullable
    public final String getAdditionalContactType2Code() {
        return this.additionalContactType2Code;
    }

    public final void setAdditionalContactType2Code(@Nullable String str) {
        this.additionalContactType2Code = str;
    }

    @Nullable
    public final String getAdditionalContactType2Description() {
        return this.additionalContactType2Description;
    }

    public final void setAdditionalContactType2Description(@Nullable String str) {
        this.additionalContactType2Description = str;
    }

    @Nullable
    public final String getAdditionalContactNumber2() {
        return this.additionalContactNumber2;
    }

    public final void setAdditionalContactNumber2(@Nullable String str) {
        this.additionalContactNumber2 = str;
    }

    @Nullable
    public final String getAdditionalContactType3Code() {
        return this.additionalContactType3Code;
    }

    public final void setAdditionalContactType3Code(@Nullable String str) {
        this.additionalContactType3Code = str;
    }

    @Nullable
    public final String getAdditionalContactType3Description() {
        return this.additionalContactType3Description;
    }

    public final void setAdditionalContactType3Description(@Nullable String str) {
        this.additionalContactType3Description = str;
    }

    @Nullable
    public final String getAdditionalContactNumber3() {
        return this.additionalContactNumber3;
    }

    public final void setAdditionalContactNumber3(@Nullable String str) {
        this.additionalContactNumber3 = str;
    }

    @Nullable
    public final String getAdditionalContactType4Code() {
        return this.additionalContactType4Code;
    }

    public final void setAdditionalContactType4Code(@Nullable String str) {
        this.additionalContactType4Code = str;
    }

    @Nullable
    public final String getAdditionalContactType4Description() {
        return this.additionalContactType4Description;
    }

    public final void setAdditionalContactType4Description(@Nullable String str) {
        this.additionalContactType4Description = str;
    }

    @Nullable
    public final String getAdditionalContactNumber4() {
        return this.additionalContactNumber4;
    }

    public final void setAdditionalContactNumber4(@Nullable String str) {
        this.additionalContactNumber4 = str;
    }

    @Nullable
    public final String getVerificationDate() {
        return this.verificationDate;
    }

    public final void setVerificationDate(@Nullable String str) {
        this.verificationDate = str;
    }

    @Nullable
    public final Boolean getRedFlag() {
        return this.redFlag;
    }

    public final void setRedFlag(@Nullable Boolean bool) {
        this.redFlag = bool;
    }

    @Nullable
    public final String getCorrespondanceLanguageCode() {
        return this.correspondanceLanguageCode;
    }

    public final void setCorrespondanceLanguageCode(@Nullable String str) {
        this.correspondanceLanguageCode = str;
    }

    @Nullable
    public final String getCorrespondanceLanguageDescription() {
        return this.correspondanceLanguageDescription;
    }

    public final void setCorrespondanceLanguageDescription(@Nullable String str) {
        this.correspondanceLanguageDescription = str;
    }

    @Nullable
    public final String getEmployerName() {
        return this.employerName;
    }

    public final void setEmployerName(@Nullable String str) {
        this.employerName = str;
    }

    @Nullable
    public final String getEmployerLocation() {
        return this.employerLocation;
    }

    public final void setEmployerLocation(@Nullable String str) {
        this.employerLocation = str;
    }

    @Nullable
    public final String getAccessToPortalCode() {
        return this.accessToPortalCode;
    }

    public final void setAccessToPortalCode(@Nullable String str) {
        this.accessToPortalCode = str;
    }

    @Nullable
    public final String getAccessToPortalDescription() {
        return this.accessToPortalDescription;
    }

    public final void setAccessToPortalDescription(@Nullable String str) {
        this.accessToPortalDescription = str;
    }

    @Nullable
    public final String getLivesWithStudentCode() {
        return this.livesWithStudentCode;
    }

    public final void setLivesWithStudentCode(@Nullable String str) {
        this.livesWithStudentCode = str;
    }

    @Nullable
    public final String getLivesWithStudentDescription() {
        return this.livesWithStudentDescription;
    }

    public final void setLivesWithStudentDescription(@Nullable String str) {
        this.livesWithStudentDescription = str;
    }

    @Nullable
    public final String getMilitaryBranchCode() {
        return this.militaryBranchCode;
    }

    public final void setMilitaryBranchCode(@Nullable String str) {
        this.militaryBranchCode = str;
    }

    @Nullable
    public final String getMilitaryBranchDescription() {
        return this.militaryBranchDescription;
    }

    public final void setMilitaryBranchDescription(@Nullable String str) {
        this.militaryBranchDescription = str;
    }

    @Nullable
    public final String getMilitaryRankCode() {
        return this.militaryRankCode;
    }

    public final void setMilitaryRankCode(@Nullable String str) {
        this.militaryRankCode = str;
    }

    @Nullable
    public final String getMilitaryRankDescription() {
        return this.militaryRankDescription;
    }

    public final void setMilitaryRankDescription(@Nullable String str) {
        this.militaryRankDescription = str;
    }

    @Nullable
    public final String getMilitaryStatusCode() {
        return this.militaryStatusCode;
    }

    public final void setMilitaryStatusCode(@Nullable String str) {
        this.militaryStatusCode = str;
    }

    @Nullable
    public final String getMilitaryStatusDescription() {
        return this.militaryStatusDescription;
    }

    public final void setMilitaryStatusDescription(@Nullable String str) {
        this.militaryStatusDescription = str;
    }

    @Nullable
    public final String getMilitarySupervisorName() {
        return this.militarySupervisorName;
    }

    public final void setMilitarySupervisorName(@Nullable String str) {
        this.militarySupervisorName = str;
    }

    @Nullable
    public final String getMilitarySupervisorPhone() {
        return this.militarySupervisorPhone;
    }

    public final void setMilitarySupervisorPhone(@Nullable String str) {
        this.militarySupervisorPhone = str;
    }

    public Contact(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        this.mailingName = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.nameSuffix = parcel.readString();
        this.homePhone = parcel.readString();
        this.comment = parcel.readString();
        this.code = parcel.readString();
        this.codeDescription = parcel.readString();
        this.mailingTagCode = parcel.readString();
        this.mailingTagDescription = parcel.readString();
        this.workPhone = parcel.readString();
        this.workPhoneExt = parcel.readString();
        this.cellPhone = parcel.readString();
        this.pager = parcel.readString();
        this.emailAddress = parcel.readString();
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        this.contactOrder = (Integer) readValue;
        this.relationshipToStudentCode = parcel.readString();
        this.relationshipToStudentDescription = parcel.readString();
        this.additionalContactType1Code = parcel.readString();
        this.additionalContactType1Description = parcel.readString();
        this.additionalContactNumber1 = parcel.readString();
        this.additionalContactType2Code = parcel.readString();
        this.additionalContactType2Description = parcel.readString();
        this.additionalContactNumber2 = parcel.readString();
        this.additionalContactType3Code = parcel.readString();
        this.additionalContactType3Description = parcel.readString();
        this.additionalContactNumber3 = parcel.readString();
        this.additionalContactType4Code = parcel.readString();
        this.additionalContactType4Description = parcel.readString();
        this.additionalContactNumber4 = parcel.readString();
        this.verificationDate = parcel.readString();
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        this.redFlag = (Boolean) readValue;
        this.correspondanceLanguageCode = parcel.readString();
        this.correspondanceLanguageDescription = parcel.readString();
        this.employerName = parcel.readString();
        this.employerLocation = parcel.readString();
        this.accessToPortalCode = parcel.readString();
        this.accessToPortalDescription = parcel.readString();
        this.livesWithStudentCode = parcel.readString();
        this.livesWithStudentDescription = parcel.readString();
        this.militaryBranchCode = parcel.readString();
        this.militaryBranchDescription = parcel.readString();
        this.militaryRankCode = parcel.readString();
        this.militaryRankDescription = parcel.readString();
        this.militaryStatusCode = parcel.readString();
        this.militaryStatusDescription = parcel.readString();
        this.militarySupervisorName = parcel.readString();
        this.militarySupervisorPhone = parcel.readString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.mailingName);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.nameSuffix);
        parcel.writeString(this.homePhone);
        parcel.writeString(this.comment);
        parcel.writeString(this.code);
        parcel.writeString(this.codeDescription);
        parcel.writeString(this.mailingTagCode);
        parcel.writeString(this.mailingTagDescription);
        parcel.writeString(this.workPhone);
        parcel.writeString(this.workPhoneExt);
        parcel.writeString(this.cellPhone);
        parcel.writeString(this.pager);
        parcel.writeString(this.emailAddress);
        parcel.writeValue(this.contactOrder);
        parcel.writeString(this.relationshipToStudentCode);
        parcel.writeString(this.relationshipToStudentDescription);
        parcel.writeString(this.additionalContactType1Code);
        parcel.writeString(this.additionalContactType1Description);
        parcel.writeString(this.additionalContactNumber1);
        parcel.writeString(this.additionalContactType2Code);
        parcel.writeString(this.additionalContactType2Description);
        parcel.writeString(this.additionalContactNumber2);
        parcel.writeString(this.additionalContactType3Code);
        parcel.writeString(this.additionalContactType3Description);
        parcel.writeString(this.additionalContactNumber3);
        parcel.writeString(this.additionalContactType4Code);
        parcel.writeString(this.additionalContactType4Description);
        parcel.writeString(this.additionalContactNumber4);
        parcel.writeString(this.verificationDate);
        parcel.writeValue(this.redFlag);
        parcel.writeString(this.correspondanceLanguageCode);
        parcel.writeString(this.correspondanceLanguageDescription);
        parcel.writeString(this.employerName);
        parcel.writeString(this.employerLocation);
        parcel.writeString(this.accessToPortalCode);
        parcel.writeString(this.accessToPortalDescription);
        parcel.writeString(this.livesWithStudentCode);
        parcel.writeString(this.livesWithStudentDescription);
        parcel.writeString(this.militaryBranchCode);
        parcel.writeString(this.militaryBranchDescription);
        parcel.writeString(this.militaryRankCode);
        parcel.writeString(this.militaryRankDescription);
        parcel.writeString(this.militaryStatusCode);
        parcel.writeString(this.militaryStatusDescription);
        parcel.writeString(this.militarySupervisorName);
        parcel.writeString(this.militarySupervisorPhone);
    }
}
