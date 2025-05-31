plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.pashgulyash.whispnote"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.pashgulyash.whispnote"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.9.0")
}
