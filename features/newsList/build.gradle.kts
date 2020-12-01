import core.dependencies.Dependencies
import core.isLocalDependencies

plugins {
    plugin(BuildPlugins.dynamicFeature)
}

android {
    sourceSets.getByName("main") {
        res.srcDir("src/main/res/")
        res.srcDir("src/main/res/layouts/activity")
        res.srcDir("src/main/res/layouts/fragment")
        res.srcDir("src/main/res/layouts/views")
    }
}

val merseyModules = listOf(
    BuildModules.Libraries.MerseyLibs.archy,
    BuildModules.Libraries.MerseyLibs.adapters,
    BuildModules.Libraries.MerseyLibs.utils
)

val merseyLibs = listOf(
    Dependencies.MerseyLibs.archy,
    Dependencies.MerseyLibs.adapters,
    Dependencies.MerseyLibs.utils
)

val libs = listOf(
    Dependencies.LIVEDATA_KTX,
    Dependencies.LIFECYCLE_VIEWMODEL
)

dependencies {
    if (isLocalDependencies()) {
        merseyModules.forEach { module -> api(project(module)) }
    } else {
        merseyLibs.forEach { lib -> api(lib) }
    }

    libs.forEach { lib -> implementation(lib)}
}
