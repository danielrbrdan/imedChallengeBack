package com.challenge.conexa.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.conexa.model.Appointment;
import com.challenge.conexa.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAllByProfessionalId(Integer id) {
        return appointmentRepository.findAllByProfessionalId(id);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public  List<Appointment> findAllByProfessionalIdAndDate(Integer id, String date) {
        return appointmentRepository.findAllByProfessionalIdAndDate(id, date);

    }

}