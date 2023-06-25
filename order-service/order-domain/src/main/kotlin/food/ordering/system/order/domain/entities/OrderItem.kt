package food.ordering.system.order.domain.entities

import food.ordering.system.common.domain.entities.BaseEntity
import food.ordering.system.common.domain.valueobjects.Money
import food.ordering.system.common.domain.valueobjects.ProductId

internal data class OrderItemProperties(
    val productId: ProductId,
    val price: Money,
    val name: String,
    val quantity: Int
)

class OrderItem internal constructor(private var props: OrderItemProperties) : BaseEntity<ProductId>(props.productId) {

    fun calculateSubTotal(): Money {
        return price * quantity
    }

    val price get() = props.price
    val name get() = props.name
    val quantity get() = props.quantity

}