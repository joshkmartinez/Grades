package com.google.android.gms.internal.auth;

public enum zzbr {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN("Unknown"),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    NEED_PERMISSION("NeedPermission"),
    NEED_REMOTE_CONSENT("NeedRemoteConsent"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_SCREENLOCK_REQUIRED("DeviceManagementScreenlockRequired"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String zzho;

    private zzbr(String str) {
        this.zzho = str;
    }

    public static boolean zzd(zzbr com_google_android_gms_internal_auth_zzbr) {
        if (!(BAD_AUTHENTICATION.equals(com_google_android_gms_internal_auth_zzbr) || CAPTCHA.equals(com_google_android_gms_internal_auth_zzbr) || NEED_PERMISSION.equals(com_google_android_gms_internal_auth_zzbr) || NEED_REMOTE_CONSENT.equals(com_google_android_gms_internal_auth_zzbr) || NEEDS_BROWSER.equals(com_google_android_gms_internal_auth_zzbr) || USER_CANCEL.equals(com_google_android_gms_internal_auth_zzbr) || DEVICE_MANAGEMENT_REQUIRED.equals(com_google_android_gms_internal_auth_zzbr) || DM_INTERNAL_ERROR.equals(com_google_android_gms_internal_auth_zzbr) || DM_SYNC_DISABLED.equals(com_google_android_gms_internal_auth_zzbr) || DM_ADMIN_BLOCKED.equals(com_google_android_gms_internal_auth_zzbr) || DM_ADMIN_PENDING_APPROVAL.equals(com_google_android_gms_internal_auth_zzbr) || DM_STALE_SYNC_REQUIRED.equals(com_google_android_gms_internal_auth_zzbr) || DM_DEACTIVATED.equals(com_google_android_gms_internal_auth_zzbr) || DM_REQUIRED.equals(com_google_android_gms_internal_auth_zzbr) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(com_google_android_gms_internal_auth_zzbr))) {
            if (!DM_SCREENLOCK_REQUIRED.equals(com_google_android_gms_internal_auth_zzbr)) {
                return false;
            }
        }
        return true;
    }

    public static final zzbr zzh(String str) {
        zzbr com_google_android_gms_internal_auth_zzbr = null;
        for (zzbr com_google_android_gms_internal_auth_zzbr2 : values()) {
            if (com_google_android_gms_internal_auth_zzbr2.zzho.equals(str)) {
                com_google_android_gms_internal_auth_zzbr = com_google_android_gms_internal_auth_zzbr2;
            }
        }
        return com_google_android_gms_internal_auth_zzbr;
    }
}
