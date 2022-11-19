package com.challenge.conexa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.conexa.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByLogin(String login);

}
