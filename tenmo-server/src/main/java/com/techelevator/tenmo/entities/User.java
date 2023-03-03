package com.techelevator.tenmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tenmo_user")
public class User {

    @Id
    @Column(name = "user_id")
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    private int Id;

    @Column(name = "username")
    private String username;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
