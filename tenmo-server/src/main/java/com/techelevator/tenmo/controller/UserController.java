package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.User;
//import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
