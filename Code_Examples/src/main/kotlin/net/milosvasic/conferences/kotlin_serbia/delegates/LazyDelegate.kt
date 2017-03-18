package net.milosvasic.conferences.kotlin_serbia.delegates

/**
 * Class that uses lazy initialization to initialize it's field.
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
    val database = client.database // Initialization will be fired here
    val database2 = client.database // And only once
    val database3 = client.database // ...
}
