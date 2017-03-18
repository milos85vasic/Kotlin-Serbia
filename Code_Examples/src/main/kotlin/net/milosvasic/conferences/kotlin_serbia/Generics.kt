package net.milosvasic.conferences.kotlin_serbia

/**
 * Examples of generics in Kotlin.
 */

/**
 * Simple class that takes anything and uses it to print
 */
class Printer<in T> { // 'in' means that this type may be only consumed but never produced.
    fun print(item: T) = println("Item [ $item ]")
}

/**
 * Builder that generates instances of T based on parameter of P type
 */
abstract class Builder<in P, out T> { // 'out' means that this type may be only produced but never consumed.
    abstract fun build(param: P): T
}

/**
 * Builder variant
 */
class IntegerBuilder : Builder<String, Int>() {
    override fun build(param: String): Int {
        return param.toInt()
    }
}

/**
 * Accepts collection and exposes min and max values.
 */
class Sorter<T : Comparable<T>>(items: List<T>) { // T is produced and consumed, so there is no 'in' or 'out'
                                                  // T also must extend Comparable
    private val sorted = items.sorted()

    init {
        items.sorted()
    }

    fun getMax(): T {
        return sorted.last()
    }

    fun getMin(): T {
        return sorted.first()
    }

}

/**
 * Examples of generic classes usage
 */
fun main(args: Array<String>) {
    val integerPrinter = Printer<Int>()
    val stringPrinter = Printer<String>()

    integerPrinter.print(2)
    stringPrinter.print("Something")

    // ---

    val intBuilder = IntegerBuilder()
    val x = intBuilder.build("1")
    println("We build [ $x ]")

    // ---

    val list = listOf(2, 5, 1, 2, 6, 6, 8, 2, 1, 10, 3)
    val sorter = Sorter(list) // We will not instantiate it via: Sorter<Int>(list)
                              // since Kotlin will take type from arguments
    println("[ ${sorter.getMin()} ][ ${sorter.getMax()} ]") // Outputs: [ 1 ][ 10 ]

}