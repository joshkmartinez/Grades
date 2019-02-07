package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.DescriptorProvider;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderListener;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.ObjectDescriptor;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

final class AndroidDocumentProvider extends ThreadBoundProxy implements DocumentProvider, AndroidDescriptorHost {
    private static final int INSPECT_HOVER_COLOR = 1077952767;
    private static final int INSPECT_OVERLAY_COLOR = 1090519039;
    private static final long REPORT_CHANGED_INTERVAL_MS = 1000;
    private final Application mApplication;
    private final DescriptorMap mDescriptorMap;
    private final AndroidDocumentRoot mDocumentRoot;
    private final ViewHighlighter mHighlighter;
    private final Rect mHighlightingBoundsRect = new Rect();
    private final Rect mHitRect = new Rect();
    private final InspectModeHandler mInspectModeHandler;
    private boolean mIsReportChangesTimerPosted;
    @Nullable
    private DocumentProviderListener mListener;
    private final Runnable mReportChangesTimer;

    class C04191 implements Runnable {
        C04191() {
        }

        public void run() {
            AndroidDocumentProvider.this.mIsReportChangesTimerPosted = false;
            if (AndroidDocumentProvider.this.mListener != null) {
                AndroidDocumentProvider.this.mListener.onPossiblyChanged();
                AndroidDocumentProvider.this.mIsReportChangesTimerPosted = true;
                AndroidDocumentProvider.this.postDelayed(this, AndroidDocumentProvider.REPORT_CHANGED_INTERVAL_MS);
            }
        }
    }

    private final class InspectModeHandler {
        private List<View> mOverlays;
        private final Predicate<View> mViewSelector;

        class C08561 implements Predicate<View> {
            C08561() {
            }

            public boolean apply(View view) {
                return (view instanceof DocumentHiddenView) == null ? true : null;
            }
        }

        class C08572 implements Accumulator<Window> {
            C08572() {
            }

            public void store(Window window) {
                if (window.peekDecorView() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) window.peekDecorView();
                    View overlayView = new OverlayView(AndroidDocumentProvider.this.mApplication);
                    LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    viewGroup.addView(overlayView, layoutParams);
                    viewGroup.bringChildToFront(overlayView);
                    InspectModeHandler.this.mOverlays.add(overlayView);
                }
            }
        }

        private final class OverlayView extends DocumentHiddenView {
            public OverlayView(Context context) {
                super(context);
            }

            protected void onDraw(Canvas canvas) {
                canvas.drawColor(AndroidDocumentProvider.INSPECT_OVERLAY_COLOR);
                super.onDraw(canvas);
            }

            public boolean onTouchEvent(MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Object parent = getParent();
                while (true) {
                    HighlightableDescriptor highlightableDescriptor = AndroidDocumentProvider.this.getHighlightableDescriptor(parent);
                    if (highlightableDescriptor == null) {
                        break;
                    }
                    AndroidDocumentProvider.this.mHitRect.setEmpty();
                    Object elementToHighlightAtPosition = highlightableDescriptor.getElementToHighlightAtPosition(parent, x, y, AndroidDocumentProvider.this.mHitRect);
                    x -= AndroidDocumentProvider.this.mHitRect.left;
                    y -= AndroidDocumentProvider.this.mHitRect.top;
                    if (elementToHighlightAtPosition == parent) {
                        break;
                    }
                    parent = elementToHighlightAtPosition;
                }
                if (parent != null) {
                    HighlightableDescriptor highlightableDescriptor2 = AndroidDocumentProvider.this.getHighlightableDescriptor(parent);
                    if (highlightableDescriptor2 != null) {
                        View viewAndBoundsForHighlighting = highlightableDescriptor2.getViewAndBoundsForHighlighting(parent, AndroidDocumentProvider.this.mHighlightingBoundsRect);
                        if (!(motionEvent.getAction() == 3 || viewAndBoundsForHighlighting == null)) {
                            AndroidDocumentProvider.this.mHighlighter.setHighlightedView(viewAndBoundsForHighlighting, AndroidDocumentProvider.this.mHighlightingBoundsRect, AndroidDocumentProvider.INSPECT_HOVER_COLOR);
                            if (motionEvent.getAction() == 1 && AndroidDocumentProvider.this.mListener != null) {
                                AndroidDocumentProvider.this.mListener.onInspectRequested(parent);
                            }
                        }
                    }
                }
                return true;
            }
        }

        private InspectModeHandler() {
            this.mViewSelector = new C08561();
        }

        public void enable() {
            AndroidDocumentProvider.this.verifyThreadAccess();
            if (this.mOverlays != null) {
                disable();
            }
            this.mOverlays = new ArrayList();
            AndroidDocumentProvider.this.getWindows(new C08572());
        }

        public void disable() {
            AndroidDocumentProvider.this.verifyThreadAccess();
            if (this.mOverlays != null) {
                for (int i = 0; i < this.mOverlays.size(); i++) {
                    View view = (View) this.mOverlays.get(i);
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mOverlays = null;
            }
        }
    }

    public AndroidDocumentProvider(Application application, List<DescriptorProvider> list, ThreadBound threadBound) {
        super(threadBound);
        threadBound = null;
        this.mIsReportChangesTimerPosted = false;
        this.mReportChangesTimer = new C04191();
        this.mApplication = (Application) Util.throwIfNull(application);
        this.mDocumentRoot = new AndroidDocumentRoot(application);
        this.mDescriptorMap = new DescriptorMap().beginInit().registerDescriptor(Activity.class, new ActivityDescriptor()).registerDescriptor(AndroidDocumentRoot.class, this.mDocumentRoot).registerDescriptor(Application.class, new ApplicationDescriptor()).registerDescriptor(Dialog.class, new DialogDescriptor()).registerDescriptor(Object.class, new ObjectDescriptor()).registerDescriptor(TextView.class, new TextViewDescriptor()).registerDescriptor(View.class, new ViewDescriptor()).registerDescriptor(ViewGroup.class, new ViewGroupDescriptor()).registerDescriptor(Window.class, new WindowDescriptor());
        DialogFragmentDescriptor.register(this.mDescriptorMap);
        FragmentDescriptor.register(this.mDescriptorMap);
        ThreadBound size = list.size();
        while (threadBound < size) {
            ((DescriptorProvider) list.get(threadBound)).registerDescriptor(this.mDescriptorMap);
            threadBound++;
        }
        this.mDescriptorMap.setHost(this).endInit();
        this.mHighlighter = ViewHighlighter.newInstance();
        this.mInspectModeHandler = new InspectModeHandler();
    }

    public void dispose() {
        verifyThreadAccess();
        this.mHighlighter.clearHighlight();
        this.mInspectModeHandler.disable();
        removeCallbacks(this.mReportChangesTimer);
        this.mIsReportChangesTimerPosted = false;
        this.mListener = null;
    }

    public void setListener(DocumentProviderListener documentProviderListener) {
        verifyThreadAccess();
        this.mListener = documentProviderListener;
        if (this.mListener == null && this.mIsReportChangesTimerPosted != null) {
            this.mIsReportChangesTimerPosted = null;
            removeCallbacks(this.mReportChangesTimer);
        } else if (this.mListener != null && this.mIsReportChangesTimerPosted == null) {
            this.mIsReportChangesTimerPosted = true;
            postDelayed(this.mReportChangesTimer, REPORT_CHANGED_INTERVAL_MS);
        }
    }

    public Object getRootElement() {
        verifyThreadAccess();
        return this.mDocumentRoot;
    }

    public NodeDescriptor getNodeDescriptor(Object obj) {
        verifyThreadAccess();
        return getDescriptor(obj);
    }

    public void highlightElement(Object obj, int i) {
        verifyThreadAccess();
        HighlightableDescriptor highlightableDescriptor = getHighlightableDescriptor(obj);
        if (highlightableDescriptor == null) {
            this.mHighlighter.clearHighlight();
            return;
        }
        this.mHighlightingBoundsRect.setEmpty();
        obj = highlightableDescriptor.getViewAndBoundsForHighlighting(obj, this.mHighlightingBoundsRect);
        if (obj == null) {
            this.mHighlighter.clearHighlight();
        } else {
            this.mHighlighter.setHighlightedView(obj, this.mHighlightingBoundsRect, i);
        }
    }

    public void hideHighlight() {
        verifyThreadAccess();
        this.mHighlighter.clearHighlight();
    }

    public void setInspectModeEnabled(boolean z) {
        verifyThreadAccess();
        if (z) {
            this.mInspectModeHandler.enable();
        } else {
            this.mInspectModeHandler.disable();
        }
    }

    public void setAttributesAsText(Object obj, String str) {
        verifyThreadAccess();
        Descriptor descriptor = this.mDescriptorMap.get(obj.getClass());
        if (descriptor != null) {
            descriptor.setAttributesAsText(obj, str);
        }
    }

    public Descriptor getDescriptor(Object obj) {
        return obj == null ? null : this.mDescriptorMap.get(obj.getClass());
    }

    public void onAttributeModified(Object obj, String str, String str2) {
        if (this.mListener != null) {
            this.mListener.onAttributeModified(obj, str, str2);
        }
    }

    public void onAttributeRemoved(Object obj, String str) {
        if (this.mListener != null) {
            this.mListener.onAttributeRemoved(obj, str);
        }
    }

    @Nullable
    public HighlightableDescriptor getHighlightableDescriptor(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        Class cls = obj.getClass();
        obj = null;
        Descriptor descriptor = obj;
        while (obj == null && cls != null) {
            Descriptor descriptor2 = this.mDescriptorMap.get(cls);
            if (descriptor2 == null) {
                return null;
            }
            if (descriptor2 != descriptor && (descriptor2 instanceof HighlightableDescriptor)) {
                obj = (HighlightableDescriptor) descriptor2;
            }
            cls = cls.getSuperclass();
            descriptor = descriptor2;
        }
        return obj;
    }

    private void getWindows(final Accumulator<Window> accumulator) {
        Descriptor descriptor = getDescriptor(this.mApplication);
        if (descriptor != null) {
            descriptor.getChildren(this.mApplication, new Accumulator<Object>() {
                public void store(Object obj) {
                    if (obj instanceof Window) {
                        accumulator.store((Window) obj);
                        return;
                    }
                    Descriptor descriptor = AndroidDocumentProvider.this.getDescriptor(obj);
                    if (descriptor != null) {
                        descriptor.getChildren(obj, this);
                    }
                }
            });
        }
    }
}
