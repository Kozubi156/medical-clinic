package com.example.medicalclinic.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PatientDTO {

    @NotEmpty
    private String firstName;
    private String surname;
    private int pesel;
    private int phoneNumber;
    private String comment;
}
