package food.ordering.system.order.domain.commands

import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.events.OrderPaidEvent

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

internal fun payOrderCommand(order: Order): OrderPaidEvent {
    order.pay()
    log.info { "Order with id: ${order.id.value} paid" }
    return OrderPaidEvent(order)
}