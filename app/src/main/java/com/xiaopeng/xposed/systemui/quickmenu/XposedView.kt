package com.xiaopeng.xposed.systemui.quickmenu

import android.annotation.SuppressLint
import android.content.Context
import android.os.PowerManager
import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import com.xiaopeng.systemui.quickmenu.QuickMenuPresenterManager
import com.xiaopeng.systemui.quickmenu.widgets.XTileButton
import org.joor.Reflect

class XposedView {

    private var mViewQuickMenuScreenOff: XTileButton? = null

    fun initView(layoutView: View) {
        initViewQuickMenuVerticalFlexboxLayout1(layoutView)
    }

    fun themeChanged() {
        mViewQuickMenuScreenOff?.refreshTheme()
    }

    @Synchronized
    private fun initViewQuickMenuVerticalFlexboxLayout1(layoutView: View) {
        if (mViewQuickMenuScreenOff != null) {
            return
        }

        val context: Context = layoutView.context
        val quickMenuVerticalFlexboxLayout1: ViewGroup = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_vertical_flexboxlayout_1"))

        /**
         * <com.xiaopeng.systemui.quickmenu.widgets.XTileButton
         *     android:id="@+id/quick_menu_360"
         *     android:layout_width="wrap_content"
         *     android:layout_height="wrap_content"
         *     app:tile_background="@drawable/quick_menu_layout_drawable"
         *     app:tile_image="@drawable/ic_qs_360_small"
         *     app:tile_orientation="horizontal"
         *     app:tile_text="@string/qs_panel_360"
         *     app:tile_textColor="@color/quick_menu_tile_text_color"/>
         */
        val quickMenuScreenOff = XTileButton(context)
        mViewQuickMenuScreenOff = quickMenuScreenOff
        quickMenuScreenOff.id = View.generateViewId()
        quickMenuScreenOff.setBackgroundRes(context.getResourceId(type = "drawable", name = "quick_menu_layout_drawable"))
        quickMenuScreenOff.setImageResource(context.getResourceId(type = "drawable", name = "ic_qs_screenoff00"))
        quickMenuScreenOff.setTextRes(context.getResourceId(type = "string", name = "qs_panel_psn_screenoff"))
        quickMenuScreenOff.setTextColor(context.getResourceId(type = "color", name = "quick_menu_tile_text_color"))
        quickMenuScreenOff.cloneVuiByView(view = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_360")))
        quickMenuScreenOff.setOnClickListener(mOnClickQuickMenuScreenOffListener)
        quickMenuScreenOff.setText(text = "关闭屏幕")
        quickMenuScreenOff.refreshTheme()

        quickMenuVerticalFlexboxLayout1.addView(quickMenuScreenOff)
    }

    private fun XTileButton.cloneVuiByView(view: View) {
        val targetAttributeSet: HashMap<String, Integer> = Reflect.on(view)
            .field("mThemeViewModel")
            .field("mAttributeSet")
            .get()

        val selfAttributeSet: HashMap<String, Integer> = Reflect.on(this)
            .field("mThemeViewModel")
            .field("mAttributeSet")
            .get()

        selfAttributeSet.putAll(targetAttributeSet)
    }

    private fun XTileButton.setText(text: String) {
        Reflect.on(this).field("mTextView").call("setText", text)
    }

    @SuppressLint("DiscouragedApi")
    private fun Context.getResourceId(type: String, name: String): Int {
        return resources.getIdentifier(name, type, packageName)
    }

    private val mOnClickQuickMenuScreenOffListener: View.OnClickListener = View.OnClickListener {
        val context: Context = it.context

        QuickMenuPresenterManager.getInstance().autoHideQuickMenu(0)

        // xp_mt_ivi = 娱乐大屏
        // xp_mt_psg = 副驾屏幕
        val powerManager: PowerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        Reflect.on(powerManager).call("setXpScreenOff", "xp_mt_ivi", SystemClock.uptimeMillis())
    }

}
