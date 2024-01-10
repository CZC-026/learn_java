package com.czc.controller;

import com.czc.entity.User;
import com.czc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/info")
    public List<User> getUerInfo(){
        return userService.getUserInfo();
    }
    @GetMapping("/name")
    public String getUserName(){
        return "czc";
    }
}
