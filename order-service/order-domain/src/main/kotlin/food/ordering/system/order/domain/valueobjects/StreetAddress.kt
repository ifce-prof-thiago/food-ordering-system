package food.ordering.system.order.domain.valueobjects

import java.util.*

data class StreetAddress(
    val id: UUID = UUID.randomUUID(),
    val street: String,
    val postalCode: String,
    val city: String
)