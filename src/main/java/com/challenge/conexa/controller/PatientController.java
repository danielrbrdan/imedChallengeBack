package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.models.dto.PatientDTO;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.utils.Mapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    private final PatientService patientService;
    
    private final Mapper mapper;


    @RequestMapping(value = "/find-patients", method = RequestMethod.GET)
    public ResponseEntity<List<PatientDTO>> findPatients(@RequestParam String name, @RequestParam String statusOnline) {
        List<PatientDTO> patientsDTO = 
            this.mapper.mapList(patientService.findPatients(name,statusOnline), PatientDTO.class);
            
        return ResponseEntity.ok().body(patientsDTO);
    }
}
