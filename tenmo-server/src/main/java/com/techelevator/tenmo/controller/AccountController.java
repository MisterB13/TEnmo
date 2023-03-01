package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Account getUserAccount(@PathVariable int id) {
        return accountService.getUserAccount(id);
    }
}
