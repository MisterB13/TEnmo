package com.techelevator.tenmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tenmo_user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
