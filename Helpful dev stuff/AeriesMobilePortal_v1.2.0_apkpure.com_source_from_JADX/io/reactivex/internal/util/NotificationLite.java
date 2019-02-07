package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable f37d;

        DisposableNotification(Disposable disposable) {
            this.f37d = disposable;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Disposable[");
            stringBuilder.append(this.f37d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable f38e;

        ErrorNotification(Throwable th) {
            this.f38e = th;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Error[");
            stringBuilder.append(this.f38e);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public int hashCode() {
            return this.f38e.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ErrorNotification)) {
                return null;
            }
            return ObjectHelper.equals(this.f38e, ((ErrorNotification) obj).f38e);
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription f39s;

        SubscriptionNotification(Subscription subscription) {
            this.f39s = subscription;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Subscription[");
            stringBuilder.append(this.f39s);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE ? true : null;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f38e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).f39s;
    }

    public static Disposable getDisposable(Object obj) {
        return ((DisposableNotification) obj).f37d;
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f38e);
            return true;
        } else {
            subscriber.onNext(obj);
            return null;
        }
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f38e);
            return true;
        } else {
            observer.onNext(obj);
            return null;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f38e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification) obj).f39s);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f38e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f37d);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}
