package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entites.TeamDetails;
import java.util.List;
import java.util.Optional;


public interface teamdao extends JpaRepository<TeamDetails,Integer>{
    Optional<TeamDetails> findById(Integer id);
}
