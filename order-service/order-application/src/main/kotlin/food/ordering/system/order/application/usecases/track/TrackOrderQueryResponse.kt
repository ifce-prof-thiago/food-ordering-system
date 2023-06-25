package food.ordering.system.order.application.usecases.track

import food.ordering.system.common.domain.valueobjects.OrderStatus
import java.util.*

data class TrackOrderQueryResponse(
    val orderTrackingId: UUID,
    val orderStatus: OrderStatus,
    val failureMessages: List<String>
)