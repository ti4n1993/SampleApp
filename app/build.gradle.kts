plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.21"
}

android {

    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = "com.ti4n.sampleapp"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
        dataBinding = true
    }
}

kapt{
    correctErrorTypes = true
}

dependencies {
    kotlin()
    jetpack()
    epoxy()
    network()
    dialog()
    kapt()
    test()
    glide()
    log()
}

fun DependencyHandler.jetpack() {
    implementation(Libraries.coreKtx)
    implementation(Libraries.activity)
    implementation(Libraries.appcompat)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.material)
    implementation(Libraries.fragmentKtx)
    implementation(Libraries.recyclerview)
    implementation(Libraries.room)
//    implementation(Libraries.livedataKtx)
    implementation(Libraries.viewModelKtx)
    implementation(Libraries.viewModelSavedState)
    implementation(Libraries.runtimeKtx)
    implementation(Libraries.paging)
    implementation(Libraries.dataStore)
    implementation(Libraries.hilt)
}

fun DependencyHandler.epoxy() {
    implementation(Libraries.epoxy)
    implementation(Libraries.epoxyDatabinding)
    implementation(Libraries.epoxyPaging)
}

fun DependencyHandler.kotlin() {
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.kotlinSerialize)
    implementation(Libraries.anko)
}

fun DependencyHandler.network() {
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitKS)
    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpLogging)
}

fun DependencyHandler.dialog() {
    implementation(Libraries.dialog)
    implementation(Libraries.dialogLifecycle)
}

fun DependencyHandler.kapt() {
    kapt(AnnotationProcessors.epoxy)
    kapt(AnnotationProcessors.hilt)
    kapt(AnnotationProcessors.room)
    kapt(AnnotationProcessors.glide)
}

fun DependencyHandler.test() {
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.kotlinCoroutinesTest)
    androidTestImplementation(InstrumentedTestLibraries.junit)
    androidTestImplementation(InstrumentedTestLibraries.espresso)
}

fun DependencyHandler.glide() {
    implementation(Libraries.glide)
}

fun DependencyHandler.log() {
    implementation(Libraries.timber)
}