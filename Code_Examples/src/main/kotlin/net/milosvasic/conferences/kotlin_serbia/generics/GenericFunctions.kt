package net.milosvasic.conferences.kotlin_serbia.generics

class EngineDiagnostics {
    /**
     * Method check engine is generic.
     * It accepts only classes that are extending Engine class.
     */
    fun <T : Engine> checkEngine(engine: T) {
        println(engine)
    }
}

/**
 * Example of use.
 */
fun main(args: Array<String>) {
    val truckEngine = TruckEngine()
    val rocketEngine = RocketEngine()
    val diagnostics = EngineDiagnostics()
    diagnostics.checkEngine(truckEngine)
    diagnostics.checkEngine(rocketEngine)
}

/**
 * Engine abstraction
 */
abstract class Engine {
    abstract val power: Long // This value will be overridden in final implementation

    override fun toString(): String {
        return "${this::class.simpleName} (power=$power)"
    }
}

/**
 * Rocket engine
 */
class RocketEngine : Engine() {
    override val power: Long
        get() = 1000
}

/**
 * Truck engine
 */
class TruckEngine : Engine() {
    override val power: Long
        get() = 100

}
