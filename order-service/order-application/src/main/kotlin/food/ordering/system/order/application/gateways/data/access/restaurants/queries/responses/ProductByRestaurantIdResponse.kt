package food.ordering.system.order.application.gateways.data.access.restaurants.queries.responses

data class ProductByRestaurantIdResponse(
    val productId: String,
    val name: String,
    val price: Number
)
