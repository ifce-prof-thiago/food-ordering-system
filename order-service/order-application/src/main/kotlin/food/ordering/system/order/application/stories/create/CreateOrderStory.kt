package food.ordering.system.order.application.stories.create

interface CreateOrderStory {
    fun execute(request: CreateOrderInput): CreateOrderResponse
}