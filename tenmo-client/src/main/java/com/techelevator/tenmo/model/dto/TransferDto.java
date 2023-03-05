package com.techelevator.tenmo.model.dto;

import java.math.BigDecimal;

public class TransferDto {
    private int id;
    private AccountDto accountFrom;
    private AccountDto accountTo;
    private BigDecimal amount;

    public TransferDto() {
    }

    public TransferDto(int id, AccountDto accountFrom, AccountDto accountTo, BigDecimal amount) {
        this.id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public AccountDto getAccountFrom() {
        return accountFrom;
    }

    public AccountDto getAccountTo() {
        return accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
