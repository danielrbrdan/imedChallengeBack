package com.challenge.conexa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.conexa.models.entity.Patient;
import com.challenge.conexa.repository.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientService {
    private PatientRepository patientRepository;

 

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