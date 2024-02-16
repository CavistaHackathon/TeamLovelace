package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.Entites.HomeAppointment;
import com.app.Entites.UserDetails;

public interface appointment extends JpaRepository <HomeAppointment,Integer>{
//@Query(name="select * from home_appointment where user_id =:id",nativeQuery = true)
    List<HomeAppointment> findAllByUserId(UserDetails user);
    
}
