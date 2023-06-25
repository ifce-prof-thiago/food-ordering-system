package food.ordering.system.order.application.gateways.messaging.restaurant.approval

interface RestaurantApprovalMessageListener {
    fun orderApproved(restaurantApprovalResponse: RestaurantApprovalResponse)
    fun orderRejected(restaurantApprovalResponse: RestaurantApprovalResponse)
}