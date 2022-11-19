package com.challenge.conexa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.challenge.conexa.repository.UserRepository;
import com.challenge.conexa.service.AppointmentService;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.service.ProfessionalService;


@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "/findAllByProfessionalId/{id}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalId(@PathVariable Long id) {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalId(id));
    }

    @GetMapping(value = "/findAllByProfessionalIdAndDate/{id}/{date}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalIdAndDate(@PathVariable Long id, @PathVariable String date) throws ParseException {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalIdAndDate(id, date));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Appointment>> findAll() {
        return ResponseEntity.ok().body(appointmentService.findAll());
    }
    @GetMapping(value = "/findAllProfessionalAppointments")
    public ResponseEntity<List<Appointment>> findAllProfessionalAppointments() {
        return ResponseEntity.ok().body(appointmentService.findAllProfessionalAppointments());
    }

    @PostMapping("/save")
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        return ResponseEntity.ok(appointmentService.save(appointmentDTO));
    }
   
    @Transactional
    @PostMapping("/{id}")
    @CrossOrigin(origins = "*")
    public void delete(@PathVariable Long id) throws Exception {
        appointmentService.deleteById(id);
    }
}
