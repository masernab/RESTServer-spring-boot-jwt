package com.miguel.springjwt.security.services;

import com.miguel.springjwt.models.User;
import com.miguel.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> addUser(User user) {
        try {
            if(userRepository.existsByEmail(user.getEmail())){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            User newUser = userRepository.save(user);
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = userRepository.findAll();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
