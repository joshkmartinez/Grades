package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import javax.annotation.Nullable;

final class WindowDescriptor extends AbstractChainedDescriptor<Window> implements HighlightableDescriptor<Window> {
    WindowDescriptor() {
    }

    protected void onGetChildren(Window window, Accumulator<Object> accumulator) {
        window = window.peekDecorView();
        if (window != null) {
            accumulator.store(window);
        }
    }

    @Nullable
    public View getViewAndBoundsForHighlighting(Window window, Rect rect) {
        return window.peekDecorView();
    }

    @Nullable
    public Object getElementToHighlightAtPosition(Window window, int i, int i2, Rect rect) {
        HighlightableDescriptor highlightableDescriptor;
        Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            window = window.peekDecorView();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(window);
        } else {
            window = null;
            highlightableDescriptor = window;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(window, i, i2, rect);
    }
}
