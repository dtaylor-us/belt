@file:JsModule("react-bootstrap/Button")
@file:JsNonModule

package bootstrap

import kotlinx.html.ButtonType
import react.*

@JsName("default")
external val button: RClass<ButtonProps>

external interface ButtonProps : RProps {
    var active: Boolean?
    var block: Boolean?
    var variant: String?
    var size: String?
    var type: ButtonType?
    var href: String?
    var disabled: Boolean?
    var target: Any?
}

