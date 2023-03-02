package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.Account;
import com.techelevator.tenmo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
=======
import org.springframework.stereotype.Service;
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountService() { }

<<<<<<< HEAD
    public Account getUserAccount(int userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account updateAccountBalance(Account account) {
        Account accountToUpdate = getUserAccount(account.getUserId());
        if(accountToUpdate == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found");
        } else {
            accountToUpdate.setBalance(account.getBalance());
            accountRepository.save(accountToUpdate);
            return accountToUpdate;
        }
    }



=======
    public Account getUserAccount(int id) {
        return accountRepository.findByUserId(id);
    }

>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
}
