package food.ordering.system.order.application.gateways.cqrs.orders

import food.ordering.system.common.domain.valueobjects.*
import food.ordering.system.order.domain.valueobjects.StreetAddress
import food.ordering.system.order.domain.valueobjects.TrackingId

interface FindOrderByTrackingIdQuery {
    fun findBy(trackingId: TrackingId): OrderByTrackingId?
}

data class OrderByTrackingId(
    val orderId: OrderId,
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val items: List<OrderItemByTrackingId>,
    val trackingId: TrackingId,
    val orderStatus: OrderStatus
)

data class OrderItemByTrackingId(
    val productId: ProductId,
    val name: String,
    val price: Money,
    val quantity: Int
)
