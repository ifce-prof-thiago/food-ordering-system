package food.ordering.system.order.application.create

import java.util.*

data class CreateOrderIn(
    val customerId: UUID,
    val restaurantId: UUID,
    val price: Number,
    val items: List<CreateOrderItem>,
    val address: CreateOrderAddress
)

data class CreateOrderItem(
    val productId: UUID,
    val price: Number,
    val name: String,
    val quantity: Int
)

data class CreateOrderAddress(
    val street: String,
    val city: String,
    val zipCode: String
)