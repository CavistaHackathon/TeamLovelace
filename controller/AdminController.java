package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public String loginAdmin(String username,String password,String role){
        return "redirect succesfully";
        //redicrect to home page
    }
}
