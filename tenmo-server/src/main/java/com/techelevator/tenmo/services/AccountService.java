package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.entities.Transfer;
import com.techelevator.tenmo.exceptions.InvalidResourceException;
import com.techelevator.tenmo.exceptions.ResourceNotFoundException;
import com.techelevator.tenmo.model.TransactionDto;
import com.techelevator.tenmo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransferService transferService;

    public AccountService() { }

    public Account getUserAccount(int userId) {
        Account account = accountRepository.findByUserId(userId);
        if(account == null) {
            throw new ResourceNotFoundException("Account Not Found for User ID: " + account.getUserId());
        }
        return account;
    }

    public Account updateAccountBalance(Account account) {
        Account accountToUpdate = getUserAccount(account.getUserId());
        if(accountToUpdate == null) {
            throw new ResourceNotFoundException("Account Not Found for User ID: " + account.getUserId());
        }

        accountToUpdate.setBalance(account.getBalance());
        accountRepository.save(accountToUpdate);
        return accountToUpdate;
    }

    @Transactional()
    public boolean createTransaction(TransactionDto transactionDto) {
        if(transactionDto == null) {
            throw new InvalidResourceException("Transaction Failed, Bad Request.");
        }
        Account accountFrom =  accountRepository.findById(transactionDto.getAccountIdFrom());
        accountFrom.setBalance(accountFrom.getBalance().subtract(transactionDto.getAmount()));
        accountRepository.save(accountFrom);

        Account accountTo = accountRepository.findById(transactionDto.getAccountIdTo());
        accountTo.setBalance(accountTo.getBalance().add(transactionDto.getAmount()));
        accountRepository.save(accountTo);

        Transfer transfer = new Transfer();
        transfer.setTransferTypeId(2);
        transfer.setTransferStatusId(2);
        transfer.setAccountToId(accountTo.getId());
        transfer.setAccountFromId(accountFrom.getId());
        transfer.setAmount(transactionDto.getAmount());

        Transfer transferCompleted = transferService.createTransfer(transfer);
        System.out.println(transferCompleted.getId());
        return true;
    }
}
