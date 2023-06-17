package food.ordering.system.order.domain

import food.ordering.system.common.domain.valueobject.Money

fun main() {

    val a = Money(27.9)
    val b = Money(54)

    val c = a + b

    println("%.5f".format(c.amount))

}