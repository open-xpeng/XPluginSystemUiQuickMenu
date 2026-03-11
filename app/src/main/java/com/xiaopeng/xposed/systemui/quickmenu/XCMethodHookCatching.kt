package com.xiaopeng.xposed.systemui.quickmenu

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge

open class XCMethodHookCatching : XC_MethodHook() {
    final override fun beforeHookedMethod(param: MethodHookParam) {
        super.beforeHookedMethod(param)
        runCatching { beforeHookedMethodCatching(param) }
            .onFailure { XposedBridge.log(/* t = */ it) }
    }

    open fun beforeHookedMethodCatching(param: MethodHookParam) {
    }

    final override fun afterHookedMethod(param: MethodHookParam) {
        super.afterHookedMethod(param)
        runCatching { afterHookedMethodCatching(param) }
            .onFailure { XposedBridge.log(/* t = */ it) }
    }

    open fun afterHookedMethodCatching(param: MethodHookParam) {
    }
}
