package food.ordering.system.order.application.stories.track

interface TrackOrderStory {
    fun execute(request: TrackOrderInput): TrackOrderResponse
}