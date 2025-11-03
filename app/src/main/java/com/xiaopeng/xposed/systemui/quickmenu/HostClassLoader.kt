package com.xiaopeng.xposed.systemui.quickmenu

import org.joor.Reflect
import java.net.URL
import kotlin.collections.any
import kotlin.jvm.Throws
import kotlin.jvm.java
import kotlin.jvm.javaClass
import kotlin.text.startsWith

class HostClassLoader(
    private val mHostClassLoader: ClassLoader,
    private val mParentClassLoader: ClassLoader
) : ClassLoader() {

    companion object {
        fun injectClassLoader(hostClassLoader: ClassLoader) {
            val selfClassLoader: ClassLoader = requireNotNull(HostClassLoader::class.java.classLoader)
            val selfParentClassLoader: ClassLoader = Reflect.on(selfClassLoader).get("parent")

            if (selfParentClassLoader.javaClass != HostClassLoader::class.java) {
                Reflect.on(selfClassLoader).set("parent", HostClassLoader(hostClassLoader, selfParentClassLoader))
            }
        }
    }

    @Throws(exceptionClasses = [ClassNotFoundException::class])
    override fun loadClass(name: String, resolve: Boolean): Class<*> {
        return runCatching { mHostClassLoader.loadClass(name) }.getOrNull()
               ?: mParentClassLoader.loadClass(name)
    }

    override fun getResource(name: String): URL? {
        return mParentClassLoader.getResource(name) ?: mHostClassLoader.getResource(name)
    }

}
