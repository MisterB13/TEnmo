package com.techelevator.tenmo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @Column(name = "transfer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transfer_type_id")
    @NotNull(message = "Transfer Type is required.")
    private int transferTypeId;

    @Column(name = "transfer_status_id")
    @NotNull(message = "Transfer Status is required.")
    private int transferStatusId;

    @Column(name = "account_from")
    @NotNull(message = "Sending Account ID is required.")
    private int accountFromId;

    @Column(name = "account_to")
    @NotNull(message = "Receiving Account ID is required ")
    private int accountToId;

    @Column(name = "amount")
    @NotNull(message = "Balance is required.")
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
