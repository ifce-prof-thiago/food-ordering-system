package food.ordering.system.order.application.gateways.messaging.payment

interface PaymentResponseMessageListener {
    fun paymentCompleted(paymentResponse: PaymentResponse)
    fun paymentCancelled(paymentResponse: PaymentResponse)
}