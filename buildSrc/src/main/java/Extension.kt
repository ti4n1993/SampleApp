import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

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