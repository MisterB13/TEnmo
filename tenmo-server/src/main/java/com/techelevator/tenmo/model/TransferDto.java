package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferDto {
    private final int Id;
    private final AccountDto accountFrom;
    private final AccountDto accountTo;
    private final BigDecimal amount;

    public TransferDto(int id, AccountDto accountFrom, AccountDto accountTo, BigDecimal amount) {
        Id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public int getId() {
        return Id;
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
