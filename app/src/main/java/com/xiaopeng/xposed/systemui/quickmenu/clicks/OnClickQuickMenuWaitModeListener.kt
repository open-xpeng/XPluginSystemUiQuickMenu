package com.xiaopeng.xposed.systemui.quickmenu.clicks

import android.view.View
import com.xiaopeng.speech.protocol.node.combo.ComboNode
import com.xiaopeng.systemui.carmanager.XuiClientWrapper
import com.xiaopeng.systemui.quickmenu.QuickMenuPresenterManager
import de.robv.android.xposed.XposedBridge

object OnClickQuickMenuWaitModeListener : View.OnClickListener {
    override fun onClick(view: View) {
        runCatching { onClickCatching(view) }
            .onFailure { XposedBridge.log(it) }
    }

    private fun onClickCatching(view: View) {
        if (false) {
            XuiClientWrapper.getInstance().startWaitingMode(/* screenId = */ 0)
        } else {
            ComboNode().openWaitMode(/* needTTS = */ true)
        }
        QuickMenuPresenterManager.getInstance().autoHideQuickMenu(/* screenIndex = */ 0)
    }

}
