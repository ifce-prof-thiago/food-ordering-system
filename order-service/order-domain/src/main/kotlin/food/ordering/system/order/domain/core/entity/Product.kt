package food.ordering.system.order.domain.core.entity

import food.ordering.system.common.domain.entity.BaseEntity
import food.ordering.system.common.domain.valueobject.Money
import food.ordering.system.common.domain.valueobject.ProductId

class Product(id: ProductId, val name: String, val price: Money) : BaseEntity<ProductId>(id)