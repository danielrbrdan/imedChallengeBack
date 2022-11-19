package com.challenge.conexa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.conexa.model.Patient;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
    List<Patient> findAll();

    @Query(value = "select * from patient " + 
	"where name like :name " + 
	"and online_status like :statusOnline ",
    nativeQuery = true)
    List<Patient> findAllByNameAndStatusOnline(String name, String statusOnline);

    Patient findByLogin(String username);
}