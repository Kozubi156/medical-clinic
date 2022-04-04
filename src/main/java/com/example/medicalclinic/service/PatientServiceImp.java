package com.example.medicalclinic.service;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.exception.PatienException;
import com.example.medicalclinic.mapper.PatientMapper;
import com.example.medicalclinic.model.Patient;
import com.example.medicalclinic.repository.PatientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Patient registerPatient(PatientDTO patientDTO) {
        if (patientRepository.existsById(patientDTO.getPesel())) {
            throw new PatienException("Patient with PESEL: " + patientDTO.getPesel() + " is already registered");
        }
        Patient patient = patientMapper.mapPatientDTOtoPatient(patientDTO);
        return patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long pesel, PatientDTO patientDTO) {
        if (patientRepository.existsById(pesel)) {
            Patient registeredPatient = patientRepository.findById(pesel).get();
            registeredPatient.setFirstName(patientDTO.getFirstName());
            registeredPatient.setSurname(patientDTO.getSurname());
            registeredPatient.setComment(patientDTO.getComment());
            registeredPatient.setPhoneNumber(patientDTO.getPhoneNumber());
            patientRepository.save(registeredPatient);
        } else {
            throw new PatienException("Patient with PESEL: " + pesel + " not found");
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientsByPESEL(Long pesel) {
        return patientRepository.findById(pesel).orElseThrow(() -> new PatienException("Patient with PESEL: " + pesel +
                " " +
                "not found"));
    }


    @Override
    public void deletePatient(Long pesel) {
        if (patientRepository.findById(pesel).isPresent()) {
            patientRepository.deleteById(pesel);
        } else {
            throw new PatienException("Patient with PESEL: " + pesel + " not found");
        }
    }
}
