import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.index() {
    get("/") {
        call.respondText(
            this::class.java.classLoader.getResource("index.html")!!.readText(),
            ContentType.Text.Html
        )
    }
}

fun Routing.static() {
    static("/") {
        resources("")
    }
}

fun Routing.belt() {
    route(Belt.path) {
        get {
            call.respond(beltCollection.find().toList())
        }
//            post {
//                getBeltList += call.receive<Belt>()
//                call.respond(HttpStatusCode.OK)
//            }
//            delete("/{id}") {
//                val id = call.parameters["id"]?.toInt() ?: error("Invalid delete request")
//                getBeltList.removeIf { it.id == id }
//                call.respond(HttpStatusCode.OK)
//            }
    }
}
