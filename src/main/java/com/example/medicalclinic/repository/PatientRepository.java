package com.example.medicalclinic.repository;

import com.example.medicalclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
