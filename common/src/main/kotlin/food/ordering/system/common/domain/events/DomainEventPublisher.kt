package food.ordering.system.common.domain.events

interface DomainEventPublisher<T : DomainEvent<*>> {
    fun publish(event: T)
}