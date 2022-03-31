package com.example.medicalclinic.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatientDTO {

    @NotEmpty(message = "Name should be set")
    private String firstName;

    @NotEmpty
    private String surname;

    @NotNull
    private Long pesel;

    @NotNull
    private Long phoneNumber;
    private String comment;
}
