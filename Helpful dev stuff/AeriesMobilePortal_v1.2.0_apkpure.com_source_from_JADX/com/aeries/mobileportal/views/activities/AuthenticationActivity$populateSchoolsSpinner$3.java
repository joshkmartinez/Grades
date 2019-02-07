package com.aeries.mobileportal.views.activities;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.aeries.mobileportal.models.School;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"com/aeries/mobileportal/views/activities/AuthenticationActivity$populateSchoolsSpinner$3", "Landroid/widget/AdapterView$OnItemSelectedListener;", "(Lcom/aeries/mobileportal/views/activities/AuthenticationActivity;Ljava/util/ArrayList;)V", "onItemSelected", "", "p0", "Landroid/widget/AdapterView;", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onNothingSelected", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthenticationActivity.kt */
public final class AuthenticationActivity$populateSchoolsSpinner$3 implements OnItemSelectedListener {
    final /* synthetic */ ArrayList $schools;
    final /* synthetic */ AuthenticationActivity this$0;

    AuthenticationActivity$populateSchoolsSpinner$3(AuthenticationActivity authenticationActivity, ArrayList arrayList) {
        this.this$0 = authenticationActivity;
        this.$schools = arrayList;
    }

    public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
        this.this$0.getSignInButton().setEnabled(false);
    }

    public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        if (!(i == 0 || i == this.$schools.size())) {
            this.this$0.getSignInButton().setEnabled(true);
            this.this$0.setSelectedSchool((School) this.$schools.get(i));
        }
        if (i == 0) {
            this.this$0.getSignInButton().setEnabled(null);
        }
    }
}
