package food.ordering.system.order.domain.actions

import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.entities.Restaurant
import food.ordering.system.order.domain.events.OrderCreatedEvent
import food.ordering.system.order.domain.exceptions.OrderDomainException

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

internal fun createOrderAction(order: Order, restaurant: Restaurant): OrderCreatedEvent {
    validateRestaurant(restaurant)
    log.info { "Order created with id: ${order.id.value}" }
    return OrderCreatedEvent(order)
}

private fun validateRestaurant(restaurant: Restaurant) {
    if (!restaurant.isActive) {
        throw OrderDomainException("Restaurant with id: ${restaurant.id.value} is not active")
    }
}