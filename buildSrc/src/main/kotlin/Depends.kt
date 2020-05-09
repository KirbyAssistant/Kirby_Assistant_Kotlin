import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

object Deps {

    object AndroidX {
        const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
        const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
        const val preference = "androidx.preference:preference:${Versions.preference}"
        const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorlayout}"
    }

    object Oasisfeng {
        const val condom = "com.oasisfeng.condom:library:${Versions.condom}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val runner = "androidx.test:runner:${Versions.runner}"
        const val ext_unit = "androidx.test.ext:junit:${Versions.runner}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    fun addRepos(handler: RepositoryHandler) {
        handler.apply {
            //google()
            //jcenter()
            maven { setUrl("https://jitpack.io") }
            maven { setUrl("https://maven.aliyun.com/repository/google") }
            maven { setUrl("https://maven.aliyun.com/repository/jcenter") }
            maven { setUrl("https://dl.bintray.com/chaozhouzhang/maven") }
            maven { setUrl("https://jitpack.io") }
            //mavenCentral()
        }
    }
}

fun DependencyHandlerScope.addCommonDeps() {
    //test
    "testImplementation"(Deps.Test.junit)
    "androidTestImplementation"(Deps.Test.runner)
    "androidTestImplementation"(Deps.Test.ext_unit)
    "androidTestImplementation"(Deps.Test.espresso)
    //module
    "implementation"(project(":app"))
    //"kapt"(Deps.Arouter.compiler)
    //"kapt"(Deps.Room.compiler)
}