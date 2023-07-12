package food.ordering.system.order.domain.entities

import food.ordering.system.common.domain.valueobjects.CustomerId
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class CustomerTest {

    @Test
    fun `should create customer`() {

        val customerId = CustomerId(UUID.randomUUID())
        val customer = Customer(CustomerProperties(customerId))

        assertEquals(customerId, customer.id)
    }
}