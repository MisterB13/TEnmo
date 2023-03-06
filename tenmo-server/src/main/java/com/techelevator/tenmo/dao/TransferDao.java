package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.entities.Transfer;

import java.util.List;

public interface TransferDao {

    Transfer getTransfer(int id);

    List<Transfer> getAllTransfers();

    List<Transfer> getTransferHistory(int accountId);

    List<Transfer> getPendingTransfers(int userId);

    int createTransfer(Transfer transfer);

    void updateTransfer(Transfer transfer);
}

