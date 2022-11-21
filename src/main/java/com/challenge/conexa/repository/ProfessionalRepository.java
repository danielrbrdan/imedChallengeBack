package com.challenge.conexa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.conexa.model.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Long> {
    List<Professional> findAll();

    Optional<Professional> findById(Long professionalId);

    Optional<Professional> findByLogin(String login);

    @Query(value = "select * from professional p "+
    "inner join users u on p.id = u.id "+
    "where name like %:key% or "+
    "crm like %:key%  or "+
    "status like %:key%",
    nativeQuery = true)
    List<Professional> search(String key);
}
