import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.jetpack() {
    implementation(Libraries.coreKtx)
    implementation(Libraries.activity)
    implementation(Libraries.appcompat)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.room)
//    implementation(Libraries.livedataKtx)
    implementation(Libraries.viewModelKtx)
    implementation(Libraries.paging)
    implementation(Libraries.dataStore)
    implementation(Libraries.hilt)
}

fun DependencyHandler.compose() {
    implementation("androidx.compose.ui:ui:${Versions.compose}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${Versions.compose}")
    // Material Design
    implementation("androidx.compose.material:material:${Versions.compose}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${Versions.compose}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.compose}")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha06")
}

fun DependencyHandler.accompanist() {
    implementation("com.google.accompanist:accompanist-pager:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-permissions:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-placeholder:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-insets:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}")
    implementation("com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}")
}

fun DependencyHandler.coil() {
    implementation("io.coil-kt:coil-compose:1.3.1")
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

fun DependencyHandler.kapt() {
    kapt(AnnotationProcessors.hilt)
    kapt(AnnotationProcessors.room)
}

fun DependencyHandler.test() {
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.kotlinCoroutinesTest)
    androidTestImplementation(InstrumentedTestLibraries.junit)
    androidTestImplementation(InstrumentedTestLibraries.espresso)
}

fun DependencyHandler.log() {
    implementation(Libraries.timber)
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? {
    return add("kapt", dependencyNotation)
}

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? {
    return add("testImplementation", dependencyNotation)
}

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? {
    return add("androidTestImplementation", dependencyNotation)
}