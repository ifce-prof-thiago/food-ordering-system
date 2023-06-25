package food.ordering.system.order.domain

import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.entities.Restaurant
import food.ordering.system.order.domain.events.OrderCancelledEvent
import food.ordering.system.order.domain.events.OrderCreatedEvent
import food.ordering.system.order.domain.events.OrderPaidEvent

interface OrderDomainService {
    fun createOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent
    fun payOrder(order: Order): OrderPaidEvent
    fun approveOrder(order: Order)
    fun cancelOrderPayment(order: Order, failureMessages: List<String >): OrderCancelledEvent
    fun cancelOrder(order: Order, failureMessages: List<String>)
}