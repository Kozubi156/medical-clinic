package com.example.medicalclinic.service;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.mapper.PatientMapper;
import com.example.medicalclinic.model.Patient;
import com.example.medicalclinic.repository.PatientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class PatientServiceImp implements PatientService{

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Override
    public Patient registerPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDTOtoPatient(patientDTO);
        return patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long pesel, Patient patient) {
        Patient registeredPatient = patientRepository.findById(pesel).get();
        registeredPatient.setFirstName(patient.getFirstName());
        registeredPatient.setSurname(patient.getSurname());
        registeredPatient.setComment(patient.getComment());
        registeredPatient.setPhoneNumber(patient.getPhoneNumber());
        patientRepository.save(registeredPatient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientsByPESEL(Long pesel) {
        return patientRepository.findById(pesel).get();
    }

    @Override
    public void deletePatient(Long pesel) {
        patientRepository.deleteById(pesel);
    }
}
