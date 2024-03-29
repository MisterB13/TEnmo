package com.techelevator.tenmo.model;
import java.math.BigDecimal;

public class Account {

    private int id;
    private int userId;
    private BigDecimal balance;


    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
