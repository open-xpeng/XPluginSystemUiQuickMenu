package com.xiaopeng.xposed.systemui.quickmenu.clicks

import android.content.Context
import android.os.PowerManager
import android.os.SystemClock
import android.view.View
import com.xiaopeng.systemui.quickmenu.QuickMenuPresenterManager
import org.joor.Reflect

object OnClickQuickMenuScreenOffListener: View.OnClickListener {
    override fun onClick(view: View) {
        QuickMenuPresenterManager.getInstance().autoHideQuickMenu(/* screenIndex = */ 0)

        // xp_mt_ivi = 娱乐大屏
        // xp_mt_psg = 副驾屏幕
        val powerManager: PowerManager = view.context.getSystemService(/* p0 = */ Context.POWER_SERVICE) as PowerManager
        Reflect.on(powerManager).call("setXpScreenOff", "xp_mt_ivi", SystemClock.uptimeMillis())
    }
}
