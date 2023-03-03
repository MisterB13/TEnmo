package com.techelevator.tenmo.model;

import java.util.Objects;

public class User {

    private int id;
    private String username;

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof User) {
            User otherUser = (User) other;
            return otherUser.getId() == id
                    && otherUser.getUsername().equals(username);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
