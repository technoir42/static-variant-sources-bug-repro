import org.gradle.configurationcache.extensions.capitalized

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

androidComponents {
    onVariants { variant ->
        tasks.register("myTask${variant.name.capitalized()}") {
            onlyIf { variant.sources.java!!.static.get().any { it.asFileTree.files.isNotEmpty() } }
            doLast {
                logger.lifecycle("Hello, world")
            }
        }
    }
}
