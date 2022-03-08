package com.example.apireactcrud.controller.rest;

import com.example.apireactcrud.config.TokenService;
import com.example.apireactcrud.controller.dto.LoginDto;
import com.example.apireactcrud.controller.dto.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticaController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AutenticaController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto loginForm){
        UsernamePasswordAuthenticationToken login = loginForm.converter();
        try {
            Authentication authentication = authManager.authenticate(login);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
