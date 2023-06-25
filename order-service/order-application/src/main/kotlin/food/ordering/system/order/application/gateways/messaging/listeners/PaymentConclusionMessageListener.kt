package food.ordering.system.order.application.gateways.messaging.listeners

import food.ordering.system.common.domain.valueobjects.PaymentStatus
import java.time.Instant

interface PaymentConclusionMessageListener {
    fun paymentCompleted(paymentConclusionPayload: PaymentConclusionPayload)
    fun paymentCancelled(paymentConclusionPayload: PaymentConclusionPayload)
}

data class PaymentConclusionPayload(
    val id: String,
    val sagaId: String,
    val orderId: String,
    val paymentId: String,
    val paymentStatus: PaymentStatus,
    val customerId: String,
    val price: Number,
    val createdAt: Instant,
    val failureMessages: List<String>
)