package com.xiaopeng.speech;

import android.os.Handler;


/* JADX INFO: loaded from: classes23.dex */
public abstract class SpeechNode<T> {
    protected Handler mWorkerHandler;
    private   boolean mSubscribed = false;

    public void setSubscribed(boolean subscribed) {
        throw new RuntimeException("Stub!");
    }

    public boolean isSubscribed() {
        throw new RuntimeException("Stub!");
    }

    protected void onSubscribe() {
        throw new RuntimeException("Stub!");
    }

    protected void onUnsubscribe() {
        throw new RuntimeException("Stub!");
    }

    public Handler getWorkerHandler() {
        throw new RuntimeException("Stub!");
    }

    public void setWorkerHandler(Handler workerHandler) {
        throw new RuntimeException("Stub!");
    }

    public void addListener(T listener) {
        throw new RuntimeException("Stub!");
    }

    public void removeListener(T listener) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performCommand(String command, String data) {
        throw new RuntimeException("Stub!");
    }

    public String[] getSubscribeEvents() {
        throw new RuntimeException("Stub!");
    }

}