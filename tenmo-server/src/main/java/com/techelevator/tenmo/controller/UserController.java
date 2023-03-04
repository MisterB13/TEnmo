package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.User;
import com.techelevator.tenmo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    UserService userService;

    public UserController() { }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
