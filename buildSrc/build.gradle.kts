
plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    jcenter()
    google()
    mavenCentral()

    maven("https://dl.bintray.com/icerockdev/plugins")
    maven("https://plugins.gradle.org/m2/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://ci.android.com/builds/submitted/5837096/androidx_snapshot/latest/repository")
}

val kotlin = "1.4.20"
val gradle = "4.0.1"
val multiplatform = "0.6.1"
val mavenVersion = "2.1"
val navigation = "2.3.0-alpha02"
val graphGenerator = "0.6.0-SNAPSHOT"
val detect = "1.2.2"
val ktlint = "0.36.0"
val gradleVersions = "0.27.0"


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("com.android.tools.build:gradle:$gradle")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:$navigation")
    implementation("com.github.dcendents:android-maven-gradle-plugin:$mavenVersion")
    implementation("dev.icerock:mobile-multiplatform:$multiplatform")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detect")
    implementation("com.pinterest:ktlint:$ktlint")
    implementation("com.github.ben-manes:gradle-versions-plugin:$gradleVersions")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}