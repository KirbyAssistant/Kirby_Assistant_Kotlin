// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        Deps.addRepos(repositories)
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        Deps.addRepos(repositories)
    }
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
