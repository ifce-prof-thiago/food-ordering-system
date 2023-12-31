package food.ordering.system.order.domain.actions

import food.ordering.system.order.domain.entities.Order
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

internal fun cancelOrderAction(order: Order, failureMessages: List<String>) {
    order.cancel(failureMessages)
    log.info { "Order with id: ${order.id.value} cancelled" }
}