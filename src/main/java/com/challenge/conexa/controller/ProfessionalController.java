package com.challenge.conexa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.models.dto.ProfessionalDTO;
import com.challenge.conexa.service.ProfessionalService;
import com.challenge.conexa.utils.Mapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {
    private final ProfessionalService professionalService;
    private final Mapper mapper;


    @GetMapping()
    public ResponseEntity<List<ProfessionalDTO>> findPatients() {
        List<ProfessionalDTO> professionalsDTO = 
            this.mapper.mapList(professionalService.findAll(), ProfessionalDTO.class);

        return ResponseEntity.ok().body(professionalsDTO);
    }

    @GetMapping(value = "/search/{key}")
    public ResponseEntity<List<ProfessionalDTO>> search(@PathVariable String key) {
        List<ProfessionalDTO> professionalsDTO = 
            this.mapper.mapList(professionalService.search(key), ProfessionalDTO.class);

        return ResponseEntity.ok().body(professionalsDTO);
    }
   
}
