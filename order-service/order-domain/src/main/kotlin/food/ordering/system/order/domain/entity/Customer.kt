package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.entity.AggregateRoot
import food.ordering.system.common.domain.valueobject.CustomerId

internal class CustomerProperties(
    val id: CustomerId
)

internal class Customer(props: CustomerProperties) : AggregateRoot<CustomerId>(props.id)