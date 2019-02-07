package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class SingleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public T get() {
        Provider provider = this.provider;
        if (this.instance == UNINITIALIZED) {
            this.instance = provider.get();
            this.provider = null;
        }
        return this.instance;
    }

    public static <T> Provider<T> provider(Provider<T> provider) {
        if (!(provider instanceof SingleCheck)) {
            if (!(provider instanceof DoubleCheck)) {
                return new SingleCheck((Provider) Preconditions.checkNotNull(provider));
            }
        }
        return provider;
    }
}
