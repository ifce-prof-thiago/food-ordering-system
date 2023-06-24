package food.ordering.system.order.application.message

import food.ordering.system.common.domain.valueobjects.OrderApprovalStatus
import java.time.Instant

data class RestaurantApprovalResponse(
    val id: String,
    val sagaId: String,
    val orderId: String,
    val restaurantId: String,
    val createdAl: Instant,
    val orderApprovalStatus: OrderApprovalStatus,
    val failureMessages: List<String>
)
