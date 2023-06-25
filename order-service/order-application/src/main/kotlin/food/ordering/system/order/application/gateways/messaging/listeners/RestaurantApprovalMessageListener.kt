package food.ordering.system.order.application.gateways.messaging.listeners

import food.ordering.system.common.domain.valueobjects.OrderApprovalStatus
import java.time.Instant

interface RestaurantApprovalMessageListener {
    fun orderApproved(restaurantApprovalPayload: RestaurantApprovalPayload)
    fun orderRejected(restaurantApprovalPayload: RestaurantApprovalPayload)
}

data class RestaurantApprovalPayload(
    val id: String,
    val sagaId: String,
    val orderId: String,
    val restaurantId: String,
    val createdAl: Instant,
    val orderApprovalStatus: OrderApprovalStatus,
    val failureMessages: List<String>
)