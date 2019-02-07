package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import okio.Okio;

class AssetRequestHandler extends RequestHandler {
    protected static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    private AssetManager assetManager;
    private final Context context;
    private final Object lock = new Object();

    AssetRequestHandler(Context context) {
        this.context = context;
    }

    public boolean canHandleRequest(Request request) {
        request = request.uri;
        if (!"file".equals(request.getScheme()) || request.getPathSegments().isEmpty() || ANDROID_ASSET.equals(request.getPathSegments().get(0)) == null) {
            return false;
        }
        return true;
    }

    public Result load(Request request, int i) throws IOException {
        if (this.assetManager == 0) {
            synchronized (this.lock) {
                if (this.assetManager == null) {
                    this.assetManager = this.context.getAssets();
                }
            }
        }
        return new Result(Okio.source(this.assetManager.open(getFilePath(request))), LoadedFrom.DISK);
    }

    static String getFilePath(Request request) {
        return request.uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
