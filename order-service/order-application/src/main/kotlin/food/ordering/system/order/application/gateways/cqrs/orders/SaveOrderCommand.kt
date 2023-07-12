package food.ordering.system.order.application.gateways.cqrs.orders

import food.ordering.system.order.domain.entities.Order

interface SaveOrderCommand {
    fun execute(order: Order)
}