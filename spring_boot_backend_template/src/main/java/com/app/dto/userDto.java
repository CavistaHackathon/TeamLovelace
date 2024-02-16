package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.Entites.RoleEnum;
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

public class userDto {
    @JsonProperty("username")
  public String userName;
  @JsonProperty("password")
  public String password;
  @JsonProperty("mobilenumber")
  public String mobileNumber;
    @JsonProperty("role")
  public RoleEnum role;
}
