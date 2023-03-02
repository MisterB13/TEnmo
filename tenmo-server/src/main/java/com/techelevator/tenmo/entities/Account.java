package com.techelevator.tenmo.entities;

import javax.persistence.*;
<<<<<<< HEAD
import java.math.BigDecimal;
=======
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "balance")
<<<<<<< HEAD
    private BigDecimal balance;
=======
    private double balance;
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

<<<<<<< HEAD
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
=======
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
        this.balance = balance;
    }
}
