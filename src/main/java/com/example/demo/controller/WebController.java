package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UrlCreator;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UrlCreator urlCreator;

    @GetMapping("/db")
    public Iterable<User> getAllData(){
        return userRepository.findAll();
    }



    //user sign in
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/SignIn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user, UrlCreator urlCreator) throws IOException {

        String name = user.getName();
        urlCreator.creatingFolder(user);
        userService.saveUser(user);


        return ResponseEntity.ok(user);
    }

}
