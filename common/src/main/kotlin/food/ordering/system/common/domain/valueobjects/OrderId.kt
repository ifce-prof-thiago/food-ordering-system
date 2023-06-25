package food.ordering.system.common.domain.valueobjects

import java.util.*

class OrderId(value: UUID) : BaseId<UUID>(value) {
    companion object {
        fun random() = OrderId(UUID.randomUUID())
    }
}