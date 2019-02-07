package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.Cookie;

class IdentifiableCookie {
    private Cookie cookie;

    static List<IdentifiableCookie> decorateAll(Collection<Cookie> collection) {
        List<IdentifiableCookie> arrayList = new ArrayList(collection.size());
        for (Cookie identifiableCookie : collection) {
            arrayList.add(new IdentifiableCookie(identifiableCookie));
        }
        return arrayList;
    }

    IdentifiableCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    Cookie getCookie() {
        return this.cookie;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (identifiableCookie.cookie.name().equals(this.cookie.name()) && identifiableCookie.cookie.domain().equals(this.cookie.domain()) && identifiableCookie.cookie.path().equals(this.cookie.path()) && identifiableCookie.cookie.secure() == this.cookie.secure() && identifiableCookie.cookie.hostOnly() == this.cookie.hostOnly()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (31 * (((((((527 + this.cookie.name().hashCode()) * 31) + this.cookie.domain().hashCode()) * 31) + this.cookie.path().hashCode()) * 31) + (this.cookie.secure() ^ 1))) + (this.cookie.hostOnly() ^ 1);
    }
}
