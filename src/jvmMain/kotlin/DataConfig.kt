import com.mongodb.ConnectionString
import com.mongodb.client.model.InsertManyOptions
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val connectionString: ConnectionString? = System.getenv("MONGODB_URI")?.let {
    ConnectionString(it)
}

val client = if (connectionString != null) KMongo.createClient(connectionString).coroutine else KMongo.createClient().coroutine
val database = client.getDatabase(connectionString?.database ?: appName)
val beltCollection = database.getCollection<Belt>()

fun bootstrapData() {
    GlobalScope.launch {
        if (beltCollection.countDocuments() == 0L)
            populateDB()
    }
}

suspend fun populateDB() {
    val beltList = mutableListOf(
        Belt(Rank.NONE.rank, Rank.NONE.order, Level.BEGINNER.level, "NA", BeltColor.WHITE.color),
        Belt(Rank.NINTH.rank, Rank.NINTH.order, Level.BEGINNER.level, "NA", BeltColor.YELLOW.color),
        Belt(Rank.EIGHTH.rank, Rank.EIGHTH.order, Level.BEGINNER.level, "NA", BeltColor.ORANGE.color),
        Belt(Rank.SEVENTH.rank, Rank.SEVENTH.order, Level.BEGINNER.level, "NA", BeltColor.GREEN.color),
        Belt(Rank.SIXTH.rank, Rank.SIXTH.order, Level.INTERMEDIATE.level, "NA", BeltColor.PURPLE.color),
        Belt(Rank.FIFTH.rank, Rank.FIFTH.order, Level.INTERMEDIATE.level, "NA", BeltColor.BLUE.color),
        Belt(Rank.FOURTH.rank, Rank.FOURTH.order, Level.INTERMEDIATE.level, "NA", BeltColor.BLUE_LEADER.color),
        Belt(Rank.THIRD.rank, Rank.THIRD.order, Level.ADVANCED.level, "NA", BeltColor.BROWN.color),
        Belt(Rank.SECOND.rank, Rank.SECOND.order, Level.ADVANCED.level, "NA", BeltColor.RED.color),
        Belt(Rank.FIRST.rank, Rank.FIRST.order, Level.ADVANCED.level, "NA", BeltColor.RED_LEADER.color),
        Belt(Rank.NONE.rank, 11, "BLACK BELT", "NA", BeltColor.DPTY_BLACK.color),
        Belt(Rank.NONE.rank, 12, "BLACK BELT", "NA", BeltColor.BLACK.color),
    )
    beltCollection.insertMany(beltList, InsertManyOptions())
}
