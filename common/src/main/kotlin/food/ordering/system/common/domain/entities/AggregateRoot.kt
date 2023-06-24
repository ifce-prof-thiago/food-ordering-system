package food.ordering.system.common.domain.entity

import food.ordering.system.common.domain.valueobject.BaseId

abstract class AggregateRoot<Id : BaseId<*>>(id: Id) : BaseEntity<Id>(id)