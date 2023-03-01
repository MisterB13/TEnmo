package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountService() { }

    public Account getUserAccount(int id) {
        return accountRepository.findByUserId(id);
    }

}
