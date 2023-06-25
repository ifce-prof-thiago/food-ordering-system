package food.ordering.system.order.application.usecases.create

import java.util.*

data class CreateOrderInput(
    val customerId: UUID,
    val restaurantId: UUID,
    val items: List<CreateOrderItem>,
    val address: CreateOrderAddress
)

data class CreateOrderItem(
    val productId: UUID,
    val quantity: Int
)

data class CreateOrderAddress(
    val street: String,
    val city: String,
    val zipCode: String
)