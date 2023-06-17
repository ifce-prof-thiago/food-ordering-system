package food.ordering.system.order.domain

import food.ordering.system.order.domain.entity.Order
import food.ordering.system.order.domain.entity.Restaurant
import food.ordering.system.order.domain.event.OrderCancelledEvent
import food.ordering.system.order.domain.event.OrderCreatedEvent
import food.ordering.system.order.domain.event.OrderPaidEvent

class OrderDomainServiceImpl : OrderDomainService {
    override fun validateAndInitializerOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent {
        TODO("Not yet implemented")
    }

    override fun payOrder(order: Order): OrderPaidEvent {
        TODO("Not yet implemented")
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