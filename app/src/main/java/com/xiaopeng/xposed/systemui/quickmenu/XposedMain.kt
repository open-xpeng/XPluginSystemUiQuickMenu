package com.xiaopeng.xposed.systemui.quickmenu

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.xiaopeng.xposed.systemui.quickmenu.extensions.getResourceId
import com.xiaopeng.xposed.systemui.quickmenu.views.QuickMenuViewOs
import com.xiaopeng.xposed.systemui.quickmenu.views.QuickMenuViewOs37
import com.xiaopeng.xposed.systemui.quickmenu.views.QuickMenuViewOs50
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import org.joor.Reflect

class XposedMain : IXposedHookLoadPackage {

    private var mQuickMenuViewOs: QuickMenuViewOs? = null

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        runCatching { handleLoadPackageCatching(loadPackageParam = lpparam) }
            .onFailure { XposedBridge.log(/* t = */ it) }
    }

    private fun handleLoadPackageCatching(loadPackageParam: XC_LoadPackage.LoadPackageParam) {
        HostClassLoader.injectClassLoader(hostClassLoader = requireNotNull(loadPackageParam.classLoader))

        XposedHelpers.findAndHookMethod(
            /* className    = */ "com.xiaopeng.systemui.quickmenu.QuickMenuVerticalViewHolder",
            /* classLoader  = */ loadPackageParam.classLoader,
            /* methodName   = */ "initView",
            /* ...parameterTypesAndCallback = */ mHookQuickMenuVerticalViewHolderInitView
        )
        XposedHelpers.findAndHookMethod(
            /* className    = */ "com.xiaopeng.systemui.quickmenu.QuickMenuVerticalViewHolder",
            /* classLoader  = */ loadPackageParam.classLoader,
            /* methodName   = */ "themeChanged",
            /* ...parameterTypesAndCallback = */ mHookQuickMenuVerticalViewHolderThemeChanged
        )

        XposedHelpers.findAndHookMethod(
            /* className    = */ "com.xiaopeng.systemui.quickmenu.widgets.XTileButton",
            /* classLoader  = */ loadPackageParam.classLoader,
            /* methodName   = */ "init",
            /* ...parameterTypesAndCallback = */ mHookXTileButtonInit
        )
    }

    private val mHookQuickMenuVerticalViewHolderInitView: XC_MethodHook = object : XCMethodHookCatching() {

        override fun beforeHookedMethodCatching(param: MethodHookParam) {
            super.beforeHookedMethodCatching(param)
            val layoutView: View = Reflect.on(param.thisObject).get("mView")

            /* 防止重复加载 */
            if (mQuickMenuViewOs != null) {
                return
            }

            val isOs50: Boolean = try {
                param.thisObject.javaClass.classLoader?.loadClass(/* name = */ "com.xiaopeng.systemui.quickmenu.widgets.DockXTileButton")
                true
            } catch (_: Exception) {
                false
            }
            mQuickMenuViewOs = when (isOs50) {
                true  -> QuickMenuViewOs50()
                false -> QuickMenuViewOs37()
            }

            XposedBridge.log(/* text = */ "QuickMenuVerticalViewHolder.initView, quick menu=$mQuickMenuViewOs")
            val mQuickMenuViewOs = mQuickMenuViewOs
            if (mQuickMenuViewOs == null) {
                XposedBridge.log(/* text = */ "QuickMenuVerticalViewHolder.initView, quick menu=null")
                return
            }

            val context: Context = layoutView.context
            val quickMenuVerticalFlexboxLayout1: ViewGroup = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_vertical_flexboxlayout_1"))
            mQuickMenuViewOs.init(layoutView = quickMenuVerticalFlexboxLayout1)
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
            mQuickMenuViewOs?.refreshTheme()
        }
    }


}
