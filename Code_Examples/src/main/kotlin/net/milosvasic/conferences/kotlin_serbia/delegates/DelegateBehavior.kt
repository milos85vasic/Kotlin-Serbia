package net.milosvasic.conferences.kotlin_serbia.delegates

/**
 * Delegating behavior
 */
class Traveling(fly: Flying) : Flying by fly // We delegate Flying to passed Flying instance - fly



/**
 * Delegate example classes usage
 */
fun main(args: Array<String>) {
    val plane = Plane()
    val zeppelin = Zeppelin()

    val travelByPlane = Traveling(plane)
    val travelByZeppelin = Traveling(zeppelin)

    travelByPlane.fly() // Outputs PLANE
    travelByZeppelin.fly() // Outputs ZEPPELIN
}


interface Flying {
    fun fly()
}

class Plane : Flying {
    override fun fly() {
        println("PLANE")
    }
}

class Zeppelin : Flying {
    override fun fly() {
        println("ZEPPELIN")
    }
}