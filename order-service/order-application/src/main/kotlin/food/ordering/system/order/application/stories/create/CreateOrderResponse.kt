package food.ordering.system.order.application.stories.create

import food.ordering.system.common.domain.valueobjects.OrderStatus
import food.ordering.system.order.domain.entities.Order
import java.util.*

data class CreateOrderResponse(
    val orderTrackingId: UUID,
    val orderStatus: OrderStatus,
    val message: String
) {
    companion object {
        fun from(order: Order) = CreateOrderResponse(
            orderTrackingId = order.trackingId.value,
            orderStatus = order.orderStatus,
            message = order.failureMessages.joinToString()
        )
    }
}