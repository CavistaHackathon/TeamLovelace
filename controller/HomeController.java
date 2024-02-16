package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/")
public class HomeController {
    @PostMapping("/roleRoute")
    public String RoutingTry(@RequestBody String role,@RequestBody String username,@RequestBody String password){
        System.out.println(role);
            if(role.equals("user")){
                return "redirect:/user/home";
            }
            else if(role.equals("admin")){
                return "redirect:/admin/home";
            }else{
                return "redirect:/user/login";
            }
    }

}
