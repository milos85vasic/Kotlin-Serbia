package net.milosvasic.conferences.kotlin_serbia.collections

import net.milosvasic.conferences.kotlin_serbia.doSomething

/**
 * Examples of immutable and mutable:
 *       - lists
 *       - maps
 *       - sets
 */
fun main(args: Array<String>) {

    /**
     * Immutable lists
     */
    val immutableList = listOf(2, 4, 6)
    val immutableList2 = listOf("Some", "Word")

    /**
     * Immutable maps
     */
    val immutableMap = mapOf("something" to 1, "else" to 2)
    val immutableMap2 = mapOf(Pair(1, "Plane"), Pair(2, "Car"))

    /**
     * Immutable sets
     */
    val immutableSet = setOf(2, 2, 3) // Will have only 2 and 3.
    immutableSet.forEach(::println) // Outputs 2 and 3. (:: Means direct access to reference)

    /**
     * Mmutable lists
     */
    val mutableList = mutableListOf(2, 4, 6)
    val mutableList2 = mutableListOf("Some", "Word")
    val mutableList3 = mutableListOf<String>()

    // Then we may add or remove items:
    mutableList2.remove("Word")
    // Or add
    mutableList3.add("Car")
    mutableList2.add("Plane")
    mutableList2.addAll(mutableList3)

    /**
     * Mutable maps
     */
    val mutableMap = mutableMapOf("something" to 1, "else" to 2)
    val mutableMap2 = mutableMapOf(Pair(1, "Plane"), Pair(2, "Car"))

    /**
     * Mutable sets
     */
    val mutableSet = mutableSetOf(2, 2, 3) // Will have only 2 and 3.
    mutableSet.add(1)
    mutableSet.add(4)
    mutableSet.add(5)
    mutableSet.add(55)
    mutableSet.remove(5)
    mutableSet.remove(55)
    mutableSet.removeIf { x -> x > 2 }
    mutableSet.forEach(::println) // Outputs 2 and 1. (:: Means direct access to reference)

    /**
     * Accessing to collection elements
     */
    val x = mutableList[0] // Get item at index 1
    val y = mutableMap["something"] // Get item with value 1 mapped to key 'something'

    /**
     * Iteration through items
     */
    mutableList.forEach { x -> doSomething(x) }
    // or (convert lambda to reference)
    mutableList.forEach(::doSomething)
    // if we need index for item
    mutableList.forEachIndexed { index, item -> doSomething(index, item) }
    // or we want to filter it
    mutableList
            .filter { x -> x >= 4 }
            .forEach(::println) // Filters from 2, 4, 6 items that are >= 4 and outputs 4 and 6

}
