import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.RProps
import react.dom.h1
import react.functionalComponent
import react.useEffect
import react.useState

private val scope = MainScope()

val BeltFormComponent = functionalComponent<RProps> { _ ->
    val (belt, setBelt) = useState(emptyList<Belt>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setBelt(getBelt())
        }
    }

    h1 {
        +"Belt form component!"
    }

//    child(
//        InputComponent,
//        props = jsObject {
//            onSubmit = { input ->
//                val cartItem = Belt(input.replace("!", ""), input.count { it == '!' })
//                scope.launch {
//                    addBelt(cartItem)
//                    setBelt(getBelt())
//                }
//            }
//        }
//    )
}
