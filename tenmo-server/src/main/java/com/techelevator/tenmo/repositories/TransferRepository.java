package com.techelevator.tenmo.repositories;

import com.techelevator.tenmo.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    Transfer save(Transfer transfer);
    Transfer findById(int transferId);
    @Query(value = "SELECT * FROM transfer t WHERE t.account_from = ?1 OR t.account_to = ?1", nativeQuery = true)
    List<Transfer> getAccountHistory(int id);
//    @Query(value = "SELECT * FROM transfer t WHERE t.account_from = :id OR t.account_to = :id", nativeQuery = true)
//    List<Transfer> history(@Param("id") int id);

}
