import kotlinx.serialization.Serializable

@Serializable
data class Belt(
    val rank: String,
    val order: Int,
    val level: String,
    val desc: String,
    val color: String
) {
    val id: Int = color.hashCode()

    companion object {
        const val path = "/belt"
    }
}
