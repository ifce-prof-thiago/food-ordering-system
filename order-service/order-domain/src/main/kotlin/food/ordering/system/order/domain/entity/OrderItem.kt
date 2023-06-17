package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.entity.BaseEntity
import food.ordering.system.common.domain.valueobject.Money
import food.ordering.system.common.domain.valueobject.ProductId
import food.ordering.system.order.domain.valueobject.OrderItemId

internal data class OrderItemProperties(
    val id: OrderItemId,
    val productId: ProductId,
    val productPrice: Money,
    val productName: String,
    val quantity: Int
)

class OrderItem internal constructor(private var props: OrderItemProperties) : BaseEntity<OrderItemId>(props.id) {

    fun calculateSubTotal(): Money {
        return productPrice * quantity
    }

    val productPrice: Money
        get() = props.productPrice

    val productName: String
        get() = props.productName

    val quantity: Int
        get() = props.quantity

}