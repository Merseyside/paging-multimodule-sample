

package core.dependencies

/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:${BuildDependenciesVersions.SERIALIZATION}"
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val RECYCLE_VIEW = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLE_VIEW}"
    const val CARD_VIEW = "androidx.cardview:cardview:${BuildDependenciesVersions.CARD_VIEW}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT_KTX}"
    const val CONSTRAIN_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"
    const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${BuildDependenciesVersions.SWIPE_REFRESH_LAYOUT}"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.RETROFIT}"
    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"
    const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.LIVEDATA_KTX}"
    const val COIL = "io.coil-kt:coil:${BuildDependenciesVersions.COIL}"
    const val RETROFIT_SERIALIZATION = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${BuildDependenciesVersions.RETROFIT_SERIALIZATION}"

    object MerseyLibs {
        private val base = "com.github.Merseyside.mersey-android-library"
        val archy = "$base:archy:${BuildDependenciesVersions.MERSEY_LIBS}"
        val adapters = "$base:adapters:${BuildDependenciesVersions.MERSEY_LIBS}"
        val animators = "$base:animators:${BuildDependenciesVersions.MERSEY_LIBS}"
        val utils = "$base:utils:${BuildDependenciesVersions.MERSEY_LIBS}"
    }
    
}
