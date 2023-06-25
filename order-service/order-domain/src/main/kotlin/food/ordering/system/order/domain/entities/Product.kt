package food.ordering.system.order.domain.entities

import food.ordering.system.common.domain.entities.BaseEntity
import food.ordering.system.common.domain.valueobjects.Money
import food.ordering.system.common.domain.valueobjects.ProductId

internal data class ProductProperties(
    val id: ProductId,
    val name: String,
    val price: Money
)

class Product internal constructor(private var props: ProductProperties) : BaseEntity<ProductId>(props.id) {
    val name get() = props.name
    val price get() = props.price
}