package com.aeries.mobileportal.views.activities;

import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.School;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¨\u0006\u0016"}, d2 = {"com/aeries/mobileportal/views/activities/ChangeDistrictActivity$initSwipe$itemTouchCallback$1", "Landroid/support/v7/widget/helper/ItemTouchHelper$SimpleCallback;", "(Lcom/aeries/mobileportal/views/activities/ChangeDistrictActivity;II)V", "onChildDraw", "", "c", "Landroid/graphics/Canvas;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "dX", "", "dY", "actionState", "", "isCurrentlyActive", "", "onMove", "target", "onSwiped", "direction", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictActivity.kt */
public final class ChangeDistrictActivity$initSwipe$itemTouchCallback$1 extends SimpleCallback {
    final /* synthetic */ ChangeDistrictActivity this$0;

    public boolean onMove(@Nullable RecyclerView recyclerView, @Nullable ViewHolder viewHolder, @Nullable ViewHolder viewHolder2) {
        return false;
    }

    ChangeDistrictActivity$initSwipe$itemTouchCallback$1(ChangeDistrictActivity changeDistrictActivity, int i, int i2) {
        this.this$0 = changeDistrictActivity;
        super(i, i2);
    }

    public void onSwiped(@Nullable ViewHolder viewHolder, int i) {
        viewHolder = viewHolder != null ? Integer.valueOf(viewHolder.getAdapterPosition()) : null;
        i = new Builder(this.this$0).setTitle(C0316R.string.delete_district);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.this$0.getString(C0316R.string.delete_district_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.delete_district_message)");
        Object[] objArr = new Object[1];
        objArr[0] = ((School) this.this$0.getAdapter().getSchools().get(viewHolder != null ? viewHolder.intValue() : 0)).getSchoolName();
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        i.setMessage(string).setPositiveButton(C0316R.string.delete, new ChangeDistrictActivity$initSwipe$itemTouchCallback$1$onSwiped$1(this, viewHolder)).setNegativeButton(C0316R.string.cancel, new ChangeDistrictActivity$initSwipe$itemTouchCallback$1$onSwiped$2(this)).setCancelable(false).create().show();
    }

    public void onChildDraw(@Nullable Canvas canvas, @Nullable RecyclerView recyclerView, @Nullable ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 1) {
            View view;
            float bottom;
            RectF rectF;
            Bitmap decodeResource;
            RectF rectF2;
            Paint paint = new Paint();
            paint.setColor(this.this$0.getResources().getColor(C0316R.color.aeries_red));
            if (viewHolder != null) {
                view = viewHolder.itemView;
                if (view != null) {
                    bottom = (((float) view.getBottom()) - ((float) view.getTop())) / ((float) 3);
                    rectF = new RectF(((float) view.getRight()) + f, (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
                    if (canvas != null) {
                        canvas.drawRect(rectF, paint);
                    }
                    decodeResource = BitmapFactory.decodeResource(this.this$0.getResources(), C0316R.drawable.delete);
                    rectF2 = new RectF(((float) view.getRight()) - (((float) 2) * bottom), ((float) view.getTop()) + bottom, ((float) view.getRight()) - bottom, ((float) view.getBottom()) - bottom);
                    if (canvas != null) {
                        canvas.drawBitmap(decodeResource, null, rectF2, paint);
                    }
                }
            }
            view = new View(this.this$0);
            bottom = (((float) view.getBottom()) - ((float) view.getTop())) / ((float) 3);
            rectF = new RectF(((float) view.getRight()) + f, (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
            if (canvas != null) {
                canvas.drawRect(rectF, paint);
            }
            decodeResource = BitmapFactory.decodeResource(this.this$0.getResources(), C0316R.drawable.delete);
            rectF2 = new RectF(((float) view.getRight()) - (((float) 2) * bottom), ((float) view.getTop()) + bottom, ((float) view.getRight()) - bottom, ((float) view.getBottom()) - bottom);
            if (canvas != null) {
                canvas.drawBitmap(decodeResource, null, rectF2, paint);
            }
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }
}
