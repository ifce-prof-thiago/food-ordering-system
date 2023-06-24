package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.entity.AggregateRoot
import food.ordering.system.common.domain.valueobject.RestaurantId

internal data class RestaurantProperties(
    val id: RestaurantId,
    val active: Boolean,
    val products: List<Product>
)

class Restaurant internal constructor(private var props: RestaurantProperties) : AggregateRoot<RestaurantId>(props.id) {

    val isActive
        get() = props.active
}