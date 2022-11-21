package com.challenge.conexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.Professional;
import com.challenge.conexa.model.User;
import com.challenge.conexa.repository.UserRepository;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.service.ProfessionalService;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository repository;
    private final PatientService patientService;
    private final ProfessionalService professionalService;

    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder,PatientService patientService,ProfessionalService professionalService) {
        this.repository = repository;
        this.encoder = encoder;
        this.patientService = patientService;
        this.professionalService = professionalService;

    }

    @PostMapping("/save/professional")
    public ResponseEntity<Professional> save(@RequestBody Professional professional) {
        professional.setPassword(encoder.encode(professional.getPassword()));
        return ResponseEntity.ok(professionalService.save(professional));
    }

    @PostMapping("/save/patient")
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        patient.setPassword(encoder.encode(patient.getPassword()));
        return ResponseEntity.ok(patientService.save(patient));
    }

    @GetMapping("/getUserType")
    public ResponseEntity<String> getUserType() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = repository.findByLogin(login).get();
        if(patientService.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PATIENT");
        }

        if(professionalService.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PROFESSIONAL");
        }

        return null;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/validPass")
    public ResponseEntity<Boolean> validPass(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<User> optuser = repository.findByLogin(login);
        if (optuser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optuser.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
