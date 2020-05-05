plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Build.targetSdk)
    buildToolsVersion(Build.buildTool)
    defaultConfig {
        applicationId = "cn.endureblaze.kirby"
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)
        versionCode = Build.versionCode
        versionName = Build.versionName
        vectorDrawables.useSupportLibrary = true
        vectorDrawables.generatedDensities("mdpi", "hdpi", "xhdpi", "xxhdpi")
        resConfigs("zh", "en", "zh-rTW")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isZipAlignEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    implementation(project(":utils"))
    implementation(project(":theme"))
    implementation(project(":customview"))

    implementation(Deps.Kotlin.stdlib)

    implementation("cn.bmob.android:bmob-sdk:3.7.8")

    implementation("io.reactivex.rxjava2:rxjava:2.2.9")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.squareup.okhttp3:okhttp:4.1.1")
    implementation("com.squareup.okio:okio:2.2.2")
    implementation("com.google.code.gson:gson:2.8.6")

    //刷新
    implementation("com.scwang.smart:refresh-layout-kernel:2.0.0")
    implementation("com.scwang.smart:refresh-header-material:2.0.0")
    //保险套
    implementation(Deps.Oasisfeng.condom)
    //Gilde
    implementation(Deps.Gilde.gilde)
    annotationProcessor(Deps.Gilde.compiler)
    implementation("com.github.EndureBlaze:GlideCache:1.2")
    //androidx
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.preference:preference:1.1.1")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.1.0")
    implementation("com.google.android.material:material:1.2.0-alpha06")

    //test
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.runner)
    androidTestImplementation(Deps.Test.ext_unit)
    androidTestImplementation(Deps.Test.espresso)
}
