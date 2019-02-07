package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;

public final class CredentialsOptions extends AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = ((CredentialsOptions) new Builder().zzh());

    public static final class Builder extends com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder {
        public final CredentialsOptions build() {
            return new CredentialsOptions();
        }

        public final Builder forceEnableSaveDialog() {
            this.zzar = Boolean.valueOf(true);
            return this;
        }

        public final /* synthetic */ AuthCredentialsOptions zzh() {
            return build();
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
