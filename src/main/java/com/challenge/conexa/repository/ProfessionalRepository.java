package com.challenge.conexa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Long> {
    List<Professional> findAll();

    Optional<Professional> findById(Long professionalId);

    Optional<Professional> findByLogin(String login);
}
