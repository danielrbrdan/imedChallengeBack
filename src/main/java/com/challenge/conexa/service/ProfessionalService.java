package com.challenge.conexa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.conexa.model.Professional;
import com.challenge.conexa.repository.ProfessionalRepository;

@Service
public class ProfessionalService {
    private ProfessionalRepository professionalRepository;

    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    
    
}
