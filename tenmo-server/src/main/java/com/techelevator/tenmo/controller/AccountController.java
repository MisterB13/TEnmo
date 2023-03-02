package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    public AccountController() { }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Account getUserAccount(@PathVariable("id") int userId) {
        return accountService.getUserAccount(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public Account updateUserAccount(@RequestBody Account account) {
        return accountService.updateAccountBalance(account);
    }
}
