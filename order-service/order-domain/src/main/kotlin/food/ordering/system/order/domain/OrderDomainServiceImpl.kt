package food.ordering.system.order.domain

import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.entities.Restaurant
import food.ordering.system.order.domain.events.OrderCancelledEvent
import food.ordering.system.order.domain.events.OrderCreatedEvent
import food.ordering.system.order.domain.events.OrderPaidEvent
import food.ordering.system.order.domain.services.createOrderService
import food.ordering.system.order.domain.services.payOrderService

class OrderDomainService : IOrderDomainService {
    override fun createOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent {
        return createOrderService(order, restaurant)
    }

    override fun payOrder(order: Order): OrderPaidEvent {
        return payOrderService(order)
    }

    override fun approveOrder(order: Order) {
        TODO("Not yet implemented")
    }

    override fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent {
        TODO("Not yet implemented")
    }

    override fun cancelOrder(order: Order, failureMessages: List<String>) {
        TODO("Not yet implemented")
    }
}