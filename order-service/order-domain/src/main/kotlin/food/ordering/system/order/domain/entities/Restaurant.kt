package food.ordering.system.order.domain.entities

import food.ordering.system.common.domain.entities.AggregateRoot
import food.ordering.system.common.domain.valueobjects.RestaurantId

internal data class RestaurantProperties(
    val id: RestaurantId,
    val active: Boolean
)

class Restaurant internal constructor(private var props: RestaurantProperties) : AggregateRoot<RestaurantId>(props.id) {
    val isActive get() = props.active
}

fun createRestaurantWith(
    restaurantId: RestaurantId,
    active: Boolean
) = RestaurantProperties(
    id = restaurantId,
    active = active
).let(::Restaurant)