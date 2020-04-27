plugins {
    `kotlin-dsl`
}

repositories {
    // The org.jetbrains.kotlin.jvm plugin requires a repository
    // where to download the Kotlin compiler dependencies from.
    //jcenter()
    google()
    maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
}