plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Build.targetSdk)
    buildToolsVersion(Build.buildTool)

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation(Deps.Kotlin.stdlib)

    implementation ("androidx.appcompat:appcompat:1.1.0")
    implementation ("androidx.core:core-ktx:1.2.0")
    //test
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.runner)
    androidTestImplementation(Deps.Test.ext_unit)
    androidTestImplementation(Deps.Test.espresso)
}
