package food.ordering.system.order.domain.entity

import food.ordering.system.common.domain.entity.BaseEntity
import food.ordering.system.common.domain.valueobject.Money
import food.ordering.system.common.domain.valueobject.ProductId

internal data class ProductProperties(
    val id: ProductId,
    val name: String,
    val price: Money
)

class Product internal constructor(private var props: ProductProperties) : BaseEntity<ProductId>(props.id) {

    val price: Money
        get() = props.price

    val name: String
        get() = props.name

}