package com.example.medicalclinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Patient {

    private String firstName;
    private String surname;
    @Id
    @Column(unique = true)
    private Long pesel;
    private Long phoneNumber;
    private String comment;

//    @Column(columnDefinition = "BIGINT(20) NOT NULL UNIQUE KEY auto_increment")
    private int Id;
}
