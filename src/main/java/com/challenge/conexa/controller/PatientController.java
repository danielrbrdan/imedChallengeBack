package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.service.PatientService;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    final String ip = "*";
    
    @CrossOrigin(origins = ip)
    @RequestMapping(value = "/cancelAppointment", method = RequestMethod.GET)
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok().body("OK");
    }

    @CrossOrigin(origins = ip)
    @RequestMapping(value = "/findPatients", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> findPatients(@RequestParam String name, @RequestParam String statusOnline) {
        return ResponseEntity.ok().body(patientService.findPatients(name,statusOnline));
    }
}
