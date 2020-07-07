import core.dependencies.Dependencies

plugins {
    id("core.commons.android-dynamic-feature")
}

android {
    sourceSets.getByName("main") {
        res.srcDir("src/main/res/")
        res.srcDir("src/main/res/layouts/fragment")
        res.srcDir("src/main/res/layouts/views")
    }
}

dependencies {
    implementation(project(BuildModules.Libraries.MerseyLibs.adapters))
}
