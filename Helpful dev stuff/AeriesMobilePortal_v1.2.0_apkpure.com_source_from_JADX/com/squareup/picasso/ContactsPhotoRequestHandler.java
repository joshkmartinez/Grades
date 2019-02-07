package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

class ContactsPhotoRequestHandler extends RequestHandler {
    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final UriMatcher matcher = new UriMatcher(-1);
    private final Context context;

    static {
        matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        matcher.addURI("com.android.contacts", "contacts/#", 3);
        matcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    ContactsPhotoRequestHandler(Context context) {
        this.context = context;
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        return (Param.CONTENT.equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(request.uri) != -1) ? true : null;
    }

    public Result load(Request request, int i) throws IOException {
        request = getInputStream(request);
        if (request == null) {
            return null;
        }
        return new Result(Okio.source(request), LoadedFrom.DISK);
    }

    private InputStream getInputStream(Request request) throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        request = request.uri;
        switch (matcher.match(request)) {
            case 1:
                request = Contacts.lookupContact(contentResolver, request);
                if (request == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(request);
            case 3:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid uri: ");
                stringBuilder.append(request);
                throw new IllegalStateException(stringBuilder.toString());
        }
        return Contacts.openContactPhotoInputStream(contentResolver, request, true);
    }
}
