package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Transfer;
import com.techelevator.tenmo.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    public TransferService() { }

    public Transfer createTransfer(Transfer transfer) {
        if(transfer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Transfer");
        } else {
            transferRepository.save(transfer);
            return transfer;
        }
    }

    public Transfer getTransferById(int transferId) {
        if(transferId == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Transfer ID");
        }

        return transferRepository.findById(transferId);
    }

    public List<Transfer> getTransfersByAccount(int accountId) {
        if(accountId == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Account ID");
        }

        return transferRepository.getAccountHistory(accountId);
    }
}
