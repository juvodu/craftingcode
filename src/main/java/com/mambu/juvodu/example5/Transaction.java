package com.mambu.juvodu.example5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Entity that describes a balance change of an account
 *
 * @author jtichomirow
 */
public class Transaction {

    private final SimpleDateFormat dd_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");

    private Date date;

    private int amount;

    private int balance;

    public Transaction(int amount, int balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Transaction(int amount, int balance, Date date) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return dd_MM_YYYY.format(date) + " | " + amount + " | " + balance;
    }
}
