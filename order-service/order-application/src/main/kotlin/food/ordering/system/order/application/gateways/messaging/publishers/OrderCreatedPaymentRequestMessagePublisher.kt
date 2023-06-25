package food.ordering.system.order.application.gateways.messaging.publishers

import food.ordering.system.common.domain.events.DomainEventPublisher
import food.ordering.system.order.domain.events.OrderCreatedEvent

interface OrderCreatedPaymentRequestMessagePublisher : DomainEventPublisher<OrderCreatedEvent>