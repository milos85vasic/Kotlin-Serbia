package net.milosvasic.conferences.kotlin_serbia.delegates

/**
 * Class that uses lazy initialization to initialize its field.
 */
class PostgreClient {

    /**
     * Lazy initialization.
     */
    val database by lazy { // by using 'lazy' delegate
        Database("PostgreSQL")
    }

}

class Database(val type: String) {
    init {
        println("Initializing $type")
    }
}

fun main(args: Array<String>) {
    val client = PostgreClient()
    val database = client.database   // Initialization will be executed here
    val database2 = client.database  // and each time when we access property, it will not be executed again.
    val database3 = client.database
}
