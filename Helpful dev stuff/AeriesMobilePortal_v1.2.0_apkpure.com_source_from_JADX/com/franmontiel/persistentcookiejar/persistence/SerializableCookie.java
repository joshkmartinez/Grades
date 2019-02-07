package com.franmontiel.persistentcookiejar.persistence;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.Cookie;
import okhttp3.Cookie.Builder;

public class SerializableCookie implements Serializable {
    private static long NON_VALID_EXPIRES_AT = -1;
    private static final String TAG = "SerializableCookie";
    private static final long serialVersionUID = -8594045714036645534L;
    private transient Cookie cookie;

    public String encode(Cookie cookie) {
        this.cookie = cookie;
        cookie = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(cookie);
            try {
                objectOutputStream.writeObject(this);
                try {
                    objectOutputStream.close();
                } catch (Throwable e) {
                    Log.d(TAG, "Stream not closed in encodeCookie", e);
                }
                return byteArrayToHexString(cookie.toByteArray());
            } catch (IOException e2) {
                cookie = e2;
                try {
                    Log.d(TAG, "IOException in encodeCookie", cookie);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Cookie cookie2) {
                            Log.d(TAG, "Stream not closed in encodeCookie", cookie2);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    cookie2 = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable e3) {
                            Log.d(TAG, "Stream not closed in encodeCookie", e3);
                        }
                    }
                    throw cookie2;
                }
            }
        } catch (IOException e4) {
            cookie2 = e4;
            objectOutputStream = null;
            Log.d(TAG, "IOException in encodeCookie", cookie2);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            cookie2 = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw cookie2;
        }
    }

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString();
    }

    public Cookie decode(String str) {
        ObjectInputStream objectInputStream;
        Throwable e;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str)));
            try {
                Cookie cookie = ((SerializableCookie) objectInputStream.readObject()).cookie;
                try {
                    objectInputStream.close();
                } catch (String str2) {
                    Log.d(TAG, "Stream not closed in decodeCookie", str2);
                }
                return cookie;
            } catch (IOException e2) {
                e = e2;
                Log.d(TAG, "IOException in decodeCookie", e);
                if (objectInputStream != null) {
                    return null;
                }
                objectInputStream.close();
                return null;
            } catch (ClassNotFoundException e3) {
                e = e3;
                try {
                    Log.d(TAG, "ClassNotFoundException in decodeCookie", e);
                    if (objectInputStream != null) {
                        return null;
                    }
                    try {
                        objectInputStream.close();
                        return null;
                    } catch (Throwable e4) {
                        Log.d(TAG, "Stream not closed in decodeCookie", e4);
                        return null;
                    }
                } catch (Throwable th) {
                    str2 = th;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e42) {
                            Log.d(TAG, "Stream not closed in decodeCookie", e42);
                        }
                    }
                    throw str2;
                }
            }
        } catch (IOException e5) {
            e42 = e5;
            objectInputStream = null;
            Log.d(TAG, "IOException in decodeCookie", e42);
            if (objectInputStream != null) {
                return null;
            }
            objectInputStream.close();
            return null;
        } catch (ClassNotFoundException e6) {
            e42 = e6;
            objectInputStream = null;
            Log.d(TAG, "ClassNotFoundException in decodeCookie", e42);
            if (objectInputStream != null) {
                return null;
            }
            objectInputStream.close();
            return null;
        } catch (Throwable e422) {
            objectInputStream = null;
            str2 = e422;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw str2;
        }
    }

    private static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookie.name());
        objectOutputStream.writeObject(this.cookie.value());
        objectOutputStream.writeLong(this.cookie.persistent() ? this.cookie.expiresAt() : NON_VALID_EXPIRES_AT);
        objectOutputStream.writeObject(this.cookie.domain());
        objectOutputStream.writeObject(this.cookie.path());
        objectOutputStream.writeBoolean(this.cookie.secure());
        objectOutputStream.writeBoolean(this.cookie.httpOnly());
        objectOutputStream.writeBoolean(this.cookie.hostOnly());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Builder builder = new Builder();
        builder.name((String) objectInputStream.readObject());
        builder.value((String) objectInputStream.readObject());
        long readLong = objectInputStream.readLong();
        if (readLong != NON_VALID_EXPIRES_AT) {
            builder.expiresAt(readLong);
        }
        String str = (String) objectInputStream.readObject();
        builder.domain(str);
        builder.path((String) objectInputStream.readObject());
        if (objectInputStream.readBoolean()) {
            builder.secure();
        }
        if (objectInputStream.readBoolean()) {
            builder.httpOnly();
        }
        if (objectInputStream.readBoolean() != null) {
            builder.hostOnlyDomain(str);
        }
        this.cookie = builder.build();
    }
}
