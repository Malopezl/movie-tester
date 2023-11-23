package gt.com.archteam.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
