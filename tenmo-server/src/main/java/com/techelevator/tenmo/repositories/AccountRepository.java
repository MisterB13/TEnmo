package com.techelevator.tenmo.repositories;

import com.techelevator.tenmo.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserId(int userId);
    Account save(Account account);

}
