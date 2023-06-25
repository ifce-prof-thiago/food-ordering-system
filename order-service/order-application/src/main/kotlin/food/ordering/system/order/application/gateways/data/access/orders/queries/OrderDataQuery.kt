package food.ordering.system.order.application.gateways.data.access.orders.queries

import food.ordering.system.order.application.gateways.data.access.orders.queries.responses.OrderByTrackingIdResponse
import food.ordering.system.order.domain.valueobjects.TrackingId

interface OrderDataQuery {
    fun findBy(trackingId: TrackingId): OrderByTrackingIdResponse?
}

