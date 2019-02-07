package com.aeries.mobileportal.utils;

import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/utils/ImageLoader;", "", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "picasso", "Lcom/squareup/picasso/Picasso;", "(Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;Lcom/squareup/picasso/Picasso;)V", "loadImage", "", "circleImageView", "Lde/hdodenhof/circleimageview/CircleImageView;", "student", "Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ImageLoader.kt */
public final class ImageLoader {
    private final NetworkRepo networkRepository;
    private final Picasso picasso;

    public ImageLoader(@NotNull NetworkRepo networkRepo, @NotNull Picasso picasso) {
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(picasso, "picasso");
        this.networkRepository = networkRepo;
        this.picasso = picasso;
    }

    public final void loadImage(@NotNull CircleImageView circleImageView, @NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(circleImageView, "circleImageView");
        Intrinsics.checkParameterIsNotNull(student, "student");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.networkRepository.getCurrentBaseURL());
        stringBuilder.append(student.getDemographics().getSchoolCode());
        stringBuilder.append("/studentimage/");
        stringBuilder.append(student.getDemographics().getStudentId());
        String stringBuilder2 = stringBuilder.toString();
        this.picasso.load(stringBuilder2).networkPolicy(NetworkPolicy.OFFLINE, new NetworkPolicy[0]).placeholder((int) C0316R.drawable.user).into(circleImageView, new ImageLoader$loadImage$1(this, stringBuilder2, circleImageView));
    }
}
