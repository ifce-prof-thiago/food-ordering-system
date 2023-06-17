package food.ordering.system.order.domain.valueobject

import java.util.UUID

data class StreetAddress(
    val id: UUID,
    val street: String,
    val postalCode: String,
    val city: String
)