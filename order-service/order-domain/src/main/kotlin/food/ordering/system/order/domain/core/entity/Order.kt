package food.ordering.system.order.domain.core.entity

import food.ordering.system.common.domain.entity.AggregateRoot
import food.ordering.system.common.domain.valueobject.*
import food.ordering.system.order.domain.core.valueobject.StreetAddress
import food.ordering.system.order.domain.core.valueobject.TrackingId

class Order(
    id: OrderId,
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val price: Money,
    val items: List<OrderItem>,
    trackingId: TrackingId,
    status: OrderStatus,
    failureMessages: List<String>
) : AggregateRoot<OrderId>(id)