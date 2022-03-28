package com.example.medicalclinic.service;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.mapper.PatientMapper;
import com.example.medicalclinic.model.Patient;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class PatientService {

    private final List<Patient> patientList;
    private final PatientMapper patientMapper;

    public void registerPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.map(patientDTO);
        patientList.add(patient);
    }

    public void updatePatient(int pesel, Patient patient) {

    }

    public void deletePatient(int pesel) {
        patientList.removeIf(patient -> patient.getPesel() == pesel);
    }

    public List<Patient> getAllPatients() {
        return getPatientList();
    }
}
