package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entites.HomeAppointment;
import com.app.Entites.UserDetails;
import com.app.dto.userDto;
import com.app.service.HomeAppointmentService;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired 
    private UserService service;

    @Autowired
    private HomeAppointmentService appointmentService;

    @Autowired
    private HttpSession session;
    @PostMapping("/create")
    public UserDetails createUser(@RequestBody userDto user){
        System.out.println(user);
        return service.saveUser(user);   
    }

    @PostMapping("/login")
    public void login(@RequestBody String username, @RequestBody String pass){
       UserDetails user= service.findByUsername(username);
       session.setAttribute("id", user.getId());
       session.setAttribute("name",user.getUserName());
       session.setAttribute("password",user.getPass());
       session.setAttribute("role", user.getRole());
    }

    @GetMapping("/myAppointments/{id}")
    public List<HomeAppointment> myAppointment(Integer id){
        UserDetails user= service.findById(id);
        System.out.println(user.getId());
        return appointmentService.findAllByUserId(user);
    }

    // @PostMapping("/addAPpointment")
    // public HomeAppointment addAppointment(HomeAppointment add){

    // }
        
}
