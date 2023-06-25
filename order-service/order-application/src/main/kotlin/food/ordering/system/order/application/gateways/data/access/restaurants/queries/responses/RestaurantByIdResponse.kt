package food.ordering.system.order.application.gateways.data.access.restaurants.queries.responses

import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.domain.valueobjects.OrderItemId

data class RestaurantByIdResponse(
    val restaurantId: RestaurantId,
    val active: Boolean,
    val products: List<ProductByRestaurantId>
)

data class ProductByRestaurantId(
    val productId: OrderItemId,
    val name: String,
    val price: Number
)
