package okhttp3.logging;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new C10831();

        class C10831 implements Logger {
            C10831() {
            }

            public void log(String str) {
                Platform.get().log(4, str, null);
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level != null) {
            this.level = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.level;
    }

    public Response intercept(Chain chain) throws IOException {
        Chain chain2 = chain;
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain2.proceed(request);
        }
        Object obj;
        RequestBody body;
        Connection connection;
        Object protocol;
        StringBuilder stringBuilder;
        String stringBuilder2;
        Logger logger;
        StringBuilder stringBuilder3;
        Headers headers;
        int size;
        int i;
        String name;
        StringBuilder stringBuilder4;
        Buffer buffer;
        Charset charset;
        MediaType contentType;
        Logger logger2;
        StringBuilder stringBuilder5;
        long nanoTime;
        Response proceed;
        ResponseBody body2;
        long contentLength;
        String stringBuilder6;
        String stringBuilder7;
        Headers headers2;
        int size2;
        int i2;
        Buffer buffer2;
        Charset charset2;
        MediaType contentType2;
        Logger logger3;
        StringBuilder stringBuilder8;
        Object obj2 = 1;
        Object obj3 = level == Level.BODY ? 1 : null;
        if (obj3 == null) {
            if (level != Level.HEADERS) {
                obj = null;
                body = request.body();
                if (body != null) {
                    obj2 = null;
                }
                connection = chain.connection();
                protocol = connection == null ? connection.protocol() : Protocol.HTTP_1_1;
                stringBuilder = new StringBuilder();
                stringBuilder.append("--> ");
                stringBuilder.append(request.method());
                stringBuilder.append(' ');
                stringBuilder.append(request.url());
                stringBuilder.append(' ');
                stringBuilder.append(protocol);
                stringBuilder2 = stringBuilder.toString();
                if (obj == null && obj2 != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(" (");
                    stringBuilder.append(body.contentLength());
                    stringBuilder.append("-byte body)");
                    stringBuilder2 = stringBuilder.toString();
                }
                r1.logger.log(stringBuilder2);
                if (obj != null) {
                    if (obj2 != null) {
                        if (body.contentType() != null) {
                            logger = r1.logger;
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Content-Type: ");
                            stringBuilder3.append(body.contentType());
                            logger.log(stringBuilder3.toString());
                        }
                        if (body.contentLength() != -1) {
                            logger = r1.logger;
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Content-Length: ");
                            stringBuilder3.append(body.contentLength());
                            logger.log(stringBuilder3.toString());
                        }
                    }
                    headers = request.headers();
                    size = headers.size();
                    for (i = 0; i < size; i++) {
                        name = headers.name(i);
                        if (!("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name))) {
                            Logger logger4 = r1.logger;
                            stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(name);
                            stringBuilder4.append(": ");
                            stringBuilder4.append(headers.value(i));
                            logger4.log(stringBuilder4.toString());
                        }
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            if (bodyEncoded(request.headers())) {
                                buffer = new Buffer();
                                body.writeTo(buffer);
                                charset = UTF8;
                                contentType = body.contentType();
                                if (contentType != null) {
                                    charset = contentType.charset(UTF8);
                                }
                                r1.logger.log("");
                                if (isPlaintext(buffer)) {
                                    logger2 = r1.logger;
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("--> END ");
                                    stringBuilder5.append(request.method());
                                    stringBuilder5.append(" (binary ");
                                    stringBuilder5.append(body.contentLength());
                                    stringBuilder5.append("-byte body omitted)");
                                    logger2.log(stringBuilder5.toString());
                                } else {
                                    r1.logger.log(buffer.readString(charset));
                                    logger2 = r1.logger;
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("--> END ");
                                    stringBuilder5.append(request.method());
                                    stringBuilder5.append(" (");
                                    stringBuilder5.append(body.contentLength());
                                    stringBuilder5.append("-byte body)");
                                    logger2.log(stringBuilder5.toString());
                                }
                            } else {
                                logger2 = r1.logger;
                                stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("--> END ");
                                stringBuilder5.append(request.method());
                                stringBuilder5.append(" (encoded body omitted)");
                                logger2.log(stringBuilder5.toString());
                            }
                        }
                    }
                    logger2 = r1.logger;
                    stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("--> END ");
                    stringBuilder5.append(request.method());
                    logger2.log(stringBuilder5.toString());
                }
                nanoTime = System.nanoTime();
                proceed = chain2.proceed(request);
                nanoTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
                body2 = proceed.body();
                contentLength = body2.contentLength();
                if (contentLength == -1) {
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(contentLength);
                    stringBuilder9.append("-byte");
                    stringBuilder6 = stringBuilder9.toString();
                } else {
                    stringBuilder6 = "unknown-length";
                }
                Logger logger5 = r1.logger;
                stringBuilder = new StringBuilder();
                stringBuilder.append("<-- ");
                stringBuilder.append(proceed.code());
                stringBuilder.append(' ');
                stringBuilder.append(proceed.message());
                stringBuilder.append(' ');
                stringBuilder.append(proceed.request().url());
                stringBuilder.append(" (");
                stringBuilder.append(nanoTime);
                stringBuilder.append("ms");
                if (obj != null) {
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(", ");
                    stringBuilder4.append(stringBuilder6);
                    stringBuilder4.append(" body");
                    stringBuilder7 = stringBuilder4.toString();
                } else {
                    stringBuilder7 = "";
                }
                stringBuilder.append(stringBuilder7);
                stringBuilder.append(')');
                logger5.log(stringBuilder.toString());
                if (obj != null) {
                    headers2 = proceed.headers();
                    size2 = headers2.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        Logger logger6 = r1.logger;
                        StringBuilder stringBuilder10 = new StringBuilder();
                        stringBuilder10.append(headers2.name(i2));
                        stringBuilder10.append(": ");
                        stringBuilder10.append(headers2.value(i2));
                        logger6.log(stringBuilder10.toString());
                    }
                    if (obj3 != null) {
                        if (!HttpHeaders.hasBody(proceed)) {
                            if (bodyEncoded(proceed.headers())) {
                                BufferedSource source = body2.source();
                                source.request(LongCompanionObject.MAX_VALUE);
                                buffer2 = source.buffer();
                                charset2 = UTF8;
                                contentType2 = body2.contentType();
                                if (contentType2 != null) {
                                    charset2 = contentType2.charset(UTF8);
                                }
                                if (isPlaintext(buffer2)) {
                                    r1.logger.log("");
                                    logger3 = r1.logger;
                                    stringBuilder8 = new StringBuilder();
                                    stringBuilder8.append("<-- END HTTP (binary ");
                                    stringBuilder8.append(buffer2.size());
                                    stringBuilder8.append("-byte body omitted)");
                                    logger3.log(stringBuilder8.toString());
                                    return proceed;
                                }
                                if (contentLength != 0) {
                                    r1.logger.log("");
                                    r1.logger.log(buffer2.clone().readString(charset2));
                                }
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder();
                                stringBuilder8.append("<-- END HTTP (");
                                stringBuilder8.append(buffer2.size());
                                stringBuilder8.append("-byte body)");
                                logger3.log(stringBuilder8.toString());
                            } else {
                                r1.logger.log("<-- END HTTP (encoded body omitted)");
                            }
                        }
                    }
                    r1.logger.log("<-- END HTTP");
                }
                return proceed;
            }
        }
        obj = 1;
        body = request.body();
        if (body != null) {
            obj2 = null;
        }
        connection = chain.connection();
        if (connection == null) {
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("--> ");
        stringBuilder.append(request.method());
        stringBuilder.append(' ');
        stringBuilder.append(request.url());
        stringBuilder.append(' ');
        stringBuilder.append(protocol);
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" (");
        stringBuilder.append(body.contentLength());
        stringBuilder.append("-byte body)");
        stringBuilder2 = stringBuilder.toString();
        r1.logger.log(stringBuilder2);
        if (obj != null) {
            if (obj2 != null) {
                if (body.contentType() != null) {
                    logger = r1.logger;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Content-Type: ");
                    stringBuilder3.append(body.contentType());
                    logger.log(stringBuilder3.toString());
                }
                if (body.contentLength() != -1) {
                    logger = r1.logger;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Content-Length: ");
                    stringBuilder3.append(body.contentLength());
                    logger.log(stringBuilder3.toString());
                }
            }
            headers = request.headers();
            size = headers.size();
            for (i = 0; i < size; i++) {
                name = headers.name(i);
                Logger logger42 = r1.logger;
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(name);
                stringBuilder4.append(": ");
                stringBuilder4.append(headers.value(i));
                logger42.log(stringBuilder4.toString());
            }
            if (obj3 != null) {
                if (obj2 == null) {
                    if (bodyEncoded(request.headers())) {
                        buffer = new Buffer();
                        body.writeTo(buffer);
                        charset = UTF8;
                        contentType = body.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(UTF8);
                        }
                        r1.logger.log("");
                        if (isPlaintext(buffer)) {
                            logger2 = r1.logger;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("--> END ");
                            stringBuilder5.append(request.method());
                            stringBuilder5.append(" (binary ");
                            stringBuilder5.append(body.contentLength());
                            stringBuilder5.append("-byte body omitted)");
                            logger2.log(stringBuilder5.toString());
                        } else {
                            r1.logger.log(buffer.readString(charset));
                            logger2 = r1.logger;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("--> END ");
                            stringBuilder5.append(request.method());
                            stringBuilder5.append(" (");
                            stringBuilder5.append(body.contentLength());
                            stringBuilder5.append("-byte body)");
                            logger2.log(stringBuilder5.toString());
                        }
                    } else {
                        logger2 = r1.logger;
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("--> END ");
                        stringBuilder5.append(request.method());
                        stringBuilder5.append(" (encoded body omitted)");
                        logger2.log(stringBuilder5.toString());
                    }
                }
            }
            logger2 = r1.logger;
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append("--> END ");
            stringBuilder5.append(request.method());
            logger2.log(stringBuilder5.toString());
        }
        nanoTime = System.nanoTime();
        try {
            proceed = chain2.proceed(request);
            nanoTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            body2 = proceed.body();
            contentLength = body2.contentLength();
            if (contentLength == -1) {
                stringBuilder6 = "unknown-length";
            } else {
                StringBuilder stringBuilder92 = new StringBuilder();
                stringBuilder92.append(contentLength);
                stringBuilder92.append("-byte");
                stringBuilder6 = stringBuilder92.toString();
            }
            Logger logger52 = r1.logger;
            stringBuilder = new StringBuilder();
            stringBuilder.append("<-- ");
            stringBuilder.append(proceed.code());
            stringBuilder.append(' ');
            stringBuilder.append(proceed.message());
            stringBuilder.append(' ');
            stringBuilder.append(proceed.request().url());
            stringBuilder.append(" (");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms");
            if (obj != null) {
                stringBuilder7 = "";
            } else {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(", ");
                stringBuilder4.append(stringBuilder6);
                stringBuilder4.append(" body");
                stringBuilder7 = stringBuilder4.toString();
            }
            stringBuilder.append(stringBuilder7);
            stringBuilder.append(')');
            logger52.log(stringBuilder.toString());
            if (obj != null) {
                headers2 = proceed.headers();
                size2 = headers2.size();
                for (i2 = 0; i2 < size2; i2++) {
                    Logger logger62 = r1.logger;
                    StringBuilder stringBuilder102 = new StringBuilder();
                    stringBuilder102.append(headers2.name(i2));
                    stringBuilder102.append(": ");
                    stringBuilder102.append(headers2.value(i2));
                    logger62.log(stringBuilder102.toString());
                }
                if (obj3 != null) {
                    if (!HttpHeaders.hasBody(proceed)) {
                        if (bodyEncoded(proceed.headers())) {
                            BufferedSource source2 = body2.source();
                            source2.request(LongCompanionObject.MAX_VALUE);
                            buffer2 = source2.buffer();
                            charset2 = UTF8;
                            contentType2 = body2.contentType();
                            if (contentType2 != null) {
                                charset2 = contentType2.charset(UTF8);
                            }
                            if (isPlaintext(buffer2)) {
                                if (contentLength != 0) {
                                    r1.logger.log("");
                                    r1.logger.log(buffer2.clone().readString(charset2));
                                }
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder();
                                stringBuilder8.append("<-- END HTTP (");
                                stringBuilder8.append(buffer2.size());
                                stringBuilder8.append("-byte body)");
                                logger3.log(stringBuilder8.toString());
                            } else {
                                r1.logger.log("");
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder();
                                stringBuilder8.append("<-- END HTTP (binary ");
                                stringBuilder8.append(buffer2.size());
                                stringBuilder8.append("-byte body omitted)");
                                logger3.log(stringBuilder8.toString());
                                return proceed;
                            }
                        }
                        r1.logger.log("<-- END HTTP (encoded body omitted)");
                    }
                }
                r1.logger.log("<-- END HTTP");
            }
            return proceed;
        } catch (Exception e) {
            Logger logger7 = r1.logger;
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append("<-- HTTP FAILED: ");
            Exception exception = e;
            stringBuilder11.append(exception);
            logger7.log(stringBuilder11.toString());
            throw exception;
        }
    }

    static boolean isPlaintext(okio.Buffer r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r7 = new okio.Buffer;	 Catch:{ EOFException -> 0x0040 }
        r7.<init>();	 Catch:{ EOFException -> 0x0040 }
        r1 = r8.size();	 Catch:{ EOFException -> 0x0040 }
        r3 = 64;	 Catch:{ EOFException -> 0x0040 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ EOFException -> 0x0040 }
        if (r5 >= 0) goto L_0x0016;	 Catch:{ EOFException -> 0x0040 }
    L_0x0010:
        r1 = r8.size();	 Catch:{ EOFException -> 0x0040 }
        r5 = r1;	 Catch:{ EOFException -> 0x0040 }
        goto L_0x0017;	 Catch:{ EOFException -> 0x0040 }
    L_0x0016:
        r5 = r3;	 Catch:{ EOFException -> 0x0040 }
    L_0x0017:
        r3 = 0;	 Catch:{ EOFException -> 0x0040 }
        r1 = r8;	 Catch:{ EOFException -> 0x0040 }
        r2 = r7;	 Catch:{ EOFException -> 0x0040 }
        r1.copyTo(r2, r3, r5);	 Catch:{ EOFException -> 0x0040 }
        r8 = r0;	 Catch:{ EOFException -> 0x0040 }
    L_0x001f:
        r1 = 16;	 Catch:{ EOFException -> 0x0040 }
        if (r8 >= r1) goto L_0x003e;	 Catch:{ EOFException -> 0x0040 }
    L_0x0023:
        r1 = r7.exhausted();	 Catch:{ EOFException -> 0x0040 }
        if (r1 == 0) goto L_0x002a;	 Catch:{ EOFException -> 0x0040 }
    L_0x0029:
        goto L_0x003e;	 Catch:{ EOFException -> 0x0040 }
    L_0x002a:
        r1 = r7.readUtf8CodePoint();	 Catch:{ EOFException -> 0x0040 }
        r2 = java.lang.Character.isISOControl(r1);	 Catch:{ EOFException -> 0x0040 }
        if (r2 == 0) goto L_0x003b;	 Catch:{ EOFException -> 0x0040 }
    L_0x0034:
        r1 = java.lang.Character.isWhitespace(r1);	 Catch:{ EOFException -> 0x0040 }
        if (r1 != 0) goto L_0x003b;
    L_0x003a:
        return r0;
    L_0x003b:
        r8 = r8 + 1;
        goto L_0x001f;
    L_0x003e:
        r8 = 1;
        return r8;
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.isPlaintext(okio.Buffer):boolean");
    }

    private boolean bodyEncoded(Headers headers) {
        headers = headers.get(HttpRequest.HEADER_CONTENT_ENCODING);
        return (headers == null || headers.equalsIgnoreCase("identity") != null) ? null : true;
    }
}
