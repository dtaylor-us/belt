@file:JsModule("react-bootstrap/Navbar")
@file:JsNonModule

package bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val navbar: RClass<NavbarProps>

external interface NavbarProps : RProps {
    var className: String?
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

@JsName("default")
external val navbarBrand: RClass<NavBarBrandProps>

external interface NavBarBrandProps : RProps {
    var bsPrefix: String?
    var className: String?
    var href: String?
}

