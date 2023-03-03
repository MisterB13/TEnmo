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

<<<<<<< HEAD
    public UserController() { }

=======
<<<<<<< HEAD
    public UserController() { }

=======
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
