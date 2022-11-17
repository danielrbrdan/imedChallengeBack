package com.challenge.conexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.service.ProfessionalService;

@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    final String ip = "*";

   
}
