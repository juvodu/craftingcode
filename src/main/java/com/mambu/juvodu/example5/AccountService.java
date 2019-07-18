package com.mambu.juvodu.example5;

import java.util.Comparator;

/**
 * Service exposes common operations on the {@link Account} entity
 *
 * @author jtichomirow
 */
public class AccountService {

    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(int amount) {

        account.addTransaction(amount);
    }

    public void withdraw(int amount) {

        account.addTransaction(-amount);
    }

    public void printStatement() {

        System.out.println("DATE       | AMOUNT | BALANCE");
        account.getTransactions().stream().sorted(Comparator.comparing(Transaction::getDate).reversed())
                .forEach(transaction -> {
                    System.out.println(transaction.toString());
                });
    }
}
