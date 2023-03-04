package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transaction {

    private final int accountIdFrom;
    private final int accountIdTo;
    private final BigDecimal amount;

    public Transaction(int accountIdFrom, int accountIdTo, BigDecimal amount) {
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.amount = amount;
    }

    public int getAccountIdFrom() {
        return accountIdFrom;
    }

    public int getAccountIdTo() {
        return accountIdTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
