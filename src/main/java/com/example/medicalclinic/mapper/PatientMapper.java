package com.example.medicalclinic.mapper;


import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PatientMapper {

    Patient mapPatientDTOtoPatient(PatientDTO patientDTO);
}

