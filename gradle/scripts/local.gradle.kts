import java.util.Properties
import java.util.Date
import java.text.SimpleDateFormat

var sProperties: Properties? = null

/**
 * 开发：配置文件
 */
fun getLocalProperties(): Properties {
    if (sProperties != null) {
        return sProperties!!
    }
    sProperties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { sProperties!!.load(it) }
    }
    return sProperties!!
}

/**
 * 获取配置信息，优先系统配置
 */
fun getPropertyFirstSystemEnv(system: String, local: String, default_: String): String {
    val envValue = System.getenv(system)
    if (envValue != null) {
        return envValue
    }
    val properties = getLocalProperties()
    return properties.getProperty(local, default_)
}

/**
 * 构建：正式版版本号
 */
fun getPropertiesBuildVersionCode(): Int {
    val buildVersionCode = getPropertyFirstSystemEnv("BUILD_VERSION_CODE", "build.version.code", "")
    return if (buildVersionCode.isNotEmpty()) {
        buildVersionCode.toInt()
    } else {
        SimpleDateFormat("yyyyMMdd").format(Date()).toInt()
    }
}

/**
 * 构建：正式版版本名
 */
fun getPropertiesBuildVersionName(): String {
    return getPropertyFirstSystemEnv("BUILD_VERSION_NAME", "build.version.name", "1.0.0")
}

/**
 * 构建：正式版密码
 */
fun getPropertiesBuildReleasePassword(): String {
    return getPropertyFirstSystemEnv("BUILD_RELEASE_PASSWORD", "build.release.password", "")
}

extra["BuildVersionCode"]     = getPropertiesBuildVersionCode()
extra["BuildVersionName"]     = getPropertiesBuildVersionName()
extra["BuildReleasePassword"] = getPropertiesBuildReleasePassword()

