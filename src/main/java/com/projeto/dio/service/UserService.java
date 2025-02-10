package com.projeto.dio.service;

import com.projeto.dio.dto.UserCreate;
import com.projeto.dio.model.User;
import com.projeto.dio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreate data) {
        if (data.username() == null || data.password() == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        return userRepository.save(new User(data.username(), encryptedPassword));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
