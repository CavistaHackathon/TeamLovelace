package com.app.service;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entites.UserDetails;
import com.app.dao.userDao;
import com.app.dto.userDto;

@Service
@Transactional
public class UserService {
    @Autowired 
    private userDao userdao;

    public UserDetails saveUser(userDto user){
        UserDetails u=new UserDetails();
        u.setMobileNumber(user.getMobileNumber());
        u.setPass(user.getPassword());
        u.setRole(user.getRole());
        u.setUserName(user.getUserName());
        return userdao.save(u);
        //return "saved succesfully";
    }

    public UserDetails findByUsername(String username) {
        return userdao.findByUsername(username);
    }
    public UserDetails findById(Integer id){
        return userdao.findById(id).get();
    }
}
