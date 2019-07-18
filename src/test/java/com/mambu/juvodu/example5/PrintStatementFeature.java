package com.mambu.juvodu.example5;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * Start with acceptance test for outside in design
 *
 * @author jtichomirow
 */
public class PrintStatementFeature {

    @Test
    public void printStatementContainingTransactionsInReversChronologicalOrder() {

        // setup
        List<Transaction> transactions = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.set(2019, 3, 1);
        Transaction transactionOne = new Transaction(1000, 1000, c.getTime());
        c.set(2019, 3, 2);
        Transaction transactionTwo = new Transaction(-100, 900, c.getTime());
        c.set(2019, 3, 10);
        Transaction transactionThree = new Transaction(500, 1400, c.getTime());
        transactions.add(transactionOne);
        transactions.add(transactionTwo);
        transactions.add(transactionThree);

        Account account = mock(Account.class);
        when(account.getTransactions()).thenReturn(transactions);
        AccountService accountService = new AccountService(account);
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);
        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(500);

        // execute
        accountService.printStatement();

        // verify
        InOrder inOrder = inOrder(outMock);
        inOrder.verify(outMock).println("DATE       | AMOUNT | BALANCE");
        inOrder.verify(outMock).println("10/04/2019 | 500 | 1400");
        inOrder.verify(outMock).println("02/04/2019 | -100 | 900");
        inOrder.verify(outMock).println("01/04/2019 | 1000 | 1000");
    }
}
