import com.mongodb.ConnectionString
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val connectionString: ConnectionString? = System.getenv("MONGODB_URI")?.let {
    ConnectionString(it)
}
val client = if (connectionString != null) KMongo.createClient(connectionString).coroutine else KMongo.createClient().coroutine
val database = client.getDatabase(connectionString?.database ?: "lcta")
val beltCollection = database.getCollection<Belt>()
