package com.challenge.conexa.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.conexa.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAllByProfessionalId(Integer id);

    List<Appointment> findAllByProfessionalIdAndDate(Integer id, String date);

}
