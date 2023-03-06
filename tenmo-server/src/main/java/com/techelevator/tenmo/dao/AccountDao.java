package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.entities.Account;

public interface AccountDao {
    Account getUserAccount(int userId);

    Account getAccountByAccountID(int accountId);

//    boolean createTransaction(int accountFromId, int accountToId , BigDecimal amount);

    void updateAccount(Account accountToUpdate);
}
