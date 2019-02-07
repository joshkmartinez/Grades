package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.interactors.attendance.AttendanceInteractor;
import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.interactors.communications.CommunicationsInteractor;
import com.aeries.mobileportal.interactors.contacts.ContactsInteractor;
import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.interactors.grades.AssignmentCategoryInteractor;
import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.interactors.main.MainInteractor;
import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsFragmentInteractor;
import com.aeries.mobileportal.interactors.report_cards.ReportCardsInteractor;
import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.interactors.tablet.MainTabletInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import com.aeries.mobileportal.web_services.services.ContactsService;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import com.aeries.mobileportal.web_services.services.SignalKitService;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J@\u0010\u001f\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J@\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J@\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007JH\u0010+\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J@\u00101\u001a\u0002022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u0002042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J@\u00105\u001a\u0002062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0007J@\u00109\u001a\u00020:2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007JH\u0010=\u001a\u00020>2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J0\u0010?\u001a\u00020@2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J8\u0010C\u001a\u00020D2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010I\u001a\u00020J2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JP\u0010K\u001a\u00020L2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010M\u001a\u00020N2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007JP\u0010O\u001a\u00020P2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007Jx\u0010U\u001a\u00020V2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010W\u001a\u00020X2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010Q\u001a\u00020R2\u0006\u0010[\u001a\u00020\\H\u0007J8\u0010]\u001a\u00020^2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010_\u001a\u00020`2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010a\u001a\u00020b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0007Jh\u0010c\u001a\u00020d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Y\u001a\u00020ZH\u0007J@\u0010i\u001a\u00020j2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0007JH\u0010k\u001a\u00020l2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010a\u001a\u00020b2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020ZH\u0007J(\u0010m\u001a\u00020n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020p2\u0006\u0010Y\u001a\u00020ZH\u0007J\b\u0010q\u001a\u00020rH\u0007J\u0010\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020vH\u0007J0\u0010w\u001a\u00020x2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020y2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010z\u001a\u00020{2\u0006\u0010_\u001a\u00020`H\u0007J\u0010\u0010|\u001a\u00020}2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010~\u001a\u000202\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\"\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u000204H\u0007¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/InteractorModule;", "", "()V", "accountSettingsInteractor", "Lcom/aeries/mobileportal/interactors/AccountSettingsInteractor;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "addDistrictInteractor", "Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "servicesProvider", "Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "assignmentCategoryInteractor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "assignmentParentInteractor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentParentInteractor;", "assignmentsInteractor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentsInteractor;", "attendanceInteractor", "Lcom/aeries/mobileportal/interactors/attendance/AttendanceInteractor;", "attendanceService", "Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "authErrorInteractor", "Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;", "changeDistrictInteractor", "Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;", "changePasswordInteractor", "Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordInteractor;", "passwordService", "Lcom/aeries/mobileportal/web_services/services/PasswordService;", "accountManager", "Landroid/accounts/AccountManager;", "classCheckInInteractor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "communicationsInteractor", "Lcom/aeries/mobileportal/interactors/communications/CommunicationsInteractor;", "signalKitService", "Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "contactsInteractor", "Lcom/aeries/mobileportal/interactors/contacts/ContactsInteractor;", "contactsService", "Lcom/aeries/mobileportal/web_services/services/ContactsService;", "coursesInteractor", "Lcom/aeries/mobileportal/interactors/grades/CoursesInteractor;", "createAccountInteractor", "Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;", "createAccountService", "Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "demographicsInteractor", "Lcom/aeries/mobileportal/interactors/demographics/DemographicsInteractor;", "feedbackInteractor", "Lcom/aeries/mobileportal/interactors/feedback/FeedbackInteractor;", "feedbackService", "Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "forgotPasswordInteractor", "Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;", "gradesInteractor", "Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;", "whatIfService", "Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "linkStudentInteractor", "Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "linkStudentService", "Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "loginInteractor", "Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "loginService", "Lcom/aeries/mobileportal/web_services/services/LoginService;", "context", "Landroid/content/Context;", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "mainFragmentInteractor", "Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;", "notificationsRepo", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "mainInteractor", "Lcom/aeries/mobileportal/interactors/main/MainInteractor;", "restrictionRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "restrictionService", "Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "mainTabletInteractor", "Lcom/aeries/mobileportal/interactors/tablet/MainTabletInteractor;", "notificationsInteractor", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;", "reportCardsFragmentInteractor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsFragmentInteractor;", "reportCardService", "Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "reportCardsInteractor", "Lcom/aeries/mobileportal/interactors/report_cards/ReportCardsInteractor;", "schoolSearchFragmentInteractor", "Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;", "schoolSearchService", "Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;", "schoolSearchInteractor", "Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;", "Lcom/aeries/mobileportal/web_services/services/ApplicationStartupService;", "settingsInteractor", "Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;", "splashScreenInteractor", "Lcom/aeries/mobileportal/interactors/splashscreen/SplashScreenInteractor;", "studentSelectInteractor", "Lcom/aeries/mobileportal/interactors/StudentSelectInteractor;", "supplementalAttendanceInteractor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: InteractorModule.kt */
public final class InteractorModule {
    @NotNull
    @ActivityScope
    @Provides
    public final SplashScreenInteractor splashScreenInteractor(@NotNull AnalyticsService analyticsService) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        return new SplashScreenInteractor(analyticsService);
    }

    @NotNull
    @Provides
    public final LoginInteractor loginInteractor(@NotNull AnalyticsService analyticsService, @NotNull LoginService loginService, @NotNull ApplicationService applicationService, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull NetworkRepo networkRepo, @NotNull ServicesProvider servicesProvider, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull AccountManager accountManager, @NotNull Context context, @NotNull GoogleSignInClient googleSignInClient, @NotNull GoogleApiClient googleApiClient) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        LoginService loginService2 = loginService;
        Intrinsics.checkParameterIsNotNull(loginService2, "loginService");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        TokenRepository tokenRepository2 = tokenRepository;
        Intrinsics.checkParameterIsNotNull(tokenRepository2, "tokenRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        NetworkRepo networkRepo2 = networkRepo;
        Intrinsics.checkParameterIsNotNull(networkRepo2, "networkRepository");
        ServicesProvider servicesProvider2 = servicesProvider;
        Intrinsics.checkParameterIsNotNull(servicesProvider2, "servicesProvider");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        AccountManager accountManager2 = accountManager;
        Intrinsics.checkParameterIsNotNull(accountManager2, "accountManager");
        Context context2 = context;
        Intrinsics.checkParameterIsNotNull(context2, "context");
        GoogleSignInClient googleSignInClient2 = googleSignInClient;
        Intrinsics.checkParameterIsNotNull(googleSignInClient2, "googleSignInClient");
        GoogleApiClient googleApiClient2 = googleApiClient;
        Intrinsics.checkParameterIsNotNull(googleApiClient2, "googleApiClient");
        return new LoginInteractor(analyticsService2, loginService2, applicationService2, userRepository2, tokenRepository2, configurationRepository2, networkRepo2, servicesProvider2, studentRepo2, schoolRepo2, accountManager2, context2, googleSignInClient2, googleApiClient2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CreateAccountInteractor createAccountInteractor(@NotNull AnalyticsService analyticsService, @NotNull CreateAccountService createAccountService, @NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo, @NotNull UserRepository userRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(createAccountService, "createAccountService");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        return new CreateAccountInteractor(analyticsService, createAccountService, configurationRepository, schoolRepo, userRepository);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ForgotPasswordInteractor forgotPasswordInteractor(@NotNull AnalyticsService analyticsService, @NotNull PasswordService passwordService, @NotNull SchoolRepo schoolRepo, @NotNull ConfigurationRepository configurationRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(passwordService, "passwordService");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        return new ForgotPasswordInteractor(analyticsService, passwordService, schoolRepo, configurationRepository);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AuthErrorInteractor authErrorInteractor(@NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        return new AuthErrorInteractor(tokenRepository);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final GradesInteractor gradesInteractor(@NotNull AnalyticsService analyticsService, @NotNull GradesService gradesService, @NotNull ApplicationService applicationService, @NotNull WhatIfService whatIfService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull TokenProvider tokenProvider) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        GradesService gradesService2 = gradesService;
        Intrinsics.checkParameterIsNotNull(gradesService2, "gradesService");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        WhatIfService whatIfService2 = whatIfService;
        Intrinsics.checkParameterIsNotNull(whatIfService2, "whatIfService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        return new GradesInteractor(analyticsService2, gradesService2, applicationService2, whatIfService2, userRepository2, configurationRepository2, studentRepo2, schoolRepo2, tokenProvider2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ContactsInteractor contactsInteractor(@NotNull AnalyticsService analyticsService, @NotNull ContactsService contactsService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull TokenProvider tokenProvider) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        ContactsService contactsService2 = contactsService;
        Intrinsics.checkParameterIsNotNull(contactsService2, "contactsService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        return new ContactsInteractor(analyticsService2, contactsService2, userRepository2, configurationRepository2, studentRepo2, schoolRepo2, tokenProvider2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final DemographicsInteractor demographicsInteractor(@NotNull AnalyticsService analyticsService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull NetworkRepo networkRepo, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        return new DemographicsInteractor(analyticsService, userRepository, configurationRepository, networkRepo, studentRepo, schoolRepo);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CommunicationsInteractor communicationsInteractor(@NotNull AnalyticsService analyticsService, @NotNull SignalKitService signalKitService, @NotNull TokenProvider tokenProvider, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        SignalKitService signalKitService2 = signalKitService;
        Intrinsics.checkParameterIsNotNull(signalKitService2, "signalKitService");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        return new CommunicationsInteractor(analyticsService2, signalKitService2, tokenProvider2, userRepository2, configurationRepository2, studentRepo2, schoolRepo2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AttendanceInteractor attendanceInteractor(@NotNull AnalyticsService analyticsService, @NotNull AttendanceService attendanceService, @NotNull TokenProvider tokenProvider, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        AttendanceService attendanceService2 = attendanceService;
        Intrinsics.checkParameterIsNotNull(attendanceService2, "attendanceService");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        return new AttendanceInteractor(analyticsService2, attendanceService2, tokenProvider2, userRepository2, configurationRepository2, studentRepo2, schoolRepo2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SchoolSearchInteractor schoolSearchInteractor(@NotNull AnalyticsService analyticsService, @NotNull ApplicationStartupService applicationStartupService, @NotNull SchoolRepo schoolRepo, @NotNull NetworkRepo networkRepo, @NotNull ConfigurationRepository configurationRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(applicationStartupService, "applicationService");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        return new SchoolSearchInteractor(analyticsService, applicationStartupService, schoolRepo, networkRepo, configurationRepository);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final MainInteractor mainInteractor(@NotNull AnalyticsService analyticsService, @NotNull ApplicationService applicationService, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull NotificationsRepo notificationsRepo, @NotNull ConfigurationRepository configurationRepository, @NotNull UserRepository userRepository, @NotNull RestrictionRepository restrictionRepository, @NotNull RestrictionService restrictionService, @NotNull TokenProvider tokenProvider, @NotNull GoogleSignInClient googleSignInClient, @NotNull Context context) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        NotificationsRepo notificationsRepo2 = notificationsRepo;
        Intrinsics.checkParameterIsNotNull(notificationsRepo2, "notificationsRepo");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        RestrictionRepository restrictionRepository2 = restrictionRepository;
        Intrinsics.checkParameterIsNotNull(restrictionRepository2, "restrictionRepository");
        RestrictionService restrictionService2 = restrictionService;
        Intrinsics.checkParameterIsNotNull(restrictionService2, "restrictionService");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        GoogleSignInClient googleSignInClient2 = googleSignInClient;
        Intrinsics.checkParameterIsNotNull(googleSignInClient2, "googleSignInClient");
        Context context2 = context;
        Intrinsics.checkParameterIsNotNull(context2, "context");
        return new MainInteractor(analyticsService2, applicationService2, studentRepo2, schoolRepo2, notificationsRepo2, configurationRepository2, userRepository2, restrictionRepository2, restrictionService2, tokenProvider2, googleSignInClient2, context2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangePasswordInteractor changePasswordInteractor(@NotNull AnalyticsService analyticsService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenProvider tokenProvider, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull PasswordService passwordService, @NotNull AccountManager accountManager) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        PasswordService passwordService2 = passwordService;
        Intrinsics.checkParameterIsNotNull(passwordService2, "passwordService");
        AccountManager accountManager2 = accountManager;
        Intrinsics.checkParameterIsNotNull(accountManager2, "accountManager");
        return new ChangePasswordInteractor(analyticsService2, userRepository2, configurationRepository2, tokenProvider2, schoolRepo2, studentRepo2, passwordService2, accountManager2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final LinkStudentInteractor linkStudentInteractor(@NotNull AnalyticsService analyticsService, @NotNull UserRepository userRepository, @NotNull TokenProvider tokenProvider, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull GoogleSignInClient googleSignInClient, @NotNull LinkStudentService linkStudentService, @NotNull ApplicationService applicationService) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        GoogleSignInClient googleSignInClient2 = googleSignInClient;
        Intrinsics.checkParameterIsNotNull(googleSignInClient2, "googleSignInClient");
        LinkStudentService linkStudentService2 = linkStudentService;
        Intrinsics.checkParameterIsNotNull(linkStudentService2, "linkStudentService");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        return new LinkStudentInteractor(analyticsService2, userRepository2, tokenProvider2, configurationRepository2, studentRepo2, schoolRepo2, googleSignInClient2, linkStudentService2, applicationService2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SupplementalAttendanceInteractor supplementalAttendanceInteractor(@NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull SupplementalAttendanceService supplementalAttendanceService) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceService, "supplementalAttendanceService");
        return new SupplementalAttendanceInteractor(tokenRepository, configurationRepository, supplementalAttendanceService);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AddDistrictInteractor addDistrictInteractor(@NotNull AnalyticsService analyticsService, @NotNull NetworkRepo networkRepo, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenRepository tokenRepository, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull ApplicationService applicationService, @NotNull ServicesProvider servicesProvider) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        NetworkRepo networkRepo2 = networkRepo;
        Intrinsics.checkParameterIsNotNull(networkRepo2, "networkRepository");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        TokenRepository tokenRepository2 = tokenRepository;
        Intrinsics.checkParameterIsNotNull(tokenRepository2, "tokenRepository");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        ServicesProvider servicesProvider2 = servicesProvider;
        Intrinsics.checkParameterIsNotNull(servicesProvider2, "servicesProvider");
        return new AddDistrictInteractor(analyticsService2, networkRepo2, userRepository2, configurationRepository2, tokenRepository2, schoolRepo2, studentRepo2, applicationService2, servicesProvider2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangeDistrictInteractor changeDistrictInteractor(@NotNull NetworkRepo networkRepo, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull ApplicationService applicationService) {
        NetworkRepo networkRepo2 = networkRepo;
        Intrinsics.checkParameterIsNotNull(networkRepo2, "networkRepository");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        TokenRepository tokenRepository2 = tokenRepository;
        Intrinsics.checkParameterIsNotNull(tokenRepository2, "tokenRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        return new ChangeDistrictInteractor(networkRepo2, userRepository2, tokenRepository2, configurationRepository2, schoolRepo2, studentRepo2, applicationService2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final FeedbackInteractor feedbackInteractor(@NotNull FeedbackService feedbackService, @NotNull UserRepository userRepository) {
        Intrinsics.checkParameterIsNotNull(feedbackService, "feedbackService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        return new FeedbackInteractor(feedbackService, userRepository);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ClassCheckInInteractor classCheckInInteractor(@NotNull AnalyticsService analyticsService, @NotNull SupplementalAttendanceService supplementalAttendanceService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull TokenProvider tokenProvider) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        SupplementalAttendanceService supplementalAttendanceService2 = supplementalAttendanceService;
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceService2, "supplementalAttendanceService");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        return new ClassCheckInInteractor(analyticsService2, supplementalAttendanceService2, userRepository2, configurationRepository2, studentRepo2, schoolRepo2, tokenProvider2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final MainTabletInteractor mainTabletInteractor(@NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenRepository tokenRepository, @NotNull ApplicationService applicationService, @NotNull GradesService gradesService) {
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        TokenRepository tokenRepository2 = tokenRepository;
        Intrinsics.checkParameterIsNotNull(tokenRepository2, "tokenRepository");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        GradesService gradesService2 = gradesService;
        Intrinsics.checkParameterIsNotNull(gradesService2, "gradesService");
        return new MainTabletInteractor(studentRepo2, schoolRepo2, userRepository2, configurationRepository2, tokenRepository2, applicationService2, gradesService2);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final CoursesInteractor coursesInteractor(@NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenProvider tokenProvider, @NotNull ApplicationService applicationService, @NotNull AnalyticsService analyticsService, @NotNull GradesService gradesService) {
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        GradesService gradesService2 = gradesService;
        Intrinsics.checkParameterIsNotNull(gradesService2, "gradesService");
        return new CoursesInteractor(schoolRepo2, studentRepo2, userRepository2, configurationRepository2, tokenProvider2, applicationService2, analyticsService2, gradesService2);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentsInteractor assignmentsInteractor(@NotNull GradesService gradesService, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(gradesService, "gradesService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        return new AssignmentsInteractor(gradesService, tokenProvider);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentCategoryInteractor assignmentCategoryInteractor(@NotNull GradesService gradesService, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(gradesService, "gradesService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        return new AssignmentCategoryInteractor(gradesService, tokenProvider);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentParentInteractor assignmentParentInteractor(@NotNull AnalyticsService analyticsService, @NotNull GradesService gradesService, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull ConfigurationRepository configurationRepository, @NotNull UserRepository userRepository, @NotNull TokenProvider tokenProvider) {
        AnalyticsService analyticsService2 = analyticsService;
        Intrinsics.checkParameterIsNotNull(analyticsService2, "analyticsService");
        GradesService gradesService2 = gradesService;
        Intrinsics.checkParameterIsNotNull(gradesService2, "gradesService");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        StudentRepo studentRepo2 = studentRepo;
        Intrinsics.checkParameterIsNotNull(studentRepo2, "studentRepo");
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        return new AssignmentParentInteractor(analyticsService2, gradesService2, schoolRepo2, studentRepo2, configurationRepository2, userRepository2, tokenProvider2);
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ReportCardsInteractor reportCardsInteractor() {
        return new ReportCardsInteractor();
    }

    @NotNull
    @FragmentScope
    @Provides
    public final ReportCardsFragmentInteractor reportCardsFragmentInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull TokenProvider tokenProvider, @NotNull ReportCardService reportCardService, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(reportCardService, "reportCardService");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new ReportCardsFragmentInteractor(configurationRepository, tokenProvider, reportCardService, context);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final NotificationsInteractor notificationsInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull UserRepository userRepository, @NotNull SchoolRepo schoolRepo, @NotNull NotificationService notificationService, @NotNull NotificationsRepo notificationsRepo, @NotNull ApplicationService applicationService, @NotNull TokenProvider tokenProvider, @NotNull Context context) {
        ConfigurationRepository configurationRepository2 = configurationRepository;
        Intrinsics.checkParameterIsNotNull(configurationRepository2, "configurationRepository");
        UserRepository userRepository2 = userRepository;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        SchoolRepo schoolRepo2 = schoolRepo;
        Intrinsics.checkParameterIsNotNull(schoolRepo2, "schoolRepo");
        NotificationService notificationService2 = notificationService;
        Intrinsics.checkParameterIsNotNull(notificationService2, "notificationService");
        NotificationsRepo notificationsRepo2 = notificationsRepo;
        Intrinsics.checkParameterIsNotNull(notificationsRepo2, "notificationsRepo");
        ApplicationService applicationService2 = applicationService;
        Intrinsics.checkParameterIsNotNull(applicationService2, "applicationService");
        TokenProvider tokenProvider2 = tokenProvider;
        Intrinsics.checkParameterIsNotNull(tokenProvider2, "tokenProvider");
        Context context2 = context;
        Intrinsics.checkParameterIsNotNull(context2, "context");
        return new NotificationsInteractor(configurationRepository2, userRepository2, schoolRepo2, notificationService2, notificationsRepo2, applicationService2, tokenProvider2, context2);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final MainFragmentInteractor mainFragmentInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull NotificationsRepo notificationsRepo, @NotNull UserRepository userRepository, @NotNull NotificationService notificationService, @NotNull ApplicationService applicationService, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(notificationService, "notificationService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        return new MainFragmentInteractor(configurationRepository, notificationsRepo, userRepository, notificationService, applicationService, tokenProvider);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SettingsInteractor settingsInteractor(@NotNull NotificationsRepo notificationsRepo) {
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        return new SettingsInteractor(notificationsRepo);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SchoolSearchFragmentInteractor schoolSearchFragmentInteractor(@NotNull SchoolSearchService schoolSearchService) {
        Intrinsics.checkParameterIsNotNull(schoolSearchService, "schoolSearchService");
        return new SchoolSearchFragmentInteractor(schoolSearchService);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final StudentSelectInteractor studentSelectInteractor(@NotNull StudentRepo studentRepo) {
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        return new StudentSelectInteractor(studentRepo);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AccountSettingsInteractor accountSettingsInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        return new AccountSettingsInteractor(configurationRepository, schoolRepo);
    }
}
