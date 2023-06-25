package food.ordering.system.order.application.stories.create

import food.ordering.system.common.domain.valueobjects.Money
import food.ordering.system.common.domain.valueobjects.ProductId
import food.ordering.system.common.domain.valueobjects.RestaurantId
import food.ordering.system.order.application.gateways.data.access.customers.queries.CustomerDataQuery
import food.ordering.system.order.application.gateways.data.access.orders.commands.OrderDataCommand
import food.ordering.system.order.application.gateways.data.access.restaurants.queries.RestaurantDataQuery
import food.ordering.system.order.domain.OrderDomainService
import food.ordering.system.order.domain.entities.Order
import food.ordering.system.order.domain.entities.Restaurant
import food.ordering.system.order.domain.entities.createOrderItemWith
import food.ordering.system.order.domain.exceptions.OrderDomainException
import mu.KotlinLogging
import java.util.*

private val log = KotlinLogging.logger {}

class CreateOrderStoryImpl(
    private val orderDomainService: OrderDomainService,
    private val orderDataCommand: OrderDataCommand,
    private val customerDataQuery: CustomerDataQuery,
    private val restaurantDataQuery: RestaurantDataQuery
) : CreateOrderStory {

    // TODO("Transaction management is missing")
    override fun execute(request: CreateOrderInput): CreateOrderResponse {

        checkIfCustomerExists(request.customerId)

        val restaurant = findRestaurantInformationOrThrows(request.restaurantId)

        val items = getItemsBy(request, restaurant.id)

        val order = request.toOrder(items)

        val orderCreatedEvent = orderDomainService.createOrder(order, restaurant)

        log.info { "Order ${order.id.value} created" }

        return CreateOrderResponse.from(order)
    }

    private fun checkIfCustomerExists(customerId: UUID) {

        val customer = customerDataQuery.findBy(customerId.toString())

        customer ?: run {
            log.warn { "Could not find customer with id $customerId" }
            throw OrderDomainException("Could not find customer with id $customerId")
        }

    }

    private fun findRestaurantInformationOrThrows(restaurantId: UUID): Restaurant {
        val restaurantInformation = restaurantDataQuery.findBy(RestaurantId(restaurantId))

        restaurantInformation ?: run {
            log.warn { "Could not find restaurant with id $restaurantId" }
            throw OrderDomainException("Could not find restaurant with id $restaurantId")
        }

        return restaurantInformation.toRestaurant()
    }

    private fun saveOrder(order: Order) {
        orderDataCommand.save(order)
        log.info { "Order ${order.id.value} saved" }
    }

    private fun getItemsBy(
        request: CreateOrderInput,
        restaurantId: RestaurantId
    ) = request.items.map {

        val productId = ProductId(it.productId)
        val productItem = restaurantDataQuery.findProductBy(RestaurantId(request.restaurantId), productId)

        productItem ?: run {
            log.warn { "Could not find product with id ${it.productId} in restaurant ${restaurantId.value}" }
            throw OrderDomainException("Could not find product with id ${it.productId} in restaurant ${restaurantId.value}")
        }

        createOrderItemWith(
            productId = productId,
            name = productItem.name,
            price = Money(productItem.price),
            quantity = it.quantity
        )
    }

}