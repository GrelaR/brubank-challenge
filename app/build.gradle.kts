plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinKsp)
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.brubankchallenge"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.brubankchallenge"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField(
            "String",
            "API_ACCESS_TOKEN",
            "\"${project.findProperty("API_ACCESS_TOKEN")}\""
        )
        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://api.themoviedb.org/3/\""
        )
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // dagger-hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    // Retrofit
    implementation(libs.retrofit)
    // Retrofit with Scalar Converter
    implementation(libs.gson)
    //gson converter
    implementation(libs.converter.gson)
    // Compose Navigation
    implementation(libs.androidx.navigation.compose.v240)

    // Compose livedata
    implementation(libs.androidx.runtime.livedata)

    // Integration with ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Glide
    implementation(libs.compose)

    // Palette
    implementation(libs.androidx.palette.ktx)

    // Pagination
    implementation(libs.androidx.paging.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.paging.runtime)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

}

