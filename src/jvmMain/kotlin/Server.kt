import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import util.populateDB


val port = System.getenv("PORT")?.toInt() ?: 9090

fun main() {
    GlobalScope.launch {
        if (beltCollection.countDocuments() == 0L)
            populateDB()
    }
    embeddedServer(Netty, watchPaths = listOf("lcta"), port = port, module = Application::module).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(CORS) {
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Delete)
        anyHost()
    }
    install(Compression) {
        gzip()
    }
    routing {
        get("/") {
            call.respondText(
                this::class.java.classLoader.getResource("index.html")!!.readText(),
                ContentType.Text.Html
            )
        }
        static("/") {
            resources("")
        }
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
}
