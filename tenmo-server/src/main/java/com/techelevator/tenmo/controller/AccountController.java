package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

<<<<<<< HEAD
    public AccountController() { }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Account getUserAccount(@PathVariable("id") int userId) {
        return accountService.getUserAccount(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public Account updateUserAccount(@RequestBody Account account) {
        return accountService.updateAccountBalance(account);
=======
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Account getUserAccount(@PathVariable int id) {
        return accountService.getUserAccount(id);
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
    }
}
