package com.challenge.conexa.service;

import org.springframework.stereotype.Service;

import com.challenge.conexa.repository.ProfessionalRepository;

@Service
public class ProfessionalService {
    private ProfessionalRepository professionalRepository;

    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    
    
}
