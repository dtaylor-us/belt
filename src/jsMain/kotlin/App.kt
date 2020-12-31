import bootstrap.navbar
import bootstrap.navbarBrand
import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.js.*
import kotlinx.coroutines.*
import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.html.InputType
import styled.css
import styled.styledDiv

private val scope = MainScope()

val App = functionalComponent<RProps> { _ ->
    val (belt, setBelt) = useState(emptyList<Belt>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setBelt(getBelt())
        }
    }


        navbar {
            attrs.bg = "dark"
            attrs.className = "white"
            attrs.variant = "dark"
            navbarBrand {
                +"LCTA Belt Application"
            }

    }
    ul {
        belt.sortedBy(Belt::order).forEach { item ->
            li {
                key = item.toString()
                attrs.onClickFunction = {
                    scope.launch {
                        deleteBelt(item)
                        setBelt(getBelt())
                    }
                }
                +"${item.rank} Keup - ${item.color.capitalize()} Belt - ${item.level.toUpperCase()} "
            }
        }
    }
//    child(
//        InputComponent,
//        props = jsObject {
//            onSubmit = { input ->
//                val beltItem = Belt(input.replace("!", ""), input.count { it == '!' })
//                scope.launch {
////                    addBelt(cartItem)
//                    setBelt(getBelt())
//                }
//            }
//        }
//    )
}
