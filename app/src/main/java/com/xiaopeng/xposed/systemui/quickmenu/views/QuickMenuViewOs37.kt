package com.xiaopeng.xposed.systemui.quickmenu.views

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.xiaopeng.systemui.quickmenu.widgets.XTileButton
import com.xiaopeng.xposed.systemui.quickmenu.clicks.OnClickQuickMenuScreenOffListener
import com.xiaopeng.xposed.systemui.quickmenu.clicks.OnClickQuickMenuWaitModeListener
import com.xiaopeng.xposed.systemui.quickmenu.extensions.getResourceId
import org.joor.Reflect

class QuickMenuViewOs37 : QuickMenuViewOs {

    private var mViewQuickMenuScreenOff: XTileButton? = null
    private var mViewQuickMenuWaitMode: XTileButton? = null

    override fun init(layoutView: ViewGroup) {
        if (mViewQuickMenuScreenOff != null) {
            return
        }
        val context: Context = layoutView.context

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
        quickMenuScreenOff.setOnClickListener(OnClickQuickMenuScreenOffListener)
        quickMenuScreenOff.setText(text = "关闭屏幕")
        quickMenuScreenOff.refreshTheme()
        layoutView.addView(quickMenuScreenOff)

        val quickMenuWaitMode = XTileButton(context)
        mViewQuickMenuWaitMode = quickMenuWaitMode
        quickMenuWaitMode.id = View.generateViewId()
        quickMenuWaitMode.setBackgroundRes(context.getResourceId(type = "drawable", name = "quick_menu_layout_drawable"))
        quickMenuWaitMode.setImageResource(context.getResourceId(type = "drawable", name = "ic_qs_wait00"))
        quickMenuWaitMode.setTextRes(context.getResourceId(type = "string", name = "qs_panel_psn_screenoff"))
        quickMenuWaitMode.setTextColor(context.getResourceId(type = "color", name = "quick_menu_tile_text_color"))
        quickMenuWaitMode.cloneVuiByView(view = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_360")))
        quickMenuWaitMode.setOnClickListener(OnClickQuickMenuWaitModeListener)
        quickMenuWaitMode.setText(text = "等人模式")
        quickMenuWaitMode.refreshTheme()

        layoutView.addView(/* child = */ quickMenuWaitMode)
    }

    override fun refreshTheme() {
        mViewQuickMenuScreenOff?.refreshTheme()
        mViewQuickMenuWaitMode?.refreshTheme()
    }

    private fun XTileButton.cloneVuiByView(view: View) {
        val targetAttributeSet: HashMap<String, Int> = Reflect.on(/* object = */ view)
            .field(/* name = */ "mThemeViewModel")
            .field(/* name = */ "mAttributeSet")
            .get()

        val selfAttributeSet: HashMap<String, Int> = Reflect.on(/* object = */ this)
            .field(/* name = */ "mThemeViewModel")
            .field(/* name = */ "mAttributeSet")
            .get()

        selfAttributeSet.putAll(targetAttributeSet)
    }

    private fun XTileButton.setText(text: String) {
        Reflect.on(/* object = */ this).field(/* name = */ "mTextView").call(/* name = */ "setText", /* ...args = */ text)
    }

}
