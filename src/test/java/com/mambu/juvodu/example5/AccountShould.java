package com.mambu.juvodu.example5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test suite for {@link Account}
 *
 * @author jtichomirow
 */
public class AccountShould {

    @Test
    public void returnZeroBalanceIfNoTransactionsExistForAccount() {

        // setup
        Account account = new Account();

        // verify
        assertEquals(0, account.getBalance());
    }

    @Test
    public void returnNegativeBalanceWhenAddNegativeTransactionForNewAccount() {

        // setup
        Account account = new Account();

        // execute
        account.addTransaction(-100);

        // verify
        assertEquals(-100, account.getBalance());
    }

    @Test
    public void returnPositiveBalanceWhenAddPositiveTransactionForNewAccount() {

        // setup
        Account account = new Account();

        // execute
        account.addTransaction(100);

        // verify
        assertEquals(100, account.getBalance());
    }
}