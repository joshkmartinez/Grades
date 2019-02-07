package com.aeries.mobileportal.views;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/BottomOffsetDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "bottomOffset", "", "(I)V", "getBottomOffset", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: BottomOffsetDecoration.kt */
public final class BottomOffsetDecoration extends ItemDecoration {
    private final int bottomOffset;

    public BottomOffsetDecoration(int i) {
        this.bottomOffset = i;
    }

    public final int getBottomOffset() {
        return this.bottomOffset;
    }

    public void getItemOffsets(@Nullable Rect rect, @Nullable View view, @Nullable RecyclerView recyclerView, @Nullable State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        state = state != null ? state.getItemCount() : null;
        view = recyclerView != null ? Integer.valueOf(recyclerView.getChildAdapterPosition(view)) : null;
        if (state > null) {
            View view2 = state - 1;
            if (view != null) {
                if (view.intValue() == view2) {
                    if (rect != null) {
                        rect.set(0, 0, 0, this.bottomOffset);
                        return;
                    }
                    return;
                }
            }
        }
        if (rect != null) {
            rect.set(0, 0, 0, 0);
        }
    }
}
