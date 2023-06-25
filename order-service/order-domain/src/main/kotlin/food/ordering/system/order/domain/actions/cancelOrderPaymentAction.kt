package food.ordering.system.order.domain.actions

import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.events.OrderCancelledEvent
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

internal fun cancelOrderPaymentAction(order: Order, failureMessages: List<String>): OrderCancelledEvent {
    order.initCancel(failureMessages)
    log.info { "Order with id: ${order.id.value} payment cancelled" }
    return OrderCancelledEvent(order)
}