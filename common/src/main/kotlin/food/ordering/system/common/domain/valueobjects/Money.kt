package food.ordering.system.common.domain.valueobjects

import java.math.BigDecimal
import java.math.RoundingMode

class Money(val amount: BigDecimal) : Comparable<Money> {
    init {
        amount.setScale(2, RoundingMode.HALF_EVEN)
    }
    constructor(amount: Number) : this(BigDecimal(amount.toDouble()))
    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }
    operator fun minus(other: Money): Money {
        return Money(amount - other.amount)
    }
    operator fun times(other: Money): Money {
        return Money(amount * other.amount)
    }
    operator fun times(other: Int): Money {
        val other = BigDecimal(other)
        return Money(amount * other)
    }
    operator fun unaryMinus(): Money {
        return Money(-amount)
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Money) return false
        return amount == other.amount
    }
    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }
}