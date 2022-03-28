package com.example.medicalclinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String surname;
    private long pesel;
    private int phoneNumber;
    private String comment;

}
