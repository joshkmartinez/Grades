package com.franmontiel.persistentcookiejar.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Cookie;

public class SetCookieCache implements CookieCache {
    private Set<IdentifiableCookie> cookies = new HashSet();

    private class SetCookieCacheIterator implements Iterator<Cookie> {
        private Iterator<IdentifiableCookie> iterator;

        public SetCookieCacheIterator() {
            this.iterator = SetCookieCache.this.cookies.iterator();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Cookie next() {
            return ((IdentifiableCookie) this.iterator.next()).getCookie();
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public void addAll(Collection<Cookie> collection) {
        collection = IdentifiableCookie.decorateAll(collection).iterator();
        while (collection.hasNext()) {
            IdentifiableCookie identifiableCookie = (IdentifiableCookie) collection.next();
            this.cookies.remove(identifiableCookie);
            this.cookies.add(identifiableCookie);
        }
    }

    public void clear() {
        this.cookies.clear();
    }

    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator();
    }
}
