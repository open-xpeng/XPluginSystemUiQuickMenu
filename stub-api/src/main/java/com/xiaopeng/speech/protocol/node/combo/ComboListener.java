package com.xiaopeng.speech.protocol.node.combo;

import com.xiaopeng.speech.INodeListener;

/* JADX INFO: loaded from: classes23.dex */
public interface ComboListener extends INodeListener {
    void onDataModeBioTts();

    void onDataModeFridgeTts();

    void onDataModeInvisibleTts();

    void onDataModeMeditationTts();

    void onDataModeVentilateTts();

    void onDataModeWaitTts();

    void onFastCloseModeInvisible();

    void onModeBio();

    void onModeBioOff();

    void onModeFridge();

    void onModeFridgeOff();

    void onModeInvisible();

    void onModeInvisibleOff();

    void onModeVentilate();

    void onModeVentilateOff();

    void onModeWait();

    void onModeWaitOff();

    default void enterUserMode(String mode) {
    }

    default void enterUserModeWithExtra(String mode, String extra) {
    }

    default void exitUserModel(String mode) {
    }
}