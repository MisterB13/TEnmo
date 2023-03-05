package com.techelevator.tenmo.model.dto;

public class AccountDto {
    private int id;
    private int userId;
    private String userName;

    public AccountDto() {
    }

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
