package com.app.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails extends BaseEntity {
    @Column
  public String userName;
    @Column
  public String pass;
  @Column(length = 10)
  public String mobileNumber;

    @Enumerated(EnumType.STRING)
  public RoleEnum role;

}
