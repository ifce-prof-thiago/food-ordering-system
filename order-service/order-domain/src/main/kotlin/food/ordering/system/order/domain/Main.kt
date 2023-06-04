package food.ordering.system.order.domain

import food.ordering.system.common.domain.valueobject.Money
import food.ordering.system.common.domain.valueobject.ProductId
import food.ordering.system.order.domain.core.entity.OrderItem
import food.ordering.system.order.domain.core.entity.Product
import food.ordering.system.order.domain.core.valueobject.OrderItemId
import java.math.BigDecimal
import java.util.*

fun main() {
    val item = OrderItem(
        id = OrderItemId(1),
        product = Product(
            id = ProductId(UUID.randomUUID()),
            name = "Pizza",
            price = Money(BigDecimal(10))
        ),
        quantity = 13
    )

    println(item.calculateSubTotal().amount)

}