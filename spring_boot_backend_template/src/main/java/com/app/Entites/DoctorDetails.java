package com.app.Entites;

import java.time.LocalTime;

import javax.persistence.Entity;

import org.apache.tomcat.jni.Local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDetails extends BaseEntity {
    public String doctorName;
    public String mobileNumber;
    public String Speciality;
    public LocalTime availableFrom;
    public LocalTime availableTill;

}
