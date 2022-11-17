package com.challenge.conexa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.conexa.model.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Long> {

}