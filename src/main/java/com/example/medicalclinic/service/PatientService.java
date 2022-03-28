package com.example.medicalclinic.service;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.mapper.PatientMapper;
import com.example.medicalclinic.model.Patient;
import com.example.medicalclinic.repository.PatientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public void registerPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDTOtoPatient(patientDTO);
        patientRepository.save(patient);
    }

    public void updatePatient(Long pesel, PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDTOtoPatient(patientDTO);
        Optional<Patient> patientRegistred = patientRepository.findById(pesel);
        if (patientRegistred.isPresent()) {
            patientRepository.save(patient);
        }
    }


    public void deletePatient(Long pesel) {
        patientRepository.deleteById(pesel);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientsByPESEL(Long pesel) {
        Optional<Patient> patient = patientRepository.findById(pesel);
        return patient.orElseGet(patient::get);
    }
}
