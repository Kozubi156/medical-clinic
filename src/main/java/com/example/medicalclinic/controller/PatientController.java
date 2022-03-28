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
    public ResponseEntity<PatientDTO> registerPatient(@RequestBody PatientDTO patient) {
        patientService.registerPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/patients/{pesel}")
    public ResponseEntity<PatientDTO> registerPatient(@PathVariable Long pesel, @RequestBody PatientDTO patient) {
        patientService.updatePatient(pesel, patient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }

    @GetMapping("/patients/{pesel}")
    public ResponseEntity<Patient> getPatientByPESEL(@PathVariable Long pesel) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientsByPESEL(pesel));
    }

    @DeleteMapping("/patients/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long pesel) {
        patientService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
