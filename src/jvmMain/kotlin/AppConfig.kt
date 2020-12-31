import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

val port = System.getenv("PORT")?.toInt() ?: 9090
val appName = System.getenv("APP_NAME") ?: "lcta"

fun configureServer() {
    embeddedServer(
        Netty,
        watchPaths = listOf("lcta"),
        port = port,
        module = Application::module
    ).start(wait = true)
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
        index()
        static()
        belt()
    }
}
