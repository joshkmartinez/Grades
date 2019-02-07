package com.crashlytics.android.beta;

import android.support.media.ExifInterface;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class CheckForUpdatesRequest extends AbstractSpiCall {
    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    static final String INSTANCE = "instance";
    static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    static String createBetaTokenHeaderValueFor(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("3:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public CheckForUpdatesRequest(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    public CheckForUpdatesResponse invoke(String str, String str2, BuildProperties buildProperties) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        String str3;
        StringBuilder stringBuilder3;
        try {
            buildProperties = getQueryParamsFor(buildProperties);
            HttpRequest httpRequest = getHttpRequest(buildProperties);
            try {
                str = applyHeadersTo(httpRequest, str, str2);
                try {
                    str2 = Fabric.getLogger();
                    str3 = Beta.TAG;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Checking for updates from ");
                    stringBuilder3.append(getUrl());
                    str2.mo2301d(str3, stringBuilder3.toString());
                    str2 = Fabric.getLogger();
                    str3 = Beta.TAG;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Checking for updates query params are: ");
                    stringBuilder3.append(buildProperties);
                    str2.mo2301d(str3, stringBuilder3.toString());
                    if (str.ok() != null) {
                        Fabric.getLogger().mo2301d(Beta.TAG, "Checking for updates was successful");
                        str2 = this.responseTransform.fromJson(new JSONObject(str.body()));
                        if (str != null) {
                            str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                            buildProperties = Fabric.getLogger();
                            String str4 = Fabric.TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Checking for updates request ID: ");
                            stringBuilder.append(str);
                            buildProperties.mo2301d(str4, stringBuilder.toString());
                        }
                        return str2;
                    }
                    str2 = Fabric.getLogger();
                    buildProperties = Beta.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Checking for updates failed. Response code: ");
                    stringBuilder.append(str.code());
                    str2.mo2303e(buildProperties, stringBuilder.toString());
                    if (str != null) {
                        str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                        str2 = Fabric.getLogger();
                        buildProperties = Fabric.TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Checking for updates request ID: ");
                        stringBuilder.append(str);
                        str2.mo2301d(buildProperties, stringBuilder.toString());
                    }
                    return null;
                } catch (Exception e) {
                    str2 = e;
                    try {
                        buildProperties = Fabric.getLogger();
                        str3 = Beta.TAG;
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Error while checking for updates from ");
                        stringBuilder3.append(getUrl());
                        buildProperties.mo2304e(str3, stringBuilder3.toString(), str2);
                        if (str != null) {
                            str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                            str2 = Fabric.getLogger();
                            buildProperties = Fabric.TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Checking for updates request ID: ");
                            stringBuilder.append(str);
                            str2.mo2301d(buildProperties, stringBuilder.toString());
                        }
                        return null;
                    } catch (Throwable th) {
                        str2 = th;
                        if (str != null) {
                            str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                            buildProperties = Fabric.getLogger();
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Checking for updates request ID: ");
                            stringBuilder2.append(str);
                            buildProperties.mo2301d(Fabric.TAG, stringBuilder2.toString());
                        }
                        throw str2;
                    }
                }
            } catch (Exception e2) {
                str2 = e2;
                str = httpRequest;
                buildProperties = Fabric.getLogger();
                str3 = Beta.TAG;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Error while checking for updates from ");
                stringBuilder3.append(getUrl());
                buildProperties.mo2304e(str3, stringBuilder3.toString(), str2);
                if (str != null) {
                    str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                    str2 = Fabric.getLogger();
                    buildProperties = Fabric.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Checking for updates request ID: ");
                    stringBuilder.append(str);
                    str2.mo2301d(buildProperties, stringBuilder.toString());
                }
                return null;
            } catch (Throwable th2) {
                str2 = th2;
                str = httpRequest;
                if (str != null) {
                    str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                    buildProperties = Fabric.getLogger();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Checking for updates request ID: ");
                    stringBuilder2.append(str);
                    buildProperties.mo2301d(Fabric.TAG, stringBuilder2.toString());
                }
                throw str2;
            }
        } catch (Exception e3) {
            str2 = e3;
            str = null;
            buildProperties = Fabric.getLogger();
            str3 = Beta.TAG;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Error while checking for updates from ");
            stringBuilder3.append(getUrl());
            buildProperties.mo2304e(str3, stringBuilder3.toString(), str2);
            if (str != null) {
                str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                str2 = Fabric.getLogger();
                buildProperties = Fabric.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Checking for updates request ID: ");
                stringBuilder.append(str);
                str2.mo2301d(buildProperties, stringBuilder.toString());
            }
            return null;
        } catch (Throwable th3) {
            str2 = th3;
            str = null;
            if (str != null) {
                str = str.header(AbstractSpiCall.HEADER_REQUEST_ID);
                buildProperties = Fabric.getLogger();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Checking for updates request ID: ");
                stringBuilder2.append(str);
                buildProperties.mo2301d(Fabric.TAG, stringBuilder2.toString());
            }
            throw str2;
        }
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AbstractSpiCall.CRASHLYTICS_USER_AGENT);
        stringBuilder.append(this.kit.getVersion());
        return httpRequest.header("Accept", "application/json").header("User-Agent", stringBuilder.toString()).header(AbstractSpiCall.HEADER_DEVELOPER_TOKEN, "470fa2b4ae81cd56ecbcda9735803434cec591fa").header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion()).header(AbstractSpiCall.HEADER_API_KEY, str).header(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(BUILD_VERSION, buildProperties.versionCode);
        hashMap.put(DISPLAY_VERSION, buildProperties.versionName);
        hashMap.put(INSTANCE, buildProperties.buildId);
        hashMap.put("source", ExifInterface.GPS_MEASUREMENT_3D);
        return hashMap;
    }
}
