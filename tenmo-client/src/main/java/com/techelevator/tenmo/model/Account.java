package com.techelevator.tenmo.model;

public class Account {


    //@JsonProperty("account_id")
    private int id;
    //@JsonProperty("user_id")
    private int userId;

    //@JsonProperty("balance")
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
