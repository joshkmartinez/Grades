package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
    public static final Dns SYSTEM = new C10601();

    class C10601 implements Dns {
        C10601() {
        }

        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Broken system behaviour for dns lookup of ");
                    stringBuilder.append(str);
                    UnknownHostException unknownHostException = new UnknownHostException(stringBuilder.toString());
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
