package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.LinkContactsAdapter.LinkContactHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: LinkContactsAdapter.kt */
final class LinkContactsAdapter$LinkContactHolder$bindData$1 implements OnClickListener {
    final /* synthetic */ LinkContactHolder this$0;

    LinkContactsAdapter$LinkContactHolder$bindData$1(LinkContactHolder linkContactHolder) {
        this.this$0 = linkContactHolder;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getListener().onContactSelected(this.this$0.getAdapterPosition());
        this.this$0.this$0.getSelectedItems().clear();
        this.this$0.this$0.getSelectedItems().put(this.this$0.getAdapterPosition(), true);
        this.this$0.getBackground().setSelected(true);
        this.this$0.this$0.notifyDataSetChanged();
    }
}
