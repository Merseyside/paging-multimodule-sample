

import core.dependencies.Dependencies
import core.dependencies.AnnotationProcessorsDependencies
import core.extensions.implementation
import core.extensions.kapt

plugins {
    id("core.commons.android-library")
}

dependencies {
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER)
    implementation(Dependencies.LOGGING)

    implementation(project(BuildModules.Libraries.MerseyLibs.archy))
    implementation(project(BuildModules.Libraries.MerseyLibs.utils))

    kapt(AnnotationProcessorsDependencies.DATABINDING)
    kapt(AnnotationProcessorsDependencies.ROOM)
}
