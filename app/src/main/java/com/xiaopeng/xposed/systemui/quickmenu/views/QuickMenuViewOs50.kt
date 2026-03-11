package com.xiaopeng.xposed.systemui.quickmenu.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.content.res.ColorStateList
import com.xiaopeng.libtheme.ThemeManager
import com.xiaopeng.systemui.quickmenu.widgets.DockXTileButton
import com.xiaopeng.xposed.systemui.quickmenu.clicks.OnClickQuickMenuScreenOffListener
import com.xiaopeng.xposed.systemui.quickmenu.clicks.OnClickQuickMenuWaitModeListener
import com.xiaopeng.xposed.systemui.quickmenu.extensions.getResourceId
import org.joor.Reflect
import androidx.core.graphics.toColorInt

class QuickMenuViewOs50: QuickMenuViewOs {

    private var mViewQuickMenuScreenOff: DockXTileButton? = null
    private var mViewQuickMenuWaitMode: DockXTileButton? = null

    override fun init(layoutView: ViewGroup) {
        if (mViewQuickMenuScreenOff != null) {
            return
        }
        val context: Context = layoutView.context

        /**
         * <com.xiaopeng.systemui.quickmenu.widgets.DockXTileButton
         *     android:id="@+id/quick_menu_360"
         *     android:layout_width="@dimen/dock_quick_menu_item_width"
         *     android:layout_height="@dimen/dock_quick_menu_item_height"
         *     app:tile_background="@drawable/dock_quick_menu_layout_drawable"
         *     app:tile_image="@drawable/dock_ic_qs_360_small"
         *     app:tile_orientation="vertical"
         *     app:tile_text="@string/qs_panel_360"
         *     app:tile_textColor="@color/dock_quick_menu_tile_text_color"/>
         */
        val quickMenuScreenOff = DockXTileButton(context)
        mViewQuickMenuScreenOff = quickMenuScreenOff
        quickMenuScreenOff.id = View.generateViewId()
        quickMenuScreenOff.setBackgroundRes(context.getResourceId(type = "drawable", name = "dock_quick_menu_layout_drawable"))
        quickMenuScreenOff.setImageResource(context.getResourceId(type = "drawable", name = "ic_qs_screenoff00"))
        quickMenuScreenOff.setTextRes(context.getResourceId(type = "string", name = "qs_panel_psn_screenoff"))
        quickMenuScreenOff.setTextColor(context.getResourceId(type = "color", name = "dock_quick_menu_tile_text_color"))
        quickMenuScreenOff.cloneVuiByView(view = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_360")))
        quickMenuScreenOff.setOnClickListener(OnClickQuickMenuScreenOffListener)
        quickMenuScreenOff.setText(text = "关闭屏幕")
        quickMenuScreenOff.refreshTheme()

        val viewParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            /* width  = */ context.resources.getDimension(/* id = */ context.getResourceId(type = "dimen", name = "dock_quick_menu_item_width")).toInt(),
            /* height = */ context.resources.getDimension(/* id = */ context.getResourceId(type = "dimen", name = "dock_quick_menu_item_height")).toInt()
        )
        layoutView.addView(/* child = */ quickMenuScreenOff, /* params = */ viewParams)

        val quickMenuWaitMode = DockXTileButton(context)
        mViewQuickMenuWaitMode = quickMenuWaitMode
        quickMenuWaitMode.id = View.generateViewId()
        quickMenuWaitMode.setBackgroundRes(context.getResourceId(type = "drawable", name = "dock_quick_menu_layout_drawable"))
        quickMenuWaitMode.setImageResource(context.getResourceId(type = "drawable", name = "dock_ic_category_more_parking"))
        quickMenuWaitMode.setTextRes(context.getResourceId(type = "string", name = "qs_panel_psn_screenoff"))
        quickMenuWaitMode.setTextColor(context.getResourceId(type = "color", name = "dock_quick_menu_tile_text_color"))
        quickMenuWaitMode.cloneVuiByView(view = layoutView.findViewById(context.getResourceId(type = "id", name = "quick_menu_360")))
        quickMenuWaitMode.setOnClickListener(OnClickQuickMenuWaitModeListener)
        quickMenuWaitMode.setText(text = "等人模式")
        quickMenuWaitMode.refreshTheme()

        layoutView.addView(/* child = */ quickMenuWaitMode, /* params = */ viewParams)
    }

    override fun refreshTheme() {
        mViewQuickMenuScreenOff?.refreshTheme()
        //mViewQuickMenuScreenOff?.updateImageTineColor()
        mViewQuickMenuWaitMode?.refreshTheme()
        //mViewQuickMenuWaitMode?.updateImageTineColor()
    }

    private fun DockXTileButton.cloneVuiByView(view: View) {
        val targetAttributeSet: HashMap<String, Int> = Reflect.on(view)
            .field("mThemeViewModel")
            .field("mAttributeSet")
            .get()

        val selfAttributeSet: HashMap<String, Int> = Reflect.on(this)
            .field("mThemeViewModel")
            .field("mAttributeSet")
            .get()

        selfAttributeSet.putAll(targetAttributeSet)
    }

    private fun DockXTileButton.setText(text: String) {
        Reflect.on(this).field("mTextView").call("setText", text)
    }

    private fun DockXTileButton.updateImageTineColor() {
        val context: Context = this.context
        val isDarkMode: Boolean = ThemeManager.getUiMode(context) == ThemeManager.UI_MODE_NIGHT_YES
        val color:Int = when(isDarkMode) {
            true  -> "#FFFFFFFF".toColorInt()
            false -> "#FF272a33".toColorInt()
        }

        val mImageView: ImageView = Reflect.on(this).field("mImageView").get()
        mImageView.imageTintList = ColorStateList.valueOf(color)
    }

}
