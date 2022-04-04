package com.example.medicalclinic.service;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.model.Patient;

import java.util.List;

public interface PatientService {

    Patient registerPatient(PatientDTO patientDTO);

    void updatePatient(Long pesel, PatientDTO patientDTO);

    List<Patient> getAllPatients();

   Patient getPatientsByPESEL(Long pesel);

    void deletePatient(Long pesel);

}
