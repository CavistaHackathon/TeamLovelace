package com.app.Entites;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="home_appointment")
public class HomeAppointment  extends BaseEntity{
    @OneToOne
    @JoinColumn(name="user_id")
    private UserDetails userId;
    @OneToOne
    @JoinColumn(name="team_id")
    private TeamDetails teamId;
    private LocalTime appointmentTime;
    private double fees;
}
