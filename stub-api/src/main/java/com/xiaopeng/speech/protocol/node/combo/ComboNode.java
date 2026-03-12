package com.xiaopeng.speech.protocol.node.combo;

import com.xiaopeng.speech.SpeechNode;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.protocol.event.ComboEvent;

/* JADX INFO: loaded from: classes23.dex */
public class ComboNode extends SpeechNode<ComboListener> {
    private static final String CLOSE_MEDITATION_INTENT = "关闭冥想模式";
    private static final String CLOSE_WAIT_INTENT       = "关闭等人模式";
    private static final String COMBO_SKILL             = "离线系统组合命令词";
    private static final String COMBO_TASK              = "组合命令词";
    private static final String OPEN_MEDITATION_INTENT  = "冥想模式";
    private static final String OPEN_WAIT_INTENT        = "等人模式";

    @SpeechAnnotation(event = ComboEvent.MODE_BIO)
    protected void onModeBio(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_VENTILATE)
    protected void onModeVentilate(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_INVISIBLE)
    protected void onModeInvisible(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_INVISIBLE_OFF)
    protected void onModeInvisibleOff(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_FRIDGE)
    protected void onModeFridge(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_INVISIBLE_TTS)
    public void onDataModeInvisibleTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_MEDITATION_TTS)
    public void onDataModeMeditationTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.FAST_CLOSE_MODE_INVISIBLE)
    protected void onFastCloseModeInvisible(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_BIO_TTS)
    public void onDataModeBioTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_VENTILATE_TTS)
    public void onDataModeVentilateTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_FRIDGE_TTS)
    public void onDataModeFridgeTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_BIO_OFF)
    public void onModeBioOff(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_VENTILATE_OFF)
    public void onModeVentilateOff(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_FRIDGE_OFF)
    public void onModeFridgeOff(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.DATA_MODE_WAIT_TTS)
    public void onDataModeWaitTts(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_WAIT)
    public void onModeWait(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.MODE_WAIT_OFF)
    protected void onModeWaitOff(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.ENTER_USER_MODE)
    protected void enterUserMode(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    @SpeechAnnotation(event = ComboEvent.EXIT_USER_MODE)
    protected void exitUserModel(String event, String data) {
        throw new RuntimeException("Stub!");
    }

    private String getExtraFromJson(String data) {
        throw new RuntimeException("Stub!");
    }

    private String getModeFromJson(String data) {
        throw new RuntimeException("Stub!");
    }

    public void openMeditationMode(String tts) {
        throw new RuntimeException("Stub!");
    }

    public void closeMeditationMode(String tts) {
        throw new RuntimeException("Stub!");
    }

    public void closeMeditationMode(String tts, boolean needTTS) {
        throw new RuntimeException("Stub!");
    }

    public void openWaitMode(boolean needTTS) {
        throw new RuntimeException("Stub!");
    }

    public void closeWaitMode(boolean needTTS) {
        throw new RuntimeException("Stub!");
    }

    public int getCurrentMode() {
        throw new RuntimeException("Stub!");
    }
}