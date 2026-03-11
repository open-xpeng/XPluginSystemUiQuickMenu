plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.xiaopeng.xposed.systemui.quickmenu"
    compileSdk {
        version = release(version = libs.versions.sdkCompile.get().toInt())
    }
    defaultConfig {
        applicationId = "com.xiaopeng.xposed.systemui.quickmenu"
        minSdk = libs.versions.sdkMin.get().toInt()
        targetSdk = libs.versions.sdkTarget.get().toInt()
        versionCode = rootProject.extra["BuildVersionCode"] as Int
        versionName = rootProject.extra["BuildVersionName"] as String
        multiDexEnabled = false
        base.archivesName = "XPluginSystemUiQuickMenu-$versionName-$versionCode"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = false
        buildConfig = false
    }
    packaging {
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
            keyPassword = rootProject.extra["BuildReleasePassword"] as String
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

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    implementation(libs.common.joor)

    compileOnly(project(":stub-api"))
    compileOnly(libs.androidx.core.ktx)
    compileOnly(libs.androidx.appcompat)
    compileOnly(libs.androidx.constraint)

    compileOnly(libs.xpeng.car)
    compileOnly(libs.xpeng.xui)
    compileOnly(libs.xpeng.xui.manager)

    compileOnly(libs.common.xposed)
    compileOnly(libs.common.framework)
}
