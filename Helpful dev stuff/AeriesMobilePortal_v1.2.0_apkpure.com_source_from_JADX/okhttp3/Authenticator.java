package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Authenticator {
    public static final Authenticator NONE = new C10571();

    class C10571 implements Authenticator {
        public Request authenticate(Route route, Response response) {
            return null;
        }

        C10571() {
        }
    }

    @Nullable
    Request authenticate(Route route, Response response) throws IOException;
}
