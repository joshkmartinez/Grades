package com.crashlytics.android.core;

import android.content.Context;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.io.IOException;
import org.jetbrains.anko.DimensionsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BinaryImagesConverter {
    private static final String DATA_DIR = "/data";
    private final Context context;
    private final FileIdStrategy fileIdStrategy;

    interface FileIdStrategy {
        String createId(File file) throws IOException;
    }

    BinaryImagesConverter(Context context, FileIdStrategy fileIdStrategy) {
        this.context = context;
        this.fileIdStrategy = fileIdStrategy;
    }

    byte[] convert(String str) throws IOException {
        return generateBinaryImagesJsonString(parseProcMapsJson(str));
    }

    private JSONArray parseProcMapsJson(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            str = joinMapsEntries(new JSONObject(str).getJSONArray("maps")).split("\\|");
            for (String parse : str) {
                ProcMapEntry parse2 = ProcMapEntryParser.parse(parse);
                if (parse2 != null) {
                    if (isRelevant(parse2)) {
                        try {
                            try {
                                jSONArray.put(createBinaryImageJson(this.fileIdStrategy.createId(getLibraryFile(parse2.path)), parse2));
                            } catch (Throwable e) {
                                Fabric.getLogger().mo2302d(CrashlyticsCore.TAG, "Could not create a binary image json string", e);
                            }
                        } catch (Throwable e2) {
                            Logger logger = Fabric.getLogger();
                            String str2 = CrashlyticsCore.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Could not generate ID for file ");
                            stringBuilder.append(parse2.path);
                            logger.mo2302d(str2, stringBuilder.toString(), e2);
                        }
                    }
                }
            }
            return jSONArray;
        } catch (String str3) {
            Fabric.getLogger().mo2315w(CrashlyticsCore.TAG, "Unable to parse proc maps string", str3);
            return jSONArray;
        }
    }

    private File getLibraryFile(String str) {
        File file = new File(str);
        return file.exists() == null ? correctDataPath(file) : file;
    }

    private File correctDataPath(File file) {
        if (VERSION.SDK_INT < 9) {
            return file;
        }
        if (file.getAbsolutePath().startsWith(DATA_DIR)) {
            try {
                file = new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, file.getName());
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(CrashlyticsCore.TAG, "Error getting ApplicationInfo", e);
            }
        }
        return file;
    }

    private static byte[] generateBinaryImagesJsonString(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONArray jSONArray2) {
            Fabric.getLogger().mo2315w(CrashlyticsCore.TAG, "Binary images string is null", jSONArray2);
            return new byte[null];
        }
    }

    private static JSONObject createBinaryImageJson(String str, ProcMapEntry procMapEntry) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", procMapEntry.address);
        jSONObject.put("size", procMapEntry.size);
        jSONObject.put("name", procMapEntry.path);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static String joinMapsEntries(JSONArray jSONArray) throws JSONException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            stringBuilder.append(jSONArray.getString(i));
        }
        return stringBuilder.toString();
    }

    private static boolean isRelevant(ProcMapEntry procMapEntry) {
        return (procMapEntry.perms.indexOf(DimensionsKt.LDPI) == -1 || procMapEntry.path.indexOf(47) == -1) ? null : true;
    }
}
