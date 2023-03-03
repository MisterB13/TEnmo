package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Transfer;
import com.techelevator.tenmo.exceptions.InvalidResourceException;
import com.techelevator.tenmo.exceptions.ResourceNotFoundException;
import com.techelevator.tenmo.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    public TransferService() { }

    public Transfer createTransfer(Transfer transfer) {
        if(transfer == null) {
            throw new InvalidResourceException("Transfer was null");
        }

        transferRepository.save(transfer);
        return transfer;

    }

    public Transfer getTransferById(int transferId) {
        Transfer transfer = transferRepository.findById(transferId);
        if(transfer == null) {
            throw new ResourceNotFoundException("Account Not Found for Transfer ID: " + transferId);
        }

        return transfer;
    }

    public List<Transfer> getTransfersByAccount(int accountId) {
        List<Transfer> transfers = transferRepository.getAccountHistory(accountId);
        if(transfers == null) {
            throw new ResourceNotFoundException("Transfer History Not Found for Account ID: " + accountId);
        }

        return transfers;
    }
}
