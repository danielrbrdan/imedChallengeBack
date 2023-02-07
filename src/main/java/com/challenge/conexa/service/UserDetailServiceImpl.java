package com.challenge.conexa.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.challenge.conexa.data.UserDetailData;
import com.challenge.conexa.models.entity.User;
import com.challenge.conexa.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    
    @Override
    public UserDetailData loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UserDetailData(user);
    }

}
