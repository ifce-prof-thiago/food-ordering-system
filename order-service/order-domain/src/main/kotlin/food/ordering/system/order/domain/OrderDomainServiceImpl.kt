package food.ordering.system.order.domain

import food.ordering.system.order.domain.actions.*
import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.entities.Restaurant
import food.ordering.system.order.domain.events.OrderCancelledEvent
import food.ordering.system.order.domain.events.OrderCreatedEvent
import food.ordering.system.order.domain.events.OrderPaidEvent

class OrderDomainServiceImpl : OrderDomainService {
    override fun createOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent {
        return createOrderAction(order, restaurant)
    }

    override fun payOrder(order: Order): OrderPaidEvent {
        return payOrderAction(order)
    }

    override fun approveOrder(order: Order) {
        return approveOrderAction(order)
    }

    override fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent {
        return cancelOrderPaymentAction(order, failureMessages)
    }

    override fun cancelOrder(order: Order, failureMessages: List<String>) {
        return cancelOrderAction(order, failureMessages)
    }
}