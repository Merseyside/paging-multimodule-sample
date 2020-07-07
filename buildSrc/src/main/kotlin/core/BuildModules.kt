

/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val NEWS_LIST = ":features:newsList"
        const val CHARACTERS_LIST = ":features:characters_list"
        const val CHARACTERS_FAVORITES = ":features:characters_favorites"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
    }

    object Libraries {

        const val NEWS_API = ":libraries:newsapi"

        object MerseyLibs {
            const val archy = ":archy"
            const val adapters = ":adapters"
            const val animators = ":animators"
            const val utils = ":utils"
        }
    }
}
