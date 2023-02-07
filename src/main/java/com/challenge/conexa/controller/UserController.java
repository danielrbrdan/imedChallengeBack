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

import com.challenge.conexa.models.dto.PatientDTO;
import com.challenge.conexa.models.dto.ProfessionalDTO;
import com.challenge.conexa.models.dto.UserDTO;
import com.challenge.conexa.models.entity.Patient;
import com.challenge.conexa.models.entity.Professional;
import com.challenge.conexa.models.entity.User;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.service.ProfessionalService;
import com.challenge.conexa.service.UserService;
import com.challenge.conexa.utils.Mapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PatientService patientService;
    private final ProfessionalService professionalService;
    private final PasswordEncoder encoder;
    private final Mapper mapper;


    @PostMapping("/professional")
    public ResponseEntity<ProfessionalDTO> save(@RequestBody Professional professional) {
        professional.setPassword(encoder.encode(professional.getPassword()));
        ProfessionalDTO professionalDTO = mapper.map(professionalService.save(professional), ProfessionalDTO.class);

        return ResponseEntity.ok(professionalDTO);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDTO> save(@RequestBody Patient patient) {
        patient.setPassword(encoder.encode(patient.getPassword()));
        PatientDTO patientDTO = mapper.map(patientService.save(patient), PatientDTO.class);

        return ResponseEntity.ok(patientDTO);
    }

    @GetMapping("/user-type")
    public ResponseEntity<String> getUserType() {
        String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userService.findByLogin(login).get();
        if(patientService.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PATIENT");
        }

        if(professionalService.findById(user.getId()).isPresent()){
            return ResponseEntity.ok("PROFESSIONAL");
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> listAll() {
        List<UserDTO> usersDTO = 
            this.mapper.mapList(userService.findAll(), UserDTO.class);

        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/valid_pass")
    public ResponseEntity<Boolean> validPass(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<User> optuser = userService.findByLogin(login);
        if (optuser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optuser.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
