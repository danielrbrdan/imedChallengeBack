package com.challenge.conexa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.challenge.conexa.model.Appointment;
import com.challenge.conexa.model.AppointmentDTO;
import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.User;
import com.challenge.conexa.repository.AppointmentRepository;
import com.challenge.conexa.repository.UserRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private UserRepository userRepository;

    public List<Appointment> findAllByProfessionalId(Long id) {
        return appointmentRepository.findAllByProfessionalId(id);
    }

    public Appointment save(AppointmentDTO appointmentDTO) throws Exception {
        if(appointmentRepository.existsByDateAndTimeAndProfessionalId(appointmentDTO.getDate(),appointmentDTO.getTime(),appointmentDTO.getProfessionalId())){
            throw new Exception("ProfessionalAlreadyInUseException");
        }

        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Appointment appointment = new Appointment();
        Patient patient = patientService.findByLogin(login);
        appointment.setProfessional(professionalService.findById(appointmentDTO.getProfessionalId()).get());
        appointment.setPatient(patient);
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDate(appointmentDTO.getDate());
        
        patientService.incrementPatientAppointments(patient.getId());
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByLogin(login).get();
        return appointmentRepository.findAllByPatientId(user.getId());
    }

    public List<Appointment> findAllProfessionalAppointments() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByLogin(login).get();
        return appointmentRepository.findAllByProfessionalId(user.getId());
    }

    public  List<Appointment> findAllByProfessionalIdAndDate(Long id, String date) {
        return appointmentRepository.findAllByProfessionalIdAndDate(id, date);

    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    

}