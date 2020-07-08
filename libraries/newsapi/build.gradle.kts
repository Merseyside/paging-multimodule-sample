import core.dependencies.Dependencies

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

dependencies {
    implementation(project(BuildModules.Libraries.MerseyLibs.utils))
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.5.0")

    libraries.forEach { lib -> implementation(lib)}
}