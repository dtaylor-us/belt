@file:JsModule("react-bootstrap/Navbar")
@file:JsNonModule

package bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val navbar: RClass<NavbarProps>

external interface NavbarProps : RProps {
    var variant: String?
    var expand: String?
    var bg: String?
    var fixed: String?
    var sticky: String?
    var onToggle: (dynamic) -> Unit?
    var onSelect: (dynamic) -> Unit?
    var collapseOnSelect: Boolean?
    var expanded: Boolean?
    var role: String?
}

