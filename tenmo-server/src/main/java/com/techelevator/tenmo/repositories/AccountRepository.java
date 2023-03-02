package com.techelevator.tenmo.repositories;

import com.techelevator.tenmo.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
<<<<<<< HEAD
    Account findByUserId(int userId);
    Account save(Account account);
=======
    Account findByUserId(int id);
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b

}
