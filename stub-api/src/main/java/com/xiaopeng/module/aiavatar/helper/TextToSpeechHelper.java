package com.xiaopeng.module.aiavatar.helper;

import android.content.Context;
import android.speech.tts.TextToSpeech;

/* JADX INFO: loaded from: classes23.dex */
@SuppressWarnings("unused")
public class TextToSpeechHelper {
    private static final String             TAG       = "TextToSpeechHelper";
    private static final TextToSpeechHelper sInstance = new TextToSpeechHelper();

    private boolean        isInit;
    private ISpeakCallback mSpeakCallback;
    private TextToSpeech   mTextToSpeech;
    private String         mTts;
    private TtsCache       mTtsCache;

    public interface ISpeakCallback {
        void onEnd(String str);

        void onError(String str);

        void onStart(String str, String str2);

        void onStop();
    }

    public static final TextToSpeechHelper instance() {
        throw new RuntimeException("Stub!");
    }

    public String speak(Context context, String tts) {
        throw new RuntimeException("Stub!");
    }

    public String speak(Context context, String tts, ISpeakCallback listener) {
        throw new RuntimeException("Stub!");
    }

    public void stop() {
        throw new RuntimeException("Stub!");
    }

    private void init(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void speakText(final String tts, final String utteranceId) {
        throw new RuntimeException("Stub!");
    }

    class TtsCache {
        ISpeakCallback listener;
        String         mTts;
        String         mUtteranceId;

        TtsCache() {
            throw new RuntimeException("Stub!");
        }
    }
}