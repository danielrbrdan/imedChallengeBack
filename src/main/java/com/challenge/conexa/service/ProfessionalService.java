package com.challenge.conexa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.conexa.model.Professional;
import com.challenge.conexa.repository.ProfessionalRepository;

@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Optional<Professional> findById(Long professionalId) {
        return professionalRepository.findById(professionalId);

    }

    public Professional save(Professional professional) {
        return professionalRepository.save(professional);
    }

    public List<Professional> search(String key) {
        return professionalRepository.search(key);
    }

    
}
