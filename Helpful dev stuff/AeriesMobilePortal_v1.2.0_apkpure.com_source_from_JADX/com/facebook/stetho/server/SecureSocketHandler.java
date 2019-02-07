package com.facebook.stetho.server;

import android.content.Context;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

public abstract class SecureSocketHandler implements SocketHandler {
    private final Context mContext;

    protected abstract void onSecured(LocalSocket localSocket) throws IOException;

    public SecureSocketHandler(Context context) {
        this.mContext = context;
    }

    public final void onAccepted(LocalSocket localSocket) throws IOException {
        try {
            enforcePermission(this.mContext, localSocket);
            onSecured(localSocket);
        } catch (LocalSocket localSocket2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unauthorized request: ");
            stringBuilder.append(localSocket2.getMessage());
            LogUtil.m17e(stringBuilder.toString());
        }
    }

    private static void enforcePermission(Context context, LocalSocket localSocket) throws IOException, PeerAuthorizationException {
        localSocket = localSocket.getPeerCredentials();
        int uid = localSocket.getUid();
        localSocket = localSocket.getPid();
        if (LogUtil.isLoggable(2)) {
            LogUtil.m26v("Got request from uid=%d, pid=%d", Integer.valueOf(uid), Integer.valueOf(localSocket));
        }
        String str = "android.permission.DUMP";
        if (context.checkPermission(str, localSocket, uid) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Peer pid=");
            stringBuilder.append(localSocket);
            stringBuilder.append(", uid=");
            stringBuilder.append(uid);
            stringBuilder.append(" does not have ");
            stringBuilder.append(str);
            throw new PeerAuthorizationException(stringBuilder.toString());
        }
    }
}
