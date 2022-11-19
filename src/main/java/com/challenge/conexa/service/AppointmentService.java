package com.challenge.conexa.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.challenge.conexa.model.Appointment;
import com.challenge.conexa.model.AppointmentDTO;
import com.challenge.conexa.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ProfessionalService professionalService;

    public List<Appointment> findAllByProfessionalId(Integer id) {
        return appointmentRepository.findAllByProfessionalId(id);
    }

    public Appointment save(AppointmentDTO appointmentDTO) throws Exception {
        if(appointmentRepository.existsByDateAndTime(appointmentDTO.getDate(),appointmentDTO.getTime())){
            throw new Exception("ProfessionalAlreadyInUseException");
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Appointment appointment = new Appointment();
        appointment.setProfessional(professionalService.findById(appointmentDTO.getProfessionalId()).get());
        appointment.setPatient(patientService.findByLogin(username));
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDate(appointmentDTO.getDate());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public  List<Appointment> findAllByProfessionalIdAndDate(Integer id, String date) {
        return appointmentRepository.findAllByProfessionalIdAndDate(id, date);

    }

    public boolean existsByDateAndTime(String date, String time) {
        return appointmentRepository.existsByDateAndTime(date, time);
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

}