package net.milosvasic.conferences.kotlin_serbia.delegates

import kotlin.properties.Delegates

/**
 * Stock value with observer delegate
 */
class Stock {

    var value : Int by Delegates.observable(0) { // Initial value is 0
        property, old, new -> println("${property.name}: [ $old ] -> [ $new ]")
    }

}

/**
 * We will set some stock values here
 */
fun main(args: Array<String>) {
    val stock = Stock()
    stock.value = 10   // Outputs: value: [ 0 ] -> [ 10 ]
    stock.value = 100  // Outputs: value: [ 10 ] -> [ 100 ]
    stock.value = 1000 // Outputs: value: [ 100 ] -> [ 1000 ]
}
