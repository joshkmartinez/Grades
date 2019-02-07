package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import okhttp3.Cookie;

@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {
    private final SharedPreferences sharedPreferences;

    public SharedPrefsCookiePersistor(Context context) {
        this(context.getSharedPreferences("CookiePersistence", 0));
    }

    public SharedPrefsCookiePersistor(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public List<Cookie> loadAll() {
        List<Cookie> arrayList = new ArrayList(this.sharedPreferences.getAll().size());
        for (Entry value : this.sharedPreferences.getAll().entrySet()) {
            Cookie decode = new SerializableCookie().decode((String) value.getValue());
            if (decode != null) {
                arrayList.add(decode);
            }
        }
        return arrayList;
    }

    public void saveAll(Collection<Cookie> collection) {
        Editor edit = this.sharedPreferences.edit();
        for (Cookie cookie : collection) {
            edit.putString(createCookieKey(cookie), new SerializableCookie().encode(cookie));
        }
        edit.commit();
    }

    public void removeAll(Collection<Cookie> collection) {
        Editor edit = this.sharedPreferences.edit();
        for (Cookie createCookieKey : collection) {
            edit.remove(createCookieKey(createCookieKey));
        }
        edit.commit();
    }

    private static String createCookieKey(Cookie cookie) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cookie.secure() ? "https" : "http");
        stringBuilder.append("://");
        stringBuilder.append(cookie.domain());
        stringBuilder.append(cookie.path());
        stringBuilder.append("|");
        stringBuilder.append(cookie.name());
        return stringBuilder.toString();
    }

    public void clear() {
        this.sharedPreferences.edit().clear().commit();
    }
}
