package food.ordering.system.order.domain.commands

import food.ordering.system.order.domain.entities.Order

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

internal fun approveOrderCommand(order: Order) {
    order.approve()
    log.info { "Order with id: ${order.id.value} approved" }
}