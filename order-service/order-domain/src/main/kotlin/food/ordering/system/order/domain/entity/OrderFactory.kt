package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.valueobject.*
import food.ordering.system.order.domain.valueobject.OrderItemId
import food.ordering.system.order.domain.valueobject.StreetAddress
import food.ordering.system.order.domain.valueobject.TrackingId

fun createOrderWith(
    id: OrderId = OrderId.random(),
    customerId: CustomerId,
    restaurantId: RestaurantId,
    deliveryAddress: StreetAddress,
    items: List<OrderItem> = mutableListOf(),
    trackingId: TrackingId = TrackingId.create(),
    orderStatus: OrderStatus = OrderStatus.PENDING,
    failureMessages: List<String> = emptyList()
): Order {

    val props = OrderProperties(
        id = id,
        customerId = customerId,
        restaurantId = restaurantId,
        deliveryAddress = deliveryAddress,
        items = items,
        trackingId = trackingId,
        orderStatus = orderStatus,
        failureMessages = failureMessages
    )

    return Order(props)
}

fun createOrderItemWith(
    id: OrderItemId,
    productId: ProductId,
    productName: String,
    productPrice: Money,
    quantity: Int
): OrderItem {

    val props = OrderItemProperties(
        id = id,
        productId = productId,
        productPrice = productPrice,
        productName = productName,
        quantity = quantity
    )

    return OrderItem(props)
}
