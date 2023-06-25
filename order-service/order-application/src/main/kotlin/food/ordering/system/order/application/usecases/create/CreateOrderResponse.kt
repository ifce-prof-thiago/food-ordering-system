package food.ordering.system.order.application.usecases.create

import food.ordering.system.common.domain.valueobjects.OrderStatus
import java.util.*

data class CreateOrderResponse(
    val orderTrackingId: UUID,
    val orderStatus: OrderStatus,
    val message: String
)