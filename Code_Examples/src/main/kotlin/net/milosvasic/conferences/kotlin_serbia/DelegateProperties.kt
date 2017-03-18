package net.milosvasic.conferences.kotlin_serbia

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegating properties
 *
 * We delegate salary property to SalaryDelegate class
 */
class Worker {
    var salary: Int by SalaryDelegate(BaseSalaryCalculation())
}

/**
 * To become property delegate we must implement ReadWriteProperty!
 */
class SalaryDelegate(val calculation: SalaryCalculation) : ReadWriteProperty<Any, Int> {
    private var salary = 0

    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return salary
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        salary = calculation.calculate(value)
    }
}

/**
 * We define some additional classes needed to calculate salary.
 */
class BaseSalaryCalculation : SalaryCalculation {
    override fun calculate(salaryBase: Int): Int {
        return salaryBase * 100
    }
}

interface SalaryCalculation {
    fun calculate(salaryBase: Int): Int
}

/**
 * We try our code
 */
fun main(args: Array<String>) {
    val worker = Worker()
    worker.salary = 10
    println("Worker earned [ ${worker.salary} ]") // Outputs 1000.
                                                  // by executing the code from BaseSalaryCalculation class.
}
