package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import javax.annotation.Nullable;

final class DialogDescriptor extends AbstractChainedDescriptor<Dialog> implements HighlightableDescriptor<Dialog> {
    DialogDescriptor() {
    }

    protected void onGetChildren(Dialog dialog, Accumulator<Object> accumulator) {
        dialog = dialog.getWindow();
        if (dialog != null) {
            accumulator.store(dialog);
        }
    }

    @Nullable
    public View getViewAndBoundsForHighlighting(Dialog dialog, Rect rect) {
        HighlightableDescriptor highlightableDescriptor;
        Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            dialog = dialog.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(dialog);
        } else {
            dialog = null;
            highlightableDescriptor = dialog;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getViewAndBoundsForHighlighting(dialog, rect);
    }

    @Nullable
    public Object getElementToHighlightAtPosition(Dialog dialog, int i, int i2, Rect rect) {
        HighlightableDescriptor highlightableDescriptor;
        Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            dialog = dialog.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(dialog);
        } else {
            dialog = null;
            highlightableDescriptor = dialog;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(dialog, i, i2, rect);
    }
}
