package com.challenge.conexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.model.User;
import com.challenge.conexa.repository.UserRepository;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @CrossOrigin(value = "*")
    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(repository.save(user));
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
