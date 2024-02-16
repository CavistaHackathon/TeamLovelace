package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String loginAdmin(String username,String password,String role){
        return "redirect succesfully";
        //redicrect to home page
    }
}
