package food.ordering.system.order.application.gateways.data.access.customers.queries

import food.ordering.system.order.application.gateways.data.access.customers.queries.responses.CustomerByIdResponse

interface CustomerDataQuery {
    fun findBy(customerId: String): CustomerByIdResponse?
}