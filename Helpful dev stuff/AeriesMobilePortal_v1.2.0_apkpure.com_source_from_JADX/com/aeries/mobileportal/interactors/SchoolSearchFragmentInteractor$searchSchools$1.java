package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.models.School;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/aeries/mobileportal/models/School;", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: SchoolSearchFragmentInteractor.kt */
final class SchoolSearchFragmentInteractor$searchSchools$1<T> implements Consumer<List<School>> {
    final /* synthetic */ SchoolSearchFragmentCallback $callback;

    SchoolSearchFragmentInteractor$searchSchools$1(SchoolSearchFragmentCallback schoolSearchFragmentCallback) {
        this.$callback = schoolSearchFragmentCallback;
    }

    public final void accept(@Nullable List<School> list) {
        SchoolSearchFragmentCallback schoolSearchFragmentCallback = this.$callback;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        schoolSearchFragmentCallback.onSchoolsRetreived(list);
    }
}
