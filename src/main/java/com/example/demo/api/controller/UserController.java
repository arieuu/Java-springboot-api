package com.example.demo.api.controller;


import com.example.demo.api.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user") // This means we can make get requests to this method
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);

        if(user.isPresent()) {
            return (User) user.get();
        }

        return null;
    }
}
