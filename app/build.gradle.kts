plugins {
    id("com.android.application")
    kotlin("android") version "1.9.0"  // Обновленная версия Kotlin
}

android {
    namespace = "com.pashgulyash.whispnote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pashgulyash.whispnote"
        minSdk = 21
        targetSdk = 34  // Рекомендуется выровнять с compileSdk
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables.useSupportLibrary = true  // Для векторной графики
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    packaging {
        resources.excludes.add("META-INF/*.kotlin_module")
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    
    // UI
    implementation("com.google.android.material:material:1.10.0")  // Обновленная версия
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")  // Добавлен ConstraintLayout
    
    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    
    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    
    // Database
    implementation("androidx.sqlite:sqlite-ktx:2.4.0")  // Для работы с SQLite
}
