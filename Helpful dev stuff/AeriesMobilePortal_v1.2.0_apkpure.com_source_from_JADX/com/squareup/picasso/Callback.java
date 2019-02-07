package com.squareup.picasso;

public interface Callback {

    public static class EmptyCallback implements Callback {
        public void onError(Exception exception) {
        }

        public void onSuccess() {
        }
    }

    void onError(Exception exception);

    void onSuccess();
}
