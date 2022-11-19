package com.challenge.conexa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Appointment;
import com.challenge.conexa.model.AppointmentDTO;
import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.Professional;
import com.challenge.conexa.service.AppointmentService;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.service.ProfessionalService;


@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ProfessionalService professionalService;


    @GetMapping(value = "/findAllByProfessionalId/{id}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalId(id));
    }

    @GetMapping(value = "/findAllByProfessionalIdAndDate/{id}/{date}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalIdAndDate(@PathVariable Integer id, @PathVariable String date) throws ParseException {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalIdAndDate(id, date));
    }
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Appointment>> findAll() {
        return ResponseEntity.ok().body(appointmentService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDTO appointmentDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Appointment appointment = new Appointment();
        appointment.setProfessional(professionalService.findById(appointmentDTO.getProfessionalId()).get());
        appointment.setPatient(patientService.findByLogin(username));
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDate(appointmentDTO.getDate());

        return ResponseEntity.ok(appointmentService.save(appointment));
    }
   
}
