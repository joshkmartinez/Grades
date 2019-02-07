package com.crashlytics.android.answers;

import java.util.HashSet;
import java.util.Set;

class SamplingEventFilter implements EventFilter {
    static final Set<Type> EVENTS_TYPE_TO_SAMPLE = new C03721();
    final int samplingRate;

    static class C03721 extends HashSet<Type> {
        C03721() {
            add(Type.START);
            add(Type.RESUME);
            add(Type.PAUSE);
            add(Type.STOP);
        }
    }

    public SamplingEventFilter(int i) {
        this.samplingRate = i;
    }

    public boolean skipEvent(SessionEvent sessionEvent) {
        boolean z = EVENTS_TYPE_TO_SAMPLE.contains(sessionEvent.type) && sessionEvent.sessionEventMetadata.betaDeviceToken == null;
        sessionEvent = Math.abs(sessionEvent.sessionEventMetadata.installationId.hashCode() % this.samplingRate) != null ? 1 : null;
        if (!z || sessionEvent == null) {
            return false;
        }
        return true;
    }
}
