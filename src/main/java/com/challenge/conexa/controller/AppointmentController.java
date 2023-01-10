package com.challenge.conexa.controller;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Appointment;
import com.challenge.conexa.model.AppointmentDTO;
import com.challenge.conexa.service.AppointmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalId(@PathVariable Long id) {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalId(id));
    }

    @GetMapping(value = "/{id}/{date}")
    public ResponseEntity<List<Appointment>> findAllByProfessionalIdAndDate(@PathVariable Long id, @PathVariable String date) throws ParseException {
        return ResponseEntity.ok().body(appointmentService.findAllByProfessionalIdAndDate(id, date));
    }

    @GetMapping()
    public ResponseEntity<List<Appointment>> findAll() {
        return ResponseEntity.ok().body(appointmentService.findAll());
    }
    @GetMapping(value = "/professional-appointments")
    public ResponseEntity<List<Appointment>> findAllProfessionalAppointments() {
        return ResponseEntity.ok().body(appointmentService.findAllProfessionalAppointments());
    }

    @PostMapping()
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        return ResponseEntity.ok(appointmentService.save(appointmentDTO));
    }
   
    @Transactional
    @PostMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        appointmentService.deleteById(id);
    }
}
