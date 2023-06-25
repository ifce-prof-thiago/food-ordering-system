package food.ordering.system.order.application.gateways.data.access.restaurants.queries.responses

import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.domain.entities.createRestaurantWith
import java.util.*

data class RestaurantByIdResponse(
    val restaurantId: UUID,
    val active: Boolean
) {
    fun toRestaurant() = createRestaurantWith(
        restaurantId = RestaurantId(restaurantId),
        active = active
    )
}