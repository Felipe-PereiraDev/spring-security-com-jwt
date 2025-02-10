package com.projeto.dio.controller;

import com.projeto.dio.dto.LoginRequestDTO;
import com.projeto.dio.dto.TokenResponse;
import com.projeto.dio.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("auth")
    public TokenResponse authenticate(@RequestBody LoginRequestDTO loginRequest) {
        var token =  authenticationService.authenticate(loginRequest);
        return new TokenResponse(token);
    }
}
