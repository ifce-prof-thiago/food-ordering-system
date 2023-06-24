package food.ordering.system.common.domain.event

import java.time.ZoneId
import java.time.ZonedDateTime

interface DomainEvent<T> {
    val payload: T
    val createdAt: ZonedDateTime
}