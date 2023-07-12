package food.ordering.system.order.application.stories.create

import food.ordering.system.order.application.gateways.messaging.publishers.OrderCreatedPaymentRequestMessagePublisher
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class CreateOrderStoryImpl(
    private val createOrderHelper: CreateOrderHelper,
    private val orderCreatedPaymentRequestMessagePublisher: OrderCreatedPaymentRequestMessagePublisher
) : CreateOrderStory {

    override fun execute(input: CreateOrderInput): CreateOrderResponse {

        val orderCreatedEvent = createOrderHelper.persistOrder(input)

        log.info { "Order ${orderCreatedEvent.payload.id.value} created" }

        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent)

        return CreateOrderResponse.from(orderCreatedEvent.payload)
    }

}