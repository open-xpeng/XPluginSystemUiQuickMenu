package com.xiaopeng.xposed.systemui.quickmenu

import android.view.View
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import org.joor.Reflect

class XposedMain : IXposedHookLoadPackage {

    private val mXposedView: XposedView = XposedView()

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        runCatching { handleLoadPackageCatching(lpparam) }
            .onFailure { XposedBridge.log(it) }
    }

    private fun handleLoadPackageCatching(loadPackageParam: XC_LoadPackage.LoadPackageParam) {
        HostClassLoader.injectClassLoader(hostClassLoader = requireNotNull(loadPackageParam.classLoader))

        XposedHelpers.findAndHookMethod("com.xiaopeng.systemui.quickmenu.QuickMenuVerticalViewHolder", loadPackageParam.classLoader, "initView", mHookQuickMenuVerticalViewHolderInitView)
        XposedHelpers.findAndHookMethod("com.xiaopeng.systemui.quickmenu.QuickMenuVerticalViewHolder", loadPackageParam.classLoader, "themeChanged", mHookQuickMenuVerticalViewHolderThemeChanged)
        XposedHelpers.findAndHookMethod("com.xiaopeng.systemui.quickmenu.widgets.XTileButton", loadPackageParam.classLoader, "init", mHookXTileButtonInit)
    }

    private val mHookQuickMenuVerticalViewHolderInitView: XC_MethodHook = object : XCMethodHookCatching() {

        override fun beforeHookedMethodCatching(param: MethodHookParam) {
            super.beforeHookedMethodCatching(param)
            val layoutView: View = Reflect.on(param.thisObject).get("mView")
            mXposedView.initView(layoutView)
        }
    }

    private val mHookXTileButtonInit: XC_MethodHook = object : XCMethodHookCatching() {
        override fun beforeHookedMethodCatching(param: MethodHookParam) {
            super.beforeHookedMethodCatching(param)

            val thisObject = param.thisObject
            val mOrientation: Int = Reflect.on(thisObject).get("mOrientation")
            val mText: String? = Reflect.on(thisObject).get("mText")
            if (mText == null && mOrientation == 0) {
                Reflect.on(thisObject).set("mOrientation", 1)
            }
        }
    }

    private val mHookQuickMenuVerticalViewHolderThemeChanged: XC_MethodHook = object : XCMethodHookCatching() {
        override fun afterHookedMethodCatching(param: MethodHookParam) {
            super.afterHookedMethodCatching(param)
            mXposedView.themeChanged()
        }
    }


}
