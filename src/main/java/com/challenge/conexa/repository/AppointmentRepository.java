package com.challenge.conexa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.conexa.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {

    List<Appointment> findAllByProfessionalId(Long id);

    List<Appointment> findAllByProfessionalIdAndDate(Long id, String date);

    void deleteById(Long id);

    boolean existsByDateAndTimeAndProfessionalId(String date, String time, Long professionalId);

    List<Appointment> findAllByPatientId(Long id);

   


}
