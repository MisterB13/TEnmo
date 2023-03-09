package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int Id;
    private int transferTypeId;
//    private String transferType;
    private int transferStatusId;
//    private String transferStatus;
    private int accountFromId;
    private int accountToId;
    private BigDecimal amount;

    public Transfer() { }

    public Transfer(int accountFromId, int accountToId, BigDecimal amount) { //Send Constructor
        transferTypeId = 2; //Send = 2
        transferStatusId = 2; //Approved = 2
        this.accountFromId = accountFromId;
        this.accountToId = accountToId;
//        this.transferType = transferType;
//        this.transferStatus = transferStatus;
        this.amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public int getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }

    public int getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
