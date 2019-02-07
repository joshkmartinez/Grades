package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Request;
import okhttp3.ResponseBody;

class NetworkRequestHandler extends RequestHandler {
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private final Downloader downloader;
    private final Stats stats;

    static class ContentLengthException extends IOException {
        ContentLengthException(String str) {
            super(str);
        }
    }

    static final class ResponseException extends IOException {
        final int code;
        final int networkPolicy;

        ResponseException(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP ");
            stringBuilder.append(i);
            super(stringBuilder.toString());
            this.code = i;
            this.networkPolicy = i2;
        }
    }

    int getRetryCount() {
        return 2;
    }

    boolean supportsReplay() {
        return true;
    }

    NetworkRequestHandler(Downloader downloader, Stats stats) {
        this.downloader = downloader;
        this.stats = stats;
    }

    public boolean canHandleRequest(Request request) {
        request = request.uri.getScheme();
        if (!SCHEME_HTTP.equals(request)) {
            if (SCHEME_HTTPS.equals(request) == null) {
                return null;
            }
        }
        return true;
    }

    public Result load(Request request, int i) throws IOException {
        i = this.downloader.load(createRequest(request, i));
        ResponseBody body = i.body();
        if (i.isSuccessful()) {
            LoadedFrom loadedFrom = i.cacheResponse() == null ? LoadedFrom.NETWORK : LoadedFrom.DISK;
            if (loadedFrom == LoadedFrom.DISK) {
                if (body.contentLength() == 0) {
                    body.close();
                    throw new ContentLengthException("Received response with 0 content-length header.");
                }
            }
            if (loadedFrom == LoadedFrom.NETWORK && body.contentLength() > 0) {
                this.stats.dispatchDownloadFinished(body.contentLength());
            }
            return new Result(body.source(), loadedFrom);
        }
        body.close();
        throw new ResponseException(i.code(), request.networkPolicy);
    }

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (!networkInfo.isConnected()) {
                return false;
            }
        }
        return true;
    }

    private static Request createRequest(Request request, int i) {
        if (i == 0) {
            i = 0;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            i = CacheControl.FORCE_CACHE;
        } else {
            Builder builder = new Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (NetworkPolicy.shouldWriteToDiskCache(i) == 0) {
                builder.noStore();
            }
            i = builder.build();
        }
        request = new Request.Builder().url(request.uri.toString());
        if (i != 0) {
            request.cacheControl(i);
        }
        return request.build();
    }
}
