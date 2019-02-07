package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    DefaultCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        createReportRequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        Logger logger = Fabric.getLogger();
        String str = CrashlyticsCore.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending report to: ");
        stringBuilder.append(getUrl());
        logger.mo2301d(str, stringBuilder.toString());
        int code = createReportRequest.code();
        Logger logger2 = Fabric.getLogger();
        String str2 = CrashlyticsCore.TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Create report request ID: ");
        stringBuilder2.append(createReportRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
        logger2.mo2301d(str2, stringBuilder2.toString());
        createReportRequest = Fabric.getLogger();
        str = CrashlyticsCore.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Result was: ");
        stringBuilder.append(code);
        createReportRequest.mo2301d(str, stringBuilder.toString());
        return ResponseParser.parse(code) == null ? true : null;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        httpRequest = httpRequest.header(AbstractSpiCall.HEADER_API_KEY, createReportRequest.apiKey).header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        for (Entry header : createReportRequest.report.getCustomHeaders().entrySet()) {
            httpRequest = httpRequest.header(header);
        }
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        httpRequest.part(IDENTIFIER_PARAM, report.getIdentifier());
        if (report.getFiles().length == 1) {
            Logger logger = Fabric.getLogger();
            String str = CrashlyticsCore.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding single file ");
            stringBuilder.append(report.getFileName());
            stringBuilder.append(" to report ");
            stringBuilder.append(report.getIdentifier());
            logger.mo2301d(str, stringBuilder.toString());
            return httpRequest.part(FILE_PARAM, report.getFileName(), FILE_CONTENT_TYPE, report.getFile());
        }
        File[] files = report.getFiles();
        int i = 0;
        int length = files.length;
        int i2 = 0;
        while (i < length) {
            File file = files[i];
            Logger logger2 = Fabric.getLogger();
            String str2 = CrashlyticsCore.TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Adding file ");
            stringBuilder2.append(file.getName());
            stringBuilder2.append(" to report ");
            stringBuilder2.append(report.getIdentifier());
            logger2.mo2301d(str2, stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(MULTI_FILE_PARAM);
            stringBuilder3.append(i2);
            stringBuilder3.append("]");
            httpRequest.part(stringBuilder3.toString(), file.getName(), FILE_CONTENT_TYPE, file);
            i2++;
            i++;
        }
        return httpRequest;
    }
}
