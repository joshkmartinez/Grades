package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

public abstract class RequestBody {

    class C10641 extends RequestBody {
        final /* synthetic */ ByteString val$content;
        final /* synthetic */ MediaType val$contentType;

        C10641(MediaType mediaType, ByteString byteString) {
            this.val$contentType = mediaType;
            this.val$content = byteString;
        }

        @Nullable
        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() throws IOException {
            return (long) this.val$content.size();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content);
        }
    }

    class C10652 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ int val$offset;

        C10652(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$byteCount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        @Nullable
        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return (long) this.val$byteCount;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
        }
    }

    class C10663 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        C10663(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        @Nullable
        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return this.val$file.length();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Closeable closeable = null;
            try {
                Closeable source = Okio.source(this.val$file);
                try {
                    bufferedSink.writeAll(source);
                    Util.closeQuietly(source);
                } catch (Throwable th) {
                    bufferedSink = th;
                    closeable = source;
                    Util.closeQuietly(closeable);
                    throw bufferedSink;
                }
            } catch (Throwable th2) {
                bufferedSink = th2;
                Util.closeQuietly(closeable);
                throw bufferedSink;
            }
        }
    }

    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(mediaType);
                stringBuilder.append("; charset=utf-8");
                mediaType = MediaType.parse(stringBuilder.toString());
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return new C10641(mediaType, byteString);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new C10652(mediaType, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        if (file != null) {
            return new C10663(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
