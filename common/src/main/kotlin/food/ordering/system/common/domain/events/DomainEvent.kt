package food.ordering.system.common.domain.events

import java.time.ZoneId
import java.time.ZonedDateTime

val ZonedUTC: ZoneId = ZoneId.of("UTC")

interface DomainEvent<T> {
    val payload: T
    val createdAt: ZonedDateTime
}