package com.challenge.conexa.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository; 
    }

    public List<Patient> findPatients(String name, String statusOnline) {
        return patientRepository.findAllByNameAndStatusOnline(name, statusOnline);
    }

    public Patient findByLogin(String username) {
        return patientRepository.findByLogin(username);

    }
    
    public void incrementPatientAppointments(Long id) {
        patientRepository.incrementPatientAppointments(id);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);

    }


}