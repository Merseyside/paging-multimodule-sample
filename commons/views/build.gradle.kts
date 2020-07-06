

import core.dependencies.Dependencies
import core.dependencies.AnnotationProcessorsDependencies
import core.extensions.implementation
import core.extensions.kapt

plugins {
    id("core.commons.android-library")
}

dependencies {
    implementation(project(BuildModules.Commons.UI))

    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.FRAGMENT_KTX)

    implementation(project(BuildModules.Libraries.MerseyLibs.utils))

    kapt(AnnotationProcessorsDependencies.DATABINDING)
}
