package com.mambu.juvodu.example4;

/**
 * Handles payments
 *
 * @author jtichomirow
 */
public class PaymentService {

    private final UserService userService;
    private final PaymentGateway paymentGateway;

    public PaymentService(UserService userService, PaymentGateway paymentGateway) {
        this.userService = userService;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {

        if (!userService.isValid(user)) {
            throw new IllegalArgumentException("User is invalid.");
        }

        paymentGateway.pay(paymentDetails);
    }
}
