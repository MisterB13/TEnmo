package com.techelevator.tenmo.services;

import com.techelevator.tenmo.entities.User;
import com.techelevator.tenmo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() { }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
