
import core.dependencies.Dependencies
import core.dependencies.AnnotationProcessorsDependencies
import core.extensions.implementation
import core.extensions.kapt
import core.isLocalDependencies

plugins {
    id("core.commons.android-library")
}

val merseyModules = listOf(
    BuildModules.Libraries.MerseyLibs.archy,
    BuildModules.Libraries.MerseyLibs.utils
)

val merseyLibs = listOf(
    Dependencies.MerseyLibs.archy,
    Dependencies.MerseyLibs.utils
)

dependencies {
    implementation(project(BuildModules.CORE))

    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.RECYCLE_VIEW)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.PAGING)

    if (isLocalDependencies()) {
        merseyModules.forEach { module -> api(project(module)) }
    } else {
        merseyLibs.forEach { lib -> api(lib) }
    }

    kapt(AnnotationProcessorsDependencies.DATABINDING)
}
