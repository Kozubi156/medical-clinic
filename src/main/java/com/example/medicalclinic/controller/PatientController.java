package com.example.medicalclinic.controller;

import com.example.medicalclinic.dto.PatientDTO;
import com.example.medicalclinic.model.Patient;
import com.example.medicalclinic.service.PatientServiceImp;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@Validated
@RestController
@RequestMapping("/medical-clinic")
public class PatientController {

    private final PatientServiceImp patientServiceImp;

    @PostMapping("/patients")
    public ResponseEntity<Patient> registerPatient(@RequestBody @Valid PatientDTO patient) {
        patientServiceImp.registerPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/patients/{pesel}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long pesel, @RequestBody Patient patient) {
        patientServiceImp.updatePatient(pesel, patient);
        return ResponseEntity.status(HttpStatus.OK).body(patientServiceImp.getPatientsByPESEL(pesel));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(patientServiceImp.getAllPatients());
    }

    @GetMapping("/patients/{pesel}")
    public ResponseEntity<Patient> getPatientByPESEL(@PathVariable Long pesel) {
        return ResponseEntity.status(HttpStatus.OK).body(patientServiceImp.getPatientsByPESEL(pesel));
    }

    @DeleteMapping("/patients/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long pesel) {
        patientServiceImp.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
