plugins {
    id("com.android.application") version "8.1.0" apply false
    kotlin("android") version "1.8.20" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
