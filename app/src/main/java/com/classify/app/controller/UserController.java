package com.classify.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getUser")
public class UserController {
    @GetMapping(path="/", produces = "application/json")
    public String getAllUser() {
       return "Hello";
    }


}

