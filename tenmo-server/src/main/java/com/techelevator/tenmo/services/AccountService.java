package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.exceptions.ResourceNotFoundException;
import com.techelevator.tenmo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

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
}
