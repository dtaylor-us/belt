@file:JsModule("@chakra-ui/react")
@file:JsNonModule

import react.*
import react.dom.*

@JsName("ChakraProvider")
external val chakraProvider: RClass<dynamic>

external interface ChakraProviderProps : RProps {
    var url: String
//    /**
//     * a theme. if omitted, uses the default theme provided by chakra
//     */
//    var theme?: Dict
//    /**
//     * Common z-index to use for `Portal`
//     *
//     * @default undefined
//     */
//    portalZIndex?: number
//    /**
//     * If `true`, `CSSReset` component will be mounted to help
//     * you reset browser styles
//     *
//     * @default true
//     */
//    resetCSS?: boolean
//    /**
//     * manager to persist a users color mode preference in
//     *
//     * omit if you don't render server-side
//     * for SSR: choose `cookieStorageManager`
//     *
//     * @default localStorageManager
//     */
//    colorModeManager?: ColorModeProviderProps["colorModeManager"]
    var children: ReactElement
}
