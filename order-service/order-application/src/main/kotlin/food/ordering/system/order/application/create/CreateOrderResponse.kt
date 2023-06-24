package food.ordering.system.order.application.create

import food.ordering.system.common.domain.valueobjects.OrderStatus
import java.util.*

data class CreateOrderOut(
    val orderTrackingId: UUID,
    val orderStatus: OrderStatus,
    val message: String
)