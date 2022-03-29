package com.example.medicalclinic.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String surname;

    @NotNull
    private Long pesel;

    @NotNull
    private int phoneNumber;
    private String comment;
}
