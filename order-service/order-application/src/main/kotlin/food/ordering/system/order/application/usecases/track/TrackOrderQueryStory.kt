package food.ordering.system.order.application.usecases.track

interface TrackOrderQueryStory {

    fun execute(request: TrackOrderQueryInput): TrackOrderQueryResponse

}