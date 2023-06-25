package food.ordering.system.order.application.gateways.data.access.orders.queries.responses

import food.ordering.system.common.domain.valueobjects.*
import food.ordering.system.order.domain.entities.createOrderItemWith
import food.ordering.system.order.domain.entities.createOrderWith
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
) {
    fun toOrder() = createOrderWith(
        id = this.orderId,
        customerId = this.customerId,
        restaurantId = this.restaurantId,
        deliveryAddress = this.deliveryAddress,
        items = this.items.map { it.toOrderItem() },
        trackingId = this.trackingId,
        orderStatus = this.orderStatus
    )
}

data class OrderItemByTrackingId(
    val productId: ProductId,
    val name: String,
    val price: Money,
    val quantity: Int
) {
    fun toOrderItem() = createOrderItemWith(
        productId = this.productId,
        name = this.name,
        price = this.price,
        quantity = this.quantity
    )
}
