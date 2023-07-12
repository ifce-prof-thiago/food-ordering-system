package food.ordering.system.order.application.stories.track

import food.ordering.system.order.application.gateways.data.cqrs.orders.queries.FindOrderByTrackingIdQuery
import food.ordering.system.order.domain.valueobjects.TrackingId

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class TrackOrderStoryImpl(private val findOrderByTrackingIdQuery: FindOrderByTrackingIdQuery) : TrackOrderStory {
    override fun execute(input: TrackOrderInput): TrackOrderResponse {

        val orderResponse = findOrderByTrackingIdQuery.findBy(TrackingId(input.orderTrackingId))
            ?: run {
                val errorMessage = "Could not find order with tracking id ${input.orderTrackingId}"
                log.warn { errorMessage }
                throw TrackOrderStoryException(errorMessage)
            }

        return TrackOrderResponse(
            orderResponse.orderId.value,
            orderResponse.orderStatus
        )
    }

}