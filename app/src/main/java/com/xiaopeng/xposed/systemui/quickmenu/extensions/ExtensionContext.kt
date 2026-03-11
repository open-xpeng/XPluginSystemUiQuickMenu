package com.xiaopeng.xposed.systemui.quickmenu.extensions

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint(value = ["DiscouragedApi"])
fun Context.getResourceId(type: String, name: String): Int {
    return resources.getIdentifier(/* name = */ name, /* defType = */ type, /* defPackage = */ packageName)
}

