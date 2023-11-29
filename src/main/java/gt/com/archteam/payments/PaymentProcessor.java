package gt.com.archteam.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        return this.paymentGateway.requestPayment(new PaymentRequest(amount))
                .getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
