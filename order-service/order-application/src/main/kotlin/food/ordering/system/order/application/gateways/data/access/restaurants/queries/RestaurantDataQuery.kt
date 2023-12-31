package food.ordering.system.order.application.gateways.data.access.restaurants.queries

import food.ordering.system.common.domain.valueobjects.ProductId
import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.application.gateways.data.access.restaurants.queries.responses.ProductByRestaurantIdResponse
import food.ordering.system.order.application.gateways.data.access.restaurants.queries.responses.RestaurantByIdResponse

interface RestaurantDataQuery {
    fun findBy(restaurantId: RestaurantId): RestaurantByIdResponse?
    fun findProductBy(restaurantId: RestaurantId, productId: ProductId): ProductByRestaurantIdResponse?
}