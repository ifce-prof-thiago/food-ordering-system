package food.ordering.system.order.application.gateways.data.access.orders.commands

import food.ordering.system.order.domain.entities.Order

interface OrderDataCommand {
    fun save(order: Order)
}