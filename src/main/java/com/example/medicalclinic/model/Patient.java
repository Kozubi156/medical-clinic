package com.example.medicalclinic.model;

import lombok.Data;

@Data
public class Patient {

    private String firstName;
    private String surname;
    private int pesel;
    private int phoneNumber;
    private String comment;
}
