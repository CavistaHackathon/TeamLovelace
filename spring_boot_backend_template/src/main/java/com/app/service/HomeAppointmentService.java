package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entites.HomeAppointment;
import com.app.Entites.UserDetails;
import com.app.dao.appointment;

@Service
@Transactional
public class HomeAppointmentService {

    @Autowired 
    private appointment dao;

    public List<HomeAppointment> findAllByUserId(UserDetails user) {
        System.out.println("id"+user);
        return dao.findAllByUserId(user);
    }
    
}
