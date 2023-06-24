package food.ordering.system.order.domain.event

import food.ordering.system.common.domain.event.DomainEvent
import food.ordering.system.order.domain.entity.Order
import java.time.ZoneId
import java.time.ZonedDateTime

data class OrderCreatedEvent(
    override val payload: Order,
    override val createdAt: ZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
) : DomainEvent<Order>