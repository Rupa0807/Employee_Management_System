package com.ems.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {

    public Employee(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    @Column(name = "FIRST_NAME")
   private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "ID")
 private  int id;
    @Column(name = "EMAIL")
   private String email;

}
