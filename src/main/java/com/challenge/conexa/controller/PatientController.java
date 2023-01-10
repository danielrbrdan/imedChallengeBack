package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.service.PatientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    private final PatientService patientService;

    @RequestMapping(value = "/find-patients", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> findPatients(@RequestParam String name, @RequestParam String statusOnline) {
        return ResponseEntity.ok().body(patientService.findPatients(name,statusOnline));
    }
}
