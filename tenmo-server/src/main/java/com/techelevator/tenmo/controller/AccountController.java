package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.model.TransactionDto;
import com.techelevator.tenmo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/account")
@EnableTransactionManagement
@PreAuthorize("isAuthenticated()")
public class AccountController {

    @Autowired
    AccountService accountService;

    public AccountController() { }

    @GetMapping(path = "/{id}")
    public Account getUserAccount(@PathVariable("id") int userId) {
        return accountService.getUserAccount(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping()
    public Account updateUserAccount(@Valid @RequestBody Account account) {
        return accountService.updateAccountBalance(account);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/transaction")
    public boolean createTransaction(@RequestBody TransactionDto transactionDto) {
        return accountService.createTransaction(transactionDto);
    }
}
