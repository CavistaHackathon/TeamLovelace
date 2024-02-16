package com.app.Entites;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAppointment extends BaseEntity{

    @OneToMany
    @JoinColumn(name="patient_id")
    private List<UserDetails> patient_id;

    private double fees;
    
}
