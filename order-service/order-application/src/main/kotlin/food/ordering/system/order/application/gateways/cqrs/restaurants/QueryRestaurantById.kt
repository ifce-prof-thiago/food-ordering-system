package food.ordering.system.order.application.gateways.cqrs.restaurants

import food.ordering.system.common.domain.valueobjects.RestaurantId
import java.util.*

interface FindRestaurantByIdQuery {
    fun findBy(restaurantId: RestaurantId): RestaurantById?
}

data class RestaurantById(
    val restaurantId: UUID,
    val active: Boolean
)
