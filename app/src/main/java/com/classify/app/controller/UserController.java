package com.classify.app.controller;

import com.classify.app.model.User;
import com.classify.app.repository.UserRepository;
import com.classify.app.service.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RegisterUser registerUser;
    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/login/{username}", produces = "application/json")
    public List<User> getAllUser(@PathVariable String username) {
       return userRepository.findByName(username);
    }

    @PostMapping(value = "/register",produces = "application/json")
    public User registerUser(@RequestBody User user){
        return registerUser.registerUser(user);
    }
    @PutMapping(value = "/update",produces = "application/json")
    public User updateUser(@RequestBody User user){
        return registerUser.registerUser(user);
    }



}

