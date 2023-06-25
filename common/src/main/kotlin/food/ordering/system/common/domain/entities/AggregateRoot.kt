package food.ordering.system.common.domain.entities

import food.ordering.system.common.domain.valueobjects.BaseId

abstract class AggregateRoot<Id : BaseId<*>>(id: Id) : BaseEntity<Id>(id)