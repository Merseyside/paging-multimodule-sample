/**
 * Configuration of all gradle build plugins
 */
object BuildPlugins {
    val androidApplication = PluginDesc(id = "com.android.application")
    val androidLibrary = PluginDesc(id = "com.android.library")
    val commonsAndroidLibrary = PluginDesc(id = "core.commons.android-library")
    val dynamicFeature = PluginDesc(id = "core.commons.android-dynamic-feature")
    val kotlinKapt = PluginDesc(id = "kotlin-kapt")
    val kotlinAndroid = PluginDesc(id = "kotlin-android")
    val detekt = PluginDesc(id = "plugins.detekt")
    val navigationArgs = PluginDesc(id = "androidx.navigation.safeargs.kotlin")

    val kotlinSerialization = PluginDesc(
        id = "kotlinx-serialization",
        module = "org.jetbrains.kotlin:kotlin-serialization:${LibraryVersions.Plugins.serialization}"
    )
}
