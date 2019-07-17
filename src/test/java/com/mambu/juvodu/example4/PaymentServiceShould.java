package com.mambu.juvodu.example4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Test suite for {@link PaymentService}
 *
 * @author jtichomirow
 */
public class PaymentServiceShould {

    private final PaymentGateway paymentGatewayMock = mock(PaymentGateway.class);
    private final UserService userServiceMock = mock(UserService.class);
    private final PaymentService paymentService = new PaymentService(userServiceMock, paymentGatewayMock);

    @Test
    public void delegateToPaymentGatewayIfUserValid() {

        // setup
        User user = new User();
        PaymentDetails paymentDetails = new PaymentDetails();
        when(userServiceMock.isValid(user)).thenReturn(true);

        // execute
        paymentService.processPayment(user, paymentDetails);

        // verify
        verify(paymentGatewayMock).pay(paymentDetails);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notDelegateToPaymentGatewayIfUserNotValid() {

        // setup
        User user = new User();
        PaymentDetails paymentDetails = new PaymentDetails();
        when(userServiceMock.isValid(user)).thenReturn(false);

        // execute
        try {

            paymentService.processPayment(user, paymentDetails);

        } catch (IllegalArgumentException e) {

            // verify
            verify(paymentGatewayMock, never());
            throw e;
        }
    }
}