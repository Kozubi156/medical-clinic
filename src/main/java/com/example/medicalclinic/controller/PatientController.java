package com.example.medicalclinic.controller;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.model.Patient;
import com.example.medicalclinic.service.PatientService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/medical-clinic")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/patients")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientDTO patient) {
        patientService.registerPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/patients/{pesel}")
    public ResponseEntity<Patient> registerPatient(@PathVariable int pesel, @RequestBody Patient patient) {
        patientService.updatePatient(pesel, patient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }

    @DeleteMapping("/patients/{pesel}")
    public ResponseEntity<Patient> deletePatient(@PathVariable int pesel) {
        patientService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
