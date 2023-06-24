package food.ordering.system.order.application.track

import food.ordering.system.common.domain.valueobjects.OrderStatus
import java.util.*

data class TrackOrderResponse(
    val orderTrackingId: UUID,
    val orderStatus: OrderStatus,
    val failureMessages: List<String>
)