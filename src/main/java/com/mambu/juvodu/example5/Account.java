package com.mambu.juvodu.example5;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains of transactions belonging to the same account
 *
 * @author jtichomirow
 */
public class Account {

    private List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(int amount) {

        int balance = getBalance() + amount;
        Transaction transaction = new Transaction(amount, balance);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getBalance() {

        if (transactions.isEmpty()) {
            return 0;
        }

        return transactions.get(transactions.size() - 1).getBalance();
    }
}
