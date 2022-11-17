package com.challenge.conexa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.repository.PatientRepository;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findPatients(String name, String statusOnline) {
        return patientRepository.findAllByNameAndStatusOnline(name, statusOnline);
    }

}