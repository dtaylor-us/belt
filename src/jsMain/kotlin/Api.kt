import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin // only needed until https://github.com/ktorio/ktor/issues/1695 is resolved

val jsonClient = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getBelt(): List<Belt> {
    return jsonClient.get(endpoint + Belt.path)
}

suspend fun addBelt(belt: Belt) {
    jsonClient.post<Unit>(endpoint + Belt.path) {
        contentType(ContentType.Application.Json)
        body = belt
    }
}

suspend fun deleteBelt(belt: Belt) {
    jsonClient.delete<Unit>(endpoint + Belt.path + "/${belt.id}")
}
