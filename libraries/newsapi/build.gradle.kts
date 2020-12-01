import core.dependencies.Dependencies
import core.isLocalDependencies

plugins {
    plugin(BuildPlugins.commonsAndroidLibrary)
}

android {
    defaultConfig {
        buildConfigField("String", "BASE_URL",
            "\"https://newsapi.org/v2/\"")

        buildConfigField("String", "PLATFORM", "\"android\"")
        buildConfigField("String", "FROM", "\"2019-04-00\"")
        buildConfigField("String", "SORT_BY", "\"publishedAt\"")
        buildConfigField("String", "API_KEY", "\"26eddb253e7840f988aec61f2ece2907\"")
    }
}

val libraries = listOf(
    Dependencies.RETROFIT,
    Dependencies.RETROFIT_CONVERTER
)

val merseyModules = listOf(
    BuildModules.Libraries.MerseyLibs.utils
)

val merseyLibs = listOf(
    Dependencies.MerseyLibs.utils
)

dependencies {
    if (isLocalDependencies()) {
        merseyModules.forEach { module -> api(project(module)) }
    } else {
        merseyLibs.forEach { lib -> api(lib) }
    }

    implementation(Dependencies.RETROFIT_SERIALIZATION)

    libraries.forEach { lib -> implementation(lib)}
}