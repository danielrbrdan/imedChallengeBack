package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Professional;
import com.challenge.conexa.service.ProfessionalService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {
    private final ProfessionalService professionalService;

    @GetMapping()
    public ResponseEntity<List<Professional>> findPatients() {
        return ResponseEntity.ok().body(professionalService.findAll());
    }

    @GetMapping(value = "/search/{key}")
    public ResponseEntity<List<Professional>> search(@PathVariable String key) {
        return ResponseEntity.ok().body(professionalService.search(key));
    }
   
}
