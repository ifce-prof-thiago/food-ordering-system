package food.ordering.system.order.application.gateways.cqrs.restaurants

import food.ordering.system.common.domain.valueobjects.ProductId
import food.ordering.system.common.domain.valueobjects.RestaurantId

interface QueryProductByIdAndRestaurantId {
    fun findBy(productId: ProductId, restaurantId: RestaurantId): ProductByIdAndRestaurantId?
}

data class ProductByIdAndRestaurantId(
    val productId: String,
    val name: String,
    val price: Number
)