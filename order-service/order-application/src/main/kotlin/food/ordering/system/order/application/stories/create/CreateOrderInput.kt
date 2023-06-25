package food.ordering.system.order.application.stories.create

import food.ordering.system.common.domain.valueobjects.CustomerId
import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.domain.entities.OrderItem
import food.ordering.system.order.domain.entities.createOrderWith
import food.ordering.system.order.domain.valueobjects.StreetAddress
import java.util.*

data class CreateOrderInput(
    val customerId: UUID,
    val restaurantId: UUID,
    val items: List<CreateOrderItem>,
    val address: CreateOrderAddress
) {
    fun toOrder(items: List<OrderItem>) = createOrderWith(
        customerId = CustomerId(customerId),
        restaurantId = RestaurantId(restaurantId),
        items = items,
        deliveryAddress = address.toAddress()
    )
}

data class CreateOrderItem(
    val productId: UUID,
    val quantity: Int
)

data class CreateOrderAddress(
    val street: String,
    val city: String,
    val postalCode: String
) {
    fun toAddress() = StreetAddress(
        street = street,
        city = city,
        postalCode = postalCode
    )
}