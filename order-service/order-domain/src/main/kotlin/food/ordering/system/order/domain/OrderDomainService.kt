package food.ordering.system.order.domain

import food.ordering.system.order.domain.entity.Order
import food.ordering.system.order.domain.entity.Restaurant
import food.ordering.system.order.domain.event.OrderCancelledEvent
import food.ordering.system.order.domain.event.OrderCreatedEvent
import food.ordering.system.order.domain.event.OrderPaidEvent

interface OrderDomainService {
    fun validateAndInitializerOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent
    fun payOrder(order: Order): OrderPaidEvent
    fun approveOrder(order: Order)
    fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent
    fun cancelOrder(order: Order, failureMessages: List<String>)
}