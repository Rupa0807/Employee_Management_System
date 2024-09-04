package com.ems.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {


    @Column(name = "FIRST_NAME")
   public String firstName;

    @Column(name = "LAST_NAME")
    public String lastName;
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "ID")
 private  int id;

    @Column(name = "EMAIL")
   private String email;




}
