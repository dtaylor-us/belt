import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.js.*
import kotlinx.coroutines.*

private val scope = MainScope()

val App = functionalComponent<RProps> { _ ->
    val (belt, setBelt) = useState(emptyList<Belt>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setBelt(getBelt())
        }
    }

    h1 {
        +"LCTA Belt App"
    }
    ul {
        belt.sortedByDescending(Belt::rank).forEach { item ->
            li {
                key = item.toString()
                attrs.onClickFunction = {
                    scope.launch {
                        deleteBelt(item)
                        setBelt(getBelt())
                    }
                }
                +"${item.rank} Keup - ${item.color.capitalize()} - ${item.level.toUpperCase()} "
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
