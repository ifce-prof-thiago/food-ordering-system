package food.ordering.system.order.application.gateways.cqrs.customers

interface QueryCustomerById {
    fun findBy(customerId: String): CustomerById?
}

data class CustomerById(
    val customerId: String
)