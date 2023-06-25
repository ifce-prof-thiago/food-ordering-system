package food.ordering.system.order.application.gateways.data.access.orders.queries.responses

import food.ordering.system.common.domain.valueobjects.CustomerId
import food.ordering.system.common.domain.valueobjects.OrderId
import food.ordering.system.common.domain.valueobjects.OrderStatus
import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.domain.valueobjects.OrderItemId
import food.ordering.system.order.domain.valueobjects.StreetAddress
import food.ordering.system.order.domain.valueobjects.TrackingId

data class OrderByTrackingIdResponse(
    val orderId: OrderId,
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val items: List<OrderItemByTrackingId>,
    val trackingId: TrackingId,
    val orderStatus: OrderStatus
)

data class OrderItemByTrackingId(
    val orderItemId: OrderItemId,
    val name: String,
    val price: String,
    val quantity: Int
)
