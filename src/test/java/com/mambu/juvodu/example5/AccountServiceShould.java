package com.mambu.juvodu.example5;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Test suite for {@link AccountService}
 *
 * @author jtichomirow
 */
public class AccountServiceShould {

    @Test
    public void increaseAccountBalanceByOneThousandWhenDepositOneThousand() {

        // setup
        Account accountMock = mock(Account.class);
        AccountService accountService = new AccountService(accountMock);

        // execute
        accountService.deposit(1000);

        // verify
        verify(accountMock).addTransaction(1000);
    }

    @Test
    public void decreaseAccountBalanceByOneThousandWhenWithdrawOneThousand() {

        // setup
        Account accountMock = mock(Account.class);
        AccountService accountService = new AccountService(accountMock);

        // execute
        accountService.withdraw(1000);

        // verify
        verify(accountMock).addTransaction(-1000);
    }
}
