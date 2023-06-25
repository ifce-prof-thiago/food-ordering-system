package food.ordering.system.order.domain.entities

import food.ordering.system.common.domain.entities.AggregateRoot
import food.ordering.system.common.domain.valueobjects.CustomerId

internal class CustomerProperties(
    val id: CustomerId
)

internal class Customer(props: CustomerProperties) : AggregateRoot<CustomerId>(props.id)