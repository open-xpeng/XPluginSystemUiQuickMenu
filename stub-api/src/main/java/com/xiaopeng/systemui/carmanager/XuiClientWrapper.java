package com.xiaopeng.systemui.carmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

import com.xiaopeng.xuimanager.ambientlight.AmbientLightManager;
import com.xiaopeng.xuimanager.contextinfo.ContextInfoManager;
import com.xiaopeng.xuimanager.makeuplight.MakeupLightManager;
import com.xiaopeng.xuimanager.userscenario.UserScenarioManager;

/* loaded from: classes24.dex */
@SuppressWarnings("unused")
public class XuiClientWrapper implements MakeupLightManager.EventListener {

    public static final int MIC_POWER_STATUS_OFF  = 0;
    public static final int MIC_POWER_STATUS_ON   = 1;
    public static final int MIC_STATUS_DONGLE_OFF = 4;
    public static final int MIC_STATUS_DONGLE_ON  = 3;
    public static final int MIC_STATUS_POWER_OFF  = 6;
    public static final int MIC_STATUS_POWER_ON   = 5;

    private AmbientLightManager mAtlManager;
    private ContextInfoManager  mCtiManager;
    private MakeupLightManager  mMakeupLightManager;
    private UserScenarioManager mUserScenarioManager;

    private Handler mHandler              = new Handler();
    private boolean mKaraokeManagerInited = false;

    private final ServiceConnection mXuiConnectionCb = new ServiceConnection() { // from class: com.xiaopeng.systemui.carmanager.XuiClientWrapper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            throw new RuntimeException("Stub!");
        }
    };

    public interface MakeupLightListener {
        void onMakeupLightStatusChanged(boolean z);
    }

    private static class SingleHolder {
        private static final XuiClientWrapper sInstance = new XuiClientWrapper();

        private SingleHolder() {
        }
    }

    public static XuiClientWrapper getInstance() {
        throw new RuntimeException("Stub!");
    }

    public void addMakeupLightListener(MakeupLightListener makeupLightListener) {
        throw new RuntimeException("Stub!");
    }

    public void connectToXui(Context context) {
        throw new RuntimeException("Stub!");
    }

    public boolean isMakeupLightOn() {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkToReconnectXui() {
        throw new RuntimeException("Stub!");
    }

    private boolean isXuiServiceDisconnected() {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initXuiManagers() {
        throw new RuntimeException("Stub!");
    }

    public AmbientLightManager getAtlManager() {
        return this.mAtlManager;
    }

    public ContextInfoManager getCtiManager() {
        return this.mCtiManager;
    }

    public void startMeditationMode() {
        throw new RuntimeException("Stub!");
    }

    public void startMeditationMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startCleanMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startSpaceCapsuleMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startSleepMode() {
        throw new RuntimeException("Stub!");
    }

    public void startSleepMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startWaitingMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startMovieMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void startMakeupMode() {
        throw new RuntimeException("Stub!");
    }

    public void startMakeupMode(int screenId) {
        throw new RuntimeException("Stub!");
    }

    public void onAvailable(final boolean status) {
        throw new RuntimeException("Stub!");
    }
}