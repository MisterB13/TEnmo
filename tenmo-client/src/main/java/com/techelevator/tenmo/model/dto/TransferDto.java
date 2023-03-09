package com.techelevator.tenmo.model.dto;

import java.math.BigDecimal;

public class TransferDto {
    private int id;
    private AccountDto accountFrom;
    private AccountDto accountTo;
    private String transferType;
    private String transferStatus;
    private BigDecimal amount;

    public TransferDto() {
    }

    public TransferDto(int id, AccountDto accountFrom, AccountDto accountTo, String transferType, String transferStatus, BigDecimal amount) {
        this.id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.transferType = transferType;
        this.transferType = transferStatus;
        this.amount = amount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
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
