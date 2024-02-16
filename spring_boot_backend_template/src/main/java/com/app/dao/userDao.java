package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.Entites.UserDetails;
import java.util.List;
import java.util.Optional;



public interface userDao extends JpaRepository<UserDetails,Integer>{
    @Query(value="select * from users where user_name=:username",nativeQuery=true)
    UserDetails findByUsername(@Param("username")String username);
    
    Optional<UserDetails> findById(Integer id);
}
