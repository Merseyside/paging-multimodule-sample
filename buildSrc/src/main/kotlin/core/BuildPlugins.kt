

/**
 * Configuration of all gradle build plugins
 */
object BuildPlugins {
    val androidApplication = PluginDesc(id = "com.android.application")
    val androidLibrary = PluginDesc(id = "com.android.library")
    val commonsAndroidLibrary = PluginDesc(id = "core.commons.android-library")
    val kotlinKapt = PluginDesc(id = "kotlin-kapt")
    val kotlinAndroid = PluginDesc(id = "kotlin-android")
    val kotlinAndroidExtensions = PluginDesc(id = "kotlin-android-extensions")
    val mobileMultiplatform = PluginDesc(id = "dev.icerock.mobile.multiplatform")
    val dynamicFeature = PluginDesc(id = "com.android.dynamic-feature")
    val updateDependencies = PluginDesc(id = "plugins.update-dependencies")
    val detekt = PluginDesc(id = "plugins.detekt")
    val navigationArgs = PluginDesc(id = "androidx.navigation.safeargs.kotlin")


    val kotlinMultiplatform = PluginDesc(
        id = "org.jetbrains.kotlin.multiplatform",
        module = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibraryVersions.Plugins.kotlin}"
    )

    val kotlinSerialization = PluginDesc(
        id = "kotlinx-serialization",
        module = "org.jetbrains.kotlin:kotlin-serialization:${LibraryVersions.Plugins.serialization}"
    )
}
