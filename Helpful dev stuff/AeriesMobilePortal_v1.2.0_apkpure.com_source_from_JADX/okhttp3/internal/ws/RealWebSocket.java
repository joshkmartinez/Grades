package okhttp3.internal.ws;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.ws.WebSocketReader.FrameCallback;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class RealWebSocket implements WebSocket, FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    class C10251 implements Runnable {
        C10251() {
        }

        public void run() {
            while (RealWebSocket.this.writeOneFrame()) {
                try {
                } catch (Exception e) {
                    RealWebSocket.this.failWebSocket(e, null);
                    return;
                }
            }
        }
    }

    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if (HttpRequest.METHOD_GET.equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random;
            this.pingIntervalMillis = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.writerRunnable = new C10251();
            return;
        }
        random = new StringBuilder();
        random.append("Request must be GET: ");
        random.append(request.method());
        throw new IllegalArgumentException(random.toString());
    }

    public Request request() {
        return this.originalRequest;
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public void cancel() {
        this.call.cancel();
    }

    public void connect(OkHttpClient okHttpClient) {
        okHttpClient = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = Internal.instance.newWebSocketCall(okHttpClient, build);
        this.call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    call = Internal.instance.streamAllocation(call);
                    call.noNewStreams();
                    Streams newWebSocketStreams = call.connection().newWebSocketStreams(call);
                    try {
                        RealWebSocket.this.listener.onOpen(RealWebSocket.this, response);
                        response = new StringBuilder();
                        response.append("OkHttp WebSocket ");
                        response.append(build.url().redact());
                        RealWebSocket.this.initReaderAndWriter(response.toString(), newWebSocketStreams);
                        call.connection().socket().setSoTimeout(null);
                        RealWebSocket.this.loopReader();
                    } catch (Call call2) {
                        RealWebSocket.this.failWebSocket(call2, null);
                    }
                } catch (Call call22) {
                    RealWebSocket.this.failWebSocket(call22, response);
                    Util.closeQuietly((Closeable) response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }
        });
    }

    void checkResponse(Response response) throws ProtocolException {
        StringBuilder stringBuilder;
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                header = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header)) {
                    response = response.header("Sec-WebSocket-Accept");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.key);
                    stringBuilder2.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
                    header = ByteString.encodeUtf8(stringBuilder2.toString()).sha1().base64();
                    if (!header.equals(response)) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Expected 'Sec-WebSocket-Accept' header value '");
                        stringBuilder3.append(header);
                        stringBuilder3.append("' but was '");
                        stringBuilder3.append(response);
                        stringBuilder3.append("'");
                        throw new ProtocolException(stringBuilder3.toString());
                    }
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Expected 'Upgrade' header value 'websocket' but was '");
                stringBuilder.append(header);
                stringBuilder.append("'");
                throw new ProtocolException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected 'Connection' header value 'Upgrade' but was '");
            stringBuilder.append(header);
            stringBuilder.append("'");
            throw new ProtocolException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expected HTTP 101 response but was '");
        stringBuilder.append(response.code());
        stringBuilder.append(" ");
        stringBuilder.append(response.message());
        stringBuilder.append("'");
        throw new ProtocolException(stringBuilder.toString());
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (this.pingIntervalMillis != 0) {
                this.executor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
            }
            if (this.messageAndCloseQueue.isEmpty() == null) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    boolean processNextFrame() throws IOException {
        boolean z = false;
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination((long) i, timeUnit);
    }

    void tearDown() throws InterruptedException {
        if (this.cancelFuture != null) {
            this.cancelFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.failed;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0022;
    L_0x0005:
        r0 = r1.enqueuedClose;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r1.messageAndCloseQueue;	 Catch:{ all -> 0x0024 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0022;
    L_0x0012:
        r0 = r1.pongQueue;	 Catch:{ all -> 0x0024 }
        r0.add(r2);	 Catch:{ all -> 0x0024 }
        r1.runWriter();	 Catch:{ all -> 0x0024 }
        r2 = r1.receivedPingCount;	 Catch:{ all -> 0x0024 }
        r2 = r2 + 1;
        r1.receivedPingCount = r2;	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);
        return;
    L_0x0022:
        monitor-exit(r1);
        return;
    L_0x0024:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = null;
    }

    public void onReadClose(int i, String str) {
        Closeable closeable;
        if (i != -1) {
            synchronized (this) {
                if (this.receivedCloseCode == -1) {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = str;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        closeable = this.streams;
                        this.streams = null;
                        if (this.cancelFuture != null) {
                            this.cancelFuture.cancel(false);
                        }
                        this.executor.shutdown();
                    } else {
                        closeable = null;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (closeable != null) {
                    this.listener.onClosed(this, i, str);
                }
                Util.closeQuietly(closeable);
            } catch (Throwable th) {
                Util.closeQuietly(closeable);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean send(String str) {
        if (str != null) {
            return send(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean send(okio.ByteString r9, int r10) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.failed;	 Catch:{ all -> 0x0040 }
        r1 = 0;
        if (r0 != 0) goto L_0x003e;
    L_0x0006:
        r0 = r8.enqueuedClose;	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x003e;
    L_0x000b:
        r2 = r8.queueSize;	 Catch:{ all -> 0x0040 }
        r0 = r9.size();	 Catch:{ all -> 0x0040 }
        r4 = (long) r0;	 Catch:{ all -> 0x0040 }
        r6 = r2 + r4;
        r2 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0023;
    L_0x001b:
        r9 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r10 = 0;
        r8.close(r9, r10);	 Catch:{ all -> 0x0040 }
        monitor-exit(r8);
        return r1;
    L_0x0023:
        r0 = r8.queueSize;	 Catch:{ all -> 0x0040 }
        r2 = r9.size();	 Catch:{ all -> 0x0040 }
        r2 = (long) r2;	 Catch:{ all -> 0x0040 }
        r4 = r0 + r2;
        r8.queueSize = r4;	 Catch:{ all -> 0x0040 }
        r0 = r8.messageAndCloseQueue;	 Catch:{ all -> 0x0040 }
        r1 = new okhttp3.internal.ws.RealWebSocket$Message;	 Catch:{ all -> 0x0040 }
        r1.<init>(r10, r9);	 Catch:{ all -> 0x0040 }
        r0.add(r1);	 Catch:{ all -> 0x0040 }
        r8.runWriter();	 Catch:{ all -> 0x0040 }
        r9 = 1;
        monitor-exit(r8);
        return r9;
    L_0x003e:
        monitor-exit(r8);
        return r1;
    L_0x0040:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }

    synchronized boolean pong(ByteString byteString) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return null;
    }

    public boolean close(int i, String str) {
        return close(i, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.validateCloseCode(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                j = new StringBuilder();
                j.append("reason.size() > 123: ");
                j.append(str);
                throw new IllegalArgumentException(j.toString());
            }
        }
        if (this.failed == null) {
            if (this.enqueuedClose == null) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteString, j));
                runWriter();
                return true;
            }
        }
        return false;
    }

    private void runWriter() {
        if (this.executor != null) {
            this.executor.execute(this.writerRunnable);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean writeOneFrame() throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r11.failed;	 Catch:{ all -> 0x00ad }
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r11);	 Catch:{ all -> 0x00ad }
        return r1;
    L_0x0008:
        r0 = r11.writer;	 Catch:{ all -> 0x00ad }
        r2 = r11.pongQueue;	 Catch:{ all -> 0x00ad }
        r2 = r2.poll();	 Catch:{ all -> 0x00ad }
        r2 = (okio.ByteString) r2;	 Catch:{ all -> 0x00ad }
        r3 = -1;
        r4 = 0;
        if (r2 != 0) goto L_0x004d;
    L_0x0016:
        r5 = r11.messageAndCloseQueue;	 Catch:{ all -> 0x00ad }
        r5 = r5.poll();	 Catch:{ all -> 0x00ad }
        r6 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Close;	 Catch:{ all -> 0x00ad }
        if (r6 == 0) goto L_0x0046;
    L_0x0020:
        r1 = r11.receivedCloseCode;	 Catch:{ all -> 0x00ad }
        r6 = r11.receivedCloseReason;	 Catch:{ all -> 0x00ad }
        if (r1 == r3) goto L_0x0031;
    L_0x0026:
        r3 = r11.streams;	 Catch:{ all -> 0x00ad }
        r11.streams = r4;	 Catch:{ all -> 0x00ad }
        r4 = r11.executor;	 Catch:{ all -> 0x00ad }
        r4.shutdown();	 Catch:{ all -> 0x00ad }
        r4 = r3;
        goto L_0x0050;
    L_0x0031:
        r3 = r11.executor;	 Catch:{ all -> 0x00ad }
        r7 = new okhttp3.internal.ws.RealWebSocket$CancelRunnable;	 Catch:{ all -> 0x00ad }
        r7.<init>();	 Catch:{ all -> 0x00ad }
        r8 = r5;
        r8 = (okhttp3.internal.ws.RealWebSocket.Close) r8;	 Catch:{ all -> 0x00ad }
        r8 = r8.cancelAfterCloseMillis;	 Catch:{ all -> 0x00ad }
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00ad }
        r3 = r3.schedule(r7, r8, r10);	 Catch:{ all -> 0x00ad }
        r11.cancelFuture = r3;	 Catch:{ all -> 0x00ad }
        goto L_0x0050;
    L_0x0046:
        if (r5 != 0) goto L_0x004a;
    L_0x0048:
        monitor-exit(r11);	 Catch:{ all -> 0x00ad }
        return r1;
    L_0x004a:
        r1 = r3;
        r6 = r4;
        goto L_0x0050;
    L_0x004d:
        r1 = r3;
        r5 = r4;
        r6 = r5;
    L_0x0050:
        monitor-exit(r11);	 Catch:{ all -> 0x00ad }
        if (r2 == 0) goto L_0x0059;
    L_0x0053:
        r0.writePong(r2);	 Catch:{ all -> 0x0057 }
        goto L_0x009e;
    L_0x0057:
        r0 = move-exception;
        goto L_0x00a9;
    L_0x0059:
        r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Message;	 Catch:{ all -> 0x0057 }
        if (r2 == 0) goto L_0x008a;
    L_0x005d:
        r1 = r5;
        r1 = (okhttp3.internal.ws.RealWebSocket.Message) r1;	 Catch:{ all -> 0x0057 }
        r1 = r1.data;	 Catch:{ all -> 0x0057 }
        r5 = (okhttp3.internal.ws.RealWebSocket.Message) r5;	 Catch:{ all -> 0x0057 }
        r2 = r5.formatOpcode;	 Catch:{ all -> 0x0057 }
        r3 = r1.size();	 Catch:{ all -> 0x0057 }
        r5 = (long) r3;	 Catch:{ all -> 0x0057 }
        r0 = r0.newMessageSink(r2, r5);	 Catch:{ all -> 0x0057 }
        r0 = okio.Okio.buffer(r0);	 Catch:{ all -> 0x0057 }
        r0.write(r1);	 Catch:{ all -> 0x0057 }
        r0.close();	 Catch:{ all -> 0x0057 }
        monitor-enter(r11);	 Catch:{ all -> 0x0057 }
        r2 = r11.queueSize;	 Catch:{ all -> 0x0087 }
        r0 = r1.size();	 Catch:{ all -> 0x0087 }
        r0 = (long) r0;	 Catch:{ all -> 0x0087 }
        r5 = r2 - r0;
        r11.queueSize = r5;	 Catch:{ all -> 0x0087 }
        monitor-exit(r11);	 Catch:{ all -> 0x0087 }
        goto L_0x009e;
    L_0x0087:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0087 }
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x008a:
        r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Close;	 Catch:{ all -> 0x0057 }
        if (r2 == 0) goto L_0x00a3;
    L_0x008e:
        r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5;	 Catch:{ all -> 0x0057 }
        r2 = r5.code;	 Catch:{ all -> 0x0057 }
        r3 = r5.reason;	 Catch:{ all -> 0x0057 }
        r0.writeClose(r2, r3);	 Catch:{ all -> 0x0057 }
        if (r4 == 0) goto L_0x009e;
    L_0x0099:
        r0 = r11.listener;	 Catch:{ all -> 0x0057 }
        r0.onClosed(r11, r1, r6);	 Catch:{ all -> 0x0057 }
    L_0x009e:
        r0 = 1;
        okhttp3.internal.Util.closeQuietly(r4);
        return r0;
    L_0x00a3:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0057 }
        r0.<init>();	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x00a9:
        okhttp3.internal.Util.closeQuietly(r4);
        throw r0;
    L_0x00ad:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x00ad }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void writePingFrame() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.failed;	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r7);	 Catch:{ all -> 0x0053 }
        return;
    L_0x0007:
        r0 = r7.writer;	 Catch:{ all -> 0x0053 }
        r1 = r7.awaitingPong;	 Catch:{ all -> 0x0053 }
        r2 = -1;
        if (r1 == 0) goto L_0x0011;
    L_0x000e:
        r1 = r7.sentPingCount;	 Catch:{ all -> 0x0053 }
        goto L_0x0012;
    L_0x0011:
        r1 = r2;
    L_0x0012:
        r3 = r7.sentPingCount;	 Catch:{ all -> 0x0053 }
        r4 = 1;
        r3 = r3 + r4;
        r7.sentPingCount = r3;	 Catch:{ all -> 0x0053 }
        r7.awaitingPong = r4;	 Catch:{ all -> 0x0053 }
        monitor-exit(r7);	 Catch:{ all -> 0x0053 }
        r3 = 0;
        if (r1 == r2) goto L_0x0048;
    L_0x001e:
        r0 = new java.net.SocketTimeoutException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "sent ping but didn't receive pong within ";
        r2.append(r5);
        r5 = r7.pingIntervalMillis;
        r2.append(r5);
        r5 = "ms (after ";
        r2.append(r5);
        r1 = r1 - r4;
        r2.append(r1);
        r1 = " successful ping/pongs)";
        r2.append(r1);
        r1 = r2.toString();
        r0.<init>(r1);
        r7.failWebSocket(r0, r3);
        return;
    L_0x0048:
        r1 = okio.ByteString.EMPTY;	 Catch:{ IOException -> 0x004e }
        r0.writePing(r1);	 Catch:{ IOException -> 0x004e }
        goto L_0x0052;
    L_0x004e:
        r0 = move-exception;
        r7.failWebSocket(r0, r3);
    L_0x0052:
        return;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, @javax.annotation.Nullable okhttp3.Response r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.failed;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        return;
    L_0x0007:
        r0 = 1;
        r3.failed = r0;	 Catch:{ all -> 0x0031 }
        r0 = r3.streams;	 Catch:{ all -> 0x0031 }
        r1 = 0;
        r3.streams = r1;	 Catch:{ all -> 0x0031 }
        r1 = r3.cancelFuture;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r1 = r3.cancelFuture;	 Catch:{ all -> 0x0031 }
        r2 = 0;
        r1.cancel(r2);	 Catch:{ all -> 0x0031 }
    L_0x0019:
        r1 = r3.executor;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x0022;
    L_0x001d:
        r1 = r3.executor;	 Catch:{ all -> 0x0031 }
        r1.shutdown();	 Catch:{ all -> 0x0031 }
    L_0x0022:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r1 = r3.listener;	 Catch:{ all -> 0x002c }
        r1.onFailure(r3, r4, r5);	 Catch:{ all -> 0x002c }
        okhttp3.internal.Util.closeQuietly(r0);
        return;
    L_0x002c:
        r4 = move-exception;
        okhttp3.internal.Util.closeQuietly(r0);
        throw r4;
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }
}
