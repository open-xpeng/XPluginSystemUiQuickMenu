package com.xiaopeng.xposed.systemui.quickmenu.views

import android.view.ViewGroup

interface QuickMenuViewOs {

    fun init(layoutView: ViewGroup)

    fun refreshTheme()

}
