object Versions {
    // Build tools and SDK
    const val buildTools = "30.0.3"
    const val compileSdk = 30
    const val gradlePlugin = "7.1.0-alpha08"
    const val kotlin = "1.5.21"
    const val minSdk = 26
    const val targetSdk = 30

    // jetpack
    const val activity = "1.3.1"
    const val appcompat = "1.4.0-alpha03"
    const val constraintlayout = "1.0.0-beta02"
    const val core = "1.6.0"
    const val viewModel = "1.0.0-alpha07"
    const val room = "2.4.0-alpha04"
    const val paging = "1.0.0-alpha12"
    const val dataStore = "1.0.0"
    const val compose = "1.1.0-alpha01"
    const val accompanist = "0.16.1"


    //kotlin
    const val kotlinCoroutines = "1.5.1"
    const val kotlinSerializable = "1.2.2"
    const val anko = "0.10.8"


    // Libraries
    const val hilt = "2.38.1"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.1"
    const val converter = "0.8.0"
    const val timber = "4.7.1"

    // Instrumented testing libraries
    const val espresso = "3.4.0"

    // Testing libraries
    const val junit = "4.13"
    const val junitExt = "1.1.3"
}

object AnnotationProcessors {
    const val hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val room = "androidx.room:room-compiler:${Versions.room}"
}

object Libraries {
    const val activity = "androidx.activity:activity-compose:${Versions.activity}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintlayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val paging = "androidx.paging:paging-compose:${Versions.paging}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    const val espressoIdlingResource =
        "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerializable}"
    const val kotlinSerialize =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val anko = "org.jetbrains.anko:anko-commons:${Versions.anko}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitKS =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.converter}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModel}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object InstrumentedTestLibraries {
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junit = "androidx.test.ext:junit:${Versions.junitExt}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
}