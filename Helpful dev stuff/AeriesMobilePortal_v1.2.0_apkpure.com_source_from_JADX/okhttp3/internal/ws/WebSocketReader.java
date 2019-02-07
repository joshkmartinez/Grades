package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSource;
import okio.ByteString;

final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer = new Buffer();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer = new Buffer();
    int opcode;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    private void readHeader() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 1, insn: 0x0036: MOVE  (r0 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r1 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:8:0x0036, method: okhttp3.internal.ws.WebSocketReader.readHeader():void
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:168)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.closed;
        if (r0 != 0) goto L_0x0119;
    L_0x0004:
        r0 = r8.source;
        r0 = r0.timeout();
        r0 = r0.timeoutNanos();
        r2 = r8.source;
        r2 = r2.timeout();
        r2.clearTimeout();
        r2 = r8.source;	 Catch:{ all -> 0x010c }
        r2 = r2.readByte();	 Catch:{ all -> 0x010c }
        r2 = r2 & 255;
        r3 = r8.source;
        r3 = r3.timeout();
        r4 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r3.timeout(r0, r4);
        r0 = r2 & 15;
        r8.opcode = r0;
        r0 = r2 & 128;
        r1 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x0036;
    L_0x0034:
        r0 = r3;
        goto L_0x0037;
    L_0x0036:
        r0 = r1;
    L_0x0037:
        r8.isFinalFrame = r0;
        r0 = r2 & 8;
        if (r0 == 0) goto L_0x003f;
    L_0x003d:
        r0 = r3;
        goto L_0x0040;
    L_0x003f:
        r0 = r1;
    L_0x0040:
        r8.isControlFrame = r0;
        r0 = r8.isControlFrame;
        if (r0 == 0) goto L_0x0053;
    L_0x0046:
        r0 = r8.isFinalFrame;
        if (r0 == 0) goto L_0x004b;
    L_0x004a:
        goto L_0x0053;
    L_0x004b:
        r0 = new java.net.ProtocolException;
        r1 = "Control frames must be final.";
        r0.<init>(r1);
        throw r0;
    L_0x0053:
        r0 = r2 & 64;
        if (r0 == 0) goto L_0x0059;
    L_0x0057:
        r0 = r3;
        goto L_0x005a;
    L_0x0059:
        r0 = r1;
    L_0x005a:
        r4 = r2 & 32;
        if (r4 == 0) goto L_0x0060;
    L_0x005e:
        r4 = r3;
        goto L_0x0061;
    L_0x0060:
        r4 = r1;
    L_0x0061:
        r2 = r2 & 16;
        if (r2 == 0) goto L_0x0067;
    L_0x0065:
        r2 = r3;
        goto L_0x0068;
    L_0x0067:
        r2 = r1;
    L_0x0068:
        if (r0 != 0) goto L_0x0104;
    L_0x006a:
        if (r4 != 0) goto L_0x0104;
    L_0x006c:
        if (r2 != 0) goto L_0x0104;
    L_0x006e:
        r0 = r8.source;
        r0 = r0.readByte();
        r0 = r0 & 255;
        r2 = r0 & 128;
        if (r2 == 0) goto L_0x007b;
    L_0x007a:
        r1 = r3;
    L_0x007b:
        r2 = r8.isClient;
        if (r1 != r2) goto L_0x008e;
    L_0x007f:
        r0 = new java.net.ProtocolException;
        r1 = r8.isClient;
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1 = "Server-sent frames must not be masked.";
        goto L_0x008a;
    L_0x0088:
        r1 = "Client-sent frames must be masked.";
    L_0x008a:
        r0.<init>(r1);
        throw r0;
    L_0x008e:
        r0 = r0 & 127;
        r2 = (long) r0;
        r8.frameLength = r2;
        r2 = r8.frameLength;
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x00aa;
    L_0x009b:
        r0 = r8.source;
        r0 = r0.readShort();
        r2 = (long) r0;
        r4 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r2 & r4;
        r8.frameLength = r6;
        goto L_0x00e5;
    L_0x00aa:
        r2 = r8.frameLength;
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x00e5;
    L_0x00b2:
        r0 = r8.source;
        r2 = r0.readLong();
        r8.frameLength = r2;
        r2 = r8.frameLength;
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x00c3;
    L_0x00c2:
        goto L_0x00e5;
    L_0x00c3:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Frame length 0x";
        r1.append(r2);
        r2 = r8.frameLength;
        r2 = java.lang.Long.toHexString(r2);
        r1.append(r2);
        r2 = " > 0x7FFFFFFFFFFFFFFF";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e5:
        r0 = r8.isControlFrame;
        if (r0 == 0) goto L_0x00fa;
    L_0x00e9:
        r2 = r8.frameLength;
        r4 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x00f2;
    L_0x00f1:
        goto L_0x00fa;
    L_0x00f2:
        r0 = new java.net.ProtocolException;
        r1 = "Control frame must be less than 125B.";
        r0.<init>(r1);
        throw r0;
    L_0x00fa:
        if (r1 == 0) goto L_0x0103;
    L_0x00fc:
        r0 = r8.source;
        r1 = r8.maskKey;
        r0.readFully(r1);
    L_0x0103:
        return;
    L_0x0104:
        r0 = new java.net.ProtocolException;
        r1 = "Reserved flags are unsupported.";
        r0.<init>(r1);
        throw r0;
    L_0x010c:
        r2 = move-exception;
        r3 = r8.source;
        r3 = r3.timeout();
        r4 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r3.timeout(r0, r4);
        throw r2;
    L_0x0119:
        r0 = new java.io.IOException;
        r1 = "closed";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketReader.readHeader():void");
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.isClient = z;
            this.source = bufferedSource;
            this.frameCallback = frameCallback;
            bufferedSource = null;
            if (z) {
                frameCallback = null;
            } else {
                frameCallback = new byte[4];
            }
            this.maskKey = frameCallback;
            if (!z) {
                bufferedSource = new UnsafeCursor();
            }
            this.maskCursor = bufferedSource;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    private void readControlFrame() throws IOException {
        if (this.frameLength > 0) {
            this.source.readFully(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int i = 1005;
                String str = "";
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        i = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(i);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    }
                    this.frameCallback.onReadClose(i, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown control opcode: ");
                stringBuilder.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(stringBuilder.toString());
        }
    }

    private void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1) {
            if (i != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown opcode: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new ProtocolException(stringBuilder.toString());
            }
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            if (this.frameLength > 0) {
                this.source.readFully(this.messageFrameBuffer, this.frameLength);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected continuation opcode. Got: ");
                    stringBuilder.append(Integer.toHexString(this.opcode));
                    throw new ProtocolException(stringBuilder.toString());
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
