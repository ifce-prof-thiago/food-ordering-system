package food.ordering.system.order.domain.valueobjects

import food.ordering.system.common.domain.valueobjects.BaseId
import java.util.*

class TrackingId(value: UUID) : BaseId<UUID>(value) {
    companion object {
        fun create() = TrackingId(UUID.randomUUID())
        fun fromString(value: String) = TrackingId(UUID.fromString(value))
        fun fromUUID(value: UUID) = TrackingId(value)
    }
}