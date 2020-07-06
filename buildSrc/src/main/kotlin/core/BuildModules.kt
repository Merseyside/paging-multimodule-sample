

/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val HOME = ":features:home"
        const val CHARACTERS_LIST = ":features:characters_list"
        const val CHARACTERS_FAVORITES = ":features:characters_favorites"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
    }

    object Libraries {

        object MerseyLibs {
            const val archy = ":archy"
            const val adapters = ":adapters"
            const val animators = ":animators"
            const val utils = ":utils"
        }
    }
}
