package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Professional;
import com.challenge.conexa.service.ProfessionalService;

import lombok.Data;

@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    final String ip = "*";

    @CrossOrigin(origins = ip)
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Professional>> findPatients() {
        return ResponseEntity.ok().body(professionalService.findAll());
    }
   
}
