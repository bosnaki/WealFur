plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.wealfur"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wealfur"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val roomVersion = "2.6.1"
    val fragment_version = "1.8.3"
    val lifecycle_version = "2.2.0"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
    
    //ROOM
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor ("androidx.room:room-compiler:$roomVersion")

    //fragments
    implementation("androidx.fragment:fragment:$fragment_version")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}