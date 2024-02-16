package com.app.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AppointmentDTO {
    @JsonProperty("userid")
       public Integer userid;
       @JsonProperty("teamid")
       public Integer teamid;
       @JsonFormat(pattern = "HH:mm:ss")
       @JsonProperty("appointmentTime")
       public LocalTime appointmentTime;
       @JsonProperty("fees")
       public double fees;    
}
