package com.techelevator.tenmo.model;

public class AccountDto {
    private final int id;
    private final int userId;
    private final String userName;

    public AccountDto(int id, int userId, String userName) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
