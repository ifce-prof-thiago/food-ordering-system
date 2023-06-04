package food.ordering.system.order.domain.core.entity

import food.ordering.system.common.domain.entity.BaseEntity
import food.ordering.system.common.domain.valueobject.Money
import food.ordering.system.order.domain.core.valueobject.OrderItemId

class OrderItem(
    id: OrderItemId,
    val product: Product,
    val quantity: Int
) : BaseEntity<OrderItemId>(id) {

    fun calculateSubTotal(): Money {
        return product.price * quantity
    }

}