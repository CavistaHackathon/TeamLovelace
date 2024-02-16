package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entites.HomeAppointment;
import com.app.Entites.TeamDetails;
import com.app.Entites.UserDetails;
import com.app.dao.appointment;
import com.app.dao.teamdao;
import com.app.dao.userDao;
import com.app.dto.AppointmentDTO;

@Service
@Transactional
public class HomeAppointmentService {

    @Autowired 
    private appointment dao;

    @Autowired 
    private teamdao teamdao;

    @Autowired 
    private userDao userdao;

    public List<HomeAppointment> findAllByUserId(UserDetails user) {
        System.out.println("id"+user);
        return dao.findAllByUserId(user);
    }

    public HomeAppointment addAppointment(AppointmentDTO app) {
        TeamDetails team= teamdao.findById(app.getTeamid()).get();
        UserDetails user=userdao.findById(app.getUserid()).get();
        HomeAppointment appointment=new HomeAppointment();
        appointment.setFees(app.getFees());
        appointment.setTeamId(team);
        appointment.setUserId(user);
        return dao.save(appointment);
    }
    
}
