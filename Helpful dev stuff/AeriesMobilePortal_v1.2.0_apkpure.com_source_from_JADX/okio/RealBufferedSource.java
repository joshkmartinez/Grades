package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import kotlin.jvm.internal.LongCompanionObject;
import org.jetbrains.anko.DimensionsKt;

final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    class C10291 extends InputStream {
        C10291() {
        }

        public int read() throws IOException {
            if (RealBufferedSource.this.closed) {
                throw new IOException("closed");
            } else if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            } else {
                return RealBufferedSource.this.buffer.readByte() & 255;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (RealBufferedSource.this.closed) {
                throw new IOException("closed");
            }
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return RealBufferedSource.this.buffer.read(bArr, i, i2);
        }

        public int available() throws IOException {
            if (!RealBufferedSource.this.closed) {
                return (int) Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            RealBufferedSource.this.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(RealBufferedSource.this);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    RealBufferedSource(Source source) {
        if (source != null) {
            this.source = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public Buffer buffer() {
        return this.buffer;
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (this.buffer.size == 0 && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.buffer.read(buffer, Math.min(j, this.buffer.size));
        }
    }

    public boolean exhausted() throws IOException {
        if (!this.closed) {
            return this.buffer.exhausted() && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j) throws IOException {
        if (request(j) == null) {
            throw new EOFException();
        }
    }

    public boolean request(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else {
            while (this.buffer.size < j) {
                if (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    public ByteString readByteString(long j) throws IOException {
        require(j);
        return this.buffer.readByteString(j);
    }

    public int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = this.buffer.selectPrefix(options);
            if (selectPrefix == -1) {
                return -1;
            }
            long size = (long) options.byteStrings[selectPrefix].size();
            if (size <= this.buffer.size) {
                this.buffer.skip(size);
                return selectPrefix;
            }
        } while (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    public byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.buffer.readByteArray(j);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.buffer.size > 0) {
                int read = this.buffer.read(bArr, i, (int) this.buffer.size);
                if (read != -1) {
                    i += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        if (this.buffer.size == 0 && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) Math.min(j, this.buffer.size));
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.buffer.size == 0 && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    public void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.buffer.readFully(buffer, j);
        } catch (long j2) {
            buffer.writeAll(this.buffer);
            throw j2;
        }
    }

    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long completeSegmentByteCount;
            long j = 0;
            while (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    long j2 = j + completeSegmentByteCount;
                    sink.write(this.buffer, completeSegmentByteCount);
                    j = j2;
                }
            }
            if (this.buffer.size() <= 0) {
                return j;
            }
            completeSegmentByteCount = j + this.buffer.size();
            sink.write(this.buffer, this.buffer.size());
            return completeSegmentByteCount;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    public String readUtf8(long j) throws IOException {
        require(j);
        return this.buffer.readUtf8(j);
    }

    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.buffer.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        return this.buffer.size != 0 ? readUtf8(this.buffer.size) : null;
    }

    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == LongCompanionObject.MAX_VALUE ? LongCompanionObject.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return this.buffer.readUtf8Line(indexOf);
            }
            if (j2 < LongCompanionObject.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == (byte) 13 && request(j2 + 1) && this.buffer.getByte(j2) == (byte) 10) {
                return this.buffer.readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            this.buffer.copyTo(buffer, 0, Math.min(32, this.buffer.size()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(this.buffer.size(), j));
            stringBuilder.append(" content=");
            stringBuilder.append(buffer.readByteString().hex());
            stringBuilder.append(8230);
            throw new EOFException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte b = this.buffer.getByte(0);
        if ((b & 224) == 192) {
            require(2);
        } else if ((b & DimensionsKt.HDPI) == 224) {
            require(3);
        } else if ((b & 248) == DimensionsKt.HDPI) {
            require(4);
        }
        return this.buffer.readUtf8CodePoint();
    }

    public short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    public short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    public int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    public int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    public long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    public long readLongLe() throws IOException {
        require(8);
        return this.buffer.readLongLe();
    }

    public long readDecimalLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b = this.buffer.getByte((long) i);
            if (b < (byte) 48 || b > (byte) 57) {
                if (i != 0) {
                    break;
                } else if (b != Framer.STDIN_FRAME_PREFIX) {
                    break;
                }
            }
            i = i2;
        }
        if (i != 0) {
            return this.buffer.readDecimalLong();
        }
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
        r6 = this;
        r0 = 1;
        r6.require(r0);
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.request(r3);
        if (r3 == 0) goto L_0x004a;
    L_0x0010:
        r3 = r6.buffer;
        r4 = (long) r1;
        r3 = r3.getByte(r4);
        r4 = 48;
        if (r3 < r4) goto L_0x001f;
    L_0x001b:
        r4 = 57;
        if (r3 <= r4) goto L_0x0030;
    L_0x001f:
        r4 = 97;
        if (r3 < r4) goto L_0x0027;
    L_0x0023:
        r4 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 <= r4) goto L_0x0030;
    L_0x0027:
        r4 = 65;
        if (r3 < r4) goto L_0x0032;
    L_0x002b:
        r4 = 70;
        if (r3 <= r4) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r1 = r2;
        goto L_0x0007;
    L_0x0032:
        if (r1 == 0) goto L_0x0035;
    L_0x0034:
        goto L_0x004a;
    L_0x0035:
        r1 = new java.lang.NumberFormatException;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Byte.valueOf(r3);
        r2[r0] = r3;
        r0 = "Expected leading [0-9a-fA-F] character but was %#x";
        r0 = java.lang.String.format(r0, r2);
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r6.buffer;
        r0 = r0.readHexadecimalUnsignedLong();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    public void skip(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.buffer.size == 0) {
                if (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
            }
            long min = Math.min(j, this.buffer.size());
            this.buffer.skip(min);
            j -= min;
        }
    }

    public long indexOf(byte b) throws IOException {
        return indexOf(b, 0, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long j) throws IOException {
        return indexOf(b, j, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long j, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long indexOf = this.buffer.indexOf(b, j, j2);
                if (indexOf != -1) {
                    return indexOf;
                }
                indexOf = this.buffer.size;
                if (indexOf < j2) {
                    if (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                        j = Math.max(j, indexOf);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            indexOf = this.buffer.size;
            if (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, (indexOf - ((long) byteString.size())) + 1);
        }
    }

    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            indexOfElement = this.buffer.size;
            if (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, indexOfElement);
        }
    }

    public boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j >= 0 && i >= 0 && i2 >= 0) {
            if (byteString.size() - i >= i2) {
                int i3 = 0;
                while (i3 < i2) {
                    long j2 = j + ((long) i3);
                    if (!request(j2 + 1) || this.buffer.getByte(j2) != byteString.getByte(i + i3)) {
                        return false;
                    }
                    i3++;
                }
                return 1;
            }
        }
        return false;
    }

    public InputStream inputStream() {
        return new C10291();
    }

    public boolean isOpen() {
        return this.closed ^ 1;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.buffer.clear();
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.source);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
