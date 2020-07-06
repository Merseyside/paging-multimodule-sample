

import core.dependencies.Dependencies
import core.dependencies.AnnotationProcessorsDependencies
import core.extensions.implementation
import core.extensions.kapt

plugins {
    id("core.commons.android-library")
}

dependencies {
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.RECYCLE_VIEW)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.PAGING)

    implementation(project(BuildModules.Libraries.MerseyLibs.archy))
    implementation(project(BuildModules.Libraries.MerseyLibs.utils))

    kapt(AnnotationProcessorsDependencies.DATABINDING)
}
