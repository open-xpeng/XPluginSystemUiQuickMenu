import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.xiaopeng.xposed.systemui.quickmenu"
    compileSdk {
        version = release(libs.versions.sdkCompile.get().toInt())
    }
    defaultConfig {
        applicationId = "com.xiaopeng.xposed.systemui.quickmenu"
        minSdk = libs.versions.sdkMin.get().toInt()
        targetSdk = libs.versions.sdkTarget.get().toInt()
        versionCode = 3
        versionName = "1.0.2"
        multiDexEnabled = false
        setProperty("archivesBaseName", "XPluginSystemUiQuickMenu-$versionName-$versionCode-" + SimpleDateFormat("yyyyMMdd").format(Date()))
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = false
        buildConfig = false
    }
    packagingOptions {
        resources.excludes.add("kotlin/**")
        resources.excludes.add("kotlin-tooling-metadata.json")
        resources.excludes.add("DebugProbesKt.bin")
        resources.excludes.add("META-INF/README.txt")
        resources.excludes.add("META-INF/com/android/**")
        resources.excludes.add("META-INF/version-control-info.textproto")
    }
    signingConfigs {
        getByName("debug") {
            storeFile = file("app.jks")
            storePassword = "123456"
            keyAlias = "debug"
            keyPassword = "123456"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
        create("release") {
            storeFile = file("app.jks")
            storePassword = "123456"
            keyAlias = "release"
            keyPassword = "12345678900."
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"), file("proguard-log.pro"))
            isShrinkResources = true
        }
    }
}

dependencies {
    implementation(libs.common.joor)

    compileOnly(project(":stub-api"))
    compileOnly(libs.androidx.core.ktx)
    compileOnly(libs.androidx.appcompat)
    compileOnly(libs.androidx.constraint)
    compileOnly(libs.common.xposed)
    compileOnly(libs.common.framework)
}
