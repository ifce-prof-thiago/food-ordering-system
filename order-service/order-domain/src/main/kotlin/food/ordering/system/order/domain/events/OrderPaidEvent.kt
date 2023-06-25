package food.ordering.system.order.domain.events

import food.ordering.system.common.domain.events.DomainEvent
import food.ordering.system.common.domain.events.ZonedUTC
import food.ordering.system.order.domain.entities.Order
import java.time.ZonedDateTime

data class OrderPaidEvent(
    override val payload: Order,
    override val createdAt: ZonedDateTime = ZonedDateTime.now(ZonedUTC)
) : DomainEvent<Order>