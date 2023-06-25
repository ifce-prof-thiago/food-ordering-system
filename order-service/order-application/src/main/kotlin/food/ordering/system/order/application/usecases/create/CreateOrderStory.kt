package food.ordering.system.order.application.usecases.create

interface CreateOrderStory {
    fun execute(request: CreateOrderInput): CreateOrderResponse
}