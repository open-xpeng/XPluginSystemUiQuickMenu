package com.xiaopeng.xposed.systemui.quickmenu.clicks

import android.view.View
import com.xiaopeng.systemui.carmanager.XuiClientWrapper
import com.xiaopeng.systemui.quickmenu.QuickMenuPresenterManager

object OnClickQuickMenuWaitModeListener : View.OnClickListener {
    override fun onClick(view: View) {
        XuiClientWrapper.getInstance().startWaitingMode(/* screenId = */ 0)
        QuickMenuPresenterManager.getInstance().autoHideQuickMenu(/* screenIndex = */ 0)
    }
}
