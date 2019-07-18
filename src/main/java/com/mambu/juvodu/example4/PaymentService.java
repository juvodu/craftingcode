package com.mambu.juvodu.example4;

/**
 * Handles payments
 *
 * @author jtichomirow
 */
public class PaymentService {

    private final UserValidator userValidator;
    private final PaymentGateway paymentGateway;

    public PaymentService(UserValidator userValidator, PaymentGateway paymentGateway) {
        this.userValidator = userValidator;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {

        if (!userValidator.isValid(user)) {
            throw new IllegalArgumentException("User is invalid.");
        }

        paymentGateway.pay(paymentDetails);
    }
}
