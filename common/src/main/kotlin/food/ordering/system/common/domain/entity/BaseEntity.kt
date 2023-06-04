package food.ordering.system.common.domain.entity

import food.ordering.system.common.domain.valueobject.BaseId

abstract class BaseEntity<Id : BaseId<*>>(val id: Id) {

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity<*>) return false
        return id == other.id
    }

}