package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
   private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/db")
    public Iterable<User> getAllData(){
        return userRepository.findAll();
    }



    //user sign in
    @PostMapping(value = "/SignIn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser( @RequestBody User user) {

        return userService.saveUser(user);
    }

}
