package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    @GetMapping("/test")
    public String loginAdmin(){
        return "redirect succesfully";
        //redicrect to home page
    }
}