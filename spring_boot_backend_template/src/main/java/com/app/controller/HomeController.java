package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {
    @PostMapping("/roleRoute")
    public String RoutingTry(@RequestBody String role){
        System.out.println(role);
            if(role.equals("user")){
                return "its user";
            }
            else{
                return "redirect:/user/login";
            }
    }

}
