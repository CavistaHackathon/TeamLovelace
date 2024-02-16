package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entites.HomeAppointment;
import com.app.Entites.UserDetails;
import com.app.dto.AppointmentDTO;
import com.app.dto.loginDto;
import com.app.dto.sessionDto;
import com.app.dto.userDto;
import com.app.service.HomeAppointmentService;
import com.app.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
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
    public void login(@RequestBody loginDto dto){
       System.out.println(dto.getPass()+" ,"+dto.getUsername());
       UserDetails user= service.findByUsername(dto.getUsername());
       
       session.setAttribute("id", user.getId());
       session.setAttribute("name",user.getUserName());
       session.setAttribute("password",user.getPass());
       session.setAttribute("role", user.getRole());
    }

    @GetMapping("/myAppointments/{id}")
    public List<HomeAppointment> myAppointment(@PathVariable Integer id){
        UserDetails user= service.findById(id);
        System.out.println(user.getId());
        return appointmentService.findAllByUserId(user);
    }

    @PostMapping("/addAppointment")
    public HomeAppointment addAppointment(@RequestBody AppointmentDTO add){
        return appointmentService.addAppointment(add);
    }

    @GetMapping("/getCurrentSession")
    public sessionDto getMethodName() {
        sessionDto dto=new sessionDto();
        dto.setId(Integer.parseInt(session.getAttribute("id").toString()));
        dto.setName(session.getAttribute("name").toString());

        return dto;
    }

    


        
}
