package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    public String loginAdmin(String username,String password,String role){
        return "redirect succesfully";
        //redicrect to home page
    }
}
