package com.challenge.conexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.Professional;
import com.challenge.conexa.model.User;
import com.challenge.conexa.repository.PatientRepository;
import com.challenge.conexa.repository.ProfessionalRepository;
import com.challenge.conexa.repository.UserRepository;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;
    private final PatientRepository patientRepository;
    private final ProfessionalRepository professionalRepository;

    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder,PatientRepository patientRepository,ProfessionalRepository professionalRepository) {
        this.repository = repository;
        this.encoder = encoder;
        this.patientRepository = patientRepository;
        this.professionalRepository = professionalRepository;

    }

    @GetMapping("/getUserType")
    public ResponseEntity<String> getUserType() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = repository.findByLogin(login).get();
        if(patientRepository.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PATIENT");
        }

        if(professionalRepository.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PROFESSIONAL");
        }

        return null;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save/professional")
    public ResponseEntity<User> save(@RequestBody Professional professional) {
        professional.setPassword(encoder.encode(professional.getPassword()));
        return ResponseEntity.ok(professionalRepository.save(professional));
    }

    @PostMapping("/save/patient")
    public ResponseEntity<User> save(@RequestBody Patient patient) {
        patient.setPassword(encoder.encode(patient.getPassword()));
        return ResponseEntity.ok(patientRepository.save(patient));
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
