package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.entity.AggregateRoot
import food.ordering.system.common.domain.valueobject.*
import food.ordering.system.order.domain.exception.OrderDomainException
import food.ordering.system.order.domain.valueobject.StreetAddress
import food.ordering.system.order.domain.valueobject.TrackingId

internal data class OrderProperties(
    val id: OrderId,
    val customerId: CustomerId,
    val restaurantId: RestaurantId,
    val deliveryAddress: StreetAddress,
    val items: List<OrderItem>,
    val trackingId: TrackingId,
    val orderStatus: OrderStatus,
    val failureMessages: List<String>
)

class Order internal constructor(private var props: OrderProperties) : AggregateRoot<OrderId>(props.id) {

    init {
        validate()
    }

    private fun validate() {
        if (totalPrice < Money.ZERO) {
            throw OrderDomainException("Total price cannot be negative")
        }
    }

    fun pay() {

        if (orderStatus != OrderStatus.PENDING) {
            throw OrderDomainException("Order is not pending")
        }

        props = props.copy(orderStatus = OrderStatus.PAID)
    }

    fun approve() {

        if (orderStatus != OrderStatus.PAID) {
            throw OrderDomainException("Order is not paid")
        }

        props = props.copy(orderStatus = OrderStatus.APPROVED)
    }

    fun initCancel(failureMessages: List<String>) {

        if (orderStatus != OrderStatus.PAID) {
            throw OrderDomainException("Order is not paid")
        }

        props = props.copy(
            orderStatus = OrderStatus.CANCELLING
        )

        updateFailureMessages(failureMessages)

    }

    fun cancel(failureMessages: List<String>) {

        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw OrderDomainException("Order is not cancelling or pending")
        }

        props = props.copy(
            orderStatus = OrderStatus.CANCELLED
        )

        updateFailureMessages(failureMessages)

    }

    private fun updateFailureMessages(failureMessages: List<String>) {
        props = props.copy(
            failureMessages = props.failureMessages + failureMessages
        )
    }

    val trackingId
        get() = props.trackingId
    val orderStatus
        get() = props.orderStatus
    val failureMessages
        get() = props.failureMessages

    val totalPrice
        get() =
            props.items.fold(Money.ZERO) { acc, item -> acc + item.calculateSubTotal() }
    val items
        get() = props.items
}