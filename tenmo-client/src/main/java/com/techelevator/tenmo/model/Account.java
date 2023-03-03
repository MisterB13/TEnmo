package com.techelevator.tenmo.model;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
import java.math.BigDecimal;

public class Account {

    private int id;
    private int userId;
    private BigDecimal balance;

<<<<<<< HEAD
=======
=======
public class Account {


    //@JsonProperty("account_id")
    private int id;
    //@JsonProperty("user_id")
    private int userId;

    //@JsonProperty("balance")
    private double balance;
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

    public int getId() {
        return id;
    }

<<<<<<< HEAD
//    public void setId(int id) {
//        this.id = id;
//    }
=======
<<<<<<< HEAD
//    public void setId(int id) {
//        this.id = id;
//    }
=======
    public void setId(int id) {
        this.id = id;
    }
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

    public int getUserId() {
        return userId;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
<<<<<<< HEAD
=======
=======
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
        this.balance = balance;
    }
}
