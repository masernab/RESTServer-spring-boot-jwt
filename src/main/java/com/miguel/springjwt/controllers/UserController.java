package com.miguel.springjwt.controllers;

import com.miguel.springjwt.models.User;
import com.miguel.springjwt.security.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@CrossOrigin("*")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }
}
